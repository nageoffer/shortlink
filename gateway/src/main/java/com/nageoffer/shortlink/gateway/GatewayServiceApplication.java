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

package com.nageoffer.shortlink.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Gateway Service Application Starter
 * <p>
 * This is the main entry point for the ShortLink Gateway Service, which acts as the API gateway
 * for the entire short link management system. The gateway serves as a reverse proxy, routing
 * requests to appropriate backend microservices while handling cross-cutting concerns such as
 * authentication, rate limiting, and request validation.
 * </p>
 * <p>
 * Key Responsibilities:
 * <ul>
 *   <li>Request routing to backend microservices (admin, link management, statistics)</li>
 *   <li>Token-based authentication validation for protected endpoints</li>
 *   <li>Request header transformation and propagation</li>
 *   <li>Access control through white-listing and authentication filters</li>
 *   <li>Centralized error handling and response formatting</li>
 * </ul>
 * </p>
 * <p>
 * Architecture Pattern: This follows the API Gateway pattern, providing a single entry point
 * for all client requests, which simplifies client-side code and enables better security
 * and monitoring capabilities.
 * </p>
 * <p>
 * Security Considerations:
 * <ul>
 *   <li>All requests (except white-listed) require valid authentication tokens</li>
 *   <li>Token validation is performed against Redis cache for performance</li>
 *   <li>User information is propagated to downstream services via HTTP headers</li>
 *   <li>White-list paths are configurable via application properties</li>
 * </ul>
 * </p>
 * 
 * @author 马丁玩编程 (Martin Plays Programming)
 * @version 1.0.0
 * @since 2024
 */
@SpringBootApplication
public class GatewayServiceApplication {

    /**
     * Main application entry point.
     * <p>
     * Initializes the Spring Boot application context, starts the embedded web server
     * (typically Tomcat, Jetty, or Undertow), and registers all configured gateway
     * filters, routes, and beans.
     * </p>
     * 
     * @param args command-line arguments passed to the application
     */
    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }
}
