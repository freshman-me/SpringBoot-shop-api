# 创建数据库
create database shop;

# 创建用户表和商品表
create table user(
                     id int not null primary key auto_increment,
                     username varchar(100) not null default '',
                     password varchar(100) not null default '',
                     is_admin int default 0 not null
);

create table product(
                        id int not null primary key auto_increment,
                        pro_name varchar(100) not null ,
                        description varchar(100) not null
);

# 插入admin用户和一些商品数据
insert into user(id, username, password, is_admin) VALUES (1,'admin','admin',1);

insert into product(id, pro_name, description) VALUES (1,'apple','apple description'),(2,'oppo','oppo description');