select * from pessoa;
insert into pessoa values (11,'11/11/1111 11:11:11','Francisca');
insert into pessoa values (12,'12/12/1212 12:12:12','Andrea');
insert into pessoa values (13,'13/01/1313 13:13:13','Marcia');
insert into pessoa values (14,'14/01/1414 14:14:14','Marcelo');

insert into pessoa values (21,'21/01/2121 21:21:21','Gisele');
insert into pessoa values (22,'22/01/2222 22:22:22','Gunther');
insert into pessoa values (23,'23/01/2323 23:23:23','Gustavo');

select * from pessoaFisica;
insert into pessoaFisica values ('','212.121.212-12',21212121,false,21);
insert into pessoaFisica values ('','222.222.222-22',22222222,true,22);
insert into pessoaFisica values ('','232.131.313-13',23232323,true,23);

select * from ferramenta;
insert into ferramenta values (31);
insert into ferramenta values (32);
insert into ferramenta values (33);

insert into ferramenta values (41);
insert into ferramenta values (42);
insert into ferramenta values (43);

select * from recurso;
insert into recurso values ('01/01/1111 11:11:41','01/01/1111 11:11:41','01/01/1111 11:11:41',1,1,9,41);
insert into recurso values ('01/01/1111 11:11:42','01/01/1111 11:11:42','01/01/1111 11:11:42',2,2,8,42);
insert into recurso values ('01/01/1111 11:11:43','01/01/1111 11:11:43','01/01/1111 11:11:43',3,3,7,43);

select * from cargo;
insert into cargo values (51,'01/01/1111 11:11:51',1,51);
insert into cargo values (52,'01/01/1111 11:11:51',2,52);
insert into cargo values (53,'01/01/1111 11:11:51',3,53);

insert into cargo values (61,'01/01/1111 11:11:01',4,61);
insert into cargo values (62,'01/01/1111 11:11:02',5,62);
insert into cargo values (63,'01/01/1111 11:11:03',6,63);
insert into cargo values (64,'01/01/1111 11:11:03',7,64);

select * from usuario;
insert into usuario values ('alias','01/01/1111 11:11:01','61@email.com','operador','1234',61);
insert into usuario values ('alias','01/01/1111 11:11:02','62@email.com','gerente','1234',62);
insert into usuario values ('alias','01/01/1111 11:11:03','63@email.com','gestor','1234',63);
insert into usuario values ('alias','01/01/1111 11:11:04','64@email.com','administrador','1234',64);

select * from funcao;
insert into funcao values (71,'funcao 71');
insert into funcao values (72,'funcao 72');
insert into funcao values (73,'funcao 73');

select * from grupo;
insert into grupo values (81,'818181','01/01/1181 11:11:01','01/01/1181 11:11:01','nome 81');
insert into grupo values (82,'828282','01/01/1182 11:11:01','01/01/1182 11:11:01','nome 82');
insert into grupo values (83,'838383','01/01/1183 11:11:01','01/01/1182 11:11:01','nome 83');