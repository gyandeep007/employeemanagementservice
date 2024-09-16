
-- liquibase formatted sql

-- changeset liquibase:1
CREATE TABLE employees
(
    id NUMBER GENERATED ALWAYS AS IDENTITY START with 1 INCREMENT by 1,

    first_name VARCHAR2( 255 ) NOT NULL,
    last_name VARCHAR2( 255 ) NOT NULL,
    email VARCHAR2(255)
);

ALTER TABLE employees ADD (
  CONSTRAINT employees_pk PRIMARY KEY (ID));
