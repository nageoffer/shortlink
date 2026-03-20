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
import com.nageoffer.shortlink.project.dao.entity.ShortLinkGotoDO;

/**
 * Short Link Redirect Mapper
 * <p>
 * This mapper manages the redirect configuration for short links. It stores the mapping between
 * short links and their target destinations, along with group association information. This mapper
 * is critical for the core short link functionality - routing users from the short URL to the
 * original long URL.
 * </p>
 * <p>
 * Key responsibilities:
 * <ul>
 *   <li>CRUD operations for ShortLinkGotoDO entities</li>
 *   <li>Redirect configuration storage and retrieval</li>
 *   <li>Group association for redirect categorization</li>
 *   <li>Support for URL routing logic</li>
 * </ul>
 * </p>
 * <p>
 * Data model:
 * <ul>
 *   <li><b>id</b>: Primary key identifier</li>
 *   <li><b>gid</b>: Group identifier for categorization</li>
 *   <li><b>fullShortUrl</b>: The complete short link URL</li>
 * </ul>
 * </p>
 * <p>
 * Use cases:
 * <ul>
 *   <li>URL redirection processing</li>
 *   <li>Redirect configuration management</li>
 *   <li>Group-based redirect organization</li>
 *   <li>Redirect analytics and tracking</li>
 * </ul>
 * </p>
 * 
 * @author NageOffer
 * @version 1.0
 * @since 2024
 */
public interface ShortLinkGotoMapper extends BaseMapper<ShortLinkGotoDO> {
}
