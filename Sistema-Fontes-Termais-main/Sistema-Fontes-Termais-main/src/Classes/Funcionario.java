package Classes;

public class Funcionario extends Pessoa {
    private String salario;
    private String cargo;
    private int cgHoraria;
    Chamado chamado;
    private String senha;

    // Construtor padrão
    public Funcionario(String nome, String cpf, String email, String salario, String cargo, int cgHoraria,
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

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public void setCgHoraria(int cgHoraria) {
        this.cgHoraria = cgHoraria;
    }

    public String getCargo() {
        return cargo;
    }

    public String getSalario() {
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
