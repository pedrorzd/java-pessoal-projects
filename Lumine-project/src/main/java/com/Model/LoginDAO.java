package main.java.com.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    public boolean validarLogin(String userName, String password){
        String sql = "SELECT * FROM users WHERE userName = ? AND password = ?";
        try(Connection conn = FabricaConexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1,userName);
            stmt.setString(2,password);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // se encontrou, login é valido
        }
        catch (SQLException e){
            System.out.println("Erro ao validar login: "+ e.getMessage());
            return false;
        }
    }

}
