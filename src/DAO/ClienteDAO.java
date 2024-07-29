package DAO;

import java.sql.*;

import javax.swing.JOptionPane;

import Classes.*;
import Conexao.*;

public class ClienteDAO {

    public void cadastrarCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (cpf, nome, email, numQuarto, tempoDeReserva) VALUES (?,?,?,?,?)";

        PreparedStatement ps = null;

        try {

            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, cliente.getCPF());
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

    public void procurarCliente(String cpf) {
        String sql = "SELECT cpf, nome, codigo, email, numQuarto, tempoDeReserva FROM cliente WHERE cpf = ?";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, cpf);

            rs = ps.executeQuery();

            if (rs.next()) {
                String cpfCliente = rs.getString("cpf");
                String nome = rs.getString("nome");
                int codigo = rs.getInt("codigo");
                String email = rs.getString("email");
                int numQuarto = rs.getInt("numQuarto");
                int tempoDeReserva = rs.getInt("tempoDeReserva");

                String mensagem = String.format(
                        "CPF: %s\nNome: %s\nCodigo: %d\nEmail: %s\nNumero do Quarto: %d\nTempo de reserva: %d",
                        cpfCliente, nome, codigo, email, numQuarto, tempoDeReserva);
                JOptionPane.showMessageDialog(null, mensagem);
            }else{
                JOptionPane.showMessageDialog(null, "Cliente não encontrado");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao procurar o cliente");
        }
    }

}
