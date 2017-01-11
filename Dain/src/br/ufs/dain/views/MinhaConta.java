package br.ufs.dain.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JButton;

public class MinhaConta extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MinhaConta frame = new MinhaConta();
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
	public MinhaConta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 781, 582);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Minha Conta");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(296, 11, 170, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(29, 96, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(102, 95, 653, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(29, 148, 46, 14);
		contentPane.add(lblEmail);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(102, 147, 314, 20);
		contentPane.add(textField_1);
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMatricula.setBounds(29, 202, 66, 14);
		contentPane.add(lblMatricula);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(102, 201, 212, 20);
		contentPane.add(textField_2);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStatus.setBounds(338, 202, 46, 14);
		contentPane.add(lblStatus);
		
		JRadioButton rdbtnAtivo = new JRadioButton("Ativo");
		rdbtnAtivo.setBounds(405, 186, 73, 50);
		contentPane.add(rdbtnAtivo);
		
		JRadioButton rdbtnNoAtivo = new JRadioButton("N\u00E3o Ativo");
		rdbtnNoAtivo.setBounds(488, 186, 99, 50);
		contentPane.add(rdbtnNoAtivo);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefone.setBounds(443, 150, 60, 14);
		contentPane.add(lblTelefone);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(508, 147, 247, 20);
		contentPane.add(textField_3);
		
		JLabel lblAlterarSenha = new JLabel("Alterar Senha:");
		lblAlterarSenha.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAlterarSenha.setBounds(29, 296, 127, 14);
		contentPane.add(lblAlterarSenha);
		
		JLabel lblSenhaAtual = new JLabel("Senha Atual:");
		lblSenhaAtual.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenhaAtual.setBounds(29, 359, 93, 14);
		contentPane.add(lblSenhaAtual);
		
		JLabel lblNovaSenha = new JLabel("Nova Senha:");
		lblNovaSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNovaSenha.setBounds(381, 359, 93, 14);
		contentPane.add(lblNovaSenha);
		
		JLabel lblRepetirNovaSenha = new JLabel("Repetir Nova Senha:");
		lblRepetirNovaSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRepetirNovaSenha.setBounds(33, 419, 138, 14);
		contentPane.add(lblRepetirNovaSenha);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(129, 358, 212, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(488, 358, 212, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(181, 418, 212, 20);
		contentPane.add(textField_6);
		
		JButton btnNewButton = new JButton("Alterar Senha");
		btnNewButton.setBounds(478, 417, 155, 23);
		contentPane.add(btnNewButton);
		
		JButton btnEditarMeusDados = new JButton("Editar Meus Dados");
		btnEditarMeusDados.setBounds(221, 249, 161, 23);
		contentPane.add(btnEditarMeusDados);
	}
}
