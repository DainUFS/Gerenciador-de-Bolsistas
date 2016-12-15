package br.ufs.dain.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;

public class TelaSobre extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	public TelaSobre() {
		
		setModal(true);
		setTitle("Sobre o sistema");
		setBounds(100, 100, 450, 434);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JLabel lblSistemaDesenvolvidoPelos = new JLabel("");
			lblSistemaDesenvolvidoPelos.setHorizontalAlignment(SwingConstants.CENTER);
			lblSistemaDesenvolvidoPelos.setIcon(new ImageIcon(TelaSobre.class.getResource("/br/ufs/dain/resources/logoDain.jpg")));
			contentPanel.add(lblSistemaDesenvolvidoPelos, BorderLayout.NORTH);
		}
		{
			JLabel lblSistemaDesenvolvidoPelos_1 = new JLabel("<html><body><p align=\"justify\">Sistema desenvolvido por Icaro ... e Murilo Almeida Formiga, alunos do curso de Ci\u00EAncia da Computa\u00E7\u00E3o da Universidade Federal de Sergipe. Sob o tema denominado No\u00E7\u00F5es de Acessibilidade do Programa de Aprendizagem e Desenvolvimento Profissional (Prodap).</p><p><br>S\u00E3o Crist\u00F3v\u00E3o, Sergipe. Dezembro de 2016.</p></body></html>");
			lblSistemaDesenvolvidoPelos_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblSistemaDesenvolvidoPelos_1.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblSistemaDesenvolvidoPelos_1, BorderLayout.CENTER);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
