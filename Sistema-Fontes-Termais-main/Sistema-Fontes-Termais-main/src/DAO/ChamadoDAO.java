package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import Classes.Chamado;
import Conexao.Conexao;
import java.util.ArrayList;

import java.util.List;

public class ChamadoDAO {
    public void cadastrarChamado(Chamado chamado) {
        String sql = "INSERT INTO chamado (descricaoChamado, solicitante, situacaoChamado) VALUES (?,?,?)";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, chamado.getDs_chamado());
            ps.setString(2, chamado.getSolicitante());
            ps.setString(3, chamado.getSc_chamado());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Chamado cadastrado com sucesso");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar um chamado");
        }

    }

    public void removerChamado(int idChamado) {
        String sql = "DELETE FROM chamado WHERE idChamado = ?";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, idChamado);
            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "Chamado removido com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao remover o chamado");
        }

    }

    // Método para listar todos os chamados do banco de dados
    public static List<Chamado> listarChamados() {
        // SQL para selecionar os dados dos chamados
        String sql = "SELECT idChamado, solicitante, descricaoChamado, situacaoChamado, FuncionarioResponsavel FROM chamado";

        // Criação da lista para armazenar os objetos Chamado
        List<Chamado> chamados = new ArrayList<>();

        // Declaração das variáveis para PreparedStatement e ResultSet
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Obtém a conexão do banco de dados
            ps = Conexao.getConexao().prepareStatement(sql);

            // Executa a consulta SQL
            rs = ps.executeQuery();

            // Itera sobre os resultados da consulta
            while (rs.next()) {
                // Obtém os dados de cada coluna do ResultSet
                int id = rs.getInt("idChamado");
                String solicitante = rs.getString("solicitante");
                String descricaoChamado = rs.getString("descricaoChamado");
                String situacaoChamado = rs.getString("situacaoChamado");
                String funciResponsavel = rs.getString("FuncionarioResponsavel");

                // Cria um novo objeto Chamado com os dados obtidos
                Chamado chamado = new Chamado(id, solicitante, descricaoChamado, situacaoChamado, funciResponsavel);

                // Adiciona o objeto Chamado à lista
                chamados.add(chamado);
            }

            // Verifica se a lista está vazia e imprime uma mensagem se nenhum chamado for
            // encontrado
            if (chamados.isEmpty()) {
                System.out.println("Nenhum chamado encontrado.");
            }

        } catch (Exception e) {
            // Captura e imprime qualquer exceção que ocorra durante a execução
            e.printStackTrace();
            System.out.println("Erro ao procurar os chamados.");
        } finally {
            // Fecha o ResultSet e o PreparedStatement para liberar os recursos
            try {
                if (rs != null)
                    rs.close();
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Retorna a lista de chamados
        return chamados;
    }

    // Método para atualizar um chamado no banco de dados
    public void atualizarChamado(Chamado chamado) {
        // Comando SQL básico para atualização
        String sql = "UPDATE chamado SET funcionarioResponsavel = ?, situacaoChamado= ? WHERE idChamado = ?";

        PreparedStatement ps = null;

        try {
            // Obtém a conexão com o banco de dados e prepara a declaração SQL
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, chamado.getFunc_resp());
            ps.setString(2, chamado.getSc_chamado());
            ps.setInt(3, chamado.getId_chamado()); // Supondo que o id_chamado já esteja definido no objeto Chamado

            // Executa o comando para atualizar o chamado no banco de dados
            ps.executeUpdate();

            // Fecha o PreparedStatement após a execução
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao atualizar o chamado");
        }
    }
}
