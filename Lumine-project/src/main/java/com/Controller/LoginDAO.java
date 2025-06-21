package main.java.com.Controller;

import main.java.com.DAO.FabricaConexao;
import main.java.com.Model.Usuarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    public Usuarios validarLogin(String userName, String password, String profile) {
        int result = 0;
        Usuarios levaDados;
        levaDados = null;
        String sql = "SELECT * FROM users WHERE userName = ? AND password = ? AND profile = ?";

        try (Connection conn = FabricaConexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, userName);
            stmt.setString(2, password);
            stmt.setString(3, profile);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                levaDados = new Usuarios();
                levaDados.setLogin(rs.getNString("userName"));
                levaDados.setSenha(rs.getNString("password"));
                levaDados.setPerfil(rs.getNString("profile"));
            }
        }
        catch (SQLException e) {
            System.out.println("Erro ao validar login: " + e.getMessage());
        }
        return levaDados;
    }
}
