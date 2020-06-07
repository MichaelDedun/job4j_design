CREATE TABLE company
(
id serial primary key ,
name character varying,
);

CREATE TABLE person
(
id serial primary key ,
name character varying,
company_id integer references "company"(id),
);

insert into company (name) values ('rtsoft');
insert into company (name) values ('google');
insert into company (name) values ('amazon');
insert into company (name) values ('uber');
insert into company (name) values ('yandex');
insert into company (name) values ('mail');

insert into person (name, company_id) values ('vova',1);
insert into person (name, company_id) values ('vasa',1);
insert into person (name, company_id) values ('misha',1);
insert into person (name, company_id) values ('alex',2);
insert into person (name, company_id) values ('vera',2);
insert into person (name, company_id) values ('nika',3);
insert into person (name, company_id) values ('katya',4);
insert into person (name, company_id) values ('peti',5);
insert into person (name, company_id) values ('jack',5);
insert into person (name, company_id) values ('evgeniy',6);


select p.id,p.name,c.name,c.id from person as p inner join company c on p.company_id = c.id where p.company_id not in (5);

select c.name, COUNT(p.company_id) as co from person as p inner join company  c on p.company_id = c.id
group by c.name order by co desc limit 1;