set foreign_key_checks = 0;

delete from cidade;
delete from cozinha;
delete from estado;
delete from restaurante_forma_pagamento;
delete from forma_pagamento;
delete from grupo;
delete from grupo_permissao;
delete from grupo_usuario;
delete from permissao;
delete from produto;
delete from restaurante;
delete from restaurante_forma_pagamento;
delete from usuario;

set foreign_key_checks = 1;

alter table cidade auto_increment = 1;
alter table cozinha auto_increment = 1;
alter table estado auto_increment = 1;
alter table forma_pagamento auto_increment = 1;
alter table grupo auto_increment = 1;
alter table grupo_permissao auto_increment = 1;
alter table grupo_usuario auto_increment = 1;
alter table permissao auto_increment = 1;
alter table produto auto_increment = 1;
alter table restaurante auto_increment = 1;
alter table usuario auto_increment = 1;

insert into cozinha (nome) values ('Mocambicana');
insert into cozinha (nome) values ('Sul Africana');
insert into cozinha (nome) values ('Americana');
insert into cozinha (nome) values ('Portuguesa');
insert into cozinha (nome) values ('Italiana');

insert into estado (nome) values('Cento');
insert into estado (nome) values('Norte');
insert into estado (nome) values('Sul');

insert into cidade  (nome, estado_id) values('Cidade de Maputo',3);
insert into cidade  (nome, estado_id) values('Cidade da Matola',3);

insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Dona Ana', 9.5, 1, utc_timestamp, utc_timestamp);
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Bom Garfo', 16, 3, utc_timestamp, utc_timestamp);
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Marinha', 5, 2, utc_timestamp, utc_timestamp);
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Dona Tereza', 14.19, 4, utc_timestamp, utc_timestamp);

insert into forma_pagamento (descricao) values ('Cartao de credito'), ('cartao de debito'), ('Dinheiro');

insert into produto  (nome, descricao, preco, ativo, restaurante_id) values ("Frango Grelhado","Frango grelhado com batatas arror e salada",195,1,1),
					 ("Poeco grelhado","Porco grelhado com batata arroz e salada",200,1,2),
					 ("Caril de peixe com coco","Caril de peixe com coco com arroz",300,1,4),
					 ("T-Bone","Carne de Vaca grelhada com arroz e salada",250,1,3),
					 ("Murg Crrry","Murg Crrry com salada e arroz",400,1,1);

insert into permissao (id, nome, descricao) values (1,"CONSULTAR_COZINHAS","Permite consultar por cozinhas"),
												   (2,"EDITAR_COZINHAS","Permite editar cozinhas");


insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1,2),(1,2),(2,3),(4,1),(4,1),(3,3),(2,2),(4,3);

