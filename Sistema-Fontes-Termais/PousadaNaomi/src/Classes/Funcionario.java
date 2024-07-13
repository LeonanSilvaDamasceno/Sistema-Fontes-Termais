package Classes;
public class Funcionario extends Pessoa {
    private int cod_Funci;
    private float salario;
    private String cargo;

    

    public Funcionario(String nome, int cpf, String email, int cod_Funci, float salario, String cargo) {
        super(nome, cpf, email);
        this.cod_Funci = cod_Funci;
        this.salario = salario;
        this.cargo = cargo;
    }

    public int getCod_Funci() {
        return cod_Funci;
    }

    public void setCod_Funci(int cod_Funci) {
        this.cod_Funci = cod_Funci;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
