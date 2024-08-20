package View;

import javax.swing.*;

import static View.Utility.background;

public class Initializer {
    public static void main (String [] args) {
        JFrame login = new JFrame("Pousada Naomi - Login");
        JFrame signup = new JFrame("Pousada Naomi - Criar Conta");
        JFrame cliente = new JFrame("Pousada Naomi - Menu cliente");
        JFrame estadia = new JFrame("Pousada Naomi - Menu cliente - Verificação de estadia");
        JFrame termas = new JFrame("Pousada Naomi - Menu cliente - Verificação de termas");
        JFrame addChamado = new JFrame("Pousada Naomi - Menu cliente - Adicionar chamado");
        JFrame func = new JFrame("Pousada Naomi - Administração");
        JFrame addFunc = new JFrame("Pousada Naomi - Administração - Adicionar funcionário");
        JFrame quarto = new JFrame("Pousada Naomi - Administração - Verificação de quartos");
        JFrame respChamado = new JFrame("Pousada Naomi - Administração - Responder chamado");
        JFrame funcChamado = new JFrame("Pousada Naomi - Administração - Verificação de Chamados");
        JFrame checkIn = new JFrame("Pousada Naomi - Administração - Check-In");
        JFrame checkOut = new JFrame("Pousada Naomi - Administração - Check-Out");

        QuartoInit(func, quarto);
        EstadiaInit(estadia, cliente);
        TermasInit(termas, cliente);
        ChamadoInit(addChamado,respChamado, funcChamado, func, cliente);
        SignupInit(signup, login);
        LoginInit(login, cliente, func, signup);
        FuncInit(func, addFunc, funcChamado, login, quarto,checkIn,checkOut);
        ClientInit(cliente, login, addChamado, termas, estadia);
    }

    public static void LoginInit (JFrame login, JFrame Cliente, JFrame Func, JFrame Signup) {
        Login.loginComponents(login, Cliente, Func, Signup);
        Utility.frameStartup(login);
        Login.labelsLogin(login);
        background("src/Imagens/Login.png", login);
        login.setVisible(true);
    }

    public static void FuncInit (JFrame Func, JFrame addFunc, JFrame funcChamado,
                                 JFrame login, JFrame Quarto,
                                 JFrame checkIn, JFrame checkOut){

        Utility.frameStartup(Func);
        Utility.frameStartup(addFunc);
        Utility.frameStartup(funcChamado);

        Funcionario.funcComponents(Func, login, checkIn, checkOut, funcChamado, Quarto, addFunc);
        background("src/Imagens/Funcionario.png", Func);
        Funcionario.addFuncComponents(addFunc, Func);
        Funcionario.addFuncLabels(addFunc);
        Funcionario.checkinCliente(checkIn,Func);
        Funcionario.checkoutCliente(checkOut, Func);
    }

    public static void ClientInit (JFrame Client, JFrame Login, JFrame addChamado,
                                   JFrame Termas, JFrame Estadia) {
        Utility.frameStartup(Client);
        Cliente.clientComponents(Client, Login, addChamado, Termas, Estadia);
        background("src/Imagens/Cliente.png", Client);

    }

    public static void TermasInit (JFrame termas, JFrame Client) {
        Utility.frameStartup(termas);
        Termas.verTermas(termas, Client);
    }

    public static void EstadiaInit (JFrame estadia, JFrame Cliente) {
        Utility.frameStartup(estadia);
        Estadia.verEstadia(estadia, Cliente);
    }

    public static void QuartoInit (JFrame Func, JFrame quarto){
        Utility.frameStartup(quarto);
        Quarto.verQuarto(quarto, Func);
    }

    public static void ChamadoInit (JFrame addChamado, JFrame respChamado, JFrame funcChamado, JFrame func, JFrame Client) {
        Utility.frameStartup(addChamado);
        Utility.frameStartup(respChamado);
        Utility.frameStartup(funcChamado);

        Chamado.acionarChamado(addChamado, Client);
        Chamado.verChamadoComponents(funcChamado, func, respChamado);
        Chamado.respChamadoComponents(respChamado, funcChamado);
    }

    public static void SignupInit (JFrame signup, JFrame login) {
        Utility.frameStartup(signup);
        Signup.signupComponents(signup, login);
        Signup.signupLabels(signup);
    }
}
