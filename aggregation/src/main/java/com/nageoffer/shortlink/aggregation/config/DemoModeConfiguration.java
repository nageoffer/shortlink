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

package com.nageoffer.shortlink.aggregation.config;

import com.alibaba.fastjson.JSON;
import com.nageoffer.shortlink.admin.common.convention.result.Result;
import com.nageoffer.shortlink.admin.common.convention.result.Results;
import jakarta.annotation.Nullable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.PrintWriter;
import java.util.Objects;

/**
 * Demo Mode Configuration
 * <p>
 * This configuration class implements a demo mode interceptor that restricts certain operations
 * in public/demo deployments. It allows read operations (GET requests) while blocking write
 * operations (POST, PUT, DELETE) on sensitive endpoints to prevent data modification in demo
 * environments.
 * </p>
 * <p>
 * Demo Mode Behavior:
 * <ul>
 *   <li>When enabled, intercepts all requests matching the blacklist paths</li>
 *   <li>Allows GET requests without restriction (read-only access)</li>
 *   <li>Blocks non-GET requests with a 403-like response (custom error code B000001)</li>
 *   <li>Response format: JSON with error code and descriptive message</li>
 * </ul>
 * </p>
 * <p>
 * Interceptor Registration:
 * <ul>
 *   <li>Registered for all paths (/**) via WebMvcConfigurer</li>
 *   <li>Executes before controller method invocation (preHandle)</li>
 *   <li>Uses configuration from DemoModeProperties</li>
 * </ul>
 * </p>
 * <p>
 * Security Considerations:
 * <ul>
 *   <li>Only blocks write operations on blacklisted paths</li>
 *   <li>Does NOT provide authentication or authorization</li>
 *   <li>Should be used in conjunction with other security measures</li>
 *   <li>Response does NOT expose internal implementation details</li>
 * </ul>
 * </p>
 * <p>
 * Use Cases:
 * <ul>
 *   <li>Public demo environments where data integrity is important</li>
 *   <li>Training environments with shared resources</li>
 *   <li>Evaluation deployments for potential customers</li>
 *   <li>Staging environments with production-like data</li>
 * </ul>
 * </p>
 * 
 * @author 马丁玩编程 (Martin Plays Programming)
 * @version 1.0.0
 * @since 2024
 * @see DemoModeProperties
 * @see HandlerInterceptor
 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer
 */
@Configuration
@RequiredArgsConstructor
public class DemoModeConfiguration implements WebMvcConfigurer {

    private final DemoModeProperties demoModeProperties;

    /**
     * Registers the demo mode interceptor.
     * <p>
     * Adds the DemoModeInterceptor to the Spring MVC interceptor chain for all paths.
     * The interceptor will be executed before each request is handled by a controller.
     * </p>
     * 
     * @param registry interceptor registry for managing interceptors
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new DemoModeInterceptor())
                .addPathPatterns("/**");
    }

    /**
     * Demo Mode Interceptor Implementation
     * <p>
     * This inner class implements the HandlerInterceptor interface to provide
     * request-level filtering for demo mode restrictions.
     * </p>
     */
    public class DemoModeInterceptor implements HandlerInterceptor {

        /**
         * Pre-handle interceptor method.
         * <p>
         * Called before the controller method is invoked. Checks if demo mode is enabled,
         * if the request path is in the blacklist, and if the method is not GET.
         * If all conditions are met, blocks the request and returns an error response.
         * </p>
         * 
         * @param request the HTTP request being processed
         * @param response the HTTP response being built
         * @param handler the handler object (controller method) being invoked
         * @return true if request should proceed, false if blocked
         * @throws Exception if an error occurs during processing
         */
        @Override
        public boolean preHandle(@Nullable HttpServletRequest request, @Nullable HttpServletResponse response, @Nullable Object handler) throws Exception {
            if (demoModeProperties.getEnable()
                    && demoModeProperties.getBlacklist().contains(request.getRequestURI())
                    && !Objects.equals(request.getMethod(), "GET")) {
                response.setContentType("application/json;charset=UTF-8");
                PrintWriter out = response.getWriter();
                Result<Void> result = Results.failure("B000001", "Some demo features are restricted. Please use link redirection and monitoring features.");
                out.print(JSON.toJSONString(result));
                out.flush();
                return false;
            }
            return true;
        }
    }
}
