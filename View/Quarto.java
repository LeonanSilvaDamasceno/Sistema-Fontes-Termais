package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Quarto implements Utility{
    public static void verQuarto(JFrame Quarto, JFrame Func) {
        Quarto.setLayout(new GridLayout(3, 4, 65, 10));

        JLabel numQuarto = new JLabel("Número do quarto: \"001\"");
        JLabel nomCliente = new JLabel("Nome cliente: \"Marcelo Pasteleiro 'C'\"");
        JLabel emailCliente = new JLabel("E-mail cliente: \"PastelaumDU@gmail.com\"");
        JLabel disp = new JLabel("Status: Ocupado");

        JButton pesquisar = new JButton("Pesquisar");
        JButton sair = new JButton("Sair");

        pesquisar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showInputDialog(null, "Digite o número do quarto:",
                        "Pesquisar quartos", JOptionPane.QUESTION_MESSAGE);
            }
        });
        sair.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utility.mudarTelas(Quarto, Func);
            }
        });

        Quarto.add(numQuarto);
        Quarto.add(nomCliente);
        Quarto.add(emailCliente);
        Quarto.add(disp);

        Quarto.add(pesquisar);
        Quarto.add(sair);

        Quarto.pack();
    }
}
