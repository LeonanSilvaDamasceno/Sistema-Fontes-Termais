package Classes;
public class Pousada_Naomi{
    private int total_Clientes; //Mudado para evitar confusão com outro dado "num_clientes"
    private int total_Func; //Mudado para manter padrão

    public Pousada_Naomi (){}
    public void setTotal_Clientes(int total_Clientes) {this.total_Clientes = total_Clientes;}
    public void setTotal_Func(int total_Func) {this.total_Func = total_Func;}


    public int getTotal_Clientes() {return total_Clientes;}
    public int getTotal_Func() {return total_Func;}
}
