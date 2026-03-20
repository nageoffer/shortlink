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

package com.nageoffer.shortlink.project.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.nageoffer.shortlink.project.common.database.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Short Link Network Statistics Entity
 * <p>
 * This entity stores network-type-specific access statistics for short links. It tracks traffic
 * distribution across different network types (WiFi, 4G, 5G, etc.) to help understand user connectivity
 * patterns and optimize network performance for different connection types. This is particularly
 * valuable for mobile traffic analysis and bandwidth planning.
 * </p>
 * <p>
 * Database table: t_link_network_stats
 * </p>
 * <p>
 * Key fields:
 * <ul>
 *   <li><b>id</b>: Primary key identifier</li>
 *   <li><b>fullShortUrl</b>: Complete short link URL</li>
 *   <li><b>date</b>: Date of the statistics record</li>
 *   <li><b>cnt</b>: Count of accesses from this network type</li>
 *   <li><b>network</b>: Network type (WiFi, 4G, 5G, 3G, 2G, etc.)</li>
 *   <li><b>BaseDO fields</b>: id, createTime, updateTime, delTime (soft delete)</li>
 * </ul>
 * </p>
 * <p>
 * Network detection:
 * <ul>
 *   <li>Network type detected via mobile network indicators in user agent</li>
 *   <li>Common types: WiFi, 4G, 5G, 3G, 2G, Ethernet, etc.</li>
 *   <li>Useful for mobile data usage analysis and optimization</li>
 * </ul>
 * </p>
 * <p>
 * Use cases:
 * <ul>
 *   <li>Network performance optimization</li>
 *   <li>Mobile data usage analysis</li>
 *   <li>Bandwidth allocation planning</li>
 *   <li>Network-specific user behavior analysis</li>
 * </ul>
 * </p>
 * 
 * @author NageOffer
 * @version 1.0
 * @since 2024
 */
@Data
@TableName("t_link_network_stats")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LinkNetworkStatsDO extends BaseDO {

    /**
     * id
     */
    private Long id;

    /**
     * 完整短链接
     */
    private String fullShortUrl;

    /**
     * 日期
     */
    private Date date;

    /**
     * 访问量
     */
    private Integer cnt;

    /**
     * 访问网络
     */
    private String network;
}
