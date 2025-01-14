create table users(
    id bigint not null auto_increment,
    name varchar(200) not null,
    email varchar(200) not null unique,
    password varchar(300) not null,

    primary key(id)
);