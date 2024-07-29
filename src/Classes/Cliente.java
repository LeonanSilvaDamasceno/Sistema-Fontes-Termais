package Classes;

public class Cliente extends Pessoa {
	private int numQuarto;
	private int tempoReserva;
	Fonte_Termal fonte_termal;
	Chamado chamado;
	
	//Construtor padrão
	public Cliente(String nome, String CPF, String email, int numQuarto, int tempoReserva) {
		super(nome, CPF, email);
		this.numQuarto = numQuarto;
		this.tempoReserva = tempoReserva;
	}
	
	//Apartir daqui são os metodos getters e setters
	public void setFonte_termal(Fonte_Termal fonte_termal) {
		this.fonte_termal = fonte_termal;
	}

	public void setNumQuarto(int numQuarto) {
		this.numQuarto = numQuarto;
	}

	public void setTempoReserva(int tempoReserva) {
		this.tempoReserva = tempoReserva;
	}

	public int getTempoReserva() {
		return tempoReserva;
	}

	public int getNumQuarto() {
		return numQuarto;
	}
	
	public void usarFonte() {
		System.out.print("Cliente" + getNome() + "está usando a fonte \"" + fonte_termal.getCodFonte() + "\"!");
	}
	
	//Metodo para renovar a reserva do cliente
	public void renovarReserva(int tempoReserva) {}
	public void abrirChamado () {
		chamado.setSc_chamado("Aberto");
		chamado.setSolicitante(getCPF());
	}
}