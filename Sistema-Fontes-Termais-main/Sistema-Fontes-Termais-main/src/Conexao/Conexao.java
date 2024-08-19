package Conexao;

import java.sql.*;

public class Conexao {

    private static final String url = "jdbc:mysql://localhost:3306/pousadanaomi?serverTimezone=UTC";
    private static final String user = "root";
    private static final String senha = "admin";

    private static Connection conn;

    public static Connection getConexao(){
        try {
            if(conn == null){
                conn = DriverManager.getConnection(url, user, senha);
                return conn;
            }
                return conn;
        } catch (Exception e) {
           e.printStackTrace();
           return null;
        }
    }
}
