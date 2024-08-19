package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import Classes.Chamado;
import Conexao.Conexao;

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
    //Caso seja preciso já vai estar pronto
    public void procurarChamado(int idChamado){
        String sql = "SELECT idChamado, funcionarioResponsavel, solicitante, descricaoChamado, situacaoChamado FROM chamado WHERE idChamado = ?";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, idChamado);

            rs = ps.executeQuery();
            if (rs.next()) {
				int id = rs.getInt("idChamado");
				String funciResp = rs.getString("funcionarioResponsavel");
				String solicitante = rs.getString("solicitante");
				String descricaoChamado  = rs.getString("descricaoChamado");
				String situacaoChamado = rs.getString("situacaoChamado");
				

				String mensagem = String.format("id: %d\n\nFuncionario responsavel: %s\n\nSolicitante: %s\n\nDescricao do Chamado: %s\n\nSituacao do chamado: %s",
    id, funciResp, solicitante, descricaoChamado, situacaoChamado);
				
						JOptionPane.showMessageDialog(null, mensagem);
				}else{
					JOptionPane.showMessageDialog(null, "Chamado não encontrado");
				}
			rs.close();
			ps.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao procurar o chamado");
        }
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
