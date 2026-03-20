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

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nageoffer.shortlink.project.dao.entity.ShortLinkDO;
import lombok.Data;

import java.util.List;

/**
 * Short Link Recycle Bin Pagination Request DTO
 * <p>
 * This Data Transfer Object (DTO) extends MyBatis-Plus Page class to provide pagination support
 * for querying soft-deleted short links in the recycle bin. It includes group filtering to enable
 * organized browsing of deleted links by group.
 * </p>
 * <p>
 * Inherited from Page<ShortLinkDO>:
 * <ul>
 *   <li><b>current</b>: Current page number (1-indexed)</li>
 *   <li><b>size</b>: Number of records per page</li>
 *   <li><b>total</b>: Total number of records</li>
 *   <li><b>records</b>: List of ShortLinkDO records</li>
 * </ul>
 * </p>
 * <p>
 * Additional fields:
 * <ul>
 *   <li><b>gidList</b>: List of group identifiers for filtering deleted links</li>
 * </ul>
 * </p>
 * <p>
 * Query capabilities:
 * <ul>
 *   <li>Paginated retrieval of soft-deleted short links</li>
 *   <li>Filter by multiple groups for organized browsing</li>
 *   <li>Efficient database query with soft delete condition (delTime > 0)</li>
 *   <li>Support for bulk recovery operations</li>
 * </ul>
 * </p>
 * <p>
 * Soft delete behavior:
 * <ul>
 *   <li>Links are not physically deleted from database</li>
 *   <li>delTime field stores deletion timestamp</li>
 *   <li>Links can be restored within retention period</li>
 *   <li>Permanent deletion requires explicit remove operation</li>
 * </ul>
 * </p>
 * <p>
 * Use cases:
 * <ul>
 *   <li>Recycle bin display in console</li>
 *   <li>Group-based deleted link browsing</li>
 *   <li>Recovery operations for accidentally deleted links</li>
 * </ul>
 * </p>
 * 
 * @author NageOffer
 * @version 1.0
 * @since 2024
 */
@Data
public class ShortLinkRecycleBinPageReqDTO extends Page<ShortLinkDO> {

    /**
     * 分组标识
     */
    private List<String> gidList;
}
