package Classes;
public class Fonte_Termal {
    private int codFonte;
    private int numClientes;

    public Fonte_Termal(int numClientes, int codFonte) {}
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
