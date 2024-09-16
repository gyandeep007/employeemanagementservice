-- liquibase formatted sql

-- changeset liquibase:3

alter table employees
add department_id number;

alter table employees
add foreign key (department_id) references departments(id)
