package Classes;

public class Funcionario extends Pessoa {
    private float salario;
    private String cargo;
    private int cgHoraria;
    Chamado chamado;
    private String senha;

    // Construtor padrão
    public Funcionario(String nome, String cpf, String email, float salario, String cargo, int cgHoraria,
            String senha) {
        super(nome, cpf, email);
        this.salario = salario;
        this.cargo = cargo;
        this.cgHoraria = cgHoraria;
        this.senha = senha;
    }

    // Construtor vazio
    public Funcionario() {

    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public String getCargo() {
        return cargo;
    }

    public float getSalario() {
        return salario;
    }

    public int getcgHoraria() {
        return cgHoraria;
    }

    public void respChamado() {
        chamado.setFunc_resp(getCPF());
        chamado.setSc_chamado("Em execução");
    }

    public void finChamado() {
        chamado.setSc_chamado("Solucionado");
    }

}
