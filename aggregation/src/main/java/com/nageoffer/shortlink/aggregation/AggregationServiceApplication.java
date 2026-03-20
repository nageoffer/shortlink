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

package com.nageoffer.shortlink.aggregation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Aggregation Service Application
 * <p>
 * This is the main entry point for the ShortLink Aggregation Service, which serves as a unified
 * application that combines multiple microservices (admin, project, aggregation) into a single
 * deployable unit. This approach simplifies deployment and reduces operational complexity while
 * maintaining modular code organization.
 * </p>
 * <p>
 * Architecture Pattern: This follows a hybrid architecture combining microservices and monolith
 * patterns. During development, individual services can be developed and tested separately.
 * For production, the aggregation service combines all functionality into a single application.
 * </p>
 * <p>
 * Component Scanning:
 * <ul>
 *   <li>com.nageoffer.shortlink.admin - Admin module for user and group management</li>
 *   <li>com.nageoffer.shortlink.project - Project module for link management and statistics</li>
 *   <li>com.nageoffer.shortlink.aggregation - Aggregation-specific configurations and services</li>
 * </ul>
 * </p>
 * <p>
 * MyBatis Mapper Scanning:
 * <ul>
 *   <li>com.nageoffer.shortlink.project.dao.mapper - Project module data access objects</li>
 *   <li>com.nageoffer.shortlink.admin.dao.mapper - Admin module data access objects</li>
 * </ul>
 * </p>
 * <p>
 * Service Discovery: Enabled via {@link EnableDiscoveryClient} for integration with service
 * discovery mechanisms like Nacos, Eureka, or Consul.
 * </p>
 * <p>
 * Use Cases:
 * <ul>
 *   <li>Simplified development and testing environment</li>
 *   <li>Small to medium-scale deployments</li>
 *   <li>Demo and demonstration environments</li>
 *   <li>Gradual migration from monolith to microservices</li>
 * </ul>
 * </p>
 * 
 * @author 马丁玩编程 (Martin Plays Programming)
 * @version 1.0.0
 * @since 2024
 * @see org.springframework.boot.SpringApplication
 * @see org.springframework.cloud.client.discovery.EnableDiscoveryClient
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {
        "com.nageoffer.shortlink.admin",
        "com.nageoffer.shortlink.project",
        "com.nageoffer.shortlink.aggregation"
})
@MapperScan(value = {
        "com.nageoffer.shortlink.project.dao.mapper",
        "com.nageoffer.shortlink.admin.dao.mapper"
})
public class AggregationServiceApplication {

    /**
     * Main application entry point.
     * <p>
     * Initializes the Spring Boot application context, registers all configured beans
     * from the scanned packages, starts the embedded web server, and registers the
     * demo mode interceptor for public deployments.
     * </p>
     * 
     * @param args command-line arguments passed to the application
     */
    public static void main(String[] args) {
        SpringApplication.run(AggregationServiceApplication.class, args);
    }
}