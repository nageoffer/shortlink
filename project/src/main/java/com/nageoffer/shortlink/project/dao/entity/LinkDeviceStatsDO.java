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
 * Short Link Device Statistics Entity
 * <p>
 * This entity stores device-type-specific access statistics for short links. It tracks traffic
 * distribution across different device categories (mobile, desktop, tablet, etc.) to help understand
 * user access patterns and optimize the user experience for different device types.
 * </p>
 * <p>
 * Database table: t_link_device_stats
 * </p>
 * <p>
 * Key fields:
 * <ul>
 *   <li><b>id</b>: Primary key identifier</li>
 *   <li><b>fullShortUrl</b>: Complete short link URL</li>
 *   <li><b>date</b>: Date of the statistics record</li>
 *   <li><b>cnt</b>: Count of accesses from this device type</li>
 *   <li><b>device</b>: Device type (mobile, desktop, tablet, bot, etc.)</li>
 *   <li><b>BaseDO fields</b>: id, createTime, updateTime, delTime (soft delete)</li>
 * </ul>
 * </p>
 * <p>
 * Device detection:
 * <ul>
 *   <li>Device type extracted from HTTP User-Agent header</li>
 *   <li>Common categories: mobile, desktop, tablet, bot, console, etc.</li>
 *   <li>Responsive design optimization based on device distribution</li>
 * </ul>
 * </p>
 * <p>
 * Use cases:
 * <ul>
 *   <li>Responsive design validation and optimization</li>
 *   <li>Mobile traffic trend analysis</li>
 *   <li>Device-specific performance monitoring</li>
 *   <li>Resource allocation for different device types</li>
 * </ul>
 * </p>
 * 
 * @author NageOffer
 * @version 1.0
 * @since 2024
 */
@Data
@TableName("t_link_device_stats")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LinkDeviceStatsDO extends BaseDO {

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
     * 访问设备
     */
    private String device;
}
