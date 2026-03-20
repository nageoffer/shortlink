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
 * Short Link Network Statistics Response DTO
 * <p>
 * This Data Transfer Object (DTO) represents network-type statistics for a short link.
 * It includes the count of accesses from a specific network type and the percentage of total
 * traffic from that network type.
 * </p>
 * <p>
 * Key fields:
 * <ul>
 *   <li><b>cnt</b>: Count of accesses from this network type</li>
 *   <li><b>network</b>: Network type (WiFi, 4G, 5G, etc.)</li>
 *   <li><b>ratio</b>: Percentage of total traffic (0.0 - 1.0)</li>
 * </ul>
 * </p>
 * <p>
 * Use cases:
 * <ul>
 *   <li>Network distribution charts</li>
 *   <li>Mobile data usage analysis</li>
 *   <li>Network performance optimization</li>
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
public class ShortLinkStatsNetworkRespDTO {

    /**
     * 统计
     */
    private Integer cnt;

    /**
     * 访问网络
     */
    private String network;

    /**
     * 占比
     */
    private Double ratio;
}
