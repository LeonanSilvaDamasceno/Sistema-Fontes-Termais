package DAO;

import Classes.*;
import Conexao.Conexao;
import java.sql.*;

import javax.swing.JOptionPane;

public class FuncionarioDAO {

	// Metodo para cadastrar as informações do funcionario no banco de dados
	public void cadastrarFuncionario(Funcionario funcionario) {
		// Comando SQL basico para inserção
		String sql = "INSERT INTO funcionario (nome, cpf, email, salario, cargo ) VALUES (?,?,?,?,?)";
		// Nota-se que existem varios pontos de interrogação no lugar dos valores
		// pois ainda não temos nada pra passar como valores ainda

		PreparedStatement ps = null;

		try {
			// Passando as informações para o banco de dados

			// cada numero representa uma posição dos pontos de interrogação. Por exemplo, o
			// primeiro
			// ponto de interrogação vai ser do nome, depois o numero 2 vai ser do CPF e por
			// assim em diante.
			ps = Conexao.getConexao().prepareStatement(sql);
			ps.setString(1, funcionario.getNome());
			ps.setString(2, funcionario.getCPF());
			ps.setString(3, funcionario.getEmail());
			ps.setFloat(4, funcionario.getSalario());
			ps.setString(5, funcionario.getCargo());

			// Comando para executar a ação acima
			ps.execute();

			// Depois de executado vai encerrar a conexão com o banco de dados
			ps.close();

			// Se houver algum problema na hora da conexão com o BD vai disparar uma exeção
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar o funcionário");
		}

	}

	public void removerFunci(String cpf) {

		String sql = "DELETE FROM funcionario WHERE cpf = ?";

		PreparedStatement ps = null;

		try {
			// Obter a conexão
			ps = Conexao.getConexao().prepareStatement(sql);
			ps.setString(1, cpf);

			// Comando para executar a ação acima
			ps.execute();

			// Depois de executado vai encerrar a conexão com o banco de dados
			ps.close();

			JOptionPane.showMessageDialog(null,"Funcionario removido com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao remover o funcionário");
		}

	}

	public void procurarFunci(String nome) {

		String sql = "SELECT nome, cpf, email, salario, cargo, codigo FROM funcionario WHERE nome = ?";

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = Conexao.getConexao().prepareStatement(sql);
			ps.setString(1, nome);

			rs = ps.executeQuery();

			if (rs.next()) {
				String nomeResult = rs.getString("nome");
				String cpf = rs.getString("cpf");
				String email = rs.getString("email");
				double salario = rs.getDouble("salario");
				String cargo = rs.getString("cargo");
				int codigo = rs.getInt("codigo");

				String mensagem = String.format("Nome: %s\nCPF: %s\nEmail: %s\nSalário: %.2f\nCargo: %s\nCódigo: %d",
						nomeResult, cpf, email, salario, cargo, codigo);
				
						JOptionPane.showMessageDialog(null, mensagem);
				}else{
					JOptionPane.showMessageDialog(null, "Funcionario não encontrado");
				}
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao procurar funcionário.");
		}

		
	}

	public void atualizarFunci(String cpf, String novoNome, String novoEmail, float novoSalario, String novoCargo) {
		String sql = "UPDATE funcionario SET nome=?, email=?, salario=?, cargo=? WHERE cpf=?";
	
		PreparedStatement ps = null;
	
		try {
			ps = Conexao.getConexao().prepareStatement(sql);
			
			ps.setString(1, novoNome);
			ps.setString(2, novoEmail);
			ps.setFloat(3, novoSalario);
			ps.setString(4, novoCargo);
			ps.setString(5, cpf);
			
			//Aqui verifica se a atualização dos dados afetou alguma linha no BD. Se o numero de linhas for maior que "0", então o UPDATE deu certo
			int linhasAfetadas = ps.executeUpdate();
			if (linhasAfetadas > 0) {
				JOptionPane.showMessageDialog(null, "Funcionário atualizado com sucesso!");
			} else {
				JOptionPane.showMessageDialog(null, "Funcionário não encontrado.");
			}
	
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao atualizar funcionário.");
		}
	}
}
