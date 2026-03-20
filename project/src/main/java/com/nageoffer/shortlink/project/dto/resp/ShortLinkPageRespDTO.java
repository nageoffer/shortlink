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
import lombok.Data;

import java.util.Date;

/**
 * Short Link Pagination Response DTO
 * <p>
 * This Data Transfer Object (DTO) represents a short link record for display in paginated
 * lists in the console. It includes comprehensive information about the link including
 * domain, URI, original URL, group, expiration settings, and statistics.
 * </p>
 * <p>
 * Key fields:
 * <ul>
 *   <li><b>id</b>: Primary key identifier</li>
 *   <li><b>domain</b>: Domain hosting the short link</li>
 *   <li><b>shortUri</b>: Unique short URI</li>
 *   <li><b>fullShortUrl</b>: Complete short link URL</li>
 *   <li><b>originUrl</b>: Original long URL</li>
 *   <li><b>gid</b>: Group identifier</li>
 *   <li><b>validDateType</b>: Expiration type (0: permanent, 1: custom)</li>
 *   <li><b>enableStatus</b>: Enable flag (0: enabled, 1: disabled)</li>
 *   <li><b>validDate</b>: Expiration date</li>
 *   <li><b>createTime</b>: Creation timestamp</li>
 *   <li><b>describe</b>: User-provided description</li>
 *   <li><b>favicon</b>: Website favicon URL</li>
 *   <li><b>totalPv/totalUv/totalUip</b>: Historical statistics</li>
 *   <li><b>todayPv/todayUv/todayUip</b>: Today's statistics</li>
 * </ul>
 * </p>
 * <p>
 * Use cases:
 * <ul>
 *   <li>Console short link list display</li>
 *   <li>Paginated link browsing</li>
 *   <li>Group-based link organization</li>
 * </ul>
 * </p>
 * 
 * @author NageOffer
 * @version 1.0
 * @since 2024
 */
@Data
public class ShortLinkPageRespDTO {

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
     * 分组标识
     */
    private String gid;

    /**
     * 有效期类型 0：永久有效 1：自定义
     */
    private Integer validDateType;

    /**
     * 启用标识 0：启用 1：未启用
     */
    private Integer enableStatus;

    /**
     * 有效期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date validDate;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 描述
     */
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
     * 今日PV
     */
    private Integer todayPv;

    /**
     * 历史UV
     */
    private Integer totalUv;

    /**
     * 今日UV
     */
    private Integer todayUv;

    /**
     * 历史UIP
     */
    private Integer totalUip;

    /**
     * 今日UIP
     */
    private Integer todayUip;
}
