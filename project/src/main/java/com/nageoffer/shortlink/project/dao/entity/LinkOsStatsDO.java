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

package com.nageoffer.shortlink.project.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.nageoffer.shortlink.project.common.database.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Short Link OS Statistics Entity
 * <p>
 * This entity stores operating system-specific access statistics for short links. It tracks traffic
 * distribution across different operating systems (Windows, macOS, Linux, Android, iOS) to help
 * understand user platform preferences and optimize platform-specific development efforts.
 * </p>
 * <p>
 * Database table: t_link_os_stats
 * </p>
 * <p>
 * Key fields:
 * <ul>
 *   <li><b>id</b>: Primary key identifier</li>
 *   <li><b>fullShortUrl</b>: Complete short link URL</li>
 *   <li><b>date</b>: Date of the statistics record</li>
 *   <li><b>cnt</b>: Count of accesses from this OS</li>
 *   <li><b>os</b>: Operating system name (Windows, macOS, Linux, Android, iOS, etc.)</li>
 *   <li><b>BaseDO fields</b>: id, createTime, updateTime, delTime (soft delete)</li>
 * </ul>
 * </p>
 * <p>
 * OS detection:
 * <ul>
 *   <li>Operating system extracted from HTTP User-Agent header</li>
 *   <li>Common OS: Windows, macOS, Linux, Android, iOS, ChromeOS, etc.</li>
 *   <li>Bot detection for non-human traffic filtering</li>
 * </ul>
 * </p>
 * <p>
 * Use cases:
 * <ul>
 *   <li>Platform compatibility testing prioritization</li>
 *   <li>OS-specific feature development</li>
 *   <li>Marketing campaign optimization by platform</li>
 *   <li>Resource allocation for different OS user bases</li>
 * </ul>
 * </p>
 * 
 * @author NageOffer
 * @version 1.0
 * @since 2024
 */
@Data
@TableName("t_link_os_stats")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LinkOsStatsDO extends BaseDO {

    /**
     * id
     */
    private Long id;

    /**
     * 完整短链接
     */
    private String fullShortUrl;

    /**
     * 日期
     */
    private Date date;

    /**
     * 访问量
     */
    private Integer cnt;

    /**
     * 操作系统
     */
    private String os;
}
