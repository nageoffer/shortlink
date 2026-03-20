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

package com.nageoffer.shortlink.admin.test;

/**
 * User Table Sharding Test Utility
 * <p>
 * This test class serves as a SQL script generator for creating user table sharding schemas.
 * It generates 16 separate user tables (t_user_0 through t_user_15) following a modulo-based
 * sharding strategy to distribute user data across multiple tables for improved performance
 * and scalability.
 * </p>
 * <p>
 * Sharding Strategy: Modulo-based user ID sharding
 * <ul>
 *   <li>Table selection: userId % 16</li>
 *   <li>Number of shards: 16 tables</li>
 *   <li>Table naming: t_user_{0-15}</li>
 * </ul>
 * </p>
 * <p>
 * Table Schema Features:
 * <ul>
 *   <li>Auto-incrementing primary key (id)</li>
 *   <li>Unique username constraint (idx_unique_username)</li>
 *   <li>Soft delete support (del_flag column)</li>
 *   <li>User deletion tracking (deletion_time timestamp)</li>
 *   <li>Standard audit fields (create_time, update_time)</li>
 * </ul>
 * </p>
 * <p>
 * Use Cases:
 * <ul>
 *   <li>Generating SQL scripts for initial database setup</li>
 *   <li>Testing sharding logic in development environments</li>
 *   <li>Documenting the user table sharding schema</li>
 *   <li>Automating database provisioning in CI/CD pipelines</li>
 * </ul>
 * </p>
 * <p>
 * Execution: Run the main method to output 16 CREATE TABLE statements to stdout.
 * The output can be redirected to a file or executed directly in a database.
 * </p>
 * 
 * @author 马丁玩编程 (Martin Plays Programming)
 * @version 1.0.0
 * @since 2024
 */
public class UserTableShardingTest {

    /**
     * SQL template for creating a sharded user table.
     * <p>
     * The %d placeholder is replaced with the shard number (0-15) at runtime.
     * This template defines a comprehensive user table with:
     * </p>
     * <ul>
     *   <li>Basic user information (username, password, real_name, phone, mail)</li>
     *   <li>Soft delete support (del_flag)</li>
     *   <li>User deletion tracking (deletion_time)</li>
     *   <li>Audit trail (create_time, update_time)</li>
     *   <li>Primary key and unique constraints</li>
     * </ul>
     */
    public static final String SQL = "CREATE TABLE `t_user_%d` (\n" +
            "  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',\n" +
            "  `username` varchar(256) DEFAULT NULL COMMENT '用户名',\n" +
            "  `password` varchar(512) DEFAULT NULL COMMENT '密码',\n" +
            "  `real_name` varchar(256) DEFAULT NULL COMMENT '真实姓名',\n" +
            "  `phone` varchar(128) DEFAULT NULL COMMENT '手机号',\n" +
            "  `mail` varchar(512) DEFAULT NULL COMMENT '邮箱',\n" +
            "  `deletion_time` bigint(20) DEFAULT NULL COMMENT '注销时间戳',\n" +
            "  `create_time` datetime DEFAULT NULL COMMENT '创建时间',\n" +
            "  `update_time` datetime DEFAULT NULL COMMENT '修改时间',\n" +
            "  `del_flag` tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  UNIQUE KEY `idx_unique_username` (`username`) USING BTREE\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=1715030926162935810 DEFAULT CHARSET=utf8mb4;";

    /**
     * Main method to generate sharded user table SQL scripts.
     * <p>
     * Iterates from 0 to 15, generating CREATE TABLE statements for each shard.
     * The output is formatted SQL that can be executed directly in a MySQL database.
     * </p>
     * 
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        for (int i = 0; i < 16; i++) {
            System.out.printf((SQL) + "%n", i);
        }
    }
}
