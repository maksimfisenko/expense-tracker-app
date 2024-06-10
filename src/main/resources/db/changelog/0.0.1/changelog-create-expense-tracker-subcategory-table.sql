--liquibase formatted sql

--changeset maksimfisenko:create-expense-tracker-subcategory-table
--comment create table expense-tracer.subcategory
create table "expense-tracker".subcategory
(
    id                serial primary key,
    name              varchar(32) not null,
    created_timestamp timestamp   not null,
    category_id       integer     not null
);
--rollback drop table "expense-tracker".subcategory;

--changeset maksimfisenko:add-expense-tracker-subcategory-table-constraints
--comment add constraints to expense-tracker.subcategory
alter table "expense-tracker".subcategory
    add constraint subcategory_category_fk
        foreign key (category_id) references "expense-tracker".category (id);
--rollback alter table "expense-tracker".subcategory drop constraint subcategory_category_fk;

--changeset maksimfisenko:add-expense-tracker-subcategory-table-column-last_modified_timestamp
--comment add column last_modified_timestamp to expense-tracker.subcategory
alter table "expense-tracker".subcategory
    add column last_modified_timestamp timestamp;

update "expense-tracker".subcategory
set last_modified_timestamp = created_timestamp
where last_modified_timestamp is null;

alter table "expense-tracker".subcategory
    alter column last_modified_timestamp set not null;
--rollback alter table "expense-tracker".subcategory drop column last_modified_timestamp;