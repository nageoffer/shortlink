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

/**
 * Short Link Pagination Request DTO
 * <p>
 * This Data Transfer Object (DTO) extends MyBatis-Plus Page class to provide pagination support
 * for querying short links. It includes additional filter fields for grouping and sorting to
 * enable flexible querying of short link lists with pagination.
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
 *   <li><b>gid</b>: Group identifier for filtering links by group</li>
 *   <li><b>orderTag</b>: Sorting criteria (e.g., "create_time", "click_num")</li>
 * </ul>
 * </p>
 * <p>
 * Query capabilities:
 * <ul>
 *   <li>Paginated retrieval of short links</li>
 *   <li>Filter by group for organized browsing</li>
 *   <li>Flexible sorting by various fields</li>
 *   <li>Efficient database query with LIMIT/OFFSET</li>
 * </ul>
 * </p>
 * <p>
 * Use cases:
 * <ul>
 *   <li>Console short link list display</li>
 *   <li>Group-based link browsing</li>
 *   <li>Search results with pagination</li>
 * </ul>
 * </p>
 * 
 * @author NageOffer
 * @version 1.0
 * @since 2024
 */
@Data
public class ShortLinkPageReqDTO extends Page<ShortLinkDO> {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 排序标识
     */
    private String orderTag;
}
