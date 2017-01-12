package br.ufs.dain.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufs.dain.dao.DAO;
import br.ufs.dain.modelo.Administrador;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Choice;

public class TelaMinhaConta extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldEmail;
	private JTextField textFieldMatricula;
	private JTextField textFieldTelefone;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMinhaConta frame = new TelaMinhaConta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public TelaMinhaConta(Administrador adm) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 781, 378);
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
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(102, 95, 653, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		textFieldNome.setText(adm.getNome());
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(29, 148, 46, 14);
		contentPane.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(102, 147, 314, 20);
		textFieldEmail.setText(adm.getEmail());
		contentPane.add(textFieldEmail);
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMatricula.setBounds(29, 202, 66, 14);
		contentPane.add(lblMatricula);
		
		textFieldMatricula = new JTextField();
		textFieldMatricula.setColumns(10);
		textFieldMatricula.setBounds(102, 201, 212, 20);
		textFieldMatricula.setText(adm.getMatricula());
		contentPane.add(textFieldMatricula);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStatus.setBounds(338, 202, 46, 14);
		contentPane.add(lblStatus);
		
		JRadioButton rdbtnAtivo = new JRadioButton("Ativo");
		rdbtnAtivo.setBounds(405, 186, 73, 50);
		contentPane.add(rdbtnAtivo);
		if(adm.getStatusAtivacao() == 1) rdbtnAtivo.setSelected(true);
		
		JRadioButton rdbtnNoAtivo = new JRadioButton("N\u00E3o Ativo");
		rdbtnNoAtivo.setBounds(488, 186, 99, 50);
		contentPane.add(rdbtnNoAtivo);
		if(adm.getStatusAtivacao() == 0) rdbtnAtivo.setSelected(true);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefone.setBounds(443, 150, 60, 14);
		contentPane.add(lblTelefone);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(508, 147, 247, 20);
		textFieldTelefone.setText(adm.getTelefone());
		contentPane.add(textFieldTelefone);
		
		JButton btnNewButton = new JButton("Mudar Senha");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMudarSenha mudarSenha = new TelaMudarSenha(adm);
				mudarSenha.setLocationRelativeTo(null);
				mudarSenha.setVisible(true);
			}
		});
		btnNewButton.setBounds(206, 281, 138, 23);
		contentPane.add(btnNewButton);
		
		JButton btnEditarDados = new JButton("Salvar Dados");
		btnEditarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAO dao = new DAO();
				dao.atualizarDados(
						new Administrador(textFieldTelefone.getText().toString(), 
								textFieldEmail.getText().toString(), 
								textFieldNome.getText().toString(), 
								textFieldMatricula.getText().toString(), 
								adm.getSenha(), adm.getStatusAtivacao()), adm.getMatricula());
				
				JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
			}
			
		});
		
		textFieldEmail.setText(adm.getEmail().toString());
		textFieldTelefone.setText(adm.getTelefone().toString());
		textFieldNome.setText(adm.getNome().toString());
		textFieldMatricula.setText(adm.getMatricula().toString());
		btnEditarDados.setBounds(443, 281, 138, 23);
		contentPane.add(btnEditarDados);
	}
}
