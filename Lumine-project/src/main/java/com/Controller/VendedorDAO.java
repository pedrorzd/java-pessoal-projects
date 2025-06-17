package main.java.com.Controller;

import main.java.com.DAO.FabricaConexao;
import main.java.com.Model.Clientes;
import main.java.com.Model.Vendedores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VendedorDAO {

    public void InserirVendedorBD(Vendedores vendedor){
        String sql = "INSERT INTO Vendedores(nome, cpf, endereco, telefone, email) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection conn = FabricaConexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, vendedor.getNome());
            stmt.setString(2, vendedor.getCpf());
            stmt.setString(3, vendedor.getEndereco());
            stmt.setString(4, vendedor.getTelefone());
            stmt.setString(5, vendedor.getEmail());
            stmt.executeUpdate();
        }
        catch (SQLException e){
            System.out.println("Erro ao validar login: "+e.getMessage());
        }
    }

    public ResultSet ListaVendedores(){
        String sql = "SELECT * FROM Vendedores";
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
}
