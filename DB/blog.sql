drop database if exists blogdb;
create database blogdb;
use blogdb;

create table users(
userid int auto_increment primary key,
userName varchar(30) not null,
`description` varchar(50),
userType varchar(30) not null,
`password` varchar(50) not null
);

create table post(
postid int auto_increment primary key,
title varchar(50) not null,
content text not null,
postDate datetime not null,
`status` boolean not null default false,
 userid int not null,
 foreign key (userid)references users(userid)
);

create table category(
categoryid int auto_increment primary key,
`name` varchar(50) not null
);

create table post_category(
 postid int not null,
 categoryid int not null,
 foreign key (postid)references post(postid),
 foreign key (categoryid)references category(categoryid)
);



