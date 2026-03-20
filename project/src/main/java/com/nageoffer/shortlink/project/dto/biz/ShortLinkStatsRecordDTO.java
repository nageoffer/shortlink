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

package com.nageoffer.shortlink.project.dto.biz;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Short Link Statistics Record DTO
 * <p>
 * This Data Transfer Object (DTO) represents a statistics record for processing short link
 * access events. It is used internally by the system to collect and process access data
 * before persisting it to the database. It includes all necessary information for tracking
 * and analyzing short link traffic.
 * </p>
 * <p>
 * Key fields:
 * <ul>
 *   <li><b>fullShortUrl</b>: Complete short link URL</li>
 *   <li><b>remoteAddr</b>: Client IP address</li>
 *   <li><b>os</b>: Operating system name</li>
 *   <li><b>browser</b>: Browser name</li>
 *   <li><b>device</b>: Device type</li>
 *   <li><b>network</b>: Network type</li>
 *   <li><b>uv</b>: User identifier for visitor tracking</li>
 *   <li><b>uvFirstFlag</b>: Flag indicating if this is the user's first visit</li>
 *   <li><b>uipFirstFlag</b>: Flag indicating if this is the IP's first visit</li>
 *   <li><b>keys</b>: Message queue unique identifier for deduplication</li>
 *   <li><b>currentDate</b>: Current timestamp for statistics</li>
 * </ul>
 * </p>
 * <p>
 * Use cases:
 * <ul>
 *   <li>Message queue processing for async statistics</li>
 *   <li>Access event aggregation</li>
 *   <li>Duplicate request handling</li>
 *   <li>Real-time statistics collection</li>
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
public class ShortLinkStatsRecordDTO {

    /**
     * 完整短链接
     */
    private String fullShortUrl;

    /**
     * 访问用户IP
     */
    private String remoteAddr;

    /**
     * 操作系统
     */
    private String os;

    /**
     * 浏览器
     */
    private String browser;

    /**
     * 操作设备
     */
    private String device;

    /**
     * 网络
     */
    private String network;

    /**
     * UV
     */
    private String uv;

    /**
     * UV访问标识
     */
    private Boolean uvFirstFlag;

    /**
     * UIP访问标识
     */
    private Boolean uipFirstFlag;

    /**
     * 消息队列唯一标识
     */
    private String keys;

    /**
     * 当前时间
     */
    private Date currentDate;
}
