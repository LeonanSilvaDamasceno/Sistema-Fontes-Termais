package DAO;

import Classes.*;
import Conexao.Conexao;
import java.sql.*;

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
		}

	}

}
