-- When the application is started, this file is written and executed, because the automatic schema creation is turned off.
-- This code createas a new table database every time that bootrun is started.

--ALTER TABLE PUBLIC.ROLES DROP CONSTRAINT fk_user;
DROP TABLE IF EXISTS ROLES;
DROP TABLE IF EXISTS REGISTERED_USER;

CREATE TABLE REGISTERED_USER (
                       ID serial PRIMARY KEY,
                       USER_NAME VARCHAR(50),
                       NAME VARCHAR(50),
                       SURNAME1 VARCHAR(50),
                       SURNAME2 VARCHAR(50)
);

CREATE TABLE ROLES (
                        ID serial PRIMARY KEY,
                        CODE VARCHAR(50),
                        DESCRIPTION VARCHAR(255),
                        ID_USER serial,
                        constraint fk_user foreign key (ID_USER) references REGISTERED_USER(ID)
                   );