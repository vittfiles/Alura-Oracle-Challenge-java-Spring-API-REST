create table topics(
    id bigint not null auto_increment,
    title varchar(100) not null,
    message varchar(256) not null,
    created_at datetime not null,
    status varchar(50) not null,
    author_id bigint not null,
    course_id bigint,

    primary key(id),
    constraint fk_topics_course_id foreign key(course_id) references courses(id),
    constraint fk_topics_author_id foreign key(author_id) references users(id)
);