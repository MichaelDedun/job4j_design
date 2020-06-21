CREATE TABLE users
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(30)
);

CREATE TABLE meetings
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(30)
);

CREATE TYPE status AS ENUM ('ACCEPTED', 'REFUSED');

CREATE TABLE meetings_users
(
    user_id     INT4 REFERENCES users (id),
    meeting_id  INT4 REFERENCES meetings (id),
    user_status status NOT NULL,
    PRIMARY KEY (meeting_id, user_id)
);

insert into users(name)
VALUES ('Michael');
insert into users(name)
VALUES ('Danon');
insert into users(name)
VALUES ('Dima');
insert into users(name)
VALUES ('Vova');

insert into meetings(name)
VALUES ('theater');
insert into meetings(name)
VALUES ('kfc');
insert into meetings(name)
VALUES ('movie');
insert into meetings(name)
VALUES ('poker');

insert into meetings_users(user_id, meeting_id, user_status)
VALUES (1, 1, 'ACCEPTED');
insert into meetings_users(user_id, meeting_id, user_status)
VALUES (2, 2, 'ACCEPTED');
insert into meetings_users(user_id, meeting_id, user_status)
VALUES (2, 1, 'REFUSED');
insert into meetings_users(user_id, meeting_id, user_status)
VALUES (2, 4, 'REFUSED');

--Нужно написать запрос, который получит список всех заяков и количество подтвердивших участников.

--Для подсчета количества подтвердивших участников
CREATE VIEW accepted as
SELECT meeting_id, count(*) as count
FROM meetings_users
WHERE user_status = 'ACCEPTED'
GROUP BY meeting_id;

SELECT m.name, COALESCE(a.count, 0) as acc_num
FROM meetings m
         LEFT JOIN accepted a
                   ON m.id = a.meeting_id;

-- Нужно получить все совещания, где не было ни одной заявки на посещения
select m.name
FROM meetings as m
         left join accepted a on m.id = a.meeting_id
where a.meeting_id ISNULL;