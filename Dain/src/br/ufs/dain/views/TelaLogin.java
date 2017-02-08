package br.ufs.dain.views;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Insets;

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
import br.ufs.dain.modelo.Nota;

import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class TelaLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	private String matricula;
	private String senha;
	private JTextField textFieldUser;
	private JLabel label;
	private JLabel lblX;
	private JPasswordField passwordField;
	private JButton btnX;
	

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/br/ufs/dain/resources/logoDainIcone.png")));
		setResizable(false);
		setUndecorated(true);
		
		setTitle("Entrar no Sistema");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldUser = new JTextField();
		textFieldUser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					logar();
				}
			}
		});
		textFieldUser.setBounds(250, 132, 135, 28);
		contentPane.add(textFieldUser);
		textFieldUser.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					logar();
				}
			}
		});
		passwordField.setBounds(250, 171, 135, 28);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logar();
			}
		});
        btnNewButton.setMargin(new Insets(0, 0, 0, 0));
        btnNewButton.setContentAreaFilled(false);
        btnNewButton.setBorderPainted(false);
        btnNewButton.setOpaque(false);
		btnNewButton.setBounds(224, 205, 95, 33);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnNewButton);
		
		btnX = new JButton("X");
		btnX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnX.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnX.setForeground(Color.BLACK);
			}
		});
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					System.exit(0);
			}
		});
		btnX.setFont(new Font("Century Gothic", Font.BOLD, 25));
		btnX.setMargin(new Insets(0, 0, 0, 0));
        btnX.setContentAreaFilled(false);
        btnX.setBorderPainted(false);
        btnX.setOpaque(false);
		btnX.setBounds(481, 0, 28, 19);
		btnX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnX.setBounds(471, 11, 46, 33);
		contentPane.add(btnX);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(TelaLogin.class.getResource("/br/ufs/dain/resources/dainLogin.png")));
		lblNewLabel_2.setBounds(0, 0, 527, 367);
		contentPane.add(lblNewLabel_2);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textFieldUser, passwordField, btnNewButton, btnX}));
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textFieldUser, passwordField, btnNewButton, btnX}));
	}
	
	private void logar () {
		matricula = textFieldUser.getText().toString();
		senha = passwordField.getText().toString();
		
		try {
			if(new GerenciadorLogin().validarSenha(matricula, senha)) {
				dispose();
				new TelaPrincipal(new DAO().buscarAdm(matricula, senha)).setVisible(true);
				
				ArrayList<Nota> notas = new DAO().TodasAsNota();
				
				if(notas.size() > 0){
					TelaTodasNotas ttn = new TelaTodasNotas();
					ttn.setLocationRelativeTo(null);
					ttn.setVisible(true);
				}
				
			} else {
				JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválidos.");
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Não foi possivel a conectar ao banco de dados.");
			e1.printStackTrace();
		}
	}
}
