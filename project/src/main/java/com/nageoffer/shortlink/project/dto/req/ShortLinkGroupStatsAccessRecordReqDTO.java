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

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nageoffer.shortlink.project.dao.entity.LinkAccessLogsDO;
import lombok.Data;

/**
 * Short Link Group Access Record Pagination Request DTO
 * <p>
 * This Data Transfer Object (DTO) extends MyBatis-Plus Page class to provide pagination support
 * for querying access logs within a specific group. It includes group identifier and date range
 * to retrieve detailed access records for all links in a group with pagination.
 * </p>
 * <p>
 * Inherited from Page<LinkAccessLogsDO>:
 * <ul>
 *   <li><b>current</b>: Current page number (1-indexed)</li>
 *   <li><b>size</b>: Number of records per page</li>
 *   <li><b>total</b>: Total number of records</li>
 *   <li><b>records</b>: List of LinkAccessLogsDO records</li>
 * </ul>
 * </p>
 * <p>
 * Additional fields:
 * <ul>
 *   <li><b>gid</b>: Group identifier for filtering access logs</li>
 *   <li><b>startDate</b>: Start date for statistics range (inclusive)</li>
 *   <li><b>endDate</b>: End date for statistics range (inclusive)</li>
 * </ul>
 * </p>
 * <p>
 * Access log data:
 * <ul>
 *   <li>User identifier</li>
 *   <li>Browser and OS information</li>
 *   <li>IP address and network type</li>
 *   <li>Device type and geographic location</li>
 *   <li>Access timestamp</li>
 * </ul>
 * </p>
 * <p>
 * Query behavior:
 * <ul>
 *   <li>Filters access logs by group and date range</li>
 *   <li>Includes only enabled links (enable_status = 0)</li>
 *   <li>Excludes soft-deleted links (del_flag = 0)</li>
 *   <li>Orders by creation time descending (most recent first)</li>
 * </ul>
 * </p>
 * <p>
 * Use cases:
 * <ul>
 *   <li>Detailed access log browsing in console</li>
 *   <li>Security audit and monitoring</li>
 *   <li>Investigating suspicious traffic patterns</li>
 *   <li>Exporting access logs for analysis</li>
 * </ul>
 * </p>
 * 
 * @author NageOffer
 * @version 1.0
 * @since 2024
 */
@Data
public class ShortLinkGroupStatsAccessRecordReqDTO extends Page<LinkAccessLogsDO> {

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
