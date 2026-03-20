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

package com.nageoffer.shortlink.gateway.config;

import lombok.Data;

import java.util.List;

/**
 * Gateway Filter Configuration
 * <p>
 * This configuration class defines the settings for the token validation gateway filter.
 * It is designed to be used with Spring Cloud Gateway's filter factory pattern, allowing
 * for dynamic configuration of filter behavior through Spring Boot's configuration properties.
 * </p>
 * <p>
 * Configuration Example (application.yml):
 * <pre>{@code
 * spring:
 *   cloud:
 *     gateway:
 *       routes:
 *         - id: admin-service
 *           uri: http://localhost:8080
 *           filters:
 *             - TokenValidate
 * 
 * gateway:
 *   filter:
 *     white-path-list:
 *       - /api/short-link/admin/v1/user
 *       - /api/short-link/admin/v1/health
 * }</pre>
 * </p>
 * <p>
 * The configuration is automatically bound to this class by Spring Boot's @ConfigurationProperties
 * mechanism, using the prefix "gateway.filter".
 * </p>
 * <p>
 * Thread Safety: This class is immutable after construction and thread-safe for read operations.
 * </p>
 * 
 * @author 马丁玩编程 (Martin Plays Programming)
 * @version 1.0.0
 * @since 2024
 * @see TokenValidateGatewayFilterFactory
 * @see org.springframework.boot.context.properties.ConfigurationProperties
 */
@Data
public class Config {

    /**
     * White-list Path Prefixes
     * <p>
     * A list of URL path prefixes that are exempt from authentication requirements.
     * Any incoming request whose path starts with one of these prefixes will be
     * allowed to proceed without token validation.
     * </p>
     * <p>
     * Use Cases:
     * <ul>
     *   <li>Public endpoints (health checks, status pages)</li>
     *   <li>Authentication endpoints (login, registration)</li>
     *   <li>Static resource endpoints</li>
     *   <li>API documentation endpoints</li>
     * </ul>
     * </p>
     * <p>
     * Matching Logic: The filter uses prefix matching (path.startsWith(whitelistEntry)),
     * so "/api/public" will match "/api/public/endpoint1", "/api/public/endpoint2", etc.
     * </p>
     * <p>
     * Security Considerations:
     * <ul>
     *   <li>Be cautious when adding paths to the white-list</li>
     *   <li>Avoid overly broad prefixes that might expose sensitive endpoints</li>
     *   <li>Regularly review and audit the white-list configuration</li>
     *   <li>Consider environment-specific white-lists (dev vs production)</li>
     * </ul>
     * </p>
     * 
     * @see TokenValidateGatewayFilterFactory#isPathInWhiteList(String, String, List)
     */
    private List<String> whitePathList;
}
