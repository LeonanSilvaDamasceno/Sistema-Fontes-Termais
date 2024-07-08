package Classes;
public class Cliente extends Pessoa {
    private int codCliente;
    private int numQuarto;
    private int tempoReserva;

    public Cliente(){

        super();
        this.codCliente = 0;
        this.numQuarto = 0;
        this.tempoReserva = 0;

    }

    public Cliente(String nome, int CPF, String email ,int codCliente, int numQuarto, int tempoReserva) {
        super(nome, CPF, email);
        this.codCliente = codCliente;
        this.numQuarto = numQuarto;
        this.tempoReserva = tempoReserva;
    }

    

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public int getNumQuarto() {
        return numQuarto;
    }

    public void setNumQuarto(int numQuarto) {
        this.numQuarto = numQuarto;
    }

    public int getTempoReserva() {
        return tempoReserva;
    }

    public void setTempoReserva(int tempoReserva) {
        this.tempoReserva = tempoReserva;
    }

    public void usarFonte() {
        
    }

    public void renovarReserva(int tempoReserva) {
        
    }
}