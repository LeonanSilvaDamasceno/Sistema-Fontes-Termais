package Classes;
public class Quarto {
    private int numQuarto;
    private String disponibilidade; //Mudado para String devido a complexidades do BD

    public Quarto(int numQuarto, String disponibilidade) {
        this.numQuarto = numQuarto;
        this.disponibilidade = disponibilidade;
    }

    public void setNumQuarto(int numQuarto) {
        this.numQuarto = numQuarto;
    }
    public void setDisp(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public String getDisp() {
        return disponibilidade;
    }
    public int getNumQuarto() {
        return numQuarto;
    }

}
