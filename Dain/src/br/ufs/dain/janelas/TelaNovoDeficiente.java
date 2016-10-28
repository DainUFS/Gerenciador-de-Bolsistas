package br.ufs.dain.janelas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class TelaNovoDeficiente extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaNovoDeficiente dialog = new TelaNovoDeficiente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaNovoDeficiente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Murilo\\Documents\\GitHub\\Gerenciador-de-Bolsistas\\Dain\\img\\icon\\icone_deficiente.png"));
		setResizable(false);
		setTitle("Adicionar Deficiente");
		setBounds(100, 100, 350, 500);
		BorderLayout borderLayout = new BorderLayout();
		getContentPane().setLayout(borderLayout);
		contentPanel.setBorder(new EmptyBorder(5, 5, 10, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new EmptyBorder(0, 0, 0, 0));
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lblCadastreUmNovo = new JLabel("Cadastre um novo deficiente");
				panel.add(lblCadastreUmNovo);
				lblCadastreUmNovo.setHorizontalAlignment(SwingConstants.CENTER);
				lblCadastreUmNovo.setFont(new Font("Tahoma", Font.PLAIN, 18));
			}
		}
		JPanel panel = new JPanel();
		contentPanel.add(panel, BorderLayout.CENTER);
		panel.setBorder(new EmptyBorder(8, 0, 0, 0));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informa\u00E7\u00F5es pessoais", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.add(panel_1_2);
		panel_1_2.setLayout(new GridLayout(9, 1, 0, 0));
		{
			JLabel label = new JLabel("Nome:");
			panel_1_2.add(label);
		}
		{
			textField = new JTextField();
			textField.setToolTipText("Digite o nome do novo bolsista");
			textField.setColumns(30);
			panel_1_2.add(textField);
		}
		{
			JLabel label = new JLabel("Matr\u00EDcula:");
			panel_1_2.add(label);
		}
		{
			textField_1 = new JTextField();
			textField_1.setColumns(15);
			panel_1_2.add(textField_1);
		}
		{
			JLabel label = new JLabel("Curso:");
			panel_1_2.add(label);
		}
		{
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			panel_1_2.add(textField_4);
		}
		JPanel panel_1_1 = new JPanel();
		panel_1_2.add(panel_1_1);
		panel_1_1.setLayout(new GridLayout(0, 3, 0, 0));
		{
			JLabel lblSexo = new JLabel("Sexo:");
			panel_1_1.add(lblSexo);
		}
		{
			ButtonGroup buttonGroup = new ButtonGroup();
			{
				JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
				panel_1_1.add(rdbtnMasculino);
				buttonGroup.add(rdbtnMasculino);
			}
			{
				JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
				panel_1_1.add(rdbtnFeminino);
				buttonGroup.add(rdbtnFeminino);
			}
		}
		{
			JLabel lblTipoDeDeficincia = new JLabel("Tipo de defici\u00EAncia:");
			panel_1_2.add(lblTipoDeDeficincia);
		}
		{
			textField_5 = new JTextField();
			panel_1_2.add(textField_5);
			textField_5.setColumns(10);
		}
		{
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Contatos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.add(panel_1);
			panel_1.setLayout(new GridLayout(4, 1, 0, 1));
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
		}
		{
			JPanel panel_1 = new JPanel();
			getContentPane().add(panel_1, BorderLayout.SOUTH);
			panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				JButton button = new JButton("OK");
				button.setActionCommand("OK");
				panel_1.add(button);
			}
			{
				JButton button = new JButton("Cancelar");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				button.setActionCommand("Cancelar");
				panel_1.add(button);
			}
		}
	}
}
