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
 * Short Link Recycle Bin Remove Request DTO
 * <p>
 * This Data Transfer Object (DTO) encapsulates parameters for permanently deleting a short link
 * from the recycle bin. It includes the group identifier and complete short link URL to identify
 * the link to be permanently removed from the database.
 * </p>
 * <p>
 * Key fields:
 * <ul>
 *   <li><b>gid</b>: Group identifier of the link</li>
 *   <li><b>fullShortUrl</b>: Complete short link URL to be permanently deleted</li>
 * </ul>
 * </p>
 * <p>
 * Permanent delete behavior:
 * <ul>
 *   <li>Link is physically removed from database</li>
 *   <li>All associated statistics are also deleted</li>
 *   <li>Link cannot be recovered after removal</li>
 *   <li>Group association is preserved for audit purposes</li>
 * </ul>
 * </p>
 * <p>
 * Use cases:
 * <ul>
 *   <li>Permanent deletion after retention period</li>
 *   <li>Manual cleanup of recycle bin</li>
 *   <li>Compliance with data retention policies</li>
 * </ul>
 * </p>
 * 
 * @author NageOffer
 * @version 1.0
 * @since 2024
 */
@Data
public class RecycleBinRemoveReqDTO {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 全部短链接
     */
    private String fullShortUrl;
}
