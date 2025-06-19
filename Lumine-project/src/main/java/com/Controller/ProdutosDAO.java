package main.java.com.Controller;

import main.java.com.DAO.FabricaConexao;
import main.java.com.Model.Produtos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutosDAO {
    public void inserirProdutoBD(Produtos produto) {
        String query = "INSERT INTO produtos(descricao, precoCompra, precoVenda, qtdeEstoque, codProduto, fornecedor) VALUES(?,?,?,?,?,?)";
        try {
            Connection conn = FabricaConexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, produto.getDescricao());
            stmt.setDouble(2, produto.getPrecoEntrada());
            stmt.setDouble(3, produto.getPrecoVenda());
            stmt.setInt(4, produto.getQuantidade());
            stmt.setString(5, produto.getFornecedor());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir produto: " + e.getMessage());;
        }
    }

    public void alterarDados(Produtos produto) {
        String query = "UPDATE produtos SET descricao = ?, precoCompra = ?, precoVenda = ?, qtdeEstoque = ?, codProduto = ?, fornecedor = ? WHERE id = ?";

        try {
            Connection conn = FabricaConexao.conectar();
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, produto.getDescricao());
            pstmt.setDouble(2, produto.getPrecoEntrada());
            pstmt.setDouble(3, produto.getPrecoVenda());
            pstmt.setInt(4, produto.getQuantidade());
            pstmt.setString(5, produto.getFornecedor());
            pstmt.setInt(6, produto.getId());
            pstmt.executeUpdate();
        }
        catch (SQLException e){
            System.out.println("Erro ao alterar produto: " + e.getMessage());
        }
    }

    public void excluirDados(Produtos produto) {
        String query = "DELETE FROM produtos WHERE id = ?";

        try{
            Connection conn = FabricaConexao.conectar();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, produto.getId());
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet ListaProdutos() {
        String query = "SELECT * FROM produtos";
        try {
            Connection conn = FabricaConexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query);
            return stmt.executeQuery();
        }
        catch (SQLException e) {
            System.out.println("Erro ao listar produtos: " + e.getMessage());
        }
        return null;
    }

}
