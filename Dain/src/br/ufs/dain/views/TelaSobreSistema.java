package br.ufs.dain.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TelaSobreSistema extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSobreSistema frame = new TelaSobreSistema();
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
	public TelaSobreSistema() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSobreOSistema = new JLabel("Sobre o Sistema");
		lblSobreOSistema.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSobreOSistema.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblSobreOSistema, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblODain = new JLabel("\tO DAIN - SGBA (DAIN - Sistema de Gerenciamento de Bolsistas e Assistentes ) \u00E9 o sistema que tem o objetivo de realizar cadastro, consultas e atualiza\u00E7\u00E3o de dados (pessoais e universit\u00E1rio) dos bolsistas e assistentes em que o setor Divis\u00E3o de A\u00E7\u00F5es Inclusivas trabalha - DAIN.\r\n\tO sistema tamb\u00E9m conta com os dados dos Administradores. S\u00E3o eles os respons\u00E1veis por cadastrar, consultar e atualizar os dados dos bolsistas e assistentes. Somente eles t\u00EAm acesso ao sistema com uso de um usu\u00E1rio e senha.\r\n\tOs Dados do Sistema s\u00E3o armazenados no Banco de Dados e fica sobre a prote\u00E7\u00E3o do \r\nDAIN.\r\n");
		panel_1.add(lblODain, BorderLayout.NORTH);
	}

}
