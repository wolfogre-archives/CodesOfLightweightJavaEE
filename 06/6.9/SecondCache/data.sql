drop database hibernate;

create database hibernate;

use hibernate;

create table news_inf
(
 news_id int primary key auto_increment,
 content varchar(255),
 title varchar(255)
);

insert into news_inf
values(null , '疯狂Java联盟' , '疯狂Java联盟是最纯粹的技术论坛。');

insert into news_inf
values(null , '天亮了' , '有一个美丽的新世界，她在远方等我！');
