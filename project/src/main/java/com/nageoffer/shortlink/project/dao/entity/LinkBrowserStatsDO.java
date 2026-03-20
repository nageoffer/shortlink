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
 * Short Link Browser Statistics Entity
 * <p>
 * This entity stores browser-specific access statistics for short links. It tracks the distribution
 * of traffic across different web browsers to help understand user browser preferences and optimize
 * compatibility testing efforts. Each record represents a unique combination of short link, date,
 * and browser with a count of accesses.
 * </p>
 * <p>
 * Database table: t_link_browser_stats
 * </p>
 * <p>
 * Key fields:
 * <ul>
 *   <li><b>id</b>: Primary key identifier</li>
 *   <li><b>fullShortUrl</b>: Complete short link URL</li>
 *   <li><b>date</b>: Date of the statistics record</li>
 *   <li><b>cnt</b>: Count of accesses from this browser</li>
 *   <li><b>browser</b>: Browser name (Chrome, Firefox, Safari, Edge, etc.)</li>
 *   <li><b>BaseDO fields</b>: id, createTime, updateTime, delTime (soft delete)</li>
 * </ul>
 * </p>
 * <p>
 * Browser detection:
 * <ul>
 *   <li>Browser name extracted from HTTP User-Agent header</li>
 *   <li>Common browsers: Chrome, Firefox, Safari, Edge, Opera, Brave, etc.</li>
 *   <li>Bot detection for non-human traffic filtering</li>
 * </ul>
 * </p>
 * <p>
 * Use cases:
 * <ul>
 *   <li>Browser compatibility testing prioritization</li>
 *   <li>Frontend development resource allocation</li>
 *   <li>Understanding user demographics by browser preference</li>
 *   <li>Reporting browser distribution to stakeholders</li>
 * </ul>
 * </p>
 * 
 * @author NageOffer
 * @version 1.0
 * @since 2024
 */
@Data
@TableName("t_link_browser_stats")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LinkBrowserStatsDO extends BaseDO {

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
     * 浏览器
     */
    private String browser;
}
