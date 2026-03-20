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

package com.nageoffer.shortlink.project.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nageoffer.shortlink.project.dao.entity.LinkStatsTodayDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * Short Link Today's Statistics Mapper
 * <p>
 * This mapper handles real-time daily statistics tracking for short links. It maintains a separate
 * table for today's PV, UV, and UIp counts that gets updated in real-time as traffic flows through
 * the system. This allows for quick access to current day statistics without scanning historical data.
 * </p>
 * <p>
 * Key responsibilities:
 * <ul>
 *   <li>CRUD operations for LinkStatsTodayDO entities</li>
 *   <li>Real-time daily statistics aggregation</li>
 *   <li>Separate tracking for today's metrics vs historical data</li>
 *   <li>Efficient upsert operations for high-frequency updates</li>
 * </ul>
 * </p>
 * <p>
 * Data model:
 * <ul>
 *   <li><b>fullShortUrl</b>: The complete short link identifier</li>
 *   <li><b>todayPv</b>: Page views for the current day</li>
 *   <li><b>todayUv</b>: Unique visitors for the current day</li>
 *   <li><b>todayUip</b>: Unique IP addresses for the current day</li>
 *   <li><b>date</b>: Current date for the statistics</li>
 * </ul>
 * </p>
 * <p>
 * Performance considerations:
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
public interface LinkStatsTodayMapper extends BaseMapper<LinkStatsTodayDO> {

    /**
     * 记录今日统计监控数据
     */
    @Insert("INSERT INTO " +
            "t_link_stats_today (full_short_url, date,  today_uv, today_pv, today_uip, create_time, update_time, del_flag) " +
            "VALUES( #{linkTodayStats.fullShortUrl}, #{linkTodayStats.date}, #{linkTodayStats.todayUv}, #{linkTodayStats.todayPv}, #{linkTodayStats.todayUip}, NOW(), NOW(), 0) " +
            "ON DUPLICATE KEY UPDATE today_uv = today_uv +  #{linkTodayStats.todayUv}, today_pv = today_pv +  #{linkTodayStats.todayPv}, today_uip = today_uip +  #{linkTodayStats.todayUip};")
    void shortLinkTodayState(@Param("linkTodayStats") LinkStatsTodayDO linkStatsTodayDO);
}
