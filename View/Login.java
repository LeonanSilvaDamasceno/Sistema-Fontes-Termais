package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login implements Utility {
    public static void loginComponents(JFrame login, JFrame cliente, JFrame funcionario, JFrame signup) {
        JTextField email = new JTextField(50);
        JPasswordField senha = new JPasswordField(50);

        JButton sign_in = new JButton("Entrar");
        JLabel sign_up = new JLabel("Clique aqui!"); // Funciona como um botão
        sign_up.setForeground(new Color(77, 117, 154));

        labelsLogin(signup);

        sign_in.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {if (email.getText().equalsIgnoreCase("C"))
                    Utility.mudarTelas(login, cliente);
                if (email.getText().equalsIgnoreCase("F"))
                    Utility.mudarTelas(login, funcionario);
            }
        });

        sign_up.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utility.mudarTelas(login, signup);
            }
        });

        email.setBounds(130, 230, 150, 30);
        senha.setBounds(130, 310, 150, 30);

        sign_in.setBounds(130, 365, 150, 25);
        sign_up.setBounds(210, 395, 75, 30);

        login.add(sign_in);
        login.add(sign_up);
        login.add(email);
        login.add(senha);
    }

    public static void labelsLogin(JFrame frame) {
        JLabel email = new JLabel("E-mail:");
        JLabel senha = new JLabel("Senha:");
        JLabel sign_up = new JLabel("Sem acesso?");

        email.setBounds(130, 200, 150, 30);
        senha.setBounds(130, 280, 150, 30);
        sign_up.setBounds(130, 395, 150, 30);

        frame.add(email);
        frame.add(senha);
        frame.add(sign_up);
    }
}
