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
 * Short Link Today's Statistics Entity
 * <p>
 * This entity stores real-time daily statistics for short links. It maintains a separate table
 * for today's PV, UV, and UIp counts that gets updated in real-time as traffic flows through
 * the system. This allows for quick access to current day statistics without scanning historical
 * data, improving query performance for dashboards and real-time monitoring.
 * </p>
 * <p>
 * Database table: t_link_stats_today
 * </p>
 * <p>
 * Key fields:
 * <ul>
 *   <li><b>id</b>: Primary key identifier</li>
 *   <li><b>fullShortUrl</b>: Complete short link URL</li>
 *   <li><b>date</b>: Current date for the statistics</li>
 *   <li><b>todayPv</b>: Page views for the current day</li>
 *   <li><b>todayUv</b>: Unique visitors for the current day</li>
 *   <li><b>todayUip</b>: Unique IP addresses for the current day</li>
 *   <li><b>BaseDO fields</b>: id, createTime, updateTime, delTime (soft delete)</li>
 * </ul>
 * </p>
 * <p>
 * Performance optimization:
 * <ul>
 *   <li>Separate table for fast read access to current day stats</li>
 *   <li>Upsert pattern prevents duplicate records</li>
 *   <li>Atomic updates ensure data consistency</li>
 *   <li>Separation from historical data improves query performance</li>
 * </ul>
 * </p>
 * <p>
 * Use cases:
 * <ul>
 *   <li>Real-time dashboard displays</li>
 *   <li>Current day performance monitoring</li>
 *   <li>Alerting on unusual traffic patterns</li>
 *   <li>Quick statistics retrieval for UI components</li>
 * </ul>
 * </p>
 * 
 * @author NageOffer
 * @version 1.0
 * @since 2024
 */
@TableName("t_link_stats_today")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LinkStatsTodayDO extends BaseDO {

    /**
     * id
     */
    private Long id;

    /**
     * 短链接
     */
    private String fullShortUrl;

    /**
     * 日期
     */
    private Date date;

    /**
     * 今日pv
     */
    private Integer todayPv;

    /**
     * 今日uv
     */
    private Integer todayUv;

    /**
     * 今日ip数
     */
    private Integer todayUip;
}
