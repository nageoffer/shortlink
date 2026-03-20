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

import java.util.List;

/**
 * Short Link Statistics Response DTO
 * <p>
 * This Data Transfer Object (DTO) represents comprehensive statistics for a short link.
 * It includes overall metrics (PV, UV, UIp) and detailed breakdowns by various dimensions
 * including time, location, browser, OS, device, and network.
 * </p>
 * <p>
 * Key fields:
 * <ul>
 *   <li><b>pv</b>: Total Page Views</li>
 *   <li><b>uv</b>: Total Unique Visitors</li>
 *   <li><b>uip</b>: Total Unique IP addresses</li>
 *   <li><b>daily</b>: Daily statistics list</li>
 *   <li><b>localeCnStats</b>: Domestic geographic distribution</li>
 *   <li><b>hourStats</b>: Hourly traffic pattern (0-23)</li>
 *   <li><b>topIpStats</b>: Top IP addresses by traffic</li>
 *   <li><b>weekdayStats</b>: Weekly traffic pattern (0-6)</li>
 *   <li><b>browserStats</b>: Browser distribution</li>
 *   <li><b>osStats</b>: OS distribution</li>
 *   <li><b>uvTypeStats</b>: New vs returning visitor distribution</li>
 *   <li><b>deviceStats</b>: Device type distribution</li>
 *   <li><b>networkStats</b>: Network type distribution</li>
 * </ul>
 * </p>
 * <p>
 * Use cases:
 * <ul>
 *   <li>Comprehensive traffic reports</li>
 *   <li>Dashboard analytics display</li>
 *   <li>Performance monitoring</li>
 *   <li>Marketing campaign analysis</li>
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
public class ShortLinkStatsRespDTO {

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

    /**
     * 基础访问详情
     */
    private List<ShortLinkStatsAccessDailyRespDTO> daily;

    /**
     * 地区访问详情（仅国内）
     */
    private List<ShortLinkStatsLocaleCNRespDTO> localeCnStats;

    /**
     * 小时访问详情
     */
    private List<Integer> hourStats;

    /**
     * 高频访问IP详情
     */
    private List<ShortLinkStatsTopIpRespDTO> topIpStats;

    /**
     * 一周访问详情
     */
    private List<Integer> weekdayStats;

    /**
     * 浏览器访问详情
     */
    private List<ShortLinkStatsBrowserRespDTO> browserStats;

    /**
     * 操作系统访问详情
     */
    private List<ShortLinkStatsOsRespDTO> osStats;

    /**
     * 访客访问类型详情
     */
    private List<ShortLinkStatsUvRespDTO> uvTypeStats;

    /**
     * 访问设备类型详情
     */
    private List<ShortLinkStatsDeviceRespDTO> deviceStats;

    /**
     * 访问网络类型详情
     */
    private List<ShortLinkStatsNetworkRespDTO> networkStats;
}
