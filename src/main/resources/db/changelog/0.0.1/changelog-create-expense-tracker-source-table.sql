--liquibase formatted sql

--changeset maksimfisenko:create-expense-tracker-source_table
--comment create table expense-tracer.source
create table "expense-tracker".source
(
    id         serial primary key,
    name       varchar(32)  not null,
    hex       varchar(32)  not null,
    balance       numeric(19, 2)  not null,
    currency varchar(32) not null,
    created_timestamp timestamp not null,
    user_profile_id integer not null
);
--rollback drop table "expense-tracker".source;

--changeset maksimfisenko:add-expense-tracker-source-table-constraints
--comment add constraints to expense-tracker.source
alter table "expense-tracker".source
    add constraint source_user_profile_fk
        foreign key (user_profile_id) references "expense-tracker".user_profile (id);
--rollback alter table "expense-tracker".source drop constraint source_user_profile_fk;