CREATE TABLE cliente (
	id INT NOT NULL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    cpf VARCHAR(13) NOT NULL,
    data_nascimento DATETIME NOT NULL,
    email VARCHAR(50) NOT NULL
);

CREATE TABLE carro (
	id INT NOT NULL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    marca VARCHAR(30) NOT NULL,
    placa VARCHAR(10) NOT NULL,
    situacao_carro INT NOT NULL
    
    /*CONSTRAINT UQ_placa UNIQUE (placa)*/
);

CREATE TABLE aluguel (
	id INT NOT NULL PRIMARY KEY,
    carro_id INT NOT NULL,
    cliente_id INT NOT NULL,
    data_inicio DATETIME NOT NULL,
    data_fim DATETIME NOT NULL,
    preco_dia DOUBLE NOT NULL,
    qtd_dias INTEGER NOT NULL,
    preco_total DOUBLE,
    situacao_aluguel INT NOT NULL

	/*CONSTRAINT FK_CARRO_ID FOREIGN KEY (carro_id) REFERENCES carro(id),
	CONSTRAINT FK_CLIENTE_ID FOREIGN KEY (cliente_id) REFERENCES cliente(id)*/

);