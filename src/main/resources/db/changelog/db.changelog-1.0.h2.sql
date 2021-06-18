--liquibase formatted sql
--changeset davi.dmg:1
create table endereco (id bigint not null, bairro varchar(255), cep bigint, logradouro varchar(255), numero varchar(255), pessoa_id bigint, primary key (id))

--changeset davi.dmg:2
create table pessoa (id bigint not null, email varchar(255), idade integer not null, nome varchar(255), primary key (id))

--changeset davi.dmg:3
create sequence hibernate_sequence start with 1 increment by 1

--changeset davi.dmg:4
alter table endereco add constraint FKn1l2g0b74rqd9ywu29sva9sy9 foreign key (pessoa_id) references pessoa