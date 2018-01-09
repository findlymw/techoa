create table techoa.rewardandpunishment
(
	id bigint auto_increment
		primary key,
	userid bigint not null,
	bonus bigint not null,
	balance bigint not null,
	rptype int not null comment '0：奖励
	1：惩罚
	2：充值',
	descstr varchar(500) null,
	createtime bigint null,
	constraint rewardandpunishment_id_uindex
		unique (id)
)
comment '奖惩、充值记录表'
;

create table techoa.totalaccount
(
	id int auto_increment
		primary key,
	account bigint default '0' null comment '单位为分',
	constraint totalaccount_id_uindex
		unique (id)
)
comment '总资金账户'
;

create table techoa.user
(
	id bigint auto_increment
		primary key,
	username varchar(20) not null,
	password varchar(64) not null,
	nickname varchar(20) default 'No Name' null,
	admin int default '0' null,
	createtime bigint null,
	constraint user_id_uindex
		unique (id)
)
;


insert into user (username,password,nickname,admin,createtime) values('admin','C33367701511B4F6020EC61DED352059','admin','777','1513836625965');