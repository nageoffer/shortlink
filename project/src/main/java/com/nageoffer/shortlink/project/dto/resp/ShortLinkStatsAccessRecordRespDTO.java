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

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Short Link Access Record Response DTO
 * <p>
 * This Data Transfer Object (DTO) represents a detailed access log record for a short link.
 * It includes comprehensive information about each visit including user type, browser, OS,
 * device, network, location, and timestamp.
 * </p>
 * <p>
 * Key fields:
 * <ul>
 *   <li><b>uvType</b>: Visitor type (新访客: new, 老访客: returning)</li>
 *   <li><b>browser</b>: Browser name</li>
 *   <li><b>os</b>: Operating system name</li>
 *   <li><b>ip</b>: Client IP address</li>
 *   <li><b>network</b>: Network type (WiFi, 4G, 5G, etc.)</li>
 *   <li><b>device</b>: Device type (mobile, desktop, tablet, etc.)</li>
 *   <li><b>locale</b>: Geographic location</li>
 *   <li><b>user</b>: User identifier</li>
 *   <li><b>createTime</b>: Access timestamp</li>
 * </ul>
 * </p>
 * <p>
 * Use cases:
 * <ul>
 *   <li>Detailed access log display in console</li>
 *   <li>Security audit and monitoring</li>
 *   <li>User behavior analysis</li>
 *   <li>Exporting access logs for analysis</li>
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
public class ShortLinkStatsAccessRecordRespDTO {

    /**
     * 访客类型
     */
    private String uvType;

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

    /**
     * 用户信息
     */
    private String user;

    /**
     * 访问时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
