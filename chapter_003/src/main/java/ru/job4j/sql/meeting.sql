CREATE TABLE users
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(30)
);

CREATE TABLE meeting
(
    id      SERIAL PRIMARY KEY,
    name    VARCHAR(30),
    user_id INT4 REFERENCES "users" (id)
);

CREATE TYPE meeting_status AS ENUM ('ACCEPTED', 'REFUSED');

CREATE TABLE status
(
    id             SERIAL PRIMARY KEY,
    current_status meeting_status not null,
    user_id        INT4 REFERENCES "users" (id)
);

insert into users(name)
VALUES ('Danon');

insert into users(name)
VALUES ('Misha');

insert into users(name)
VALUES ('Vova');

insert into meeting(name, user_id)
VALUES ('exam', 1);
insert into meeting(name, user_id)
VALUES ('vibori', 2);
insert into meeting(name, user_id)
VALUES ('svadba', 3);
insert into meeting(name)
VALUES ('kino');
insert into meeting(name)
VALUES ('teatr');

insert into status (current_status, user_id)
VALUES ('ACCEPTED', 1);
insert into status (current_status, user_id)
VALUES ('ACCEPTED', 2);
insert into status (current_status, user_id)
VALUES ('ACCEPTED', 3);

--Нужно написать запрос, который получит список всех заяков и количество подтвердивших участников.

select count(*) as meet, count(s.user_id) as accepted
from meeting as m
         join status s on m.user_id = s.user_id
where s.current_status = 'ACCEPTED';

--Нужно получить все совещания, где не было ни одной заявки на посещения

select *  from meeting as m where m.user_id IS NULL ;