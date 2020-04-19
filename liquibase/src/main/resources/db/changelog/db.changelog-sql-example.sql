--liquibase formatted sql

--changeset guedimliquibase-demo-service:add-user-name-constraint
ALTER TABLE user_details ADD CONSTRAINT user_details_username_key UNIQUE (username);
