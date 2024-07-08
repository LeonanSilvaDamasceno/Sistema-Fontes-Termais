package Classes;
public class Pessoa {
    private String nome;
    private int CPF;
    private String email;

    public Pessoa(){
        
    }

    public Pessoa(String nome, int cpf, String email) {
        this.nome = nome;
        this.CPF = cpf;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCPF() {
        return CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
