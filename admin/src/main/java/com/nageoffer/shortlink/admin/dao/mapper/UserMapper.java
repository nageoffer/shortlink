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
import com.nageoffer.shortlink.admin.dao.entity.UserDO;

/**
 * User Mapper
 * <p>
 * This mapper provides data access operations for user entities in the short link
 * administration system. It handles all database interactions related to user management,
 * including authentication, authorization, and user profile operations. This is a core
 * component of the system's security and user management infrastructure.
 * </p>
 * <p>
 * Key responsibilities:
 * <ul>
 *   <li>CRUD operations for UserDO entities</li>
 *   <li>User authentication and session management support</li>
 *   <li>User permission and role data access</li>
 *   <li>Integration with security filters for access control</li>
 * </ul>
 * </p>
 * <p>
 * Security considerations:
 * <ul>
 *   <li>Phone number desensitization through {@link com.nageoffer.shortlink.admin.common.serialize.PhoneDesensitizationSerializer}</li>
 *   <li>Integration with {@link UserFlowRiskControlFilter} for traffic control</li>
 *   <li>Support for user context management via {@link UserContext}</li>
 * </ul>
 * </p>
 * <p>
 * Related components:
 * <ul>
 *   <li>{@link UserDO} - Entity class representing user data structure</li>
 *   <li>{@link com.nageoffer.shortlink.admin.controller.UserController} - User management controller</li>
 *   <li>{@link com.nageoffer.shortlink.admin.common.biz.user.UserContext} - User context holder</li>
 * </ul>
 * </p>
 * 
 * @author NageOffer
 * @version 1.0
 * @since 2024
 */
public interface UserMapper extends BaseMapper<UserDO> {
}
