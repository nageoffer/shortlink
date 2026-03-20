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

import java.util.List;

/**
 * Short Link Batch Creation Response DTO
 * <p>
 * This Data Transfer Object (DTO) represents the response for batch short link creation
 * operations. It includes the total count of successfully created links and a list of
 * base information for each created link.
 * </p>
 * <p>
 * Key fields:
 * <ul>
 *   <li><b>total</b>: Total number of successfully created short links</li>
 *   <li><b>baseLinkInfos</b>: List of ShortLinkBaseInfoRespDTO containing information for each link</li>
 * </ul>
 * </p>
 * <p>
 * Response structure:
 * <ul>
 *   <li>Contains summary information (total count)</li>
 *   <li>Includes detailed information for each created link</li>
 *   <li>May include failed links in error responses (separate error handling)</li>
 * </ul>
 * </p>
 * <p>
 * Use cases:
 * <ul>
 *   <li>Response for batch short link creation API</li>
 *   <li>Console display of batch creation results</li>
 *   <li>Client-side processing of multiple created links</li>
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
public class ShortLinkBatchCreateRespDTO {

    /**
     * 成功数量
     */
    private Integer total;

    /**
     * 批量创建返回参数
     */
    private List<ShortLinkBaseInfoRespDTO> baseLinkInfos;
}
