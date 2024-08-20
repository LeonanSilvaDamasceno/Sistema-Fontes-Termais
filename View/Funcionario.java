package View;

import Classes.Chamado;
import DAO.ChamadoDAO;
import DAO.FuncionarioDAO;
import jdk.jshell.execution.Util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Funcionario implements Utility {

    public static void funcComponents(JFrame func, JFrame login, JFrame checkIn,
                                      JFrame checkOut, JFrame funcChamado, JFrame quarto, JFrame addFunc) {
        JLabel verChamado = new JLabel("Verificar chamados");
        JLabel verQuartos = new JLabel("Verificar quartos");
        JLabel Func = new JLabel("Adicionar funcionário");
        JLabel checkI = new JLabel("Realizar Check-in");
        JLabel checkO = new JLabel("Realizar Check-out");

        JButton logout = new JButton("Logout");

        funcDetails(func, verChamado, verQuartos, Func, checkI, checkO, logout);

        verChamado.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utility.mudarTelas(func, funcChamado);
            }
        });
        verQuartos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utility.mudarTelas(func, quarto);
            }
        });
        Func.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utility.mudarTelas(func, addFunc);
            }
        });
        checkIn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utility.mudarTelas(func, checkIn);
            }
        });
        checkOut.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utility.mudarTelas(func, checkOut);
            }
        });
        logout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utility.mudarTelas(func, login);
            }
        });
    }
    public static void addFuncComponents(JFrame addFunc, JFrame Funcionario) {
        // Define o tamanho da janela para adicionar um funcionário
        addFunc.setSize(500, 800);

        // Criação dos campos de entrada para os dados do funcionário
        JTextField nome = new JTextField(); // Campo para o nome do funcionário
        JTextField email = new JTextField(); // Campo para o e-mail do funcionário
        JTextField cpf = new JTextField(); // Campo para o CPF do funcionário
        JTextField cargo = new JTextField(); // Campo para o cargo do funcionário
        JTextField cgHoraria = new JTextField(); // Campo para a carga horária semanal
        JTextField salario = new JTextField(); // Campo para o salário mensal
        JPasswordField senha = new JPasswordField(); // Campo para a senha do funcionário

        // Criação dos botões para confirmar e cancelar a operação
        JButton confirmar = new JButton("Confirmar"); // Botão para confirmar o cadastro
        JButton cancelar = new JButton("Cancelar"); // Botão para cancelar a operação

        // Adiciona um MouseListener ao botão "Cancelar"
        cancelar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Troca para a tela anterior quando o botão "Cancelar" é clicado
                Utility.mudarTelas(addFunc, Funcionario);
            }
        });

        // Adiciona um MouseListener ao botão "Confirmar"
        confirmar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    // Cria um novo objeto Funcionario e define seus atributos com os valores dos
                    // campos
                    Classes.Funcionario funcionario = new Classes.Funcionario();
                    funcionario.setNome(nome.getText()); // Define o nome do funcionário
                    funcionario.setCPF(cpf.getText()); // Define o CPF do funcionário
                    funcionario.setEmail(email.getText()); // Define o e-mail do funcionário
                    funcionario.setCargo(cargo.getText()); // Define o cargo do funcionário
                    int cargaHoraria = Integer.parseInt(cgHoraria.getText()); //Define  a carga horaria semanal do funcionario
                    funcionario.setSalario(Float.parseFloat(salario.getText())); // Define o salário do funcionário
                    funcionario.setCgHoraria(cargaHoraria);
                    // Converte a senha de char[] para String
                    funcionario.setSenha(new String(senha.getPassword())); // Define a senha do funcionário

                    // Cria uma instância de FuncionarioDAO e chama o método para cadastrar o
                    // funcionário
                    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
                    funcionarioDAO.cadastrarFuncionario(funcionario);

                    // Exibe uma mensagem de sucesso
                    JOptionPane.showMessageDialog(addFunc, "Funcionário cadastrado com sucesso!");
                    // Troca para a tela anterior após o cadastro bem-sucedido
                    Utility.mudarTelas(addFunc, Funcionario);
                } catch (Exception ex) {
                    // Captura e exibe qualquer exceção que ocorra durante o processo
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(addFunc, "Erro ao cadastrar funcionário. Verifique os dados.");
                }
            }
        });

        // Define as posições e tamanhos dos componentes na janela
        nome.setBounds(120, 130, 230, 30);
        email.setBounds(120, 200, 230, 30);
        cpf.setBounds(120, 280, 230, 30);
        cgHoraria.setBounds(120, 360, 230, 30);
        salario.setBounds(120, 440, 230, 30);
        cargo.setBounds(120, 520, 230, 30);
        senha.setBounds(120, 600, 230, 30);
        confirmar.setBounds(120, 645, 95, 25);
        cancelar.setBounds(255, 645, 95, 25);

        // Adiciona todos os componentes à janela
        addFunc.add(nome);
        addFunc.add(email);
        addFunc.add(cpf);
        addFunc.add(cargo);
        addFunc.add(cgHoraria);
        addFunc.add(salario);
        addFunc.add(senha);
        addFunc.add(confirmar);
        addFunc.add(cancelar);
    } //Tela de adicionar funcionário

    public static void addFuncLabels(JFrame addFunc) {
        JLabel flavour1 = new JLabel("Cadastrar conta");
        JLabel flavour2 = new JLabel("Crie sua conta preenchendo os campos abaixo!");

        JLabel nome = new JLabel("Nome:");
        JLabel email = new JLabel("Email:");
        JLabel cpf = new JLabel("CPF:");
        JLabel cargo = new JLabel("Cargo:");
        JLabel cgHoraria = new JLabel("Carga horária semanal:");
        JLabel salario = new JLabel("Salário mensal:");
        JLabel senha = new JLabel("Senha:");

        flavour1.setFont(new Font("Times new Roman", Font.PLAIN, 15));
        flavour2.setFont(new Font("Times new Roman", Font.PLAIN, 13));
        nome.setFont(new Font("Times new Roman", Font.PLAIN, 13));
        email.setFont(new Font("Times new Roman", Font.PLAIN, 13));
        cpf.setFont(new Font("Times new Roman", Font.PLAIN, 13));
        cargo.setFont(new Font("Times new Roman", Font.PLAIN, 13));
        cgHoraria.setFont(new Font("Times new Roman", Font.PLAIN, 13));
        salario.setFont(new Font("Times new Roman", Font.PLAIN, 13));
        senha.setFont(new Font("Times new Roman", Font.PLAIN, 13));

        flavour1.setBounds(100, 42, 200, 30);
        flavour2.setBounds(100, 72, 300, 30);
        nome.setBounds(120, 105, 150, 30);
        email.setBounds(120, 175, 150, 30);
        cpf.setBounds(120, 255, 150, 30);
        cargo.setBounds(120, 335, 150, 30);
        cgHoraria.setBounds(120, 415, 150, 30);
        salario.setBounds(120, 495, 150, 30);
        senha.setBounds(120, 575, 150, 30);

        addFunc.add(flavour1);
        addFunc.add(flavour2);
        addFunc.add(nome);
        addFunc.add(email);
        addFunc.add(cpf);
        addFunc.add(cargo);
        addFunc.add(cgHoraria);
        addFunc.add(salario);
        addFunc.add(senha);
    }

    public static void funcDetails(JFrame Funcionario, JLabel verChamado, JLabel verQuartos, JLabel addFunc,
                                   JLabel checkIn, JLabel checkOut, JButton logout) {

        logout.setBackground(Color.white);

        verChamado.setFont(new Font("Times new Roman", Font.PLAIN, 20));
        verQuartos.setFont(new Font("Times new Roman", Font.PLAIN, 20));
        addFunc.setFont(new Font("Times new Roman", Font.PLAIN, 20));
        checkIn.setFont(new Font("Times new Roman", Font.PLAIN, 20));
        checkOut.setFont(new Font("Times new Roman", Font.PLAIN, 20));

        verChamado.setBounds(135, 105, 300, 30);
        verQuartos.setBounds(135, 185, 300, 30);
        addFunc.setBounds(135, 265, 300, 30);
        checkIn.setBounds(135, 345, 300, 30);
        checkOut.setBounds(135, 425, 300, 30);
        logout.setBounds(135, 505, 175, 30);

        Funcionario.add(verChamado);
        Funcionario.add(verQuartos);
        Funcionario.add(addFunc);
        Funcionario.add(checkIn);
        Funcionario.add(checkOut);
        Funcionario.add(logout);
    }

    public static void checkinCliente(JFrame checkIn, JFrame Func) {
        checkIn.setLayout(new GridLayout(0, 2, 65, 10));

        JLabel nome = new JLabel("Nome:");
        JTextField nomeField = new JTextField();

        JLabel cpf = new JLabel("CPF:");
        JTextField cpfField = new JTextField();

        JLabel email = new JLabel("Email:");
        JTextField emailField = new JTextField();

        JLabel numQuarto = new JLabel("Número do quarto:");
        JTextField numQuartoField = new JTextField();

        JLabel dt_checkIn = new JLabel("Check-in:");
        JTextField checkInField = new JTextField();

        JLabel tempEstadia = new JLabel("Tempo de estadia:");
        JTextField tempEstadiaField = new JTextField();

        JButton confirmar = new JButton("Confirmar");
        JButton cancelar = new JButton("Cancelar");

        checkIn.add(nome);
        checkIn.add(nomeField);
        checkIn.add(cpf);
        checkIn.add(cpfField);
        checkIn.add(email);
        checkIn.add(emailField);
        checkIn.add(numQuarto);
        checkIn.add(numQuartoField);
        checkIn.add(tempEstadia);
        checkIn.add(tempEstadiaField);
        checkIn.add(dt_checkIn);
        checkIn.add(checkInField);

        confirmar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utility.mudarTelas(checkIn, Func);
                JOptionPane.showMessageDialog(null, "Check-In efetuado com êxito!",
                        "Check-In registrado", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        cancelar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utility.mudarTelas(checkIn, Func);
            }
        });

        checkIn.add(confirmar);
        checkIn.add(cancelar);

        checkIn.pack();
    }

    public static void checkoutCliente(JFrame checkOut, JFrame Func) {
        checkOut.setLayout(new GridLayout(0, 2, 65, 10));

        JLabel cpf = new JLabel("CPF:");
        JTextField cpfField = new JTextField();

        JLabel numQuarto = new JLabel("Número do quarto:");
        JTextField numQuartoField = new JTextField();

        JButton confirmar = new JButton("Confirmar");
        JButton cancelar = new JButton("Cancelar");

        confirmar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utility.mudarTelas(checkOut, Func);
                JOptionPane.showMessageDialog(null, "Check-Out efetuado com êxito!",
                        "Solicitação de Check-out homologada", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        cancelar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utility.mudarTelas(checkOut, Func);
            }
        });

        checkOut.add(cpf);
        checkOut.add(cpfField);
        checkOut.add(numQuarto);
        checkOut.add(numQuartoField);

        checkOut.add(confirmar);
        checkOut.add(cancelar);

        checkOut.pack();
    }

}
