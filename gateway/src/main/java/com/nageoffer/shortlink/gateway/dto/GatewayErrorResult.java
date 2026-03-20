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

package com.nageoffer.shortlink.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Gateway Error Response DTO
 * <p>
 * This class represents the standardized error response format returned by the gateway when
 * authentication or other validation failures occur. It follows a consistent structure for
 * all error responses to enable predictable client-side error handling.
 * </p>
 * <p>
 * Response Structure:
 * <pre>{@code
 * {
 *   "status": 401,
 *   "message": "Unauthorized request"
 * }
 * }</pre>
 * </p>
 * <p>
 * Usage Scenarios:
 * <ul>
 *   <li>Authentication failures (invalid or missing tokens)</li>
 *   <li>Invalid request format</li>
 *   <li>Rate limiting exceeded</li>
 *   <li>Any gateway-level validation failure</li>
 * </ul>
 * </p>
 * <p>
 * Design Patterns:
 * <ul>
 *   <li>DTO (Data Transfer Object) - used for data transfer between layers</li>
 *   <li>Builder pattern - enabled via Lombok's @Builder annotation</li>
 *   <li>Immutable response structure - ensures thread safety</li>
 * </ul>
 * </p>
 * <p>
 * Integration: This DTO is serialized to JSON using FastJSON2 and returned in the
 * response body with appropriate HTTP status codes.
 * </p>
 * 
 * @author 马丁玩编程 (Martin Plays Programming)
 * @version 1.0.0
 * @since 2024
 * @see com.alibaba.fastjson2.JSON
 * @see org.springframework.http.HttpStatus
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GatewayErrorResult {

    /**
     * HTTP Status Code
     * <p>
     * The standard HTTP status code indicating the result of the request.
     * Common values include:
     * <ul>
     *   <li>401 - Unauthorized (authentication failure)</li>
     *   <li>403 - Forbidden (insufficient permissions)</li>
     *   <li>404 - Not Found (invalid endpoint)</li>
     *   <li>429 - Too Many Requests (rate limiting)</li>
     *   <li>500 - Internal Server Error (gateway error)</li>
     * </ul>
     * </p>
     */
    private Integer status;

    /**
     * Error Message
     * <p>
     * A human-readable message describing the error. This message is intended for
     * client-side display and debugging purposes. For security reasons, detailed
     * error information should not be exposed in production environments.
     * </p>
     * <p>
     * Message Guidelines:
     * <ul>
     *   <li>Be clear and concise</li>
     *   <li>Avoid exposing internal implementation details</li>
     *   <li>Use consistent terminology</li>
     *   <li>Consider localization requirements</li>
     * </ul>
     * </p>
     */
    private String message;
}
