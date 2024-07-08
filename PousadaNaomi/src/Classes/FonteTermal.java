package Classes;
public class FonteTermal extends PousadaNaomi {
    private int codFonte;
    private int numClientes;

    public FonteTermal(int numClientes, int numFuncionarios, int codFonte, int numClientes2) {
        super(numClientes, numFuncionarios);
        this.codFonte = codFonte;
        this.numClientes = numClientes2;
    }

    public int getCodFonte() {
        return codFonte;
    }

    public void setCodFonte(int codFonte) {
        this.codFonte = codFonte;
    }

    public int getNumClientes() {
        return numClientes;
    }

    public void setNumClientes(int numClientes) {
        this.numClientes = numClientes;
    }
}
