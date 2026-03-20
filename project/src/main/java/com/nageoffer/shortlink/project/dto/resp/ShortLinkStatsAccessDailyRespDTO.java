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

package com.nageoffer.shortlink.project.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Short Link Base Access Statistics Response DTO
 * <p>
 * This Data Transfer Object (DTO) represents daily access statistics for a short link.
 * It includes PV (Page Views), UV (Unique Visitors), and UIp (Unique IP) counts for
 * a specific date.
 * </p>
 * <p>
 * Key fields:
 * <ul>
 *   <li><b>date</b>: Date of the statistics (format: yyyy-MM-dd)</li>
 *   <li><b>pv</b>: Page Views - total number of accesses</li>
 *   <li><b>uv</b>: Unique Visitors - distinct users</li>
 *   <li><b>uip</b>: Unique IP addresses - distinct IPs</li>
 * </ul>
 * </p>
 * <p>
 * Use cases:
 * <ul>
 *   <li>Daily traffic reports</li>
 *   <li>Time-series data for charts</li>
 *   <li>Performance trend analysis</li>
 * </ul>
 * </p>
 * 
 * @author NageOffer
 * @version 1.0
 * @since 2024
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortLinkStatsAccessDailyRespDTO {

    /**
     * 日期
     */
    private String date;

    /**
     * 访问量
     */
    private Integer pv;

    /**
     * 独立访客数
     */
    private Integer uv;

    /**
     * 独立IP数
     */
    private Integer uip;
}
