package br.ufs.dain.views;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import br.ufs.dain.dao.DAO;
import br.ufs.dain.gerenciador.GerenciadorLogin;
import br.ufs.dain.modelo.Administrador;
import br.ufs.dain.modelo.Login;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class TelaLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	private JTextField textField_user;
	private JTextField textField_pass;

	private String matricula;
	private String senha;
	
	private JPanel panel;
	private JPanel panel_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		//setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/br/ufs/dain/resources/logoDain.jpg")));
		
		setTitle("Entrar no Sistema");
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 2, 0, 0));
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.add(panel);
		panel.setLayout(new GridLayout(2, 2, 0, 5));
		
		JLabel lblNewLabel = new JLabel("Matr\u00EDcula");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		textField_user = new JTextField();
		panel.add(textField_user);
		textField_user.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		textField_pass = new JTextField();
		panel.add(textField_pass);
		textField_pass.setColumns(10);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(3, 1, 0, 0));
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				matricula = textField_user.getText().toString();
				senha = textField_pass.getText().toString();
				
				try {
					if(new GerenciadorLogin().validarSenha(matricula, senha)) {
						dispose();
						new TelaPrincipal(new DAO().buscarAdm(matricula, senha)).setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválidos.");
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possivel a conectar ao banco de dados.");
					e1.printStackTrace();
				}
			}
		});
		panel_1.add(btnNewButton);
				
	}

}
