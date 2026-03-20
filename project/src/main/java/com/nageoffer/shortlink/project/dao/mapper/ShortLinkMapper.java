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

package com.nageoffer.shortlink.project.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.nageoffer.shortlink.project.dao.entity.ShortLinkDO;
import com.nageoffer.shortlink.project.dto.req.ShortLinkPageReqDTO;
import com.nageoffer.shortlink.project.dto.req.ShortLinkRecycleBinPageReqDTO;
import org.apache.ibatis.annotations.Param;

/**
 * Short Link Mapper
 * <p>
 * This mapper provides database access operations for short link entities in the project module.
 * It extends MyBatis-Plus BaseMapper to inherit common CRUD operations and includes custom methods
 * for statistics increment, pagination, and recycle bin management. This is a core component of
 * the short link system handling link creation, management, and deletion.
 * </p>
 * <p>
 * Key responsibilities:
 * <ul>
 *   <li>CRUD operations for ShortLinkDO entities</li>
 *   <li>Statistics increment for PV, UV, UIp counters</li>
 *   <li>Pagination support for link listing</li>
 *   <li>Recycle bin management for soft-deleted links</li>
 *   <li>Integration with MyBatis-Plus for efficient data access</li>
 * </ul>
 * </p>
 * <p>
 * Custom methods:
 * <ul>
 *   <li><b>incrementStats</b>: Atomically increases PV, UV, UIp counters</li>
 *   <li><b>pageLink</b>: Paginated query for active links with filtering</li>
 *   <li><b>pageRecycleBinLink</b>: Paginated query for soft-deleted links</li>
 * </ul>
 * </p>
 * <p>
 * Data model:
 * <ul>
 *   <li><b>domain</b>: Domain hosting the short link</li>
 *   <li><b>shortUri</b>: Unique short URI</li>
 *   <li><b>fullShortUrl</b>: Complete short URL</li>
 *   <li><b>originUrl</b>: Original long URL</li>
 *   <li><b>gid</b>: Group identifier</li>
 *   <li><b>enableStatus</b>: Enable/disable flag</li>
 *   <li><b>validDateType</b>: Expiration type (permanent/custom)</li>
 *   <li><b>validDate</b>: Expiration date</li>
 *   <li><b>totalPv/totalUv/totalUip</b>: Historical statistics</li>
 *   <li><b>delTime</b>: Soft delete timestamp</li>
 * </ul>
 * </p>
 * <p>
 * Related components:
 * <ul>
 *   <li>{@link com.nageoffer.shortlink.project.dao.entity.ShortLinkDO} - Entity class representing short link data structure</li>
 *   <li>{@link com.nageoffer.shortlink.project.service.ShortLinkService} - Service layer</li>
 *   <li>{@link com.nageoffer.shortlink.project.controller.ShortLinkController} - Controller layer</li>
 * </ul>
 * </p>
 * 
 * @author NageOffer
 * @version 1.0
 * @since 2024
 */
public interface ShortLinkMapper extends BaseMapper<ShortLinkDO> {

    /**
     * 短链接访问统计自增
     */
    void incrementStats(@Param("gid") String gid,
                        @Param("fullShortUrl") String fullShortUrl,
                        @Param("totalPv") Integer totalPv,
                        @Param("totalUv") Integer totalUv,
                        @Param("totalUip") Integer totalUip);

    /**
     * 分页统计短链接
     */
    IPage<ShortLinkDO> pageLink(ShortLinkPageReqDTO requestParam);

    /**
     * 分页统计回收站短链接
     */
    IPage<ShortLinkDO> pageRecycleBinLink(ShortLinkRecycleBinPageReqDTO requestParam);
}
