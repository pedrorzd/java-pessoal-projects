package main.java.com.Controller;

import main.java.com.DAO.FabricaConexao;
import main.java.com.Model.Clientes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VendedorDAO {

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
