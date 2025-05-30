package main.java.com.Controller;

import main.java.com.DAO.FabricaConexao;

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
}
