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

package com.nageoffer.shortlink.admin.remote.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Short-link analytics response DTO
 * 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortLinkStatsRespDTO {

    /**
     * Visits
     */
    private Integer pv;

    /**
     * Unique visitors
     */
    private Integer uv;

    /**
     * Unique IPs
     */
    private Integer uip;

    /**
     * Basic visit statistics.
     */
    private List<ShortLinkStatsAccessDailyRespDTO> daily;

    /**
     * Region statistics (China only).
     */
    private List<ShortLinkStatsLocaleCNRespDTO> localeCnStats;

    /**
     * Hourly visit statistics.
     */
    private List<Integer> hourStats;

    /**
     * Top IP statistics.
     */
    private List<ShortLinkStatsTopIpRespDTO> topIpStats;

    /**
     * Weekday visit statistics.
     */
    private List<Integer> weekdayStats;

    /**
     * Browser statistics.
     */
    private List<ShortLinkStatsBrowserRespDTO> browserStats;

    /**
     * Operating system statistics.
     */
    private List<ShortLinkStatsOsRespDTO> osStats;

    /**
     * Visitor type statistics.
     */
    private List<ShortLinkStatsUvRespDTO> uvTypeStats;

    /**
     * Device statistics.
     */
    private List<ShortLinkStatsDeviceRespDTO> deviceStats;

    /**
     * Network statistics.
     */
    private List<ShortLinkStatsNetworkRespDTO> networkStats;
}
