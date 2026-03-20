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
 * Short Link Base Access Statistics Entity
 * <p>
 * This entity stores aggregated access statistics for short links at different time granularities.
 * It maintains daily, hourly, and weekday-level statistics for PV (Page Views), UV (Unique Visitors),
 * and UIp (Unique IP addresses). This table is optimized for fast querying of traffic patterns
 * without scanning detailed access logs.
 * </p>
 * <p>
 * Database table: t_link_access_stats
 * </p>
 * <p>
 * Key fields:
 * <ul>
 *   <li><b>id</b>: Primary key identifier</li>
 *   <li><b>fullShortUrl</b>: Complete short link URL</li>
 *   <li><b>date</b>: Date of the statistics record</li>
 *   <li><b>pv</b>: Page Views - total number of accesses</li>
 *   <li><b>uv</b>: Unique Visitors - distinct users</li>
 *   <li><b>uip</b>: Unique IP addresses - distinct IPs</li>
 *   <li><b>hour</b>: Hour of day (0-23) for hourly breakdown</li>
 *   <li><b>weekday</b>: Day of week (0-6) for weekly patterns</li>
 *   <li><b>BaseDO fields</b>: id, createTime, updateTime, delTime (soft delete)</li>
 * </ul>
 * </p>
 * <p>
 * Data aggregation:
 * <ul>
 *   <li>Daily aggregation: hour and weekday are NULL</li>
 *   <li>Hourly aggregation: date is the specific date, hour is 0-23</li>
 *   <li>Weekly aggregation: date is the specific date, weekday is 0-6</li>
 * </ul>
 * </p>
 * <p>
 * Use cases:
 * <ul>
 *   <li>Fast retrieval of traffic statistics</li>
 *   <li>Generating daily/weekly reports</li>
 *   <li>Identifying peak usage hours</li>
 *   <li>Understanding weekly traffic patterns</li>
 *   <li>Performance monitoring dashboards</li>
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
@TableName("t_link_access_stats")
public class LinkAccessStatsDO extends BaseDO {

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
    private Integer pv;

    /**
     * 独立访客数
     */
    private Integer uv;

    /**
     * 独立ip数
     */
    private Integer uip;

    /**
     * 小时
     */
    private Integer hour;

    /**
     * 星期
     */
    private Integer weekday;
}
