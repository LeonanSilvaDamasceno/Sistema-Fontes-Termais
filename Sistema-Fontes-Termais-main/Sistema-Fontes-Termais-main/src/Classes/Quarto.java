package Classes;

public class Quarto {
    private int num;
    private int num_cli;
    private String disp;

    Cliente cliente;

    public Quarto () {}
    

    public Quarto(int num, int num_cli, String disp) {
        this.num = num;
        this.num_cli = num_cli;
        this.disp = disp;
    }


    public Cliente getCliente() {return cliente;}

    public void setNum(int num) {this.num = num;}
    public void setNum_cli(int num_cli) {this.num_cli = num_cli;}
    public void setDisp(String disp) {this.disp = disp;}
    public void setCliente(Cliente cliente) {this.cliente = cliente;}

    public int getNum_cli() {return num_cli;}
    public int getNum() {return num;}
    public String getDisp() {return disp;}
}
