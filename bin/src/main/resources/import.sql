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


insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1,2),(1,2),(2,3),(4,1),(4,1),(3,3),(2,2),(4,3);

