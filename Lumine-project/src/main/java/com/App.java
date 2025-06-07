package main.java.com;

import main.java.com.View.Login;

import javax.swing.*;


public class App extends JFrame {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setTitle("Lumine Glam");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setContentPane(new Login().JPanelLogin);
        jf.setSize(850,750);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }
}

/*
drop schema lumineglam;

create database lumineglam;
use lumineglam;

create table Users(
idUser int primary key auto_increment,
userName varchar (50) not null,
password varchar(10),
profile varchar(50)
);
create table Clientes(
id int primary key auto_increment,
nome varchar(50)not null,
cpf varchar(11)not null,
endereco varchar(20)not null,
telefone varchar(20)not null
);
create table Produtos(
id int primary key auto_increment,
descricao varchar(50) not null,
precoCompra double not null,
precoVenda double not null,
qtdeEstoque int not null
);
create table Vendedores(
id int primary key auto_increment,
nome varchar(50)not null,
cpf varchar(11)not null,
endereco varchar(40)not null,
telefone varchar(20)not null
);

INSERT INTO Clientes (nome, cpf, endereco, telefone) VALUES
('João Silva', '12345678901', 'Rua A, 123', '11999990001'),
('Maria Souza', '23456789012', 'Rua B, 456', '11999990002'),
('Carlos Oliveira', '34567890123', 'Av. Central, 789', '11999990003'),
('Ana Paula', '45678901234', 'Rua das Flores, 321', '11999990004'),
('Fernanda Lima', '56789012345', 'Rua Verde, 654', '11999990005');

INSERT INTO Produtos (descricao, precoCompra, precoVenda, qtdeEstoque) VALUES
('Caneta Azul', 1.00, 2.50, 100),
('Caderno 100 folhas', 5.00, 10.00, 50),
('Mochila Escolar', 30.00, 55.00, 20),
('Lápis HB', 0.50, 1.00, 200),
('Borracha Branca', 0.75, 1.50, 150);

INSERT INTO Vendedores (nome, cpf, endereco, telefone) VALUES
('Lucas Martins', '67890123456', 'Rua Azul, 789', '11999990006'),
('Juliana Alves', '78901234567', 'Av. Rosa, 321', '11999990007'),
('Paulo Henrique', '89012345678', 'Rua das Palmeiras, 456', '11999990008'),
('Renata Dias', '90123456789', 'Rua Sol, 987', '11999990009'),
('Bruno Costa', '01234567890', 'Av. Norte, 654', '11999990010');




select * from Users;
insert into Users(userName, password, profile) values
("pedrorzd","3643", "administrador");
insert into Users(userName, password, profile) values
("thiagin69","12345", "usuario");
insert into Users(userName, password, profile) values
("teste","teste","administrador");
 */