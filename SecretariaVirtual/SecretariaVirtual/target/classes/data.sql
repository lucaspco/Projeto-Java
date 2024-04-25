create table usuario (id integer primary key auto_increment,nome varchar (100) ,senha varchar (100) ,cpf numeric (20,2));
create table cadastro (id integer primary key auto_increment, usuario_id integer references usuario (id) ,endereco varchar (100) ,telefone varchar (100) ,email varchar (100),data_nascimento numeric (20,2) ,nome_responsavel varchar (100) ,telefone_responsavel varchar (20,2));
create table pedido (id integer primary key auto_increment, usuario_id integer references usuario (id) ,prontuario varchar (100));

