package br.ufs.dain.views;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import br.ufs.dain.dao.DAO;
import br.ufs.dain.modelo.Administrador;
import br.ufs.dain.modelo.Login;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField textField_user;
	private JTextField textField_pass;
	DAO dao = new DAO();
	Login login;
	boolean bool;
	String s1, s2;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblEsqueceuSuaSenha;
	//
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
		
		JLabel lblNewLabel = new JLabel("Usu\u00E1rio");
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
		
		JButton btnNewButton = new JButton("New button");
		panel_1.add(btnNewButton);
		
		lblEsqueceuSuaSenha = new JLabel("Esqueceu sua senha?");
		lblEsqueceuSuaSenha.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblEsqueceuSuaSenha);
		
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				s1 = textField_user.getText().toString();
				s2 = textField_pass.getText().toString();
				login = new Login(s1, s2);
				bool = dao.validarLogin(login);
				if (bool == true) {
					System.out.println("ENTROU!");
					dispose();
					
					Administrador adm = new DAO().buscarAdm(s1, s2);
					
					TelaPrincipal telaPrincipal = new TelaPrincipal(adm);
					//telaPrincipal.setExtendedState(MAXIMIZED_BOTH);
					telaPrincipal.setVisible(true);
					
				} else {
					System.out.println("NÃO ENTROU!");
				}
			
			}	
		});
		
	}

}
