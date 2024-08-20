package View;

import Classes.Chamado;
import DAO.ChamadoDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cliente implements Utility{
    public static void clientComponents(JFrame Cliente, JFrame Login, JFrame addChamado, JFrame Termas,
                                        JFrame Estadia) {
        JLabel acionarServiço = new JLabel("Acionar serviço");
        JLabel verificarTermas = new JLabel("Verificar termas");
        JLabel verificarEstadia = new JLabel("Verificar estadia");

        JButton logout = new JButton("Logout");

        acionarServiço.setFont(new Font("Times new Roman", Font.PLAIN, 20));
        verificarEstadia.setFont(new Font("Times new Roman", Font.PLAIN, 20));
        verificarTermas.setFont(new Font("Times new Roman", Font.PLAIN, 20));

        logout.setBackground(Color.white);

        acionarServiço.setBounds(120, 105, 200, 30);
        verificarTermas.setBounds(120, 205, 300, 30);
        verificarEstadia.setBounds(120, 305, 150, 30);
        logout.setBounds(120, 405, 150, 30);

        logout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utility.mudarTelas(Cliente, Login);
            }
        });
        acionarServiço.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utility.mudarTelas(Cliente, addChamado);
            }
        });
        verificarEstadia.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utility.mudarTelas(Cliente, Estadia);
            }
        });
        verificarTermas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utility.mudarTelas(Cliente, Termas);
            }
        });

        Cliente.add(acionarServiço);
        Cliente.add(verificarTermas);
        Cliente.add(verificarEstadia);
        Cliente.add(logout);
    }
}
