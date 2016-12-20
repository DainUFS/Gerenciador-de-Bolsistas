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
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class TelaSobre extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	public TelaSobre() {
		setResizable(false);

		setModal(true);
		setTitle("Sobre o sistema");
		setBounds(100, 100, 450, 480);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout(0, 0));
			{
				JLabel lblSistemaDesenvolvidoPelos = new JLabel("");
				panel.add(lblSistemaDesenvolvidoPelos, BorderLayout.NORTH);
				lblSistemaDesenvolvidoPelos.setHorizontalAlignment(SwingConstants.CENTER);
				lblSistemaDesenvolvidoPelos.setIcon(new ImageIcon(TelaSobre.class.getResource("/com/sun/java/swing/plaf/motif/icons/DesktopIcon.gif")));
			}
			{
				JLabel lblSistemaDesenvolvidoPelos_1 = new JLabel("<html><body align=\"justify\"><p>Sistema desenvolvido por Icaro ... e Murilo Almeida Formiga, alunos do curso de Ci\u00EAncia da Computa\u00E7\u00E3o da Universidade Federal de Sergipe. Sob o tema denominado No\u00E7\u00F5es de Acessibilidade do Programa de Aprendizagem e Desenvolvimento Profissional (Prodap).</p><p><br>S\u00E3o Crist\u00F3v\u00E3o, Sergipe. Dezembro de 2016.</p>\r\n\r\n<p>O DAIN - SGBA (DAIN - Sistema de Gerenciamento de Bolsistas e Assistentes ) \u00E9 o sistema que tem o objetivo de realizar cadastro, consultas e atualiza\u00E7\u00E3o de dados (pessoais e universit\u00E1rio) dos bolsistas e assistentes em que o setor Divis\u00E3o de A\u00E7\u00F5es Inclusivas trabalha - DAIN.</p>\r\n\t<p>O sistema tamb\u00E9m conta com os dados dos Administradores. S\u00E3o eles os respons\u00E1veis por cadastrar, consultar e atualizar os dados dos bolsistas e assistentes. Somente eles t\u00EAm acesso ao sistema com uso de um usu\u00E1rio e senha.</p>\r\n\t<p>Os Dados do Sistema s\u00E3o armazenados no Banco de Dados e fica sobre a prote\u00E7\u00E3o da DAIN.</p></body></html>");
				panel.add(lblSistemaDesenvolvidoPelos_1);
				lblSistemaDesenvolvidoPelos_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblSistemaDesenvolvidoPelos_1.setHorizontalAlignment(SwingConstants.CENTER);
			}
			JScrollPane scrollPane = new JScrollPane(panel);
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			contentPanel.add(scrollPane, BorderLayout.CENTER);
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
