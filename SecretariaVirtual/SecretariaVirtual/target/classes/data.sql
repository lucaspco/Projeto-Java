CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100),
    senha VARCHAR(100),
    cpf NUMERIC(20,2)
);

CREATE TABLE cadastro (
    id SERIAL PRIMARY KEY,
    usuario_id INTEGER REFERENCES usuario(id),
    endereco VARCHAR(50),
    telefone VARCHAR(50),
    email VARCHAR(50),
    data_nascimento DATE,
    nome_responsavel VARCHAR(50),
    telefone_responsavel VARCHAR(20)
);

CREATE TABLE pedido (
    id SERIAL PRIMARY KEY,
    usuario_id INTEGER REFERENCES usuario(id),
    prontuario VARCHAR(100)
);
