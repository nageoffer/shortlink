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

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.nageoffer.shortlink.project.common.database.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Short Link Entity
 * <p>
 * This entity represents a complete short link record in the system. It stores all information
 * about a short link including the original long URL, domain, group association, expiration
 * settings, and comprehensive statistics. This is the core entity of the short link system.
 * </p>
 * <p>
 * Database table: t_link
 * </p>
 * <p>
 * Key fields:
 * <ul>
 *   <li><b>id</b>: Primary key identifier</li>
 *   <li><b>domain</b>: Domain hosting the short link</li>
 *   <li><b>shortUri</b>: Unique short URI (e.g., "abc123")</li>
 *   <li><b>fullShortUrl</b>: Complete short URL (domain + shortUri)</li>
 *   <li><b>originUrl</b>: Original long URL to redirect to</li>
 *   <li><b>clickNum</b>: Click count (deprecated, use totalPv)</li>
 *   <li><b>gid</b>: Group identifier for categorization</li>
 *   <li><b>enableStatus</b>: Enable flag (0: enabled, 1: disabled)</li>
 *   <li><b>createdType</b>: Creation type (0: API, 1: Console)</li>
 *   <li><b>validDateType</b>: Expiration type (0: permanent, 1: custom)</li>
 *   <li><b>validDate</b>: Expiration date for custom expiration</li>
 *   <li><b>describe</b>: User-provided description</li>
 *   <li><b>favicon</b>: Website favicon URL</li>
 *   <li><b>totalPv/totalUv/totalUip</b>: Historical statistics</li>
 *   <li><b>delTime</b>: Soft delete timestamp</li>
 * </ul>
 * </p>
 * <p>
 * Statistics fields (transient):
 * <ul>
 *   <li><b>todayPv/todayUv/todayUip</b>: Today's statistics (not persisted)</li>
 * </ul>
 * </p>
 * <p>
 * Use cases:
 * <ul>
 *   <li>Short link creation and management</li>
 *   <li>Link expiration handling</li>
 *   <li>Soft delete for link removal</li>
 *   <li>Statistics aggregation and reporting</li>
 *   <li>Group-based link organization</li>
 * </ul>
 * </p>
 * 
 * @author NageOffer
 * @version 1.0
 * @since 2024
 */
@Data
@Builder
@TableName("t_link")
@NoArgsConstructor
@AllArgsConstructor
public class ShortLinkDO extends BaseDO {

    /**
     * id
     */
    private Long id;

    /**
     * 域名
     */
    private String domain;

    /**
     * 短链接
     */
    private String shortUri;

    /**
     * 完整短链接
     */
    private String fullShortUrl;

    /**
     * 原始链接
     */
    private String originUrl;

    /**
     * 点击量
     */
    private Integer clickNum;

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 启用标识 0：启用 1：未启用
     */
    private Integer enableStatus;

    /**
     * 创建类型 0：接口创建 1：控制台创建
     */
    private Integer createdType;

    /**
     * 有效期类型 0：永久有效 1：自定义
     */
    private Integer validDateType;

    /**
     * 有效期
     */
    private Date validDate;

    /**
     * 描述
     */
    @TableField("`describe`")
    private String describe;

    /**
     * 网站标识
     */
    private String favicon;

    /**
     * 历史PV
     */
    private Integer totalPv;

    /**
     * 历史UV
     */
    private Integer totalUv;

    /**
     * 历史UIP
     */
    private Integer totalUip;

    /**
     * 今日PV
     */
    @TableField(exist = false)
    private Integer todayPv;

    /**
     * 今日UV
     */
    @TableField(exist = false)
    private Integer todayUv;

    /**
     * 今日UIP
     */
    @TableField(exist = false)
    private Integer todayUip;

    /**
     * 删除时间
     */
    private Long delTime;
}
