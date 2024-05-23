-- liquibase formatted sql

--changeset maksimfisenko:create-identity-schema
--comment create new identity schema
create schema identity;
--rollback drop schema identity;

--changeset maksimfisenko:create-identity-user_account-table
--comment create table identity.user_account
create table identity.user_account
(
    id       serial primary key,
    username varchar(32) unique not null,
    password varchar(128)       not null
);
--rollback drop table identity.user_account;

--changeset maksimfisenko:create-identity-user_role-table
--comment create table identity.user_role
create table identity.user_role
(
    id        serial primary key,
    authority varchar(32) unique not null
);
--rollback drop table identity.user_role;

--changeset maksimfisenko:create-identity-user_account_role-table
--comment create table identity.user_account_role
create table identity.user_account_role
(
    user_account_id integer not null,
    user_role_id    integer not null
);
--rollback drop table identity.user_account_role;

--changeset maksimfisenko:add-user_account_role-table-constraints
--comment add constraints to user_account_role
alter table identity.user_account_role
    add constraint user_account_role_user_role_fk
        foreign key (user_role_id) references identity.user_role (id);

alter table identity.user_account_role
    add constraint user_account_role_user_account_fk
        foreign key (user_account_id) references identity.user_account (id);

alter table identity.user_account_role
    add constraint user_account_role_unique
        unique (user_account_id, user_role_id);
--rollback alter table identity.user_account_role drop constraint user_account_role_user_role_fk;
--rollback alter table identity.user_account_role drop constraint user_account_role_user_account_fk;
--rollback alter table identity.user_account_role drop constraint user_account_role_unique;

--changeset maksimfisenko:add-data-to-user_role-table
--comment add roles to user_role table
insert into identity.user_role(authority)
values ('ROLE_USER'),
       ('ROLE_ADMIN');
--rollback truncate table identity.user_role;


