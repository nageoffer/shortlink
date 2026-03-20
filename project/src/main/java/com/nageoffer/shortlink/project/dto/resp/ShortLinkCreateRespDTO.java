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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Short Link Creation Response DTO
 * <p>
 * This Data Transfer Object (DTO) represents the response for single short link creation
 * operations. It includes the group identifier, original URL, and the complete short link
 * URL that was created.
 * </p>
 * <p>
 * Key fields:
 * <ul>
 *   <li><b>gid</b>: Group identifier where the link was created</li>
 *   <li><b>originUrl</b>: Original long URL that the short link redirects to</li>
 *   <li><b>fullShortUrl</b>: Complete short link URL (domain + shortUri)</li>
 * </ul>
 * </p>
 * <p>
 * Use cases:
 * <ul>
 *   <li>Response for single short link creation API</li>
 *   <li>Console display of created link</li>
 *   <li>Client-side processing of created link</li>
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
public class ShortLinkCreateRespDTO {

    /**
     * 分组信息
     */
    private String gid;

    /**
     * 原始链接
     */
    private String originUrl;

    /**
     * 短链接
     */
    private String fullShortUrl;
}
