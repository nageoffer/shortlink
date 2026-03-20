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

import lombok.Data;

/**
 * Short Link Recycle Bin Save Request DTO
 * <p>
 * This Data Transfer Object (DTO) encapsulates parameters for soft-deleting a short link and
 * moving it to the recycle bin. It includes the group identifier and complete short link URL
 * to identify the link to be moved to the recycle bin.
 * </p>
 * <p>
 * Key fields:
 * <ul>
 *   <li><b>gid</b>: Group identifier of the link</li>
 *   <li><b>fullShortUrl</b>: Complete short link URL to be moved to recycle bin</li>
 * </ul>
 * </p>
 * <p>
 * Soft delete behavior:
 * <ul>
 *   <li>Link is not physically deleted from database</li>
 *   <li>delTime field is set to current timestamp</li>
 *   <li>Link becomes invisible in normal queries</li>
 *   <li>Link can be restored within retention period</li>
 *   <li>Link can be permanently deleted from recycle bin</li>
 * </ul>
 * </p>
 * <p>
 * Use cases:
 * <ul>
 *   <li>Accidentally deleted link recovery</li>
 *   <li>Temporary link removal without permanent deletion</li>
 *   <li>Recycle bin management in console</li>
 * </ul>
 * </p>
 * 
 * @author NageOffer
 * @version 1.0
 * @since 2024
 */
@Data
public class RecycleBinSaveReqDTO {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 全部短链接
     */
    private String fullShortUrl;
}
