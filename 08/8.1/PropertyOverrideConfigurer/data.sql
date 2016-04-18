drop database if exists spring;
create database spring;
use spring;

create table news_inf
(
 news_id int auto_increment primary key,
 news_title varchar(255),
 news_content varchar(255)
);
