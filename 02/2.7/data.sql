drop database if exists liuyan;
create database liuyan;

use liuyan;

create table user_inf
(
	id int auto_increment primary key,
	name varchar(255),
	pass varchar(255)
);

insert into user_inf
values(null,'crazyit','123');
insert into user_inf
values(null,'tiger','123');
