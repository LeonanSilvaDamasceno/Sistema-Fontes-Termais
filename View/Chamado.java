package View;

import DAO.ChamadoDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Chamado implements Utility{

    public static void acionarChamado(JFrame chamadoCliente, JFrame Client) {
        // Define o layout da janela como um grid com uma única coluna
        chamadoCliente.setLayout(new GridLayout(0, 1, 65, 10));

        // Cria os componentes da interface gráfica
        JLabel labelSolicitante = new JLabel("Nome do solicitante:");
        JTextField solicitanteField = new JTextField();

        JLabel labelDemanda = new JLabel("Demanda:");
        JTextField demandaField = new JTextField();

        JButton confirmar = new JButton("Confirmar");
        JButton cancelar = new JButton("Cancelar");

        // Adiciona os componentes à janela
        chamadoCliente.add(labelSolicitante);
        chamadoCliente.add(solicitanteField);
        chamadoCliente.add(labelDemanda);
        chamadoCliente.add(demandaField);
        chamadoCliente.add(new JLabel("")); // Espaçamento entre o JTextField e o botão de confirmar
        chamadoCliente.add(confirmar);
        chamadoCliente.add(cancelar);

        // Adicionando funcionalidade ao botão Confirmar
        confirmar.addActionListener(e -> {
            // Coleta as informações inseridas
            String nomeSolicitante = solicitanteField.getText();
            String demanda = demandaField.getText();

            // Cria um novo objeto Chamado
            Classes.Chamado chamado = new Classes.Chamado();
            chamado.setSolicitante(nomeSolicitante);
            chamado.setDs_chamado(demanda);
            chamado.setSc_chamado("Aberto"); // Define o status inicial do chamado como "Aberto"

            // Usa ChamadoDAO para inserir o chamado no banco de dados
            ChamadoDAO chamadoDAO = new ChamadoDAO();
            chamadoDAO.cadastrarChamado(chamado);

            // Exibe uma mensagem de confirmação e fecha a janela
            JOptionPane.showMessageDialog(chamadoCliente, "Chamado cadastrado com sucesso!", "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
            Utility.mudarTelas(chamadoCliente, Client); // Fecha a janela atual após a confirmação
        });

        // Adicionando funcionalidade ao botão Cancelar
        cancelar.addActionListener(e -> Utility.mudarTelas(chamadoCliente, Client));
    }


    public static void verChamadoComponents(JFrame funcChamado, JFrame Func, JFrame respChamado) {
        funcChamado.setLayout(new GridLayout(2, 3, 65, 10));

        JLabel numQuarto = new JLabel("Solicitante: Marcelo Pastel 'C'");
        JLabel dsChamado = new JLabel("Descrição: Alguém pode mandar o serviço de quarto? Obrigado!");
        JLabel scChamado = new JLabel("Status: Aberto");

        JButton atender = new JButton("Atender chamado");
        JButton sair = new JButton("Sair");

        atender.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utility.mudarTelas(funcChamado, respChamado);
            }
        });
        sair.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utility.mudarTelas(funcChamado, Func);
            }
        });

        funcChamado.add(numQuarto);
        funcChamado.add(dsChamado);
        funcChamado.add(scChamado);
        funcChamado.add(atender);
        funcChamado.add(sair);
        funcChamado.pack();
    }

    public static void respChamadoComponents(JFrame respChamado, JFrame Funcionario) {
        // Define o layout da janela como um grid com 3 linhas e 3 colunas
        respChamado.setLayout(new GridLayout(3, 3, 65, 10));

        // Cria os componentes da interface gráfica
        JLabel label_responsavel = new JLabel("Funcionário responsável:");
        JTextField responsavel = new JTextField();

        JLabel sc_Chamado = new JLabel("Informe a situação do chamado:");
        JRadioButton execucao = new JRadioButton("Em execução", false);
        JRadioButton finalizado = new JRadioButton("Finalizado", false);

        // Grupo de botões para garantir que apenas um status seja selecionado
        ButtonGroup statusGroup = new ButtonGroup();
        statusGroup.add(execucao);
        statusGroup.add(finalizado);

        JButton confirmar = new JButton("Confirmar");
        JButton cancelar = new JButton("Cancelar");

        // Adiciona os componentes à janela
        respChamado.add(label_responsavel);
        respChamado.add(responsavel);
        respChamado.add(new JLabel("")); // Espaçamento
        respChamado.add(sc_Chamado);
        respChamado.add(execucao);
        respChamado.add(finalizado);
        respChamado.add(confirmar);
        respChamado.add(cancelar);

        // Adicionando funcionalidade ao botão Confirmar
        confirmar.addActionListener(e -> {
            // Captura as informações inseridas
            String funcionarioResponsavel = responsavel.getText();
            String situacaoChamado = execucao.isSelected() ? "Em execução" : "Finalizado";

            // Cria um novo objeto Chamado
            Classes.Chamado chamado = new Classes.Chamado();
            chamado.setFunc_resp(funcionarioResponsavel);
            chamado.setSc_chamado(situacaoChamado);

            // Atualiza o chamado no banco de dados
            ChamadoDAO chamadoDAO = new ChamadoDAO();
            chamadoDAO.atualizarChamado(chamado);

            // Exibe uma mensagem de confirmação e muda para a tela de Funcionário
            Utility.mudarTelas(respChamado, Funcionario);
            JOptionPane.showMessageDialog(respChamado, "Chamado atendido!", "Resposta adicionada ao chamado",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        // Adicionando funcionalidade ao botão Cancelar
        cancelar.addActionListener(e -> Utility.mudarTelas(respChamado, Funcionario));

        // Adicionando funcionalidade ao botão Cancelar
        cancelar.addActionListener(e -> Utility.mudarTelas(respChamado, Funcionario));
    }
}
