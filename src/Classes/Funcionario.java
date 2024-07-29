package Classes;
public class Funcionario extends Pessoa {
    private float salario;
    private String cargo;

    private int cgHoraria;
    Chamado chamado;
    
    //Construtor padrão
    public Funcionario(String nome, String cpf, String email,  float salario, String cargo, int cgHoraria) {
        super(nome, cpf, email);
        this.salario = salario;
        this.cargo = cargo;
        this.cgHoraria = cgHoraria;
    }
    // Construtor vazio
    public Funcionario(){
        
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public void setSalario(float salario) {
        this.salario = salario;
    }
    public void setCgHoraria(int cgHoraria) {
        this.cgHoraria = cgHoraria;
    }

    public String getCargo() {return cargo;}
    public float getSalario() {
        return salario;
    }
    public float getcgHoraria() {
        return cgHoraria;
    }
    public void respChamado (){
        chamado.setFunc_resp(getCPF());
        chamado.setSc_chamado("Em execução");
    }
    public void finChamado (){chamado.setSc_chamado("Solucionado");}

}
