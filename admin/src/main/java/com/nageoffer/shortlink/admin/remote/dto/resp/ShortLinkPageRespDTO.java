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

package com.nageoffer.shortlink.admin.remote.dto.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * Short-link page response DTO
 * 
 */
@Data
public class ShortLinkPageRespDTO {

    /**
     * id
     */
    private Long id;

    /**
     * Domain
     */
    private String domain;

    /**
     * Short link
     */
    private String shortUri;

    /**
     * Full short link
     */
    private String fullShortUrl;

    /**
     * Original URL
     */
    private String originUrl;

    /**
     * Group identifier
     */
    private String gid;

    /**
     * Expiration type 0: permanent 1: custom
     */
    private Integer validDateType;

    /**
     * Enable flag 0: enabled 1: disabled
     */
    private Integer enableStatus;

    /**
     * Expiration
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date validDate;

    /**
     * Created time
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * Description
     */
    private String describe;

    /**
     * 网站标识
     */
    private String favicon;


    /**
     * Total PV
     */
    private Integer totalPv;

    /**
     * Today PV
     */
    private Integer todayPv;

    /**
     * Total UV
     */
    private Integer totalUv;

    /**
     * Today UV
     */
    private Integer todayUv;

    /**
     * Total UIP
     */
    private Integer totalUip;

    /**
     * Today UIP
     */
    private Integer todayUip;
}
