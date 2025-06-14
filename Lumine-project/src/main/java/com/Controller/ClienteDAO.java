package main.java.com.Controller;

import main.java.com.DAO.FabricaConexao;
import main.java.com.Model.Clientes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {
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
        String sql = "INSERT INTO Clientes(nome, cpf, email, telefone) VALUES (?, ?, ?, ?)";

        try {

            Connection conn = FabricaConexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getCpf());
            stmt.setString(3, c.getEmail());
            stmt.setString(4, c.getTelefone());
            stmt.executeUpdate();
        }
        catch (SQLException e){
            System.out.println("Erro ao validar login: "+e.getMessage());
        }
    }

    public void deletaDados(main.java.com.Model.Clientes c){
        String query = "DELETE FROM Clientes WHERE id = ?";

        try(Connection connection = FabricaConexao.conectar();
            PreparedStatement pstmt = connection.prepareStatement(query)){
            pstmt.setInt(1, c.getId());
            pstmt.executeQuery();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
