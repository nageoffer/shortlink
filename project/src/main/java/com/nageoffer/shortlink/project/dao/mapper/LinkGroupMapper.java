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
import com.nageoffer.shortlink.project.dao.entity.GroupDO;

/**
 * Short Link Group Mapper
 * <p>
 * This mapper provides database access operations for short link group entities in the project module.
 * It extends MyBatis-Plus BaseMapper to inherit common CRUD operations without requiring explicit
 * implementation. This layer handles persistence logic for group management functionality in the
 * short link project system.
 * </p>
 * <p>
 * Key responsibilities:
 * <ul>
 *   <li>CRUD operations for GroupDO entities</li>
 *   <li>Database persistence for link grouping functionality</li>
 *   <li>Integration with MyBatis-Plus for efficient data access</li>
 * </ul>
 * </p>
 * <p>
 * Related components:
 * <ul>
 *   <li>{@link com.nageoffer.shortlink.project.dao.entity.GroupDO} - Entity class representing group data structure</li>
 *   <li>{@link com.nageoffer.shortlink.project.service.GroupService} - Service layer</li>
 *   <li>{@link com.nageoffer.shortlink.project.controller.GroupController} - Controller layer</li>
 * </ul>
 * </p>
 * 
 * @author NageOffer
 * @version 1.0
 * @since 2024
 */
public interface LinkGroupMapper extends BaseMapper<GroupDO> {
}
