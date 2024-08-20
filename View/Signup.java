package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Signup implements Utility {

    public static void signupComponents(JFrame Signup, JFrame Login) {
        Signup.setSize(500, 500);

        JTextField nome = new JTextField();
        JTextField email = new JTextField();
        JTextField cpf = new JTextField();
        JPasswordField senha = new JPasswordField();

        JButton confirmar = new JButton("Confirmar");
        JButton cancelar = new JButton("Cancelar");

        cancelar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utility.mudarTelas(Signup, Login);
            }
        });
        confirmar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                criarConta(nome.getText(), Integer.parseInt(cpf.getText()), email.getText(), senha.getPassword());
                Utility.mudarTelas(Signup, Login);
            }
        });

        nome.setBounds(120, 130, 230, 30);
        email.setBounds(120, 200, 230, 30);
        cpf.setBounds(120, 280, 230, 30);
        senha.setBounds(120, 360, 230, 30);
        confirmar.setBounds(120, 405, 95, 25);
        cancelar.setBounds(255, 405, 95, 25);

        Signup.add(nome);
        Signup.add(email);
        Signup.add(cpf);
        Signup.add(senha);
        Signup.add(confirmar);
        Signup.add(cancelar);
    }

    public static void signupLabels(JFrame Signup) {
        JLabel flavour1 = new JLabel("Cadastrar conta");
        JLabel flavour2 = new JLabel("Crie sua conta preenchendo os campos abaixo!");

        JLabel nome = new JLabel("Nome:");
        JLabel email = new JLabel("Email:");
        JLabel cpf = new JLabel("CPF:");
        JLabel senha = new JLabel("Senha:");

        flavour1.setFont(new Font("Times new Roman", Font.PLAIN, 15));
        flavour2.setFont(new Font("Times new Roman", Font.PLAIN, 13));
        nome.setFont(new Font("Times new Roman", Font.PLAIN, 13));
        email.setFont(new Font("Times new Roman", Font.PLAIN, 13));
        cpf.setFont(new Font("Times new Roman", Font.PLAIN, 13));
        senha.setFont(new Font("Times new Roman", Font.PLAIN, 13));

        flavour1.setBounds(100, 42, 200, 30);
        flavour2.setBounds(100, 72, 300, 30);
        nome.setBounds(120, 105, 150, 30);
        email.setBounds(120, 175, 150, 30);
        cpf.setBounds(120, 245, 150, 30);
        senha.setBounds(120, 315, 150, 30);

        Signup.add(flavour1);
        Signup.add(flavour2);
        Signup.add(nome);
        Signup.add(email);
        Signup.add(cpf);
        Signup.add(senha);
    }

    public static void criarConta(String nome, int cpf, String email, char[] senha) {
        JOptionPane.showMessageDialog(null, "Conta criada com êxito!",
                "Cadastro efetuado", JOptionPane.INFORMATION_MESSAGE);
    }
}
