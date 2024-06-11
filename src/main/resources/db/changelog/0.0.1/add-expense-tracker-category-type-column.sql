--liquibase formatted sql

--changeset maksimfisenko:add-expense-tracker-category-table-column-type
--comment add column type to expense-tracker.category
alter table "expense-tracker".category
    add column type varchar(32);

update "expense-tracker".category
set type = 'EXPENSE'
where type is null;

alter table "expense-tracker".category
    alter column type set not null;
--rollback alter table "expense-tracker".type drop column type;