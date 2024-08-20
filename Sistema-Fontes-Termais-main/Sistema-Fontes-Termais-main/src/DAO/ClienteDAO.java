package DAO;

import java.sql.*;

import javax.swing.JOptionPane;

import Classes.*;
import Conexao.*;

public class ClienteDAO {

    public void cadastrarCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (cpf, nome, email, numQuarto, tempoDeReserva, dataCheckin) VALUES (?,?,?,?,?,?)";

        PreparedStatement ps = null;

        try {

            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, cliente.getCPF());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getEmail());
            ps.setInt(4, cliente.getQuarto().getNum());
            ps.setInt(5, cliente.getTempoReserva());
            ps.setString(6, cliente.getCheckIn());

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
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao procurar o cliente");
        }
    }

    public void removerCliente(String cpf) {
        String sql = "DELETE FROM cliente where cpf =?";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, cpf);
            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "Check-out realizado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Falha ao realiza o check-out");
        }

    }

    public void cadastrarLoginCliente(String nome, String email, String cpf, String senha) {
        String sql = "INSERT INTO clientelogin (nome, email, cpf, senha) VALUES (?,?,?,?)";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, email);
            ps.setString(3, cpf);
            ps.setString(4, senha);

            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "Novo usuario do sistema cadastrado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar um novo usuario");
        }

    }

    public boolean loginClienteSistema(String email, String senha) {
        String sql = "SELECT email, senha FROM clientelogin WHERE email = ? AND senha = ?";

        PreparedStatement ps;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, senha);

            // Execute a consulta
            ResultSet rs = ps.executeQuery();

            // Verifica se há resultados (se o usuário existe no banco de dados)
            return rs.next(); // Retorna true se encontrar um registro
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao fazer login no sistema");
        }
        return false;

    }

}
