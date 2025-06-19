package main.java.com.Controller;

import main.java.com.DAO.FabricaConexao;
import main.java.com.Model.Fornecedores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FornecedoresDAO {
    public void inserirFornecedor(Fornecedores fornecedor) {
        String query = "INSERT INTO Fornecedores (nomeFornecedor, cnpj, endereco, emailFornecedor, telefoneFornecedor, produto, statusDeAtividade) VALUES (?,?,?,?,?,?,?)";
        try {
            Connection conn = FabricaConexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, fornecedor.getNomeFornecedor());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.setString(3, fornecedor.getEndereco());
            stmt.setString(4, fornecedor.getEmailFornecedor());
            stmt.setString(5, fornecedor.getTelefoneFornecedor());
            stmt.setString(6, fornecedor.getProduto());
            stmt.setString(7, fornecedor.getStatusDeAtividade());
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("Erro ao inserir Fornecedores: " + e.getMessage());;
        }
    }

    public void alterarFornecedor(Fornecedores fornecedor) {
        String query = "UPDATE fornecedores SET nomeFornecedor = ?, cnpj = ?, endereco = ?, emailFornecedor = ?, telefoneFornecedor = ?, produto = ?, statusDeAtividade = ?  WHERE id = ? ";
        try {
            Connection conn = FabricaConexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, fornecedor.getNomeFornecedor());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.setString(3, fornecedor.getEndereco());
            stmt.setString(4, fornecedor.getEmailFornecedor());
            stmt.setString(5, fornecedor.getTelefoneFornecedor());
            stmt.setString(6, fornecedor.getProduto());
            stmt.setString(7, fornecedor.getStatusDeAtividade());
            stmt.setInt(8, fornecedor.getId());
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("Erro ao alterar Fornecedores: " + e.getMessage());;
        }
    }

    public void excluirFornecedor(Fornecedores fornecedor) {
        String query = "DELETE FROM fornecedores WHERE id = ? ";
        try {
            Connection conn = FabricaConexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, fornecedor.getId());
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("Erro ao excluir Fornecedores: " + e.getMessage());;
        }
    }

    public ResultSet consultarFornecedores() {
        String query = "SELECT * FROM fornecedores ";
        try {
            Connection conn = FabricaConexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query);
            return stmt.executeQuery();
        }
        catch (SQLException e) {
            System.out.println("Erro ao consultar Fornecedores: " + e.getMessage());;
        }
        return null;
    }
}
