create table persons (
    id int primary key,
    name_person varchar,
    sex varchar,
    birtday date
);
insert into persons (id, name_person, sex, birtday) VALUES
                                                           (1, 'Andrew', 'M', '1976-10-19'),
                                                           (2, 'Roma', 'M', '1949-07-17'),
                                                           (3,'Dima', 'M', '1976-04-20'),
                                                           (4, 'Natali', 'W', '1975-02-12'),
                                                           (5, 'Tereza', 'W', '1975-09-30'),
                                                           (6, 'Alla', 'W', '1949-04-26'),
                                                           (7, 'Dina', 'W', '1949-04-26'),
                                                           (8, 'Arkadz', 'M', '1949-02-25'),
                                                           (9, 'Ariana', 'W', '2016-06-22'),
                                                           (10, 'Vova', 'M', '1971-04-26');

create table hobbys (
    id int primary key,
    name_hobby varchar,
    type_hobby int,
    constraint type_hobby_fk foreign key (type_hobby) references types_of_hobbys (id)
);
insert into hobbys (id, name_hobby, type_hobby)  VALUES
(1, 'football', 1),
(2, 'reading', 2),
(3, 'chess', 2),
(4, 'judo', 1);


create table types_of_hobbys (
    id int primary key,
    type_name varchar
);
insert into types_of_hobbys (id, type_name) VALUES
                                                    (1, 'activ'),
                                                   (2, 'passiv');

create table persons_hobbys (
    id int primary key,
    id_person int,
    id_hobby int,
    constraint person_fk foreign key (id_person) references persons (id),
    constraint hobby_fk foreign key (id_hobby) references hobbys (id)
);
insert into persons_hobbys (id, id_person, id_hobby)  VALUES
(1, 1, 1), (2, 1, 2), (3, 1, 3),
(4, 2, 1),
(5, 3, 2),
(6, 4, 2),(7, 4, 3),
(8, 5, 2),
(9, 6, 2),(10, 6, 1),
(11, 7, 2),
(12, 8, 1),(13, 8, 2),
(14, 9, 2),(15, 9, 3),
(16, 10, 1),(17, 10, 2),(18, 10, 4), (19, 4, 4);

select name_person from persons where birtday > '1975-01-01';

select p.name_person, h.name_hobby from persons p join persons_hobbys ph on p.id = ph.id_person
    join hobbys h on h.id = ph.id_hobby;

select th.type_name, count(*) from hobbys h join types_of_hobbys th on h.type_hobby = th.id
group by th.type_name;
