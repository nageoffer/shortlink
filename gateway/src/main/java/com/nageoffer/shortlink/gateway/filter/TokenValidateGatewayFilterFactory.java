/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nageoffer.shortlink.gateway.filter;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.nageoffer.shortlink.gateway.config.Config;
import com.nageoffer.shortlink.gateway.dto.GatewayErrorResult;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

/**
 * Token Validation Gateway Filter Factory
 * <p>
 * This filter implements authentication and authorization logic for the API gateway. It intercepts
 * incoming requests and validates whether they contain valid authentication tokens before allowing
 * them to proceed to backend services.
 * </p>
 * <p>
 * Filter Logic Flow:
 * <ol>
 *   <li>Extract request path and HTTP method</li>
 *   <li>Check if the path is in the white-list (exempt from authentication)</li>
 *   <li>For non-white-listed paths:
 *     <ul>
 *       <li>Extract username and token from request headers</li>
 *       <li>Validate token against Redis cache</li>
 *       <li>On success: Extract user info and add to request headers (userId, realName)</li>
 *       <li>On failure: Return 401 Unauthorized with error message</li>
 *     </ul>
 *   </li>
 *   <li>Forward request to next filter or backend service</li>
 * </ol>
 * </p>
 * <p>
 * White-list Paths:
 * <ul>
 *   <li>Paths matching any prefix in {@link Config#getWhitePathList()}</li>
 *   <li>POST /api/short-link/admin/v1/user (user registration endpoint)</li>
 * </ul>
 * </p>
 * <p>
 * Redis Key Pattern: {@code short-link:login:{username}} (Hash containing token -> user info mappings)
 * </p>
 * <p>
 * Security Features:
 * <ul>
 *   <li>Token validation using Redis for fast lookups</li>
 *   <li>URL encoding of user real names to prevent header injection</li>
 *   <li>Proper HTTP status codes for authentication failures</li>
 *   <li>Non-blocking reactive implementation using Project Reactor</li>
 * </ul>
 * </p>
 * 
 * @author 马丁玩编程 (Martin Plays Programming)
 * @version 1.0.0
 * @since 2024
 * @see AbstractGatewayFilterFactory
 * @see Config
 * @see GatewayErrorResult
 */
@Component
public class TokenValidateGatewayFilterFactory extends AbstractGatewayFilterFactory<Config> {

    private final StringRedisTemplate stringRedisTemplate;

    /**
     * Constructor with dependency injection.
     * <p>
     * Injects the Redis template for token validation. The StringRedisTemplate provides
     * convenient methods for working with string-based Redis operations.
     * </p>
     * 
     * @param stringRedisTemplate Redis template for token validation operations
     */
    public TokenValidateGatewayFilterFactory(StringRedisTemplate stringRedisTemplate) {
        super(Config.class);
        this.stringRedisTemplate = stringRedisTemplate;
    }

    /**
     * Creates and configures the gateway filter instance.
     * <p>
     * This method returns a lambda function that implements the actual filtering logic.
     * It uses reactive programming with Project Reactor's Mono and Flux to handle
     * non-blocking I/O operations.
     * </p>
     * 
     * @param config filter configuration containing white-list paths
     * @return configured GatewayFilter instance
     */
    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            String requestPath = request.getPath().toString();
            String requestMethod = request.getMethod().name();
            if (!isPathInWhiteList(requestPath, requestMethod, config.getWhitePathList())) {
                String username = request.getHeaders().getFirst("username");
                String token = request.getHeaders().getFirst("token");
                Object userInfo;
                if (StringUtils.hasText(username) && StringUtils.hasText(token) && (userInfo = stringRedisTemplate.opsForHash().get("short-link:login:" + username, token)) != null) {
                    JSONObject userInfoJsonObject = JSON.parseObject(userInfo.toString());
                    ServerHttpRequest.Builder builder = exchange.getRequest().mutate().headers(httpHeaders -> {
                        httpHeaders.set("userId", userInfoJsonObject.getString("id"));
                        httpHeaders.set("realName", URLEncoder.encode(userInfoJsonObject.getString("realName"), StandardCharsets.UTF_8));
                    });
                    return chain.filter(exchange.mutate().request(builder.build()).build());
                }
                ServerHttpResponse response = exchange.getResponse();
                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                return response.writeWith(Mono.fromSupplier(() -> {
                    DataBufferFactory bufferFactory = response.bufferFactory();
                    GatewayErrorResult resultMessage = GatewayErrorResult.builder()
                            .status(HttpStatus.UNAUTHORIZED.value())
                            .message("Unauthorized request")
                            .build();
                    return bufferFactory.wrap(JSON.toJSONString(resultMessage).getBytes());
                }));
            }
            return chain.filter(exchange);
        };
    }

    /**
     * Checks if a request path is in the white-list.
     * <p>
     * Determines whether the given request path should bypass authentication based on
     * the white-list configuration. Two types of paths are considered white-listed:
     * </p>
     * <ul>
     *   <li>Paths that start with any prefix in the whitePathList configuration</li>
     *   <li>The specific admin user registration endpoint (POST /api/short-link/admin/v1/user)</li>
     * </ul>
     * <p>
     * This method is called for every request to determine if authentication is required.
     * </p>
     * 
     * @param requestPath the incoming request path
     * @param requestMethod the HTTP method of the request
     * @param whitePathList list of white-list path prefixes
     * @return true if the path is white-listed (no authentication required), false otherwise
     */
    private boolean isPathInWhiteList(String requestPath, String requestMethod, List<String> whitePathList) {
        return (!CollectionUtils.isEmpty(whitePathList) && whitePathList.stream().anyMatch(requestPath::startsWith)) || (Objects.equals(requestPath, "/api/short-link/admin/v1/user") && Objects.equals(requestMethod, "POST"));
    }
}
