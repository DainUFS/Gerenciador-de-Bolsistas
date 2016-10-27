package br.ufs.dain.janelas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaNovoBolsista extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaNovoBolsista dialog = new TelaNovoBolsista();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaNovoBolsista() {
		setResizable(false);
		setTitle("Adicionar ou Editar Bolsista");
		setBounds(100, 100, 450, 400);
		BorderLayout borderLayout = new BorderLayout();
		getContentPane().setLayout(borderLayout);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		contentPanel.setLayout(new GridLayout(2, 1, 0, 0));
		{
			JLabel lblCadastreUmNovo = new JLabel("Cadastre um novo bolsista");
			lblCadastreUmNovo.setHorizontalAlignment(SwingConstants.CENTER);
			lblCadastreUmNovo.setFont(new Font("Tahoma", Font.PLAIN, 18));
			contentPanel.add(lblCadastreUmNovo);
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1, BorderLayout.CENTER);
				panel_1.setLayout(new GridLayout(5, 2, 10, 10));
				{
					JLabel label = new JLabel("Nome:");
					panel_1.add(label);
				}
				{
					textField = new JTextField();
					textField.setToolTipText("Digite o nome do novo bolsista");
					textField.setColumns(30);
					panel_1.add(textField);
				}
				{
					JLabel label = new JLabel("Matr\u00EDcula:");
					panel_1.add(label);
				}
				{
					textField_1 = new JTextField();
					textField_1.setColumns(15);
					panel_1.add(textField_1);
				}
				{
					JLabel label = new JLabel("Telefone:");
					panel_1.add(label);
				}
				{
					textField_2 = new JTextField();
					textField_2.setColumns(10);
					panel_1.add(textField_2);
				}
				{
					JLabel label = new JLabel("E-mail:");
					panel_1.add(label);
				}
				{
					textField_3 = new JTextField();
					textField_3.setColumns(10);
					panel_1.add(textField_3);
				}
				{
					JLabel label = new JLabel("Curso:");
					panel_1.add(label);
				}
				{
					textField_4 = new JTextField();
					textField_4.setColumns(10);
					panel_1.add(textField_4);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1, BorderLayout.SOUTH);
				{
					JLabel lblSexo = new JLabel("Sexo:");
					panel_1.add(lblSexo);
				}
				{
					ButtonGroup buttonGroup = new ButtonGroup();

					JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
					panel_1.add(rdbtnMasculino);

					JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
					panel_1.add(rdbtnFeminino);

					buttonGroup.add(rdbtnMasculino);
					buttonGroup.add(rdbtnFeminino);
				}
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
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancelar");
				buttonPane.add(cancelButton);
			}
		}
	}
}