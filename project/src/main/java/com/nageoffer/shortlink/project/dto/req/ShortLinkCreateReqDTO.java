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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Short Link Creation Request DTO
 * <p>
 * This Data Transfer Object (DTO) encapsulates all the parameters required to create a new short link.
 * It is used by the service layer to receive client requests and process short link creation.
 * The DTO includes domain configuration, original URL, group association, expiration settings,
 * and description fields.
 * </p>
 * <p>
 * Key fields:
 * <ul>
 *   <li><b>domain</b>: Custom domain for the short link (optional)</li>
 *   <li><b>originUrl</b>: Original long URL to be shortened</li>
 *   <li><b>gid</b>: Group identifier for categorization</li>
 *   <li><b>createdType</b>: Creation method (0: API, 1: Console)</li>
 *   <li><b>validDateType</b>: Expiration type (0: permanent, 1: custom)</li>
 *   <li><b>validDate</b>: Expiration date (required if validDateType=1)</li>
 *   <li><b>describe</b>: User-provided description for the link</li>
 * </ul>
 * </p>
 * <p>
 * Validation rules:
 * <ul>
 *   <li>originUrl must be a valid URL format</li>
 *   <li>validDate must be in the future if validDateType=1</li>
 *   <li>gid must exist in the system</li>
 * </ul>
 * </p>
 * <p>
 * Use cases:
 * <ul>
 *   <li>API endpoint for short link creation</li>
 *   <li>Console form submission for link creation</li>
 *   <li>Bulk link creation with batch processing</li>
 * </ul>
 * </p>
 * 
 * @author NageOffer
 * @version 1.0
 * @since 2024
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShortLinkCreateReqDTO {

    /**
     * 域名
     */
    private String domain;

    /**
     * 原始链接
     */
    private String originUrl;

    /**
     * 分组标识
     */
    private String gid;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date validDate;

    /**
     * 描述
     */
    private String describe;
}
