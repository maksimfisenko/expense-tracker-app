-- liquibase formatted sql

--changeset maksimfisenko:create-expense-tracker-schema
--comment create new schema
create schema "expense-tracker";
--rollback drop schema "expense-tracker";