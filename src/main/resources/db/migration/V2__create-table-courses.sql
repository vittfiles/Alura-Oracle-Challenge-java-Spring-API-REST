create table courses(
    id bigint not null auto_increment,
    name varchar(255) not null,
    category varchar(100),

    primary key(id)
);