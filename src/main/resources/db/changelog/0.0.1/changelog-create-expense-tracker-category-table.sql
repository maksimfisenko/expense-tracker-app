--liquibase formatted sql

--changeset maksimfisenko:create-expense-tracker-category-table
--comment create table expense-tracer.category
create table "expense-tracker".category
(
    id                serial primary key,
    name              varchar(32) not null,
    hex               varchar(32) not null,
    currency          varchar(32) not null,
    created_timestamp timestamp   not null,
    user_profile_id   integer     not null
);
--rollback drop table "expense-tracker".category;

--changeset maksimfisenko:add-expense-tracker-category-table-constraints
--comment add constraints to expense-tracker.category
alter table "expense-tracker".category
    add constraint category_user_profile_fk
        foreign key (user_profile_id) references "expense-tracker".user_profile (id);
--rollback alter table "expense-tracker".category drop constraint category_user_profile_fk;

--changeset maksimfisenko:add-expense-tracker-category-table-column-last_modified_timestamp
--comment add column last_modified_timestamp to expense-tracker.category
alter table "expense-tracker".category
    add column last_modified_timestamp timestamp;

update "expense-tracker".category
set last_modified_timestamp = created_timestamp
where last_modified_timestamp is null;

alter table "expense-tracker".category
    alter column last_modified_timestamp set not null;
--rollback alter table "expense-tracker".category drop column last_modified_timestamp;