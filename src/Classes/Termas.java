package Classes;
public class Termas {
    private int numQuarto;
    private String disponibilidade; //Mudado para String devido a complexidades do BD

  //Construtor padrão
    public Termas(int numQuarto, String disponibilidade) {
        this.numQuarto = numQuarto;
        this.disponibilidade = disponibilidade;
    }
    
  //Apartir daqui são os metodos getters e setters
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
