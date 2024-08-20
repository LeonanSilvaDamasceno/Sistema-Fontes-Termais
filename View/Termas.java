package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Termas implements Utility{

    public static void verTermas(JFrame Termas, JFrame Cliente) {
        Termas.setLayout(new GridLayout(2, 2, 65, 10));

        JLabel codFonte = new JLabel("Código 01");
        JLabel qtdPessoas = new JLabel("Nome cliente: \"Marcelo Pasteleiro 'C'\"");

        JButton pesquisar = new JButton("Pesquisar");
        JButton sair = new JButton("Sair");

        pesquisar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showInputDialog(null, "Digite o número da fonte termal desejada:",
                        "Pesquisar fonte termal", JOptionPane.QUESTION_MESSAGE);
            }
        });
        sair.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utility.mudarTelas(Termas, Cliente);
            }
        });

        Termas.add(codFonte);
        Termas.add(qtdPessoas);
        Termas.add(pesquisar);
        Termas.add(sair);
        Termas.pack();
    }
}
