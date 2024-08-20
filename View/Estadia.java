package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Estadia implements Utility {
    public static void verEstadia(JFrame Estadia, JFrame Cliente) {
        Estadia.setLayout(new GridLayout(3, 4, 65, 10));

        JLabel numQuarto = new JLabel("Número do quarto: \"001\"");
        JLabel nomCliente = new JLabel("Nome cliente: \"Marcelo Pasteleiro 'C'\"");
        JLabel emailCliente = new JLabel("E-mail cliente: \"PastelaumDU@gmail.com\"");
        JLabel checkout = new JLabel("Check-Out: 22/02/2024");

        JButton estender = new JButton("Estender duração?");
        JButton sair = new JButton("Sair");

        estender.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showInputDialog(null, "Informe o número de dias aos quais deseja passar a mais conosco: ",
                        "Enviar solicitação para aumento de estadia", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        sair.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utility.mudarTelas(Estadia, Cliente);
            }
        });

        Estadia.add(numQuarto);
        Estadia.add(nomCliente);
        Estadia.add(emailCliente);
        Estadia.add(checkout);

        Estadia.add(estender);
        Estadia.add(sair);

        Estadia.pack();
    }
}
