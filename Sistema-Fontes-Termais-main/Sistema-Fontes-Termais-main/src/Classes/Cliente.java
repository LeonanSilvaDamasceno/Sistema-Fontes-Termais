package Classes;

public class Cliente extends Pessoa {
	private int tempoReserva;
	Quarto quarto;
	Fonte_Termal fonte_termal;
	Chamado chamado;
	private String checkIn;


	public Cliente(){

	}
	
	//Construtor padrão
	public Cliente(String nome, String cpf, String email, int tempoReserva, Quarto quarto, String checkIn) {
		super(nome, cpf, email);
		this.tempoReserva = tempoReserva;
		this.quarto = quarto;
		this.checkIn = checkIn;
	}

	//Apartir daqui são os metodos getters e setters
	public void setFonte_termal(Fonte_Termal fonte_termal) {
		this.fonte_termal = fonte_termal;
	}

	public void setQuarto (Quarto quarto) {this.quarto = quarto;}

	public void setTempoReserva(int tempoReserva) {
		this.tempoReserva = tempoReserva;
	}

	public int getTempoReserva() {
		return tempoReserva;
	}
	public Quarto getQuarto(){
		return quarto;
	}

	
	public void usarFonte() {
		System.out.print("Cliente" + getNome() + "está usando a fonte \"" + fonte_termal.getCodFonte() + "\"!");
	}
	
	
	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	//Metodo para renovar a reserva do cliente
	public void renovarReserva(int tempoReserva) {}
	public void abrirChamado () {
		chamado.setSc_chamado("Aberto");
		chamado.setSolicitante(getCPF());
	}
}