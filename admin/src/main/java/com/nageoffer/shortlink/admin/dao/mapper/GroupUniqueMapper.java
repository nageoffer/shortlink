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

package com.nageoffer.shortlink.admin.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nageoffer.shortlink.admin.dao.entity.GroupUniqueDO;

/**
 * Short Link Group Unique Route Mapper
 * <p>
 * This mapper handles database operations for unique route configurations of short link groups.
 * It manages the mapping between group identifiers and their unique URL routes, ensuring each
 * group has a distinct path for link generation and redirection purposes. This is critical for
 * maintaining URL uniqueness across the short link system.
 * </p>
 * <p>
 * Key responsibilities:
 * <ul>
 *   <li>CRUD operations for GroupUniqueDO entities</li>
 *   <li>Management of unique route constraints for link groups</li>
 *   <li>Support for URL routing logic in the short link service</li>
 *   <li>Ensuring database-level uniqueness of group routes</li>
 * </ul>
 * </p>
 * <p>
 * Use cases:
 * <ul>
 *   <li>Creating new group with unique route</li>
 *   <li>Querying group by unique route identifier</li>
 *   <li>Updating route configuration for existing groups</li>
 *   <li>Deleting group route mappings</li>
 * </ul>
 * </p>
 * 
 * @author NageOffer
 * @version 1.0
 * @since 2024
 */
public interface GroupUniqueMapper extends BaseMapper<GroupUniqueDO> {
}
