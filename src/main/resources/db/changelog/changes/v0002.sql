
-- liquibase formatted sql

-- changeset liquibase:2
CREATE TABLE departments
(
    id NUMBER GENERATED ALWAYS AS IDENTITY START with 1 INCREMENT by 1,

    department_name VARCHAR2( 255 ) NOT NULL,
    department_description VARCHAR2( 255 ) NOT NULL
);

ALTER TABLE departments ADD (
  CONSTRAINT departments_pk PRIMARY KEY (ID));
