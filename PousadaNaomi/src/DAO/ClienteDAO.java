package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Classes.Cliente;
import conexaoMySQL.Conexao;

public class ClienteDAO {

    public void cadastrarCliente(Cliente cliente){
        String sql = "INSERT INTO CLIENTE (cpf, nome, email, numQuarto, tempoDeReserva) VALUES (?,?,?,?,?)";

        PreparedStatement ps = null;

        try {

            ps = Conexao.getConexaoMySQL().prepareStatement(sql);
            ps.setInt(1, cliente.getCPF());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getEmail());
            ps.setInt(4, cliente.getNumQuarto());
            ps.setInt(5, cliente.getTempoReserva());

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    

}
