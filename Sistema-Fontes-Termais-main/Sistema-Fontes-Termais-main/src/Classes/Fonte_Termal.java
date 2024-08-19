package Classes;
public class Fonte_Termal {
    private int codFonte;
    private int numClientes;
  //Construtor padrão
    public Fonte_Termal(int numClientes, int codFonte) {
    	this.numClientes = numClientes;
    	this.codFonte = codFonte;
    	
    }
  //Apartir daqui são os metodos getters e setters
    public void setCodFonte(int codFonte) {
        this.codFonte = codFonte;
    }
    public void setNumClientes(int numClientes) {
        this.numClientes = numClientes;
    }

    public int getCodFonte() {
        return codFonte;
    }
    public int getNumClientes() {
        return numClientes;
    }
}
