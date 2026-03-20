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

/**
 * Short Link Access Log Entity
 * <p>
 * This entity stores detailed access log records for each short link click. It captures comprehensive
 * information about each visit including user identifier, browser, operating system, IP address,
 * network type, device type, and geographic location. This data is essential for detailed traffic
 * analysis and user behavior understanding.
 * </p>
 * <p>
 * Database table: t_link_access_logs
 * </p>
 * <p>
 * Key fields:
 * <ul>
 *   <li><b>id</b>: Primary key identifier</li>
 *   <li><b>fullShortUrl</b>: Complete short link URL that was accessed</li>
 *   <li><b>user</b>: User identifier (cookie, session, or user ID)</li>
 *   <li><b>browser</b>: Browser name extracted from user agent</li>
 *   <li><b>os</b>: Operating system name extracted from user agent</li>
 *   <li><b>ip</b>: Client IP address</li>
 *   <li><b>network</b>: Network type (WiFi, 4G, 5G, etc.)</li>
 *   <li><b>device</b>: Device type (mobile, desktop, tablet, etc.)</li>
 *   <li><b>locale</b>: Geographic location information</li>
 *   <li><b>BaseDO fields</b>: id, createTime, updateTime, delTime (soft delete)</li>
 * </ul>
 * </p>
 * <p>
 * Data collection:
 * <ul>
 *   <li>User agent parsing for browser, OS, and device detection</li>
 *   <li>IP geolocation for locale information</li>
 *   <li>Network type detection via mobile network indicators</li>
 *   <li>User tracking via cookies or authentication tokens</li>
 * </ul>
 * </p>
 * <p>
 * Use cases:
 * <ul>
 *   <li>Detailed traffic analysis and reporting</li>
 *   <li>Security monitoring and fraud detection</li>
 *   <li>User behavior analysis and funnel tracking</li>
 *   <li>Geographic distribution analysis</li>
 *   <li>Device and browser compatibility monitoring</li>
 * </ul>
 * </p>
 * 
 * @author NageOffer
 * @version 1.0
 * @since 2024
 */
@Data
@TableName("t_link_access_logs")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LinkAccessLogsDO extends BaseDO {

    /**
     * id
     */
    private Long id;

    /**
     * 完整短链接
     */
    private String fullShortUrl;

    /**
     * 用户信息
     */
    private String user;

    /**
     * 浏览器
     */
    private String browser;

    /**
     * 操作系统
     */
    private String os;

    /**
     * ip
     */
    private String ip;

    /**
     * 访问网络
     */
    private String network;

    /**
     * 访问设备
     */
    private String device;

    /**
     * 地区
     */
    private String locale;
}
