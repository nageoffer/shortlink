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

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Demo Mode Configuration Properties
 * <p>
 * This class holds the configuration properties for the demo mode feature. It is bound to
 * configuration properties with the prefix "short-link.demo-mode" using Spring Boot's
 * {@link ConfigurationProperties} mechanism.
 * </p>
 * <p>
 * Configuration Example (application.yml):
 * <pre>{@code
 * short-link:
 *   demo-mode:
 *     enable: true
 *     blacklist:
 *       - /api/short-link/admin/v1/user
 *       - /api/short-link/admin/v1/group
 *       - /api/short-link/admin/v1/short-link
 * }</pre>
 * </p>
 * <p>
 * Property Details:
 * <ul>
 *   <li>enable: When true, activates demo mode restrictions</li>
 *   <li>blacklist: List of paths that should be restricted in demo mode</li>
 * </ul>
 * </p>
 * <p>
 * Blacklist Path Guidelines:
 * <ul>
 *   <li>Include paths that modify user data (create, update, delete users)</li>
 *   <li>Include paths that modify link configurations</li>
 *   <li>Include paths that modify group settings</li>
 *   <li>Exclude read-only endpoints (statistics, queries)</li>
 * </ul>
 * </p>
 * <p>
 * Thread Safety: This class is immutable after Spring Boot's property binding and
 * is thread-safe for read operations.
 * </p>
 * 
 * @author 马丁玩编程 (Martin Plays Programming)
 * @version 1.0.0
 * @since 2024
 * @see DemoModeConfiguration
 * @see org.springframework.boot.context.properties.ConfigurationProperties
 */
@Data
@Component
@ConfigurationProperties(prefix = "short-link.demo-mode")
public class DemoModeProperties {

    /**
     * Enable Demo Mode
     * <p>
     * When set to true, the demo mode interceptor will block write operations on
     * blacklisted paths. When false, all operations are allowed without restrictions.
     * </p>
     * <p>
     * Default: false
     * </p>
     */
    private Boolean enable;

    /**
     * Blacklist of Restricted Paths
     * <p>
     * A list of URL paths that should be restricted in demo mode. Only GET requests
     * to these paths will be allowed; all other HTTP methods will be blocked.
     * </p>
     * <p>
     * Path Matching: Exact path matching is used (not prefix matching).
     * Each path in the list must match the request URI exactly.
     * </p>
     * <p>
     * Example Paths:
     * <ul>
     *   <li>/api/short-link/admin/v1/user - User management endpoints</li>
     *   <li>/api/short-link/admin/v1/group - Group management endpoints</li>
     *   <li>/api/short-link/admin/v1/short-link - Link management endpoints</li>
     * </ul>
     * </p>
     */
    private List<String> blacklist;
}
