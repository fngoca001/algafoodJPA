create table cidade (id bigint not null auto_increment, nome varchar(255) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
create table cozinha (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
create table estado (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
create table forma_pagamento (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table grupo (id bigint not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB
create table grupo_permissao (grupo_id bigint not null, permissao_id bigint not null) engine=InnoDB
create table grupo_usuario (grupo_id bigint not null, usuario_id bigint not null) engine=InnoDB
create table permissao (id bigint not null auto_increment, descricao varchar(255) not null, nome varchar(255) not null, primary key (id)) engine=InnoDB
create table produto (id bigint not null auto_increment, ativo bit, descricao varchar(255) not null, nome varchar(255) not null, preco decimal(19,2) not null, restaurante_id bigint not null, primary key (id)) engine=InnoDB
create table restaurante (id bigint not null auto_increment, data_atualizacao dateTime not null, data_cadastro dateTime not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(255) not null, taxa_frete decimal(19,2) not null, cozinha_id bigint not null, endereco_cidade_id bigint, primary key (id)) engine=InnoDB
create table restaurante_forma_pagamento (restaurante_id bigint not null, forma_pagamento_id bigint not null) engine=InnoDB
create table usuario (id bigint not null auto_increment, data_cadastro datetime(6), email varchar(255), nome varchar(255), senha varchar(255), primary key (id)) engine=InnoDB
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id)
alter table grupo_permissao add constraint FKh21kiw0y0hxg6birmdf2ef6vy foreign key (permissao_id) references permissao (id)
alter table grupo_permissao add constraint FKta4si8vh3f4jo3bsslvkscc2m foreign key (grupo_id) references grupo (id)
alter table grupo_usuario add constraint FK25j96t87erikpns70qrgqohf4 foreign key (usuario_id) references grupo (id)
alter table grupo_usuario add constraint FK9nsftnf1bu6j1rvtrarlnlfns foreign key (grupo_id) references usuario (id)
alter table produto add constraint FKb9jhjyghjcn25guim7q4pt8qx foreign key (restaurante_id) references restaurante (id)
alter table restaurante add constraint FK76grk4roudh659skcgbnanthi foreign key (cozinha_id) references cozinha (id)
alter table restaurante add constraint FKbc0tm7hnvc96d8e7e2ulb05yw foreign key (endereco_cidade_id) references cidade (id)
alter table restaurante_forma_pagamento add constraint FK7aln770m80358y4olr03hyhh2 foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table restaurante_forma_pagamento add constraint FKa30vowfejemkw7whjvr8pryvj foreign key (restaurante_id) references restaurante (id)
insert into cozinha (nome) values ('Mocambicana')
insert into cozinha (nome) values ('Sul Africana')
insert into cozinha (nome) values ('Americana')
insert into cozinha (nome) values ('Portuguesa')
insert into cozinha (nome) values ('Italiana')
insert into estado (nome) values('Cento')
insert into estado (nome) values('Norte')
insert into estado (nome) values('Sul')
insert into cidade  (nome, estado_id) values('Cidade de Maputo',3)
insert into cidade  (nome, estado_id) values('Cidade da Matola',3)
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Dona Ana', 9.5, 1, utc_timestamp, utc_timestamp)
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Bom Garfo', 16, 3, utc_timestamp, utc_timestamp)
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Marinha', 5, 2, utc_timestamp, utc_timestamp)
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Dona Tereza', 14.19, 4, utc_timestamp, utc_timestamp)
insert into forma_pagamento (descricao) values ('Cartao de credito'), ('cartao de debito'), ('Dinheiro')
insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1,2),(1,2),(2,3),(4,1),(4,1),(3,3),(2,2),(4,3)
create table cidade (id bigint not null auto_increment, nome varchar(255) not null, estado_id bigint not null, primary key (id)) engine=InnoDB
create table cozinha (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
create table estado (id bigint not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB
create table forma_pagamento (id bigint not null auto_increment, descricao varchar(255) not null, primary key (id)) engine=InnoDB
create table grupo (id bigint not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB
create table grupo_permissao (grupo_id bigint not null, permissao_id bigint not null) engine=InnoDB
create table grupo_usuario (grupo_id bigint not null, usuario_id bigint not null) engine=InnoDB
create table permissao (id bigint not null auto_increment, descricao varchar(255) not null, nome varchar(255) not null, primary key (id)) engine=InnoDB
create table produto (id bigint not null auto_increment, ativo bit, descricao varchar(255) not null, nome varchar(255) not null, preco decimal(19,2) not null, restaurante_id bigint not null, primary key (id)) engine=InnoDB
create table restaurante (id bigint not null auto_increment, data_atualizacao dateTime not null, data_cadastro dateTime not null, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome varchar(255) not null, taxa_frete decimal(19,2) not null, cozinha_id bigint not null, endereco_cidade_id bigint, primary key (id)) engine=InnoDB
create table restaurante_forma_pagamento (restaurante_id bigint not null, forma_pagamento_id bigint not null) engine=InnoDB
create table usuario (id bigint not null auto_increment, data_cadastro datetime(6), email varchar(255), nome varchar(255), senha varchar(255), primary key (id)) engine=InnoDB
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id)
alter table grupo_permissao add constraint FKh21kiw0y0hxg6birmdf2ef6vy foreign key (permissao_id) references permissao (id)
alter table grupo_permissao add constraint FKta4si8vh3f4jo3bsslvkscc2m foreign key (grupo_id) references grupo (id)
alter table grupo_usuario add constraint FK25j96t87erikpns70qrgqohf4 foreign key (usuario_id) references grupo (id)
alter table grupo_usuario add constraint FK9nsftnf1bu6j1rvtrarlnlfns foreign key (grupo_id) references usuario (id)
alter table produto add constraint FKb9jhjyghjcn25guim7q4pt8qx foreign key (restaurante_id) references restaurante (id)
alter table restaurante add constraint FK76grk4roudh659skcgbnanthi foreign key (cozinha_id) references cozinha (id)
alter table restaurante add constraint FKbc0tm7hnvc96d8e7e2ulb05yw foreign key (endereco_cidade_id) references cidade (id)
alter table restaurante_forma_pagamento add constraint FK7aln770m80358y4olr03hyhh2 foreign key (forma_pagamento_id) references forma_pagamento (id)
alter table restaurante_forma_pagamento add constraint FKa30vowfejemkw7whjvr8pryvj foreign key (restaurante_id) references restaurante (id)
insert into cozinha (nome) values ('Mocambicana')
insert into cozinha (nome) values ('Sul Africana')
insert into cozinha (nome) values ('Americana')
insert into cozinha (nome) values ('Portuguesa')
insert into cozinha (nome) values ('Italiana')
insert into estado (nome) values('Cento')
insert into estado (nome) values('Norte')
insert into estado (nome) values('Sul')
insert into cidade  (nome, estado_id) values('Cidade de Maputo',3)
insert into cidade  (nome, estado_id) values('Cidade da Matola',3)
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Dona Ana', 9.5, 1, utc_timestamp, utc_timestamp)
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Bom Garfo', 16, 3, utc_timestamp, utc_timestamp)
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Marinha', 5, 2, utc_timestamp, utc_timestamp)
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Dona Tereza', 14.19, 4, utc_timestamp, utc_timestamp)
insert into forma_pagamento (descricao) values ('Cartao de credito'), ('cartao de debito'), ('Dinheiro')
insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1,2),(1,2),(2,3),(4,1),(4,1),(3,3),(2,2),(4,3)
