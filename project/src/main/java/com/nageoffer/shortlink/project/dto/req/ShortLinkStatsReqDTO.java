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

package com.nageoffer.shortlink.project.dto.req;

import lombok.Data;

/**
 * Short Link Statistics Request DTO
 * <p>
 * This Data Transfer Object (DTO) encapsulates parameters for querying statistics for a specific
 * short link. It includes the link identifier, group information, date range, and enable status
 * filter to retrieve comprehensive traffic analytics for a single short link.
 * </p>
 * <p>
 * Key fields:
 * <ul>
 *   <li><b>fullShortUrl</b>: Complete short link URL to query statistics</li>
 *   <li><b>gid</b>: Group identifier for validation and categorization</li>
 *   <li><b>startDate</b>: Start date for statistics range (inclusive)</li>
 *   <li><b>endDate</b>: End date for statistics range (inclusive)</li>
 *   <li><b>enableStatus</b>: Enable status filter (0: enabled, 1: disabled)</li>
 * </ul>
 * </p>
 * <p>
 * Statistics data:
 * <ul>
 *   <li>PV (Page Views): Total number of accesses</li>
 *   <li>UV (Unique Visitors): Distinct users</li>
 *   <li>UIP (Unique IP): Distinct IP addresses</li>
 *   <li>Browser distribution</li>
 *   <li>OS distribution</li>
 *   <li>Device distribution</li>
 *   <li>Geographic distribution</li>
 *   <li>Network type distribution</li>
 *   <li>Hourly traffic patterns</li>
 *   <li>Weekly traffic patterns</li>
 * </ul>
 * </p>
 * <p>
 * Use cases:
 * <ul>
 *   <li>Detailed traffic analysis for specific short links</li>
 *   <li>Performance monitoring dashboards</li>
 *   <li>Marketing campaign effectiveness tracking</li>
 *   <li>Security monitoring for unusual traffic patterns</li>
 * </ul>
 * </p>
 * 
 * @author NageOffer
 * @version 1.0
 * @since 2024
 */
@Data
public class ShortLinkStatsReqDTO {

    /**
     * 完整短链接
     */
    private String fullShortUrl;

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 开始日期
     */
    private String startDate;

    /**
     * 结束日期
     */
    private String endDate;

    /**
     * 启用标识 0：启用 1：未启用
     */
    private Integer enableStatus;
}
