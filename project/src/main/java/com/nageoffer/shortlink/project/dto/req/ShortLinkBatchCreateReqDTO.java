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
import java.util.List;

/**
 * Short Link Batch Creation Request DTO
 * <p>
 * This Data Transfer Object (DTO) encapsulates parameters for creating multiple short links
 * in a single operation. It allows users to submit a list of original URLs with corresponding
 * descriptions, all organized under a single group with shared expiration settings. This is
 * useful for bulk link creation scenarios.
 * </p>
 * <p>
 * Key fields:
 * <ul>
 *   <li><b>originUrls</b>: List of original long URLs to be shortened</li>
 *   <li><b>describes</b>: List of descriptions corresponding to each URL</li>
 *   <li><b>gid</b>: Group identifier for categorizing all created links</li>
 *   <li><b>createdType</b>: Creation method (0: API, 1: Console)</li>
 *   <li><b>validDateType</b>: Expiration type for all links (0: permanent, 1: custom)</li>
 *   <li><b>validDate</b>: Expiration date for all links (required if validDateType=1)</li>
 * </ul>
 * </p>
 * <p>
 * Batch processing:
 * <ul>
 *   <li>One-to-one mapping between originUrls and describes</li>
 *   <li>All links share the same group and expiration settings</li>
 *   <li>Atomic operation - all succeed or all fail</li>
 *   <li>Efficient database batch insert operations</li>
 * </ul>
 * </p>
 * <p>
 * Use cases:
 * <ul>
 *   <li>API endpoint for bulk short link creation</li>
 *   <li>Console import from file or list</li>
 *   <li>Automated link generation for campaigns</li>
 * </ul>
 * </p>
 * 
 * @author NageOffer
 * @version 1.0
 * @since 2024
 */
@Data
public class ShortLinkBatchCreateReqDTO {

    /**
     * 原始链接集合
     */
    private List<String> originUrls;

    /**
     * 描述集合
     */
    private List<String> describes;

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
}
