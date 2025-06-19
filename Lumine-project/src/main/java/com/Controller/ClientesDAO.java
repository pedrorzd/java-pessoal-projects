package main.java.com.Controller;

import main.java.com.DAO.FabricaConexao;
import main.java.com.Model.Clientes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientesDAO {

    public ResultSet ListaClientes(){
        String sql = "SELECT * FROM Clientes";
        try {
            Connection conn = FabricaConexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
                return stmt.executeQuery();
        }
        catch (SQLException e){
            System.out.println("Erro ao validar login: "+e.getMessage());
        }
        return null;
    }

    public void InserirClienteBD(Clientes c){
        String sql = "INSERT INTO Clientes(nome, cpf, endereco, telefone, email) VALUES (?, ?, ?, ?, ?)";

        try {

            Connection conn = FabricaConexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getCpf());
            stmt.setString(3, c.getEndereco());
            stmt.setString(4, c.getTelefone());
            stmt.setString(5, c.getEmail());
            stmt.executeUpdate();
        }
        catch (SQLException e){
            System.out.println("Erro ao validar login: "+e.getMessage());
        }
    }

    public void alteraDados(Clientes clientes){
        String query = "UPDATE clientes SET nome = ?, cpf = ?, endereco = ?, telefone = ?, email = ? WHERE id = ?";

        try(Connection connection = FabricaConexao.conectar();
            PreparedStatement pstmt = connection.prepareStatement(query)){
            pstmt.setString(1, clientes.getNome());
            pstmt.setString(2, clientes.getCpf());
            pstmt.setString(3, clientes.getEndereco());
            pstmt.setString(4, clientes.getTelefone());
            pstmt.setString(5, clientes.getEmail());
            pstmt.setInt(6, clientes.getId());
            pstmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deletaDados(main.java.com.Model.Clientes c){
        String query = "DELETE FROM Clientes WHERE id = ?";

        try(Connection connection = FabricaConexao.conectar();
            PreparedStatement pstmt = connection.prepareStatement(query)){
            pstmt.setInt(1, c.getId());
            pstmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
