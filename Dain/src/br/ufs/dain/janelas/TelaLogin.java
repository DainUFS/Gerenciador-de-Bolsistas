package br.ufs.dain.janelas;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import br.ufs.dain.dao.DAO;
import br.ufs.dain.dominio.Login;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField_user;
	private JTextField textField_pass;
	DAO dao = new DAO();
	Login login;
	boolean bool;
	String s1, s2;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Usu\u00E1rio");
		contentPane.add(lblNewLabel);
		
		textField_user = new JTextField();
		contentPane.add(textField_user);
		textField_user.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		contentPane.add(lblNewLabel_1);
		
		textField_pass = new JTextField();
		contentPane.add(textField_pass);
		textField_pass.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				s1 = textField_user.getText().toString();
				s2 = textField_pass.getText().toString();
				login = new Login(s1, s2);
				bool = dao.validarLogin(login);
				if (bool == true) {
					System.out.println("ENTROU!");
					new TelaPrincipal().setVisible(true);
				} else {
					System.out.println("NÃO ENTROU!");
				}
			
			}	
		});

		
		
		
		
		contentPane.add(btnNewButton);
		
	}

}
