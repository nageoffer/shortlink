CREATE TABLE `t_group_0`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`         varchar(32)  DEFAULT NULL COMMENT 'Group identifier',
    `name`        varchar(64)  DEFAULT NULL COMMENT 'Group name',
    `username`    varchar(256) DEFAULT NULL COMMENT 'Username that created the group',
    `sort_order`  int(3) DEFAULT NULL COMMENT 'Group sort order',
    `create_time` datetime     DEFAULT NULL COMMENT 'Created time',
    `update_time` datetime     DEFAULT NULL COMMENT 'Updated time',
    `del_flag`    tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    KEY           `idx_username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_group_1`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`         varchar(32)  DEFAULT NULL COMMENT 'Group identifier',
    `name`        varchar(64)  DEFAULT NULL COMMENT 'Group name',
    `username`    varchar(256) DEFAULT NULL COMMENT 'Username that created the group',
    `sort_order`  int(3) DEFAULT NULL COMMENT 'Group sort order',
    `create_time` datetime     DEFAULT NULL COMMENT 'Created time',
    `update_time` datetime     DEFAULT NULL COMMENT 'Updated time',
    `del_flag`    tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    KEY           `idx_username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_group_10`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`         varchar(32)  DEFAULT NULL COMMENT 'Group identifier',
    `name`        varchar(64)  DEFAULT NULL COMMENT 'Group name',
    `username`    varchar(256) DEFAULT NULL COMMENT 'Username that created the group',
    `sort_order`  int(3) DEFAULT NULL COMMENT 'Group sort order',
    `create_time` datetime     DEFAULT NULL COMMENT 'Created time',
    `update_time` datetime     DEFAULT NULL COMMENT 'Updated time',
    `del_flag`    tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    KEY           `idx_username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_group_11`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`         varchar(32)  DEFAULT NULL COMMENT 'Group identifier',
    `name`        varchar(64)  DEFAULT NULL COMMENT 'Group name',
    `username`    varchar(256) DEFAULT NULL COMMENT 'Username that created the group',
    `sort_order`  int(3) DEFAULT NULL COMMENT 'Group sort order',
    `create_time` datetime     DEFAULT NULL COMMENT 'Created time',
    `update_time` datetime     DEFAULT NULL COMMENT 'Updated time',
    `del_flag`    tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    KEY           `idx_username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_group_12`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`         varchar(32)  DEFAULT NULL COMMENT 'Group identifier',
    `name`        varchar(64)  DEFAULT NULL COMMENT 'Group name',
    `username`    varchar(256) DEFAULT NULL COMMENT 'Username that created the group',
    `sort_order`  int(3) DEFAULT NULL COMMENT 'Group sort order',
    `create_time` datetime     DEFAULT NULL COMMENT 'Created time',
    `update_time` datetime     DEFAULT NULL COMMENT 'Updated time',
    `del_flag`    tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    KEY           `idx_username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_group_13`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`         varchar(32)  DEFAULT NULL COMMENT 'Group identifier',
    `name`        varchar(64)  DEFAULT NULL COMMENT 'Group name',
    `username`    varchar(256) DEFAULT NULL COMMENT 'Username that created the group',
    `sort_order`  int(3) DEFAULT NULL COMMENT 'Group sort order',
    `create_time` datetime     DEFAULT NULL COMMENT 'Created time',
    `update_time` datetime     DEFAULT NULL COMMENT 'Updated time',
    `del_flag`    tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    KEY           `idx_username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_group_14`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`         varchar(32)  DEFAULT NULL COMMENT 'Group identifier',
    `name`        varchar(64)  DEFAULT NULL COMMENT 'Group name',
    `username`    varchar(256) DEFAULT NULL COMMENT 'Username that created the group',
    `sort_order`  int(3) DEFAULT NULL COMMENT 'Group sort order',
    `create_time` datetime     DEFAULT NULL COMMENT 'Created time',
    `update_time` datetime     DEFAULT NULL COMMENT 'Updated time',
    `del_flag`    tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    KEY           `idx_username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_group_15`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`         varchar(32)  DEFAULT NULL COMMENT 'Group identifier',
    `name`        varchar(64)  DEFAULT NULL COMMENT 'Group name',
    `username`    varchar(256) DEFAULT NULL COMMENT 'Username that created the group',
    `sort_order`  int(3) DEFAULT NULL COMMENT 'Group sort order',
    `create_time` datetime     DEFAULT NULL COMMENT 'Created time',
    `update_time` datetime     DEFAULT NULL COMMENT 'Updated time',
    `del_flag`    tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    KEY           `idx_username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_group_2`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`         varchar(32)  DEFAULT NULL COMMENT 'Group identifier',
    `name`        varchar(64)  DEFAULT NULL COMMENT 'Group name',
    `username`    varchar(256) DEFAULT NULL COMMENT 'Username that created the group',
    `sort_order`  int(3) DEFAULT NULL COMMENT 'Group sort order',
    `create_time` datetime     DEFAULT NULL COMMENT 'Created time',
    `update_time` datetime     DEFAULT NULL COMMENT 'Updated time',
    `del_flag`    tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    KEY           `idx_username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_group_3`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`         varchar(32)  DEFAULT NULL COMMENT 'Group identifier',
    `name`        varchar(64)  DEFAULT NULL COMMENT 'Group name',
    `username`    varchar(256) DEFAULT NULL COMMENT 'Username that created the group',
    `sort_order`  int(3) DEFAULT NULL COMMENT 'Group sort order',
    `create_time` datetime     DEFAULT NULL COMMENT 'Created time',
    `update_time` datetime     DEFAULT NULL COMMENT 'Updated time',
    `del_flag`    tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    KEY           `idx_username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_group_4`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`         varchar(32)  DEFAULT NULL COMMENT 'Group identifier',
    `name`        varchar(64)  DEFAULT NULL COMMENT 'Group name',
    `username`    varchar(256) DEFAULT NULL COMMENT 'Username that created the group',
    `sort_order`  int(3) DEFAULT NULL COMMENT 'Group sort order',
    `create_time` datetime     DEFAULT NULL COMMENT 'Created time',
    `update_time` datetime     DEFAULT NULL COMMENT 'Updated time',
    `del_flag`    tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    KEY           `idx_username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_group_5`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`         varchar(32)  DEFAULT NULL COMMENT 'Group identifier',
    `name`        varchar(64)  DEFAULT NULL COMMENT 'Group name',
    `username`    varchar(256) DEFAULT NULL COMMENT 'Username that created the group',
    `sort_order`  int(3) DEFAULT NULL COMMENT 'Group sort order',
    `create_time` datetime     DEFAULT NULL COMMENT 'Created time',
    `update_time` datetime     DEFAULT NULL COMMENT 'Updated time',
    `del_flag`    tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    KEY           `idx_username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_group_6`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`         varchar(32)  DEFAULT NULL COMMENT 'Group identifier',
    `name`        varchar(64)  DEFAULT NULL COMMENT 'Group name',
    `username`    varchar(256) DEFAULT NULL COMMENT 'Username that created the group',
    `sort_order`  int(3) DEFAULT NULL COMMENT 'Group sort order',
    `create_time` datetime     DEFAULT NULL COMMENT 'Created time',
    `update_time` datetime     DEFAULT NULL COMMENT 'Updated time',
    `del_flag`    tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    KEY           `idx_username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_group_7`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`         varchar(32)  DEFAULT NULL COMMENT 'Group identifier',
    `name`        varchar(64)  DEFAULT NULL COMMENT 'Group name',
    `username`    varchar(256) DEFAULT NULL COMMENT 'Username that created the group',
    `sort_order`  int(3) DEFAULT NULL COMMENT 'Group sort order',
    `create_time` datetime     DEFAULT NULL COMMENT 'Created time',
    `update_time` datetime     DEFAULT NULL COMMENT 'Updated time',
    `del_flag`    tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    KEY           `idx_username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_group_8`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`         varchar(32)  DEFAULT NULL COMMENT 'Group identifier',
    `name`        varchar(64)  DEFAULT NULL COMMENT 'Group name',
    `username`    varchar(256) DEFAULT NULL COMMENT 'Username that created the group',
    `sort_order`  int(3) DEFAULT NULL COMMENT 'Group sort order',
    `create_time` datetime     DEFAULT NULL COMMENT 'Created time',
    `update_time` datetime     DEFAULT NULL COMMENT 'Updated time',
    `del_flag`    tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    KEY           `idx_username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_group_9`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`         varchar(32)  DEFAULT NULL COMMENT 'Group identifier',
    `name`        varchar(64)  DEFAULT NULL COMMENT 'Group name',
    `username`    varchar(256) DEFAULT NULL COMMENT 'Username that created the group',
    `sort_order`  int(3) DEFAULT NULL COMMENT 'Group sort order',
    `create_time` datetime     DEFAULT NULL COMMENT 'Created time',
    `update_time` datetime     DEFAULT NULL COMMENT 'Updated time',
    `del_flag`    tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    KEY           `idx_username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_group_unique`
(
    `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid` varchar(32) DEFAULT NULL COMMENT 'Group identifier',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_gid` (`gid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_link_0`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT 'Domain',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT 'Short link',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整Short link',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT 'Original URL',
    `click_num`       int(11) DEFAULT '0' COMMENT 'Click count',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT 'Group identifier',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT 'Favicon',
    `enable_status`   tinyint(1) DEFAULT NULL COMMENT 'Enable flag 0: enabled 1: disabled',
    `created_type`    tinyint(1) DEFAULT NULL COMMENT 'Create type 0: API 1: console',
    `valid_date_type` tinyint(1) DEFAULT NULL COMMENT 'Expiration type 0: permanent 1: custom',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT 'Expiration',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT 'Description',
    `total_pv`        int(11) DEFAULT NULL COMMENT 'Total PV',
    `total_uv`        int(11) DEFAULT NULL COMMENT 'Total UV',
    `total_uip`       int(11) DEFAULT NULL COMMENT 'Total UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT 'Created time',
    `update_time`     datetime                                       DEFAULT NULL COMMENT 'Updated time',
    `del_time`        bigint(20) DEFAULT '0' COMMENT 'Deletion timestamp',
    `del_flag`        tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_link_1`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT 'Domain',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT 'Short link',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整Short link',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT 'Original URL',
    `click_num`       int(11) DEFAULT '0' COMMENT 'Click count',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT 'Group identifier',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT 'Favicon',
    `enable_status`   tinyint(1) DEFAULT NULL COMMENT 'Enable flag 0: enabled 1: disabled',
    `created_type`    tinyint(1) DEFAULT NULL COMMENT 'Create type 0: API 1: console',
    `valid_date_type` tinyint(1) DEFAULT NULL COMMENT 'Expiration type 0: permanent 1: custom',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT 'Expiration',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT 'Description',
    `total_pv`        int(11) DEFAULT NULL COMMENT 'Total PV',
    `total_uv`        int(11) DEFAULT NULL COMMENT 'Total UV',
    `total_uip`       int(11) DEFAULT NULL COMMENT 'Total UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT 'Created time',
    `update_time`     datetime                                       DEFAULT NULL COMMENT 'Updated time',
    `del_time`        bigint(20) DEFAULT '0' COMMENT 'Deletion timestamp',
    `del_flag`        tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_link_10`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT 'Domain',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT 'Short link',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整Short link',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT 'Original URL',
    `click_num`       int(11) DEFAULT '0' COMMENT 'Click count',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT 'Group identifier',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT 'Favicon',
    `enable_status`   tinyint(1) DEFAULT NULL COMMENT 'Enable flag 0: enabled 1: disabled',
    `created_type`    tinyint(1) DEFAULT NULL COMMENT 'Create type 0: API 1: console',
    `valid_date_type` tinyint(1) DEFAULT NULL COMMENT 'Expiration type 0: permanent 1: custom',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT 'Expiration',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT 'Description',
    `total_pv`        int(11) DEFAULT NULL COMMENT 'Total PV',
    `total_uv`        int(11) DEFAULT NULL COMMENT 'Total UV',
    `total_uip`       int(11) DEFAULT NULL COMMENT 'Total UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT 'Created time',
    `update_time`     datetime                                       DEFAULT NULL COMMENT 'Updated time',
    `del_time`        bigint(20) DEFAULT '0' COMMENT 'Deletion timestamp',
    `del_flag`        tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_link_11`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT 'Domain',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT 'Short link',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整Short link',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT 'Original URL',
    `click_num`       int(11) DEFAULT '0' COMMENT 'Click count',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT 'Group identifier',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT 'Favicon',
    `enable_status`   tinyint(1) DEFAULT NULL COMMENT 'Enable flag 0: enabled 1: disabled',
    `created_type`    tinyint(1) DEFAULT NULL COMMENT 'Create type 0: API 1: console',
    `valid_date_type` tinyint(1) DEFAULT NULL COMMENT 'Expiration type 0: permanent 1: custom',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT 'Expiration',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT 'Description',
    `total_pv`        int(11) DEFAULT NULL COMMENT 'Total PV',
    `total_uv`        int(11) DEFAULT NULL COMMENT 'Total UV',
    `total_uip`       int(11) DEFAULT NULL COMMENT 'Total UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT 'Created time',
    `update_time`     datetime                                       DEFAULT NULL COMMENT 'Updated time',
    `del_time`        bigint(20) DEFAULT '0' COMMENT 'Deletion timestamp',
    `del_flag`        tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_link_12`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT 'Domain',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT 'Short link',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整Short link',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT 'Original URL',
    `click_num`       int(11) DEFAULT '0' COMMENT 'Click count',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT 'Group identifier',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT 'Favicon',
    `enable_status`   tinyint(1) DEFAULT NULL COMMENT 'Enable flag 0: enabled 1: disabled',
    `created_type`    tinyint(1) DEFAULT NULL COMMENT 'Create type 0: API 1: console',
    `valid_date_type` tinyint(1) DEFAULT NULL COMMENT 'Expiration type 0: permanent 1: custom',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT 'Expiration',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT 'Description',
    `total_pv`        int(11) DEFAULT NULL COMMENT 'Total PV',
    `total_uv`        int(11) DEFAULT NULL COMMENT 'Total UV',
    `total_uip`       int(11) DEFAULT NULL COMMENT 'Total UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT 'Created time',
    `update_time`     datetime                                       DEFAULT NULL COMMENT 'Updated time',
    `del_time`        bigint(20) DEFAULT '0' COMMENT 'Deletion timestamp',
    `del_flag`        tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_link_13`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT 'Domain',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT 'Short link',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整Short link',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT 'Original URL',
    `click_num`       int(11) DEFAULT '0' COMMENT 'Click count',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT 'Group identifier',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT 'Favicon',
    `enable_status`   tinyint(1) DEFAULT NULL COMMENT 'Enable flag 0: enabled 1: disabled',
    `created_type`    tinyint(1) DEFAULT NULL COMMENT 'Create type 0: API 1: console',
    `valid_date_type` tinyint(1) DEFAULT NULL COMMENT 'Expiration type 0: permanent 1: custom',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT 'Expiration',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT 'Description',
    `total_pv`        int(11) DEFAULT NULL COMMENT 'Total PV',
    `total_uv`        int(11) DEFAULT NULL COMMENT 'Total UV',
    `total_uip`       int(11) DEFAULT NULL COMMENT 'Total UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT 'Created time',
    `update_time`     datetime                                       DEFAULT NULL COMMENT 'Updated time',
    `del_time`        bigint(20) DEFAULT '0' COMMENT 'Deletion timestamp',
    `del_flag`        tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_link_14`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT 'Domain',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT 'Short link',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整Short link',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT 'Original URL',
    `click_num`       int(11) DEFAULT '0' COMMENT 'Click count',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT 'Group identifier',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT 'Favicon',
    `enable_status`   tinyint(1) DEFAULT NULL COMMENT 'Enable flag 0: enabled 1: disabled',
    `created_type`    tinyint(1) DEFAULT NULL COMMENT 'Create type 0: API 1: console',
    `valid_date_type` tinyint(1) DEFAULT NULL COMMENT 'Expiration type 0: permanent 1: custom',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT 'Expiration',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT 'Description',
    `total_pv`        int(11) DEFAULT NULL COMMENT 'Total PV',
    `total_uv`        int(11) DEFAULT NULL COMMENT 'Total UV',
    `total_uip`       int(11) DEFAULT NULL COMMENT 'Total UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT 'Created time',
    `update_time`     datetime                                       DEFAULT NULL COMMENT 'Updated time',
    `del_time`        bigint(20) DEFAULT '0' COMMENT 'Deletion timestamp',
    `del_flag`        tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_link_15`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT 'Domain',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT 'Short link',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整Short link',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT 'Original URL',
    `click_num`       int(11) DEFAULT '0' COMMENT 'Click count',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT 'Group identifier',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT 'Favicon',
    `enable_status`   tinyint(1) DEFAULT NULL COMMENT 'Enable flag 0: enabled 1: disabled',
    `created_type`    tinyint(1) DEFAULT NULL COMMENT 'Create type 0: API 1: console',
    `valid_date_type` tinyint(1) DEFAULT NULL COMMENT 'Expiration type 0: permanent 1: custom',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT 'Expiration',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT 'Description',
    `total_pv`        int(11) DEFAULT NULL COMMENT 'Total PV',
    `total_uv`        int(11) DEFAULT NULL COMMENT 'Total UV',
    `total_uip`       int(11) DEFAULT NULL COMMENT 'Total UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT 'Created time',
    `update_time`     datetime                                       DEFAULT NULL COMMENT 'Updated time',
    `del_time`        bigint(20) DEFAULT '0' COMMENT 'Deletion timestamp',
    `del_flag`        tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_link_2`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT 'Domain',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT 'Short link',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整Short link',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT 'Original URL',
    `click_num`       int(11) DEFAULT '0' COMMENT 'Click count',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT 'Group identifier',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT 'Favicon',
    `enable_status`   tinyint(1) DEFAULT NULL COMMENT 'Enable flag 0: enabled 1: disabled',
    `created_type`    tinyint(1) DEFAULT NULL COMMENT 'Create type 0: API 1: console',
    `valid_date_type` tinyint(1) DEFAULT NULL COMMENT 'Expiration type 0: permanent 1: custom',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT 'Expiration',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT 'Description',
    `total_pv`        int(11) DEFAULT NULL COMMENT 'Total PV',
    `total_uv`        int(11) DEFAULT NULL COMMENT 'Total UV',
    `total_uip`       int(11) DEFAULT NULL COMMENT 'Total UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT 'Created time',
    `update_time`     datetime                                       DEFAULT NULL COMMENT 'Updated time',
    `del_time`        bigint(20) DEFAULT '0' COMMENT 'Deletion timestamp',
    `del_flag`        tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_link_3`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT 'Domain',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT 'Short link',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整Short link',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT 'Original URL',
    `click_num`       int(11) DEFAULT '0' COMMENT 'Click count',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT 'Group identifier',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT 'Favicon',
    `enable_status`   tinyint(1) DEFAULT NULL COMMENT 'Enable flag 0: enabled 1: disabled',
    `created_type`    tinyint(1) DEFAULT NULL COMMENT 'Create type 0: API 1: console',
    `valid_date_type` tinyint(1) DEFAULT NULL COMMENT 'Expiration type 0: permanent 1: custom',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT 'Expiration',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT 'Description',
    `total_pv`        int(11) DEFAULT NULL COMMENT 'Total PV',
    `total_uv`        int(11) DEFAULT NULL COMMENT 'Total UV',
    `total_uip`       int(11) DEFAULT NULL COMMENT 'Total UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT 'Created time',
    `update_time`     datetime                                       DEFAULT NULL COMMENT 'Updated time',
    `del_time`        bigint(20) DEFAULT '0' COMMENT 'Deletion timestamp',
    `del_flag`        tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_link_4`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT 'Domain',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT 'Short link',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整Short link',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT 'Original URL',
    `click_num`       int(11) DEFAULT '0' COMMENT 'Click count',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT 'Group identifier',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT 'Favicon',
    `enable_status`   tinyint(1) DEFAULT NULL COMMENT 'Enable flag 0: enabled 1: disabled',
    `created_type`    tinyint(1) DEFAULT NULL COMMENT 'Create type 0: API 1: console',
    `valid_date_type` tinyint(1) DEFAULT NULL COMMENT 'Expiration type 0: permanent 1: custom',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT 'Expiration',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT 'Description',
    `total_pv`        int(11) DEFAULT NULL COMMENT 'Total PV',
    `total_uv`        int(11) DEFAULT NULL COMMENT 'Total UV',
    `total_uip`       int(11) DEFAULT NULL COMMENT 'Total UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT 'Created time',
    `update_time`     datetime                                       DEFAULT NULL COMMENT 'Updated time',
    `del_time`        bigint(20) DEFAULT '0' COMMENT 'Deletion timestamp',
    `del_flag`        tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_link_5`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT 'Domain',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT 'Short link',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整Short link',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT 'Original URL',
    `click_num`       int(11) DEFAULT '0' COMMENT 'Click count',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT 'Group identifier',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT 'Favicon',
    `enable_status`   tinyint(1) DEFAULT NULL COMMENT 'Enable flag 0: enabled 1: disabled',
    `created_type`    tinyint(1) DEFAULT NULL COMMENT 'Create type 0: API 1: console',
    `valid_date_type` tinyint(1) DEFAULT NULL COMMENT 'Expiration type 0: permanent 1: custom',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT 'Expiration',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT 'Description',
    `total_pv`        int(11) DEFAULT NULL COMMENT 'Total PV',
    `total_uv`        int(11) DEFAULT NULL COMMENT 'Total UV',
    `total_uip`       int(11) DEFAULT NULL COMMENT 'Total UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT 'Created time',
    `update_time`     datetime                                       DEFAULT NULL COMMENT 'Updated time',
    `del_time`        bigint(20) DEFAULT '0' COMMENT 'Deletion timestamp',
    `del_flag`        tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_link_6`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT 'Domain',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT 'Short link',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整Short link',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT 'Original URL',
    `click_num`       int(11) DEFAULT '0' COMMENT 'Click count',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT 'Group identifier',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT 'Favicon',
    `enable_status`   tinyint(1) DEFAULT NULL COMMENT 'Enable flag 0: enabled 1: disabled',
    `created_type`    tinyint(1) DEFAULT NULL COMMENT 'Create type 0: API 1: console',
    `valid_date_type` tinyint(1) DEFAULT NULL COMMENT 'Expiration type 0: permanent 1: custom',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT 'Expiration',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT 'Description',
    `total_pv`        int(11) DEFAULT NULL COMMENT 'Total PV',
    `total_uv`        int(11) DEFAULT NULL COMMENT 'Total UV',
    `total_uip`       int(11) DEFAULT NULL COMMENT 'Total UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT 'Created time',
    `update_time`     datetime                                       DEFAULT NULL COMMENT 'Updated time',
    `del_time`        bigint(20) DEFAULT '0' COMMENT 'Deletion timestamp',
    `del_flag`        tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_link_7`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT 'Domain',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT 'Short link',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整Short link',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT 'Original URL',
    `click_num`       int(11) DEFAULT '0' COMMENT 'Click count',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT 'Group identifier',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT 'Favicon',
    `enable_status`   tinyint(1) DEFAULT NULL COMMENT 'Enable flag 0: enabled 1: disabled',
    `created_type`    tinyint(1) DEFAULT NULL COMMENT 'Create type 0: API 1: console',
    `valid_date_type` tinyint(1) DEFAULT NULL COMMENT 'Expiration type 0: permanent 1: custom',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT 'Expiration',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT 'Description',
    `total_pv`        int(11) DEFAULT NULL COMMENT 'Total PV',
    `total_uv`        int(11) DEFAULT NULL COMMENT 'Total UV',
    `total_uip`       int(11) DEFAULT NULL COMMENT 'Total UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT 'Created time',
    `update_time`     datetime                                       DEFAULT NULL COMMENT 'Updated time',
    `del_time`        bigint(20) DEFAULT '0' COMMENT 'Deletion timestamp',
    `del_flag`        tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_link_8`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT 'Domain',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT 'Short link',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整Short link',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT 'Original URL',
    `click_num`       int(11) DEFAULT '0' COMMENT 'Click count',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT 'Group identifier',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT 'Favicon',
    `enable_status`   tinyint(1) DEFAULT NULL COMMENT 'Enable flag 0: enabled 1: disabled',
    `created_type`    tinyint(1) DEFAULT NULL COMMENT 'Create type 0: API 1: console',
    `valid_date_type` tinyint(1) DEFAULT NULL COMMENT 'Expiration type 0: permanent 1: custom',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT 'Expiration',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT 'Description',
    `total_pv`        int(11) DEFAULT NULL COMMENT 'Total PV',
    `total_uv`        int(11) DEFAULT NULL COMMENT 'Total UV',
    `total_uip`       int(11) DEFAULT NULL COMMENT 'Total UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT 'Created time',
    `update_time`     datetime                                       DEFAULT NULL COMMENT 'Updated time',
    `del_time`        bigint(20) DEFAULT '0' COMMENT 'Deletion timestamp',
    `del_flag`        tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_link_9`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT 'Domain',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT 'Short link',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整Short link',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT 'Original URL',
    `click_num`       int(11) DEFAULT '0' COMMENT 'Click count',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT 'Group identifier',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT 'Favicon',
    `enable_status`   tinyint(1) DEFAULT NULL COMMENT 'Enable flag 0: enabled 1: disabled',
    `created_type`    tinyint(1) DEFAULT NULL COMMENT 'Create type 0: API 1: console',
    `valid_date_type` tinyint(1) DEFAULT NULL COMMENT 'Expiration type 0: permanent 1: custom',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT 'Expiration',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT 'Description',
    `total_pv`        int(11) DEFAULT NULL COMMENT 'Total PV',
    `total_uv`        int(11) DEFAULT NULL COMMENT 'Total UV',
    `total_uip`       int(11) DEFAULT NULL COMMENT 'Total UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT 'Created time',
    `update_time`     datetime                                       DEFAULT NULL COMMENT 'Updated time',
    `del_time`        bigint(20) DEFAULT '0' COMMENT 'Deletion timestamp',
    `del_flag`        tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_link_access_logs`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整Short link',
    `user`           varchar(64)  DEFAULT NULL COMMENT 'User info',
    `ip`             varchar(64)  DEFAULT NULL COMMENT 'IP',
    `browser`        varchar(64)  DEFAULT NULL COMMENT '浏览器',
    `os`             varchar(64)  DEFAULT NULL COMMENT '操作系统',
    `network`        varchar(64)  DEFAULT NULL COMMENT 'Network',
    `device`         varchar(64)  DEFAULT NULL COMMENT 'Device',
    `locale`         varchar(256) DEFAULT NULL COMMENT 'Region',
    `create_time`    datetime     DEFAULT NULL COMMENT 'Created time',
    `update_time`    datetime     DEFAULT NULL COMMENT 'Updated time',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    KEY              `idx_full_short_url` (`full_short_url`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_link_access_stats`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整Short link',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `pv`             int(11) DEFAULT NULL COMMENT '访问量',
    `uv`             int(11) DEFAULT NULL COMMENT '独立访客数',
    `uip`            int(11) DEFAULT NULL COMMENT '独立IP数',
    `hour`           int(3) DEFAULT NULL COMMENT '小时',
    `weekday`        int(3) DEFAULT NULL COMMENT 'Weekday',
    `create_time`    datetime     DEFAULT NULL COMMENT 'Created time',
    `update_time`    datetime     DEFAULT NULL COMMENT 'Updated time',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_access_stats` (`full_short_url`,`date`,`hour`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_link_browser_stats`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整Short link',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `cnt`            int(11) DEFAULT NULL COMMENT '访问量',
    `browser`        varchar(64)  DEFAULT NULL COMMENT '浏览器',
    `create_time`    datetime     DEFAULT NULL COMMENT 'Created time',
    `update_time`    datetime     DEFAULT NULL COMMENT 'Updated time',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_browser_stats` (`full_short_url`,`date`,`browser`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_link_device_stats`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整Short link',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `cnt`            int(11) DEFAULT NULL COMMENT '访问量',
    `device`         varchar(64)  DEFAULT NULL COMMENT 'Device',
    `create_time`    datetime     DEFAULT NULL COMMENT 'Created time',
    `update_time`    datetime     DEFAULT NULL COMMENT 'Updated time',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_browser_stats` (`full_short_url`,`date`,`device`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `t_link_goto_0`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT 'Group identifier',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整Short link',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_full_short_url` (`full_short_url`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_link_goto_1`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT 'Group identifier',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整Short link',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_full_short_url` (`full_short_url`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_link_goto_10`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT 'Group identifier',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整Short link',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_full_short_url` (`full_short_url`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_link_goto_11`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT 'Group identifier',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整Short link',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_full_short_url` (`full_short_url`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_link_goto_12`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT 'Group identifier',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整Short link',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_full_short_url` (`full_short_url`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_link_goto_13`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT 'Group identifier',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整Short link',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_full_short_url` (`full_short_url`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_link_goto_14`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT 'Group identifier',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整Short link',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_full_short_url` (`full_short_url`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_link_goto_15`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT 'Group identifier',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整Short link',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_full_short_url` (`full_short_url`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_link_goto_2`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT 'Group identifier',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整Short link',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_full_short_url` (`full_short_url`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_link_goto_3`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT 'Group identifier',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整Short link',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_full_short_url` (`full_short_url`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_link_goto_4`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT 'Group identifier',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整Short link',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_full_short_url` (`full_short_url`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_link_goto_5`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT 'Group identifier',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整Short link',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_full_short_url` (`full_short_url`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_link_goto_6`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT 'Group identifier',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整Short link',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_full_short_url` (`full_short_url`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_link_goto_7`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT 'Group identifier',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整Short link',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_full_short_url` (`full_short_url`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_link_goto_8`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT 'Group identifier',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整Short link',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_full_short_url` (`full_short_url`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_link_goto_9`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT 'Group identifier',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整Short link',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_full_short_url` (`full_short_url`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_link_locale_stats`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整Short link',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `cnt`            int(11) DEFAULT NULL COMMENT '访问量',
    `province`       varchar(64)  DEFAULT NULL COMMENT 'Province name',
    `city`           varchar(64)  DEFAULT NULL COMMENT 'City name',
    `adcode`         varchar(64)  DEFAULT NULL COMMENT 'City code',
    `country`        varchar(64)  DEFAULT NULL COMMENT 'Country identifier',
    `create_time`    datetime     DEFAULT NULL COMMENT 'Created time',
    `update_time`    datetime     DEFAULT NULL COMMENT 'Updated time',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_locale_stats` (`full_short_url`,`date`,`adcode`,`province`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_link_network_stats`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整Short link',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `cnt`            int(11) DEFAULT NULL COMMENT '访问量',
    `network`        varchar(64)  DEFAULT NULL COMMENT 'Network',
    `create_time`    datetime     DEFAULT NULL COMMENT 'Created time',
    `update_time`    datetime     DEFAULT NULL COMMENT 'Updated time',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_browser_stats` (`full_short_url`,`date`,`network`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_link_os_stats`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整Short link',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `cnt`            int(11) DEFAULT NULL COMMENT '访问量',
    `os`             varchar(64)  DEFAULT NULL COMMENT '操作系统',
    `create_time`    datetime     DEFAULT NULL COMMENT 'Created time',
    `update_time`    datetime     DEFAULT NULL COMMENT 'Updated time',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_os_stats` (`full_short_url`,`date`,`os`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_link_stats_today`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT 'Short link',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `today_pv`       int(11) DEFAULT '0' COMMENT '今日PV',
    `today_uv`       int(11) DEFAULT '0' COMMENT '今日UV',
    `today_uip`      int(11) DEFAULT '0' COMMENT '今日IP数',
    `create_time`    datetime     DEFAULT NULL COMMENT 'Created time',
    `update_time`    datetime     DEFAULT NULL COMMENT 'Updated time',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_today_stats` (`full_short_url`,`date`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_user_0`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      varchar(256) DEFAULT NULL COMMENT 'Username',
    `password`      varchar(512) DEFAULT NULL COMMENT 'Password',
    `real_name`     varchar(256) DEFAULT NULL COMMENT 'Real name',
    `phone`         varchar(128) DEFAULT NULL COMMENT 'Phone number',
    `mail`          varchar(512) DEFAULT NULL COMMENT 'Email',
    `deletion_time` bigint(20) DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime     DEFAULT NULL COMMENT 'Created time',
    `update_time`   datetime     DEFAULT NULL COMMENT 'Updated time',
    `del_flag`      tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1716344307570487299 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_user_1`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      varchar(256) DEFAULT NULL COMMENT 'Username',
    `password`      varchar(512) DEFAULT NULL COMMENT 'Password',
    `real_name`     varchar(256) DEFAULT NULL COMMENT 'Real name',
    `phone`         varchar(128) DEFAULT NULL COMMENT 'Phone number',
    `mail`          varchar(512) DEFAULT NULL COMMENT 'Email',
    `deletion_time` bigint(20) DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime     DEFAULT NULL COMMENT 'Created time',
    `update_time`   datetime     DEFAULT NULL COMMENT 'Updated time',
    `del_flag`      tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1726253659068588035 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_user_10`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      varchar(256) DEFAULT NULL COMMENT 'Username',
    `password`      varchar(512) DEFAULT NULL COMMENT 'Password',
    `real_name`     varchar(256) DEFAULT NULL COMMENT 'Real name',
    `phone`         varchar(128) DEFAULT NULL COMMENT 'Phone number',
    `mail`          varchar(512) DEFAULT NULL COMMENT 'Email',
    `deletion_time` bigint(20) DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime     DEFAULT NULL COMMENT 'Created time',
    `update_time`   datetime     DEFAULT NULL COMMENT 'Updated time',
    `del_flag`      tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1726262175087058946 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_user_11`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      varchar(256) DEFAULT NULL COMMENT 'Username',
    `password`      varchar(512) DEFAULT NULL COMMENT 'Password',
    `real_name`     varchar(256) DEFAULT NULL COMMENT 'Real name',
    `phone`         varchar(128) DEFAULT NULL COMMENT 'Phone number',
    `mail`          varchar(512) DEFAULT NULL COMMENT 'Email',
    `deletion_time` bigint(20) DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime     DEFAULT NULL COMMENT 'Created time',
    `update_time`   datetime     DEFAULT NULL COMMENT 'Updated time',
    `del_flag`      tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1716835884998893571 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_user_12`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      varchar(256) DEFAULT NULL COMMENT 'Username',
    `password`      varchar(512) DEFAULT NULL COMMENT 'Password',
    `real_name`     varchar(256) DEFAULT NULL COMMENT 'Real name',
    `phone`         varchar(128) DEFAULT NULL COMMENT 'Phone number',
    `mail`          varchar(512) DEFAULT NULL COMMENT 'Email',
    `deletion_time` bigint(20) DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime     DEFAULT NULL COMMENT 'Created time',
    `update_time`   datetime     DEFAULT NULL COMMENT 'Updated time',
    `del_flag`      tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1716356833762906114 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_user_13`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      varchar(256) DEFAULT NULL COMMENT 'Username',
    `password`      varchar(512) DEFAULT NULL COMMENT 'Password',
    `real_name`     varchar(256) DEFAULT NULL COMMENT 'Real name',
    `phone`         varchar(128) DEFAULT NULL COMMENT 'Phone number',
    `mail`          varchar(512) DEFAULT NULL COMMENT 'Email',
    `deletion_time` bigint(20) DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime     DEFAULT NULL COMMENT 'Created time',
    `update_time`   datetime     DEFAULT NULL COMMENT 'Updated time',
    `del_flag`      tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1716777589441347586 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_user_14`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      varchar(256) DEFAULT NULL COMMENT 'Username',
    `password`      varchar(512) DEFAULT NULL COMMENT 'Password',
    `real_name`     varchar(256) DEFAULT NULL COMMENT 'Real name',
    `phone`         varchar(128) DEFAULT NULL COMMENT 'Phone number',
    `mail`          varchar(512) DEFAULT NULL COMMENT 'Email',
    `deletion_time` bigint(20) DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime     DEFAULT NULL COMMENT 'Created time',
    `update_time`   datetime     DEFAULT NULL COMMENT 'Updated time',
    `del_flag`      tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1716835562859589634 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_user_15`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      varchar(256) DEFAULT NULL COMMENT 'Username',
    `password`      varchar(512) DEFAULT NULL COMMENT 'Password',
    `real_name`     varchar(256) DEFAULT NULL COMMENT 'Real name',
    `phone`         varchar(128) DEFAULT NULL COMMENT 'Phone number',
    `mail`          varchar(512) DEFAULT NULL COMMENT 'Email',
    `deletion_time` bigint(20) DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime     DEFAULT NULL COMMENT 'Created time',
    `update_time`   datetime     DEFAULT NULL COMMENT 'Updated time',
    `del_flag`      tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1752265616481370114 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_user_2`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      varchar(256) DEFAULT NULL COMMENT 'Username',
    `password`      varchar(512) DEFAULT NULL COMMENT 'Password',
    `real_name`     varchar(256) DEFAULT NULL COMMENT 'Real name',
    `phone`         varchar(128) DEFAULT NULL COMMENT 'Phone number',
    `mail`          varchar(512) DEFAULT NULL COMMENT 'Email',
    `deletion_time` bigint(20) DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime     DEFAULT NULL COMMENT 'Created time',
    `update_time`   datetime     DEFAULT NULL COMMENT 'Updated time',
    `del_flag`      tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1726260205890691074 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_user_3`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      varchar(256) DEFAULT NULL COMMENT 'Username',
    `password`      varchar(512) DEFAULT NULL COMMENT 'Password',
    `real_name`     varchar(256) DEFAULT NULL COMMENT 'Real name',
    `phone`         varchar(128) DEFAULT NULL COMMENT 'Phone number',
    `mail`          varchar(512) DEFAULT NULL COMMENT 'Email',
    `deletion_time` bigint(20) DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime     DEFAULT NULL COMMENT 'Created time',
    `update_time`   datetime     DEFAULT NULL COMMENT 'Updated time',
    `del_flag`      tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1716826815625977859 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_user_4`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      varchar(256) DEFAULT NULL COMMENT 'Username',
    `password`      varchar(512) DEFAULT NULL COMMENT 'Password',
    `real_name`     varchar(256) DEFAULT NULL COMMENT 'Real name',
    `phone`         varchar(128) DEFAULT NULL COMMENT 'Phone number',
    `mail`          varchar(512) DEFAULT NULL COMMENT 'Email',
    `deletion_time` bigint(20) DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime     DEFAULT NULL COMMENT 'Created time',
    `update_time`   datetime     DEFAULT NULL COMMENT 'Updated time',
    `del_flag`      tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1716777824704053251 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_user_5`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      varchar(256) DEFAULT NULL COMMENT 'Username',
    `password`      varchar(512) DEFAULT NULL COMMENT 'Password',
    `real_name`     varchar(256) DEFAULT NULL COMMENT 'Real name',
    `phone`         varchar(128) DEFAULT NULL COMMENT 'Phone number',
    `mail`          varchar(512) DEFAULT NULL COMMENT 'Email',
    `deletion_time` bigint(20) DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime     DEFAULT NULL COMMENT 'Created time',
    `update_time`   datetime     DEFAULT NULL COMMENT 'Updated time',
    `del_flag`      tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1716835362095034371 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_user_6`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      varchar(256) DEFAULT NULL COMMENT 'Username',
    `password`      varchar(512) DEFAULT NULL COMMENT 'Password',
    `real_name`     varchar(256) DEFAULT NULL COMMENT 'Real name',
    `phone`         varchar(128) DEFAULT NULL COMMENT 'Phone number',
    `mail`          varchar(512) DEFAULT NULL COMMENT 'Email',
    `deletion_time` bigint(20) DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime     DEFAULT NULL COMMENT 'Created time',
    `update_time`   datetime     DEFAULT NULL COMMENT 'Updated time',
    `del_flag`      tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1716991700406161411 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_user_7`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      varchar(256) DEFAULT NULL COMMENT 'Username',
    `password`      varchar(512) DEFAULT NULL COMMENT 'Password',
    `real_name`     varchar(256) DEFAULT NULL COMMENT 'Real name',
    `phone`         varchar(128) DEFAULT NULL COMMENT 'Phone number',
    `mail`          varchar(512) DEFAULT NULL COMMENT 'Email',
    `deletion_time` bigint(20) DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime     DEFAULT NULL COMMENT 'Created time',
    `update_time`   datetime     DEFAULT NULL COMMENT 'Updated time',
    `del_flag`      tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1716834641844936706 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_user_8`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      varchar(256) DEFAULT NULL COMMENT 'Username',
    `password`      varchar(512) DEFAULT NULL COMMENT 'Password',
    `real_name`     varchar(256) DEFAULT NULL COMMENT 'Real name',
    `phone`         varchar(128) DEFAULT NULL COMMENT 'Phone number',
    `mail`          varchar(512) DEFAULT NULL COMMENT 'Email',
    `deletion_time` bigint(20) DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime     DEFAULT NULL COMMENT 'Created time',
    `update_time`   datetime     DEFAULT NULL COMMENT 'Updated time',
    `del_flag`      tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_user_9`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      varchar(256) DEFAULT NULL COMMENT 'Username',
    `password`      varchar(512) DEFAULT NULL COMMENT 'Password',
    `real_name`     varchar(256) DEFAULT NULL COMMENT 'Real name',
    `phone`         varchar(128) DEFAULT NULL COMMENT 'Phone number',
    `mail`          varchar(512) DEFAULT NULL COMMENT 'Email',
    `deletion_time` bigint(20) DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime     DEFAULT NULL COMMENT 'Created time',
    `update_time`   datetime     DEFAULT NULL COMMENT 'Updated time',
    `del_flag`      tinyint(1) DEFAULT NULL COMMENT 'Delete flag 0: not deleted 1: deleted',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1726852231086505986 DEFAULT CHARSET=utf8mb4;
