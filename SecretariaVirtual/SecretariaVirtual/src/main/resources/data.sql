-- Create Usuario table
CREATE TABLE IF NOT EXISTS Usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    endereco VARCHAR(100),
    email VARCHAR(100),
    telefone VARCHAR(20),
    nome_responsavel VARCHAR(100),
    telefone_responsavel VARCHAR(20),
    cpf VARCHAR(20),
    senha VARCHAR(100)
);

-- Insert initial Usuario data
INSERT INTO Usuario (nome, endereco, email, telefone, nome_responsavel, telefone_responsavel, cpf, senha)
VALUES
    ('Nome1', 'Endereco1', 'email1@example.com', '123456789', 'Responsavel1', '987654321', 123456789, 'senha123'),
    ('Nome2', 'Endereco2', 'email2@example.com', '987654321', 'Responsavel2', '123456789', 987654321, 'senha456');

-- Create Prontuario table
CREATE TABLE IF NOT EXISTS Prontuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    prontuario VARCHAR(100)
);

-- Insert initial Prontuario data
INSERT INTO Prontuario (prontuario)
VALUES
    ('Prontuario1'),
    ('Prontuario2');

-- Create Agendamento table
CREATE TABLE IF NOT EXISTS Agendamento (
    id INT AUTO_INCREMENT PRIMARY KEY,
    data_hora TIMESTAMP,
    usuario_id INT,
    descricao VARCHAR(100),
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id)
);

-- Insert initial Agendamento data
INSERT INTO Agendamento (data_hora, usuario_id, descricao)
VALUES
    ('2024-05-20 10:00:00', 1, 'Descricao1'),
    ('2024-05-21 11:00:00', 2, 'Descricao2');
