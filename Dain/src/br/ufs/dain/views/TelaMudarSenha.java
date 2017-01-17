package br.ufs.dain.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufs.dain.dao.DAO;
import br.ufs.dain.modelo.Administrador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaMudarSenha extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSenhaAtual;
	private JTextField textFieldNovaSenha;
	private JTextField textFieldRepetir;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMudarSenha frame = new TelaMudarSenha();
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
	public TelaMudarSenha(Administrador adm) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAlterarASenha = new JLabel("Alterar a Senha");
		lblAlterarASenha.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAlterarASenha.setBounds(152, 11, 142, 38);
		contentPane.add(lblAlterarASenha);
		
		JLabel lblSenhaAtual = new JLabel("Senha Atual:");
		lblSenhaAtual.setBounds(22, 69, 104, 14);
		contentPane.add(lblSenhaAtual);
		
		textFieldSenhaAtual = new JTextField();
		textFieldSenhaAtual.setBounds(131, 66, 188, 20);
		contentPane.add(textFieldSenhaAtual);
		textFieldSenhaAtual.setColumns(10);
		
		JLabel lblNovaSenha = new JLabel("Nova Senha:");
		lblNovaSenha.setBounds(22, 111, 104, 14);
		contentPane.add(lblNovaSenha);
		
		textFieldNovaSenha = new JTextField();
		textFieldNovaSenha.setColumns(10);
		textFieldNovaSenha.setBounds(131, 108, 188, 20);
		contentPane.add(textFieldNovaSenha);
		
		JLabel lblRepetirNovaSenha = new JLabel("Repetir Nova Senha:");
		lblRepetirNovaSenha.setBounds(22, 158, 142, 14);
		contentPane.add(lblRepetirNovaSenha);
		
		textFieldRepetir = new JTextField();
		textFieldRepetir.setColumns(10);
		textFieldRepetir.setBounds(174, 155, 188, 20);
		contentPane.add(textFieldRepetir);
		
		JButton btnSalvarSenha = new JButton("Salvar ");
		btnSalvarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(adm.getSenha().toString().equals(textFieldSenhaAtual.getText().toString())){
					if(textFieldNovaSenha.getText().toString().equals(
							textFieldRepetir.getText().toString()) && !textFieldNovaSenha.getText().toString().equals("")){
							DAO dao = new DAO();
							dao.mudarSenha(adm, textFieldNovaSenha.getText().toString());
							JOptionPane.showMessageDialog(null, "Nova Senha Salva com Sucesso!");
							dispose();
					}else{
						JOptionPane.showMessageDialog(null, "Senha Nova não Altenticada! ");
					}
				}else{
					JOptionPane.showMessageDialog(null, "Senha Atual não Confere!");
				}
			}
		});
		btnSalvarSenha.setBounds(54, 216, 114, 23);
		contentPane.add(btnSalvarSenha);
		
		JButton btnCancelar = new JButton("Cancelar ");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(205, 216, 114, 23);
		contentPane.add(btnCancelar);
	}
}
