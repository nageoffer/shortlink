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

package com.nageoffer.shortlink.project.dto.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * Short Link Update Request DTO
 * <p>
 * This Data Transfer Object (DTO) encapsulates all the parameters required to update an existing
 * short link. It includes fields for modifying the original URL, group association, expiration
 * settings, and description. The DTO uses fullShortUrl to identify the link to update and
 * originGid to track group changes.
 * </p>
 * <p>
 * Key fields:
 * <ul>
 *   <li><b>originUrl</b>: Updated original long URL</li>
 *   <li><b>fullShortUrl</b>: Complete short link URL to identify the record</li>
 *   <li><b>originGid</b>: Original group identifier (for change tracking)</li>
 *   <li><b>gid</b>: New group identifier for reorganization</li>
 *   <li><b>validDateType</b>: Updated expiration type (0: permanent, 1: custom)</li>
 *   <li><b>validDate</b>: Updated expiration date (required if validDateType=1)</li>
 *   <li><b>describe</b>: Updated description for the link</li>
 * </ul>
 * </p>
 * <p>
 * Update behavior:
 * <ul>
 *   <li>Only specified fields are updated (partial update)</li>
 *   <li>Group change tracking via originGid</li>
 *   <li>Expiration date validation for custom expiration</li>
 * </ul>
 * </p>
 * <p>
 * Use cases:
 * <ul>
 *   <li>API endpoint for short link modification</li>
 *   <li>Console form submission for link updates</li>
 *   <li>Batch link update operations</li>
 * </ul>
 * </p>
 * 
 * @author NageOffer
 * @version 1.0
 * @since 2024
 */
@Data
public class ShortLinkUpdateReqDTO {

    /**
     * 原始链接
     */
    private String originUrl;

    /**
     * 完整短链接
     */
    private String fullShortUrl;

    /**
     * 原始分组标识
     */
    private String originGid;

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 有效期类型 0：永久有效 1：自定义
     */
    private Integer validDateType;

    /**
     * 有效期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date validDate;

    /**
     * 描述
     */
    private String describe;
}
