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
 * Short Link Locale Statistics Entity
 * <p>
 * This entity stores location-based access statistics for short links. It tracks traffic distribution
 * across different geographic regions (country, province, city) to help understand user geographic
 * distribution and optimize regional content delivery. The entity supports hierarchical location
 * data from country down to specific city codes.
 * </p>
 * <p>
 * Database table: t_link_locale_stats
 * </p>
 * <p>
 * Key fields:
 * <ul>
 *   <li><b>id</b>: Primary key identifier</li>
 *   <li><b>fullShortUrl</b>: Complete short link URL</li>
 *   <li><b>date</b>: Date of the statistics record</li>
 *   <li><b>cnt</b>: Count of accesses from this location</li>
 *   <li><b>country</b>: Country name or ISO code</li>
 *   <li><b>province</b>: Province or state name</li>
 *   <li><b>city</b>: City name</li>
 *   <li><b>adcode</b>: Administrative division code (postal code)</li>
 *   <li><b>BaseDO fields</b>: id, createTime, updateTime, delTime (soft delete)</li>
 * </ul>
 * </p>
 * <p>
 * Geographic data:
 * <ul>
 *   <li>Country: ISO 3166-1 alpha-2 or alpha-3 code</li>
 *   <li>Province: State or province name</li>
 *   <li>City: City or municipality name</li>
 *   <li>Adcode: China's administrative division code (6 digits)</li>
 *   <li>IP geolocation service for location detection</li>
 * </ul>
 * </p>
 * <p>
 * Use cases:
 * <ul>
 *   <li>Geographic traffic distribution analysis</li>
 *   <li>Regional marketing effectiveness tracking</li>
 *   <li>Content localization optimization</li>
 *   <li>Server load balancing by region</li>
 * </ul>
 * </p>
 * 
 * @author NageOffer
 * @version 1.0
 * @since 2024
 */
@Data
@TableName("t_link_locale_stats")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LinkLocaleStatsDO extends BaseDO {

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
     * 省份名称
     */
    private String province;

    /**
     * 市名称
     */
    private String city;

    /**
     * 城市编码
     */
    private String adcode;

    /**
     * 国家标识
     */
    private String country;
}
