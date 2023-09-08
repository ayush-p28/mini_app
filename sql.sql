/* mysql> source C:\Tomcat 9.0\webapps\70_authentication\sql.sql */

create table users
(
    user_id int auto_increment primary key,
    name varchar(35) not null,
    email varchar(256) not null unique,
    password varchar(20) not null
);


create table khilonas 
(
    khilona_id int auto_increment primary key,
    name varchar(45) not null,
    price int not null,
    age_group varchar(5) not null,
    quantity int not null  
);

alter table khilonas 
add column user_id int not null,
add constraint fk_khilona_user foreign key (user_id)
references users (user_id);

alter table users add column user_type int not null default 2;

update users set user_type=1 where user_id in (1, 4);





