--liquibase formatted sql

--changeset guedim-debezium-demo:create table
CREATE TABLE public.student
(
    id character varying(20) NOT NULL,
    address character varying(255),
    email character varying(255),
    name character varying(255),
    CONSTRAINT student_pkey PRIMARY KEY (id)
);

--changeset guedim-debezium-demo:Insert record 
--INSERT INTO STUDENT(ID, NAME, ADDRESS, EMAIL) VALUES('1','Mario','Colombia','guedim@gmail.com');

--changeset guedim-debezium-demo:update record
--UPDATE STUDENT SET EMAIL='guedim-2@gmail.com', NAME='Matias' WHERE ID = '1'; 

--changeset guedim-debezium-demo:delete record
--DELETE FROM STUDENT WHERE ID = '1';