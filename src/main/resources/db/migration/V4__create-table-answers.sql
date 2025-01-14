create table answers(
    id bigint not null auto_increment,
    message varchar(255) not null,
    topic_id bigint not null,
    created_at datetime not null,
    author_id bigint not null,
    solution tinyint default FALSE not null,

    primary key(id),
    constraint fk_answers_topic_id foreign key(topic_id) references topics(id),
    constraint fk_answers_author_id foreign key(author_id) references users(id)
);