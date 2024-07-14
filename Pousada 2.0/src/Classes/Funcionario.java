package Classes;
public class Funcionario extends Pessoa {
    private float salario;
    private String cargo;

    
  //Construtor padrão
    public Funcionario(String nome, String cpf, String email,  float salario, String cargo) {
        super(nome, cpf, email);
        this.salario = salario;
        this.cargo = cargo;
    }

  //Apartir daqui são os metodos getters e setters
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
