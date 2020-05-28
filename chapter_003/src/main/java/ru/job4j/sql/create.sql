CREATE DATABASE db_for_task (
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;
);

CREATE TABLE "role" (
	id SERIAL PRIMARY KEY,
	role VARCHAR(20),
);

CREATE TABLE "user" (
	id SERIAL PRIMARY KEY,
	login VARCHAR(20),
	password VARCHAR(20),
	first_name VARCHAR(255),
	last_name VARCHAR(255),
	role_id INT4 REFERENCES "role"(id)
);

CREATE TABLE "rules" (
	id SERIAL PRIMARY KEY,
	rule VARCHAR(25)
);

CREATE TABLE "user_role_rules" (
	id SERIAL PRIMARY KEY,
	role_id INT4 REFERENCES "role"(id),
	rule_id INT4 REFERENCES "rules"(id)
);

CREATE TABLE "category" (
	id SERIAL PRIMARY KEY,
	category_name VARCHAR(30),
);

CREATE TABLE "state" (
	id SERIAL PRIMARY KEY,
	state VARCHAR(30)
);

CREATE TABLE "items" (
	id SERIAL PRIMARY KEY,
	description VARCHAR(255),
	user_id INT4 REFERENCES "user"(id),
	category_id INT4 REFERENCES "category"(id),
	state_id INT4 REFERENCES "state"(id)

);

CREATE TABLE "comments" (
	id SERIAL PRIMARY KEY,
	description TEXT,
	item_id INT4 REFERENCES "items"(id)
);

CREATE TABLE "attachs" (
	id SERIAL PRIMARY KEY,
	file_name VARCHAR(30),
	item_id INT4 REFERENCES "items"(id)
);

INSERT INTO "role" (role) VALUES ('admin');
INSERT INTO "role" (role) VALUES ('main_admin');

INSERT INTO "user" (login, password, first_name, last_name, role_id) VALUES ('ms_hant2011', '123321qq', 'Misha', 'Dedun', 1);



INSERT INTO "rules" (rule) VALUES ('delete user');

INSERT INTO "user_role_rules" (role_id, rule_id) VALUES (1, 1);

INSERT INTO "category" (category_name) VALUES ('Спорт');

INSERT INTO "state" (state) VALUES ('В ожидании');

INSERT INTO "items" (description, user_id, category_id, state_id) VALUES ('Сумка',1 ,1 ,1);

INSERT INTO "comments" (description, item_id) VALUES ('сумка хоккейная', 1);

INSERT INTO "attachs" (file_name, item_id) VALUES ('word.txt', 1);



















