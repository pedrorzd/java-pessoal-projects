package main.java.com.Controller;

import main.java.com.DAO.FabricaConexao;
import main.java.com.Model.Usuarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    public void adicionarUsuario(Usuarios usuario) {
        String query = "INSERT INTO users(userName, password, profile) values(?,?,?)";
        try {
            Connection conn = FabricaConexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.toString());
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("Não foi possível adicionar usuário: "+e.getMessage());
        }
    }

    public void alterarUsuario(Usuarios usuario) {
        String query = "UPDATE users SET userName = ?, password = ?, profile = ? WHERE userName = ?";

         try {
             Connection conn = FabricaConexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query);
             stmt.setString(1, usuario.getLogin());
             stmt.setString(2, usuario.getSenha());
             stmt.setString(3, usuario.toString());
             stmt.executeUpdate();
         }
         catch (SQLException e) {
             System.out.println("Erro ao alterar usuario: "+e.getMessage());
         }
    }

    public void excluirUsuario(Usuarios usuario) {
        String query = "DELETE FROM users WHERE userName = ?";

        try {
            Connection conn = FabricaConexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, usuario.getLogin());
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("Erro ao excluir usuario: "+e.getMessage());
        }
    }

    public ResultSet listarUsuarios() {
        String query = "SELECT * FROM users";
        try {
            Connection conn = FabricaConexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query);
            return stmt.executeQuery();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
