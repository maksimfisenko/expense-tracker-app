--liquibase formatted sql

--changeset maksimfisenko:create-expense-tracker-user_profile_table
--comment create table expense-tracer.user_profile
create table "expense-tracker".user_profile
(
    id         integer primary key,
    name       varchar(32)  not null,
    image_link varchar(128) not null
);
--rollback drop table expense-tracker.user_profile;

--changeset maksimfisenko:add-expense-tracker-user_profile-table-constraints
--comment add constraints to expense-tracker.user_profile
alter table "expense-tracker".user_profile
    add constraint user_profile_user_account_fk
        foreign key (id) references identity.user_account (id);
--rollback alter table expense-tracker.user_profile drop constraint user_profile_user_account_fk;