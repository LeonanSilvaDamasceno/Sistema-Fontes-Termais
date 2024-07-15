package Swing;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Frame extends JFrame {
	public static void initializer() {
		JFrame Login = new JFrame("Pousada Naomi - Login");
		JFrame Signup = new JFrame("Pousada Naomi - Criar Conta");
		JFrame Cliente = new JFrame("Pousada Naomi - Menu cliente");
		JFrame Estadia = new JFrame("Pousada Naomi - Menu cliente - Verificação de estadia");
		JFrame Termas = new JFrame("Pousada Naomi - Menu cliente - Verificação de termas");
		JFrame add_Chamado = new JFrame("Pousada Naomi - Menu cliente - Adicionar chamado");
		JFrame Funcionario = new JFrame("Pousada Naomi - Administração");
		JFrame addFunc = new JFrame("Pousada Naomi - Administração - Adicionar funcionário");
		JFrame Quarto = new JFrame("Pousada Naomi - Administração - Verificação de quartos");
		JFrame resp_Chamado = new JFrame("Pousada Naomi - Administração - Responder chamado");
		JFrame func_Chamado = new JFrame("Pousada Naomi - Administração - Verificação de Chamados");
		JFrame CheckIn = new JFrame("Pousada Naomi - Administração - Check-In");
		JFrame CheckOut = new JFrame("Pousada Naomi - Administração - Check-Out");

		//Cliente methods
		frameStartup(Cliente);
		clientComponents(Cliente, Login, add_Chamado, Termas,Estadia);
		background("src/Imagens/Cliente.png", Cliente);

		//Fonte methods
		frameStartup(Termas);
		verTermas(Termas, Cliente);

		//Estadia methods
		frameStartup(Estadia);
		verTermas(Estadia, Cliente);

		//Funcionario methods
		frameStartup(Funcionario);
		funcComponents(Funcionario, Login, CheckIn, CheckOut, func_Chamado, Quarto, addFunc);
		background("src/Imagens/Funcionario.png", Funcionario);

		//Check-In methods
		frameStartup(CheckIn);
		checkinCliente(CheckIn, Funcionario);

		//Check-Out methods
		frameStartup(CheckOut);
		checkoutCliente(CheckOut, Funcionario);

		//Quarto methods
		frameStartup(Quarto);
		verQuarto(Quarto, Funcionario);

		//Signup methods
		frameStartup(Signup);
		signupLabels(Signup);
		signupComponents(Signup, Login);

		//addFunc methods
		frameStartup(addFunc);
		addFuncComponents(addFunc, Funcionario);
		addFuncLabels(addFunc);

		//Chamado methods
		frameStartup(resp_Chamado);
		frameStartup(func_Chamado);
		frameStartup(add_Chamado);
		acionarChamado(add_Chamado);
		verChamado(func_Chamado, Funcionario, resp_Chamado);
		respChamado(resp_Chamado, func_Chamado);

		//Login methods
		loginComponents(Login, Cliente, Funcionario, Signup);
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
	}

	public static void background (String imagem, JFrame frame){
		JLabel background;
		ImageIcon img_login = new ImageIcon(
				new ImageIcon(imagem).getImage().getScaledInstance(810, 596, Image.SCALE_DEFAULT));
		background = new JLabel("", img_login, JLabel.CENTER);
		background.setBounds(0, 0, 810, 596);
		frame.add(background);
	}

	public static void mudarTelas (JFrame ant, JFrame prox){
		ant.setVisible(false);
		prox.setVisible(true);
	}

	public static void loginComponents (JFrame Login, JFrame Cliente, JFrame Funcionario, JFrame Signup){
		JTextField email = new JTextField(50);
		JPasswordField senha = new JPasswordField(50);

		JButton login = new JButton("Entrar");
		JLabel sign_up = new JLabel("Clique aqui!"); // Funciona como um botão
		sign_up.setForeground(new Color(77,117,154));

		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (email.getText().equalsIgnoreCase("C"))
					mudarTelas(Login, Cliente);
				if (email.getText().equalsIgnoreCase("F"))
					mudarTelas(Login, Funcionario);
			}
		});

		sign_up.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mudarTelas(Login, Signup);
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
	}

	public static void funcComponents (JFrame Funcionario, JFrame Login, JFrame CheckIn,
									   JFrame CheckOut, JFrame Chamado, JFrame Quarto, JFrame addFunc){
		JLabel verQuartos = new JLabel("Verificar quartos");
		JLabel verChamado = new JLabel("Verificar chamados");
		JLabel Func = new JLabel("Adicionar funcionário");
		JLabel checkIn = new JLabel("Realizar Check-in");
		JLabel checkOut = new JLabel("Realizar Check-out");

		JButton logout = new JButton("Logout");

		funcDetails(Funcionario, verChamado,verQuartos, Func, checkIn, checkOut, logout);

		verChamado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mudarTelas(Funcionario, Chamado);
			}
		});
		verQuartos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mudarTelas(Funcionario, Quarto);
			}
		});
		Func.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mudarTelas(Funcionario, addFunc);
			}
		});
		checkIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mudarTelas(Funcionario, CheckIn);
			}
		});
		checkOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mudarTelas(Funcionario, CheckOut);
			}
		});
		logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mudarTelas(Funcionario, Login);
			}
		});
	}

	public static void funcDetails (JFrame Funcionario, JLabel verChamado, JLabel verQuartos, JLabel addFunc,
									JLabel checkIn, JLabel checkOut, JButton logout) {

		logout.setBackground(Color.white);

		verChamado.setFont(new Font("Times new Roman",Font.PLAIN,20));
		verQuartos.setFont(new Font("Times new Roman",Font.PLAIN,20));
		addFunc.setFont(new Font("Times new Roman",Font.PLAIN,20));
		checkIn.setFont(new Font("Times new Roman",Font.PLAIN,20));
		checkOut.setFont(new Font("Times new Roman",Font.PLAIN,20));

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

	public static void clientComponents (JFrame Cliente, JFrame Login, JFrame addChamado, JFrame Termas, JFrame Estadia){
		JLabel acionarServiço = new JLabel("Acionar serviço");
		JLabel verificarTermas = new JLabel("Verificar termas");
		JLabel verificarEstadia = new JLabel("Verificar estadia");

		JButton logout = new JButton("Logout");

		acionarServiço.setFont(new Font("Times new Roman",Font.PLAIN,20));
		verificarEstadia.setFont(new Font("Times new Roman",Font.PLAIN,20));
		verificarTermas.setFont(new Font("Times new Roman",Font.PLAIN,20));


		logout.setBackground(Color.white);

		acionarServiço.setBounds(120, 105, 200, 30);
		verificarTermas.setBounds(120, 205, 300, 30);
		verificarEstadia.setBounds(120, 305, 150, 30);
		logout.setBounds(120, 405, 150, 30);

		logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mudarTelas(Cliente, Login);
			}
		});
		acionarServiço.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mudarTelas(Cliente, addChamado);
			}
		});
		verificarEstadia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mudarTelas(Cliente, Estadia);
			}
		});
		verificarTermas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mudarTelas(Cliente, Termas);
			}
		});

		Cliente.add(acionarServiço);
		Cliente.add(verificarTermas);
		Cliente.add(verificarEstadia);
		Cliente.add(logout);
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
				mudarTelas(Signup, Login);
			}
		});
		confirmar.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				criarConta(nome.getText(), Integer.parseInt(cpf.getText()), email.getText(), senha.getPassword());
				mudarTelas(Signup,Login);
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

	public static void signupLabels (JFrame Signup){
		JLabel flavour1 = new JLabel("Cadastrar conta");
		JLabel flavour2 = new JLabel("Crie sua conta preenchendo os campos abaixo!");

		JLabel nome = new JLabel("Nome:");
		JLabel email = new JLabel("Email:");
		JLabel cpf = new JLabel("CPF:");
		JLabel senha = new JLabel("Senha:");

		flavour1.setFont(new Font("Times new Roman",Font.PLAIN,15));
		flavour2.setFont(new Font("Times new Roman",Font.PLAIN,13));
		nome.setFont(new Font("Times new Roman",Font.PLAIN,13));
		email.setFont(new Font("Times new Roman",Font.PLAIN,13));
		cpf.setFont(new Font("Times new Roman",Font.PLAIN,13));
		senha.setFont(new Font("Times new Roman",Font.PLAIN,13));


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

	public static void criarConta (String nome, int cpf, String email, char[] senha){
		JOptionPane.showMessageDialog(null, "Conta criada com êxito!",
				"Cadastro efetuado", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void addFuncComponents(JFrame addFunc, JFrame Funcionario) {
		addFunc.setSize(500, 800);

		JTextField nome = new JTextField();
		JTextField email = new JTextField();
		JTextField cpf = new JTextField();
		JTextField cargo = new JTextField();
		JTextField cgHoraria = new JTextField();
		JTextField salario = new JTextField();
		JPasswordField senha = new JPasswordField();

		JButton confirmar = new JButton("Confirmar");
		JButton cancelar = new JButton("Cancelar");

		cancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mudarTelas(addFunc, Funcionario);
			}
		});
		confirmar.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				adicionarFunc(nome.getText(), Integer.parseInt(cpf.getText()), email.getText(), cargo.getText(),
						Integer.parseInt(cgHoraria.getText()), Float.parseFloat(salario.getText()), senha.getPassword());
				mudarTelas(addFunc,Funcionario);
			}
		});

		nome.setBounds(120, 130, 230, 30);
		email.setBounds(120, 200, 230, 30);
		cpf.setBounds(120, 280, 230, 30);
		cgHoraria.setBounds(120, 360, 230, 30);
		salario.setBounds(120, 440, 230, 30);
		cargo.setBounds(120, 520, 230, 30);
		senha.setBounds(120, 600, 230, 30);
		confirmar.setBounds(120, 645, 95, 25);
		cancelar.setBounds(255, 645, 95, 25);

		addFunc.add(nome);
		addFunc.add(email);
		addFunc.add(cpf);
		addFunc.add(cargo);
		addFunc.add(cgHoraria);
		addFunc.add(salario);
		addFunc.add(senha);
		addFunc.add(confirmar);
		addFunc.add(cancelar);
	}

	public static void addFuncLabels (JFrame addFunc){
		JLabel flavour1 = new JLabel("Cadastrar conta");
		JLabel flavour2 = new JLabel("Crie sua conta preenchendo os campos abaixo!");

		JLabel nome = new JLabel("Nome:");
		JLabel email = new JLabel("Email:");
		JLabel cpf = new JLabel("CPF:");
		JLabel cargo = new JLabel("Cargo:");
		JLabel cgHoraria = new JLabel("Carga horária semanal:");
		JLabel salario = new JLabel("Salário mensal:");
		JLabel senha = new JLabel("Senha:");

		flavour1.setFont(new Font("Times new Roman",Font.PLAIN,15));
		flavour2.setFont(new Font("Times new Roman",Font.PLAIN,13));
		nome.setFont(new Font("Times new Roman",Font.PLAIN,13));
		email.setFont(new Font("Times new Roman",Font.PLAIN,13));
		cpf.setFont(new Font("Times new Roman",Font.PLAIN,13));
		cargo.setFont(new Font("Times new Roman",Font.PLAIN,13));
		cgHoraria.setFont(new Font("Times new Roman",Font.PLAIN,13));
		salario.setFont(new Font("Times new Roman",Font.PLAIN,13));
		senha.setFont(new Font("Times new Roman",Font.PLAIN,13));

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

	public static void adicionarFunc (String nome, int cpf, String email, String cargo,
									  int cgHoraria, float salario, char[] senha){
		JOptionPane.showMessageDialog(null, "Funcionário adicionado com êxito!",
				"Cadastro efetuado", JOptionPane.INFORMATION_MESSAGE);
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
				mudarTelas(checkIn, Func);
				JOptionPane.showMessageDialog(null, "Check-In efetuado com êxito!",
						"Check-In registrado", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		cancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mudarTelas(checkIn, Func);
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
				mudarTelas(checkOut, Func);
				JOptionPane.showMessageDialog(null, "Check-Out efetuado com êxito!",
						"Solicitação de Check-out homologada", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		cancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mudarTelas(checkOut, Func);
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
				mudarTelas(Quarto, Func);
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

	public static void verChamado(JFrame funcChamado, JFrame Func, JFrame respChamado) {
		funcChamado.setLayout(new GridLayout(2, 3, 65, 10));

		JLabel numQuarto = new JLabel("Solicitante: Marcelo Pastel 'C'");
		JLabel dsChamado = new JLabel("Descrição: Alguém pode mandar o serviço de quarto? Obrigado!");
		JLabel scChamado = new JLabel("Status: Aberto");

		JButton atender = new JButton("Atender chamado");
		JButton sair = new JButton("Sair");

		atender.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mudarTelas(funcChamado, respChamado);
			}
		});
		sair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mudarTelas(funcChamado, Func);
			}
		});

		funcChamado.add(numQuarto);
		funcChamado.add(dsChamado);
		funcChamado.add(scChamado);
		funcChamado.add(atender);
		funcChamado.add(new JLabel(""));
		funcChamado.add(sair);

		funcChamado.pack();
	}

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
				mudarTelas(Estadia, Cliente);
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


	public static void verTermas (JFrame Termas, JFrame Cliente) {
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
				mudarTelas(Termas, Cliente);
			}
		});

		Termas.add(codFonte);
		Termas.add(qtdPessoas);
		Termas.add(pesquisar);
		Termas.add(sair);
		Termas.pack();
	}


	public static void acionarChamado(JFrame chamadoCliente) {
		chamadoCliente.setLayout(new GridLayout(0, 1, 65, 10));

		JTextField demandaField = new JTextField();
		JButton confirmar = new JButton("Confirmar");
		JButton cancelar = new JButton("Cancelar");

		// Adicionando os componentes na ordem correta
		chamadoCliente.add(new JLabel("Demanda:"));
		chamadoCliente.add(demandaField);
		chamadoCliente.add(new JLabel("")); //Pulando uma linha pra ficar um espaçamento entre o JTextField e o
									// botão de confirmar
		chamadoCliente.add(confirmar);
		chamadoCliente.add(cancelar);

		// Adicionando funcionalidade ao botão
		confirmar.addActionListener(e -> {
            String demanda = demandaField.getText();
            JOptionPane.showMessageDialog(chamadoCliente, "Demanda recebida: " + demanda);
        });
	}
	public static void respChamado(JFrame respChamado, JFrame Funcionario) {
		respChamado.setLayout(new GridLayout(3, 3, 65, 10));

		JLabel label_responsavel = new JLabel("Funcionário responsável:");
		JTextField responsavel = new JTextField();

		JLabel sc_Chamado = new JLabel("Informe a situação do chamado:");
		JRadioButton execucao = new JRadioButton ("Em execução", false);
		JRadioButton finalizado = new JRadioButton ("Finalizado", false);


		JButton confirmar = new JButton("Confirmar");
		JButton cancelar = new JButton("Cancelar");

		respChamado.add(label_responsavel);
		respChamado.add(responsavel);
		respChamado.add(new JLabel(""));
		respChamado.add(sc_Chamado);
		respChamado.add(execucao);
		respChamado.add(finalizado);
		respChamado.add(confirmar);
		respChamado.add(cancelar);

		confirmar.addActionListener(e -> {
			mudarTelas(respChamado, Funcionario);
			JOptionPane.showMessageDialog(respChamado, "Chamado atendido!", "Resposta adicionada ao chamado",
					JOptionPane.INFORMATION_MESSAGE);
		});
		cancelar.addActionListener(e -> {
			mudarTelas(respChamado, Funcionario);
		});
	}
}
