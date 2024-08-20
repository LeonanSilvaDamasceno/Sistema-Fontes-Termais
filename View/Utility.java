package View;

import javax.swing.*;
import java.awt.*;

public interface Utility {
    static void frameStartup(JFrame frame) {
        frame.setSize(810, 600);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    static void background(String imagem, JFrame frame) {
        JLabel background;
        ImageIcon img_login = new ImageIcon(
                new ImageIcon(imagem).getImage().getScaledInstance(810, 596, Image.SCALE_DEFAULT));
        background = new JLabel("", img_login, JLabel.CENTER);
        background.setBounds(0, 0, 810, 596);
        frame.add(background);
    }

    static void mudarTelas(JFrame ant, JFrame prox) {
        ant.setVisible(false);
        prox.setVisible(true);
    }
}
