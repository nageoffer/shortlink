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
 * Short Link Group Statistics Request DTO
 * <p>
 * This Data Transfer Object (DTO) encapsulates parameters for querying aggregated statistics
 * for all short links within a specific group. It includes the group identifier and date range
 * to retrieve comprehensive traffic analytics for an entire group of links.
 * </p>
 * <p>
 * Key fields:
 * <ul>
 *   <li><b>gid</b>: Group identifier to query statistics for all links in the group</li>
 *   <li><b>startDate</b>: Start date for statistics range (inclusive)</li>
 *   <li><b>endDate</b>: End date for statistics range (inclusive)</li>
 * </ul>
 * </p>
 * <p>
 * Statistics data:
 * <ul>
 *   <li>Group-level PV, UV, UIp aggregation</li>
 *   <li>Link count within the group</li>
 *   <li>Average traffic per link</li>
 *   <li>Top performing links in the group</li>
 *   <li>Group traffic trends over time</li>
 * </ul>
 * </p>
 * <p>
 * Query behavior:
 * <ul>
 *   <li>Aggregates statistics across all links in the group</li>
 *   <li>Filters by enable status (only enabled links)</li>
 *   <li>Excludes soft-deleted links (del_flag = 0)</li>
 *   <li>Supports time-series analysis</li>
 * </ul>
 * </p>
 * <p>
 * Use cases:
 * <ul>
 *   <li>Group-level performance overview</li>
 *   <li>Comparing performance across different groups</li>
 *   <li>Resource allocation based on group traffic</li>
 *   <li>Marketing campaign analysis by group</li>
 * </ul>
 * </p>
 * 
 * @author NageOffer
 * @version 1.0
 * @since 2024
 */
@Data
public class ShortLinkGroupStatsReqDTO {

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
}
