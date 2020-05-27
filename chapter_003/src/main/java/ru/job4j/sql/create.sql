CREATE DATABASE db_for_task (
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;
);

CREATE TABLE "user" (
	id SERIAL PRIMARY KEY,
	login VARCHAR(20),
	password VARCHAR(20),
	first_name VARCHAR(255),
	last_name VARCHAR(255)
);

CREATE TABLE "role" (
	id SERIAL PRIMARY KEY,
	role_type VARCHAR(20),
	user_id INT4,
	FOREIGN KEY (user_id) REFERENCES "user" (id)
);

CREATE TABLE "rules" (
	id SERIAL PRIMARY KEY,
	rule VARCHAR(25)
);

CREATE TABLE "user_role_rules" (
	id SERIAL PRIMARY KEY,
	role_id INT4 REFERENCES "role"(id),
	rule_id INT4 REFERENCES "rules"
);

CREATE TABLE "items" (
	id SERIAL PRIMARY KEY,
	description VARCHAR(255),
	user_id INT4 REFERENCES "user"(id)
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

CREATE TABLE "category" (
	id SERIAL PRIMARY KEY,
	category_name VARCHAR(30),
	item_id INT4 REFERENCES "items"(id)
);

CREATE TABLE "state" (
	id SERIAL PRIMARY KEY,
	state VARCHAR(30),
	item_id INT4 REFERENCES "items"(id)
);

INSERT INTO "user" (login, password, first_name, last_name) VALUES ('ms_hant2011', '123321qq', 'Misha', 'Dedun');

INSERT INTO "role" (role_type, user_id) VALUES ('admin', '1');
INSERT INTO "role" (role_type, user_id) VALUES ('main_admin', '1');

INSERT INTO "rules" (rule) VALUES ('delete user');

INSERT INTO "user_role_rules" (role_id, rule_id) VALUES (1,1);

INSERT INTO "items" (description, user_id) VALUES ('Сумка',1);

INSERT INTO "comments" (description, item_id) VALUES ('сумка хоккейная',1);

INSERT INTO "attachs" (file_name, item_id) VALUES ('word.txt',1);

INSERT INTO "category" (category_name, item_id) VALUES ('Спорт',1);

INSERT INTO "state" (state, item_id) VALUES ('В ожидании',1);

















