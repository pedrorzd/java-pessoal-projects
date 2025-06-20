package main.java.com;

import com.mysql.cj.xdevapi.Table;
import main.java.com.View.Homepage;
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
 ----SENHA PARA ACESSAR O SISTEMA----
 admin
 123456
 Administrador
  */


/*
drop schema lumineglam;

CREATE DATABASE  IF NOT EXISTS `lumineglam`
USE `lumineglam`;

-- ------------------------------------------------------
DROP TABLE IF EXISTS `clientes`;
CREATE TABLE `clientes` (
        `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `endereco` varchar(100) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `fornecedores`;

CREATE TABLE `fornecedores` (
        `id` int NOT NULL AUTO_INCREMENT,
  `nomeFornecedor` varchar(50) NOT NULL,
  `cnpj` varchar(20) NOT NULL,
  `endereco` varchar(100) NOT NULL,
  `emailFornecedor` varchar(100) NOT NULL,
  `telefoneFornecedor` varchar(20) NOT NULL,
  `produto` varchar(50) NOT NULL,
  `statusDeAtividade` varchar(10) NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `produtos`;

CREATE TABLE `produtos` (
        `id` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(50) NOT NULL,
  `precoCompra` double NOT NULL,
        `precoVenda` double NOT NULL,
        `qtdeEstoque` int NOT NULL,
        `codProduto` varchar(20) DEFAULT NULL,
  `fornecedor` varchar(50) DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
        `idUser` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) NOT NULL,
  `password` varchar(10) DEFAULT NULL,
  `profile` varchar(50) DEFAULT NULL,
PRIMARY KEY (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `vendedores`;
CREATE TABLE `vendedores` (
        `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `endereco` varchar(40) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

*/

/*

INSERT INTO clientes (nome, cpf, endereco, telefone, email) VALUES

('João da Silva', '12345678901', 'Rua das Flores, 100', '31987654321', 'joao@gmail.com'),
        ('Maria Oliveira', '98765432100', 'Av. Brasil, 456', '31976543210', 'maria.oliveira@yahoo.com'),
        ('Carlos Mendes', '45612378900', 'Rua A, 321', '31988887777', 'carlos.mendes@outlook.com'),
        ('Ana Beatriz', '32165498700', 'Rua B, 654', '31999998888', 'ana.b@gmail.com'),
        ('Lucas Ferreira', '74185296300', 'Travessa C, 22', '31999887766', 'lucasf@uol.com.br'),
        ('Fernanda Souza', '96325874100', 'Av. Contorno, 999', '31991234567', 'fernanda.souza@hotmail.com'),
        ('Ricardo Lima', '85274196300', 'Rua das Palmeiras, 123', '31993456789', 'ricardo.lima@globo.com'),
        ('Juliana Alves', '74196385200', 'Alameda Santos, 44', '31997654321', 'juliana.alves@gmail.com'),
        ('Bruno Rocha', '36925814700', 'Rua Goiás, 110', '31994561234', 'bruno.rocha@yahoo.com'),
        ('Patrícia Nunes', '15975348600', 'Praça Sete, 1', '31991239876', 'patricia.nunes@ig.com.br');

INSERT INTO fornecedores (nomeFornecedor, cnpj, endereco, emailFornecedor, telefoneFornecedor, produto, statusDeAtividade) VALUES
('Moda Minas', '12345678000199', 'Rua das Confecções, 500', 'contato@modaminas.com', '31993334444', 'Camisetas', 'Ativo'),
('Estilo & Cia', '98765432000155', 'Av. Fashion, 900', 'vendas@estiloc.com', '31992223333', 'Vestidos', 'Ativo'),
('Têxtil Brasil', '45678912000177', 'Rua Alfaiates, 1010', 'contato@textilbr.com', '31991112222', 'Calças', 'Ativo'),
('Distribuidora Malhas', '10293847000166', 'Rua das Malhas, 707', 'vendas@malhasbh.com', '31994445555', 'Moletom', 'Ativo'),
('Fábrica Fashion', '99887766000144', 'Rua Tricot, 320', 'fabrica@fashion.com.br', '31990001122', 'Jaquetas', 'Ativo'),
('Top Moda', '33445566000133', 'Av. Tendência, 2500', 'atendimento@topmoda.com', '31995556677', 'Camisetas', 'Ativo'),
('Jeans Prime', '22334455000122', 'Rua Denim, 120', 'vendas@jeansprime.com', '31996667788', 'Calças Jeans', 'Ativo'),
('Confecções Real', '11223344000111', 'Rua Costura, 85', 'suporte@confreal.com', '31998889900', 'Legging', 'Ativo'),
('Estampas BH', '44332211000199', 'Av. Criativa, 3000', 'contato@estampasbh.com', '31997778899', 'Blusas', 'Ativo'),
('Veste Fácil', '66778899000155', 'Av. Tecido, 77', 'vendas@vestefacil.com', '31991110000', 'Saias', 'Ativo');


INSERT INTO produtos (descricao, precoCompra, precoVenda, qtdeEstoque, codProduto, fornecedor) VALUES
('Camiseta Básica Branca', 15.00, 39.90, 150, 'CAM-BR-001', 'Top Moda'),
('Calça Jeans Masculina', 45.00, 99.90, 80, 'CAL-JEANS-M', 'Jeans Prime'),
('Vestido Floral Curto', 35.00, 89.90, 60, 'VES-FLOR-01', 'Estilo & Cia'),
('Bermuda Moletom', 20.00, 59.90, 100, 'BER-MOL-02', 'Distribuidora Malhas'),
('Jaqueta Jeans Feminina', 60.00, 129.90, 40, 'JAQ-JEANS-F', 'Fábrica Fashion'),
('Camiseta Estampada', 18.00, 44.90, 120, 'CAM-EST-02', 'Estampas BH'),
('Calça Legging Preta', 22.00, 59.90, 90, 'LEG-PRE-01', 'Confecções Real'),
('Saia Jeans', 28.00, 69.90, 70, 'SAI-JEANS', 'Veste Fácil'),
('Camisa Polo Masculina', 30.00, 74.90, 65, 'POL-MASC-01', 'Moda Minas'),
('Blusa Tricot Feminina', 40.00, 99.90, 50, 'TRI-FEM-01', 'Têxtil Brasil');


INSERT INTO users (userName, password, profile) VALUES
('admin', '123456', 'Administrador'),
('joao', 'joao123', 'Usuário'),
('maria', 'maria321', 'Usuário'),
('lucas', 'lucas123', 'Usuário'),
('ana', 'ana456', 'Administrador'),
('patricia', 'patri789', 'Usuário'),
('ricardo', 'ric123', 'Usuário'),
('juliana', 'ju456', 'Usuário'),
('bruno', 'br789', 'Usuário'),
('fernanda', 'fer321', 'Administrador');


INSERT INTO vendedores (nome, cpf, endereco, telefone, email) VALUES
('João Vendas', '10101010101', 'Rua Varejo, 10', '31990123456', 'joaov@empresa.com'),
('Maria Vendedora', '20202020202', 'Av. Moda, 20', '31990234567', 'mariav@empresa.com'),
('Carlos Comercial', '30303030303', 'Rua Lojas, 30', '31990345678', 'carlos@empresa.com'),
('Ana Atendimento', '40404040404', 'Travessa Fashion, 40', '31990456789', 'ana.atendimento@empresa.com'),
('Lucas Loja', '50505050505', 'Av. Roupas, 50', '31990567890', 'lucas.loja@empresa.com'),
('Fernanda Estilo', '60606060606', 'Rua Estilo, 60', '31990678901', 'fernanda@empresa.com'),
('Ricardo Moda', '70707070707', 'Alameda Moda, 70', '31990789012', 'ricardo.moda@empresa.com'),
('Juliana Varejo', '80808080808', 'Rua Centro, 80', '31990890123', 'juliana@empresa.com'),
('Bruno Peças', '90909090909', 'Rua Peças, 90', '31990901234', 'bruno@empresa.com'),
('Patrícia Têxtil', '11223344556', 'Rua Tecidos, 100', '31991012345', 'patricia@empresa.com');



 */