package Classes;

public class Pessoa {
	
	private String nome;
	private String CPF;
	private String email;


	//Construtor padrão
	public Pessoa(String nome, String cpf, String email) {
		this.nome = nome;
		this.CPF = cpf;
		this.email = email;
	}
	
	//Apartir daqui são os metodos getters e setters da classe
	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public String getCPF() {
		return CPF;
	}

	public String getEmail() {
		return email;
	}

}
