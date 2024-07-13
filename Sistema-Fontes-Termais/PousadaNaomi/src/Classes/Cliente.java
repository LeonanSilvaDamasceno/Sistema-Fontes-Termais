package Classes;
public class Cliente extends Pessoa {
    private int codCliente;
    private int numQuarto;
    private int tempoReserva;
    Fonte_Termal fonte_termal;

    public Cliente(){}

    public Cliente(String nome, int CPF, String email ,int codCliente, int numQuarto, int tempoReserva) {
        super(nome, CPF, email);
        this.codCliente = codCliente;
        this.numQuarto = numQuarto;
        this.tempoReserva = tempoReserva;
    }

    public void setFonte_termal(Fonte_Termal fonte_termal) {this.fonte_termal = fonte_termal;}

    public void setNumQuarto(int numQuarto) {
        this.numQuarto = numQuarto;
    }
    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }
    public void setTempoReserva(int tempoReserva) {
        this.tempoReserva = tempoReserva;
    }

    public int getCodCliente() {
        return codCliente;
    }
    public int getTempoReserva() {
        return tempoReserva;
    }
    public int getNumQuarto() {
        return numQuarto;
    }

    public void usarFonte() {
        System.out.print("Cliente" + getNome() + "está usando a fonte \"" +
                fonte_termal.getCodFonte() + "\"!"
        );
    }

    public void renovarReserva(int tempoReserva) {
        
    }
}