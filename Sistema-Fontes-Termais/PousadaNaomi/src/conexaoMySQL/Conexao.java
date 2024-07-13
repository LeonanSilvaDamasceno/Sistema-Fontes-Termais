package conexaoMySQL;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    private static final String url = "jdbc:mysql://localhost:3306/Pousada_Naomi";
    private static final String user = "root";
    private static final String senha = "admin";

    private static Connection conn;

    public static  Connection getConexaoMySQL(){
        try {
            if(conn == null){
                conn = DriverManager.getConnection(url, user, senha);
                return conn;
            }else{
                return conn;
            }
        } catch (Exception e) {
           e.printStackTrace();
           return conn;
        }
    }
}
