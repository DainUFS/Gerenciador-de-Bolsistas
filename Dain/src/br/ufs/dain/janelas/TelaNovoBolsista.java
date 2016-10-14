package br.ufs.dain.janelas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class TelaNovoBolsista extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaNovoBolsista dialog = new TelaNovoBolsista();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaNovoBolsista() {
		setTitle("Novo Bolsista");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(2, 1, 0, 0));
		{
			JLabel lblCadastreUmNovo = new JLabel("Cadastre um novo bolsista");
			lblCadastreUmNovo.setFont(new Font("Tahoma", Font.PLAIN, 18));
			contentPanel.add(lblCadastreUmNovo);
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(new GridLayout(3, 1, 0, 0));
			{
				JLabel lblNome = new JLabel("Nome:");
				panel.add(lblNome);
			}
			{
				textField = new JTextField();
				textField.setToolTipText("Digite o nome do novo bolsista");
				panel.add(textField);
				textField.setColumns(30);
			}
			{
				JLabel lblMatrcula = new JLabel("Matr\u00EDcula:");
				panel.add(lblMatrcula);
			}
			{
				textField_1 = new JTextField();
				panel.add(textField_1);
				textField_1.setColumns(15);
			}
			{
				JLabel lblTelefone = new JLabel("Telefone:");
				panel.add(lblTelefone);
			}
			{
				textField_2 = new JTextField();
				panel.add(textField_2);
				textField_2.setColumns(10);
			}
			{
				JLabel lblEmail = new JLabel("E-mail:");
				panel.add(lblEmail);
			}
			{
				textField_3 = new JTextField();
				panel.add(textField_3);
				textField_3.setColumns(10);
			}
			{
				JLabel label = new JLabel("");
				panel.add(label);
			}
			{
				JLabel label = new JLabel("");
				panel.add(label);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
