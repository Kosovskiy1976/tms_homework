drop table if exists students;
create table students(
                         id uuid primary key,
                         name varchar,
                         surname varchar,
                         sex varchar,
                         yearOfBirth int,
                         classNumber int,
                         adress varchar
)