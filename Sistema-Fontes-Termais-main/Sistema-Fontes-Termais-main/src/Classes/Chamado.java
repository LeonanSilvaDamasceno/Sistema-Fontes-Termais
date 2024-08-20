package Classes;

public class Chamado {
    private int id_chamado;
    private String solicitante;
    private String ds_chamado;
    private String func_resp;
    private String sc_chamado;

    public Chamado (){}

    
    public Chamado(int id_chamado, String solicitante, String ds_chamado,String sc_chamado, String func_resp ) {
        this.id_chamado = id_chamado;
        this.solicitante = solicitante;
        this.ds_chamado = ds_chamado;
        this.func_resp = func_resp;
        this.sc_chamado = sc_chamado;
    }


    public void setId_chamado(int id_chamado) {this.id_chamado = id_chamado;}
    public void setSolicitante(String solicitante) {this.solicitante = solicitante;}
    public void setDs_chamado(String ds_chamado) {this.ds_chamado = ds_chamado;}
    public void setFunc_resp(String func_resp) {this.func_resp = func_resp;}
    public void setSc_chamado(String sc_chamado) {this.sc_chamado = sc_chamado;}

    public int getId_chamado() {return id_chamado;}
    public String getSolicitante() {return solicitante;}
    public String getDs_chamado() {return ds_chamado;}
    public String getFunc_resp() {return func_resp;}
    public String getSc_chamado() {return sc_chamado;}

}
