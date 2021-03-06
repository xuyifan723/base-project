create table bus_data_source
(
    id           int auto_increment
        primary key,
    name         varchar(50) not null comment '数据源名称',
    username     int         not null comment '数据源用户名',
    password     varchar(50) not null comment '密码',
    url          varchar(50) not null comment '数据url',
    driver_name  varchar(50) not null comment '数据库驱动',
    version      int         null comment '0以下代表删除，0及0以上代表版本',
    created      varchar(30) null comment '创建人',
    created_time datetime    null comment '创建时间',
    updated      varchar(30) null comment '更新人',
    updated_time datetime    null comment '更新时间'
);

create table bus_resource_permission
(
    id                int auto_increment
        primary key,
    operator_type     varchar(50) not null comment '用户类型',
    operator_id       int         not null comment '用户id',
    resource_type     varchar(50) not null comment '资源类型',
    resource_id       int         not null comment '资源id',
    permission_type   varchar(50) not null comment '允许操作类型',
    permission_action int         not null comment '0代表不允许，1代表允许',
    version           int         null comment '0以下代表删除，0及0以上代表版本',
    created           varchar(30) null comment '创建人',
    created_time      datetime    null comment '创建时间',
    updated           varchar(30) null comment '更新人',
    updated_time      datetime    null comment '更新时间'
);

create table bus_user
(
    id           varchar(50)  not null
        primary key,
    user_name    varchar(255) null,
    login_name   varchar(255) null,
    password     varchar(255) null,
    version      int(255)     null,
    created_id   varchar(50)  null,
    created_time datetime     null,
    updater_id   varchar(50)  null,
    updater_time datetime     null
);

create table com_menu
(
    id           varchar(50)  not null
        primary key,
    title        varchar(255) null,
    url          varchar(255) null,
    icon         varchar(255) null,
    parent_id    varchar(0)   null,
    version      int(255)     null,
    created      varchar(255) null,
    created_time datetime     null,
    updated      varchar(0)   null,
    updated_time datetime     null
);

