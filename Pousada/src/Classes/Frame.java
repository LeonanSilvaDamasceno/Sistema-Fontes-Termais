package Classes;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Frame extends JFrame {
	public static void login(String[] args) {

		JFrame Cliente = new JFrame("Pousada Naomi - Menu cliente");
		frameStartup(Cliente);
		background("src/Imagens/Cliente.png", Cliente);

		JFrame Funcionario = new JFrame("Pousada Naomi - Administração");
		frameStartup(Funcionario);
		background("src/Imagens/Funcionario.png", Funcionario);

		JFrame Login = new JFrame("Login");
		loginComponents(Login, Cliente, Funcionario);
		frameStartup(Login);
		labelsLogin(Login);
		background("src/Imagens/Login.png", Login);
		Login.setVisible(true);
	}

	public static void frameStartup(JFrame frame) {
		frame.setSize(810, 600);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

	} // Inicializa todos com os mesmos parâmetros!

	public static void background(String imagem, JFrame frame) {
		JLabel background;
		ImageIcon img_login = new ImageIcon(
				new ImageIcon(imagem).getImage().getScaledInstance(810, 596, Image.SCALE_DEFAULT));
		background = new JLabel("", img_login, JLabel.CENTER);
		background.setBounds(0, 0, 810, 596);
		frame.add(background);
	} // Usado em telas diferentes mudando o caminho da imagem

	public static void loginComponents(JFrame Login, JFrame Cliente, JFrame Funcionario) {
		JTextField email = new JTextField(50); // Quer deixar um texto salvo para a inicialização? Use "("insira texto
												// aqui", 50)" como parâmetro
		JPasswordField senha = new JPasswordField(50);

		JButton login = new JButton("Entrar");

		JLabel sign_up = new JLabel("Clique aqui!"); // Funciona como um botão! Pode ser configurado como abaixo

		sign_up.setForeground(Color.cyan);

		login.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (email.getText().equalsIgnoreCase("C"))
					mudarTelas(Login, Cliente);
				if (email.getText().equalsIgnoreCase("F"))
					mudarTelas(Login, Funcionario);
			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});

		email.setBounds(130, 230, 150, 30);
		senha.setBounds(130, 310, 150, 30);

		login.setBounds(130, 365, 150, 25);
		sign_up.setBounds(210, 395, 75, 30);

		Login.add(login);
		Login.add(sign_up);

		Login.add(email);
		Login.add(senha);
	} // Bons e velhos butões, outros frames para fazer o links!

	public static void fieldsLogin(JFrame frame) {

	} // JTextFields && JPasswordFields

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

	public static void mudarTelas(JFrame ant, JFrame prox) {
		ant.setVisible(false);
		prox.setVisible(true);
	}

	public static void cadastroCliente() {
		
		// Construção do JFrame
		JFrame frame = new JFrame("Cadastro do Cliente");
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		// Definindo como sera o layout
		frame.setLayout(new GridLayout(0, 2, 65, 10));
		// O primeiro numero representa as linhas no frame, já que está em '0' o layout
		// ajusta automaticamente o número de linhas com base na quantidade de
		// componentes adicionados
		// o segundo numero representa as colunas que no caso são 2 colunas
		// o terceiro numero representa o espaçamento horizontal entre as colunas.
		// o quarto numero representa o espaçamento vertical entre as linhas, se mudar esse valor para '0' vai ficar muito proximo uma linha da outra.

		JLabel nome = new JLabel("Nome:");
		JTextField nomeField = new JTextField();

		JLabel cpf = new JLabel("CPF:");
		JTextField cpfField = new JTextField();

		JLabel email = new JLabel("Email:");
		JTextField emailField = new JTextField();

		JLabel numQuarto = new JLabel("Numero do quarto:");
		JTextField numQuartoField = new JTextField();

		JLabel tempEstadia = new JLabel("Tempo de estadia:");
		JTextField tempEstadiaField = new JTextField();

		JLabel checkIn = new JLabel("Check-in:");
		JTextField checkInField = new JTextField();

		JLabel checkOut = new JLabel("Check-out:");
		JTextField checkOutField = new JTextField();

		JButton confirmButton = new JButton("Confirmar");
		JButton cancelButton = new JButton("Cancelar");

		// Adicionando componentes ao frame
		frame.add(nome);
		frame.add(nomeField);
		frame.add(cpf);
		frame.add(cpfField);
		frame.add(email);
		frame.add(emailField);
		frame.add(numQuarto);
		frame.add(numQuartoField);
		frame.add(tempEstadia);
		frame.add(tempEstadiaField);
		frame.add(checkIn);
		frame.add(checkInField);
		
		//Deixei a parte do check-out como comentario caso seja necessario coloca-lo de volta
		
		/*
		 * frame.add(checkOut); frame.add(checkOutField);
		 */
		
		//Adicionando os botões no frame
		frame.add(confirmButton);
		frame.add(cancelButton);
		
		//Não tirar esse comando, sem ele não redimenciona corretamente o frame quando muda o tamanho da janela do frame.
		frame.pack();
	}
}
