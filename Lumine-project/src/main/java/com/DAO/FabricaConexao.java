package main.java.com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
    //private static final String URL ="jdbc:mysql://192.168.0.19:3306/lumineGlam";
    //private static final String URL ="jdbc:mysql://localhost:3306/lumineGlam";

    private static final String URL ="jdbc:mysql://localhost:3306/lumineGlam";
    private static final String USUARIO = "root";
    private static final String SENHA = "123456";

    public static Connection conectar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL,USUARIO,SENHA);
        }
        catch (ClassNotFoundException e){
            System.out.println("Driver JDBC nao encontrado: "+ e.getMessage());
        }
        catch (SQLException e){
            System.out.println("Erro ao conectar: "+ e.getMessage());
        }
        return null;
    }

    public static void desconectar(Connection conn){
        if (conn != null){
            try {
                conn.close();
                System.out.println("Conexao encerrada.");
            }
            catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: "+e.getMessage());
            }
        }
    }

}