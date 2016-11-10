package br.ufs.dain.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import br.ufs.dain.dao.DAO;
import br.ufs.dain.modelo.Administrador;
import br.ufs.dain.modelo.Deficiente;

public class TelaNovoDeficiente extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_nome;
	private JTextField textField_matricula;
	private JTextField textField_curso;
	private JTextField textField_telefone;
	private JTextField textField_email;
	private JTextField textField_tipoDeficiencia;
	
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFeminino;

	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		try {
	//			TelaNovoDeficiente dialog = new TelaNovoDeficiente();
	//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	//			dialog.setVisible(true);
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//		}
	//	}

	/**
	 * Create the dialog.
	 */
	public TelaNovoDeficiente(Administrador adm) {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Murilo\\Documents\\GitHub\\Gerenciador-de-Bolsistas\\Dain\\img\\icon\\icone_deficiente.png"));
		setResizable(false);
		setTitle("Cadastrar Novo Deficiente");
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
			textField_nome = new JTextField();
			textField_nome.setToolTipText("");
			textField_nome.setColumns(30);
			panel_1_2.add(textField_nome);
		}
		{
			JLabel label = new JLabel("Matr\u00EDcula:");
			panel_1_2.add(label);
		}
		{
			textField_matricula = new JTextField();
			textField_matricula.setColumns(15);
			panel_1_2.add(textField_matricula);
		}
		{
			JLabel label = new JLabel("Curso:");
			panel_1_2.add(label);
		}
		{
			textField_curso = new JTextField();
			textField_curso.setColumns(10);
			panel_1_2.add(textField_curso);
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
				rdbtnMasculino = new JRadioButton("Masculino");
				panel_1_1.add(rdbtnMasculino);
				buttonGroup.add(rdbtnMasculino);
			}
			{
				rdbtnFeminino = new JRadioButton("Feminino");
				panel_1_1.add(rdbtnFeminino);
				buttonGroup.add(rdbtnFeminino);
			}
		}
		{
			JLabel lblTipoDeDeficincia = new JLabel("Tipo de defici\u00EAncia:");
			panel_1_2.add(lblTipoDeDeficincia);
		}
		{
			textField_tipoDeficiencia = new JTextField();
			panel_1_2.add(textField_tipoDeficiencia);
			textField_tipoDeficiencia.setColumns(10);
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
				textField_telefone = new JTextField();
				textField_telefone.setColumns(10);
				panel_1.add(textField_telefone);
			}
			{
				JLabel label = new JLabel("E-mail:");
				panel_1.add(label);
			}
			{
				textField_email = new JTextField();
				textField_email.setColumns(10);
				panel_1.add(textField_email);
			}
		}
		{
			JPanel panel_1 = new JPanel();
			getContentPane().add(panel_1, BorderLayout.SOUTH);
			panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				JButton button = new JButton("OK");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						String sexoSelecionado = null;

						if (rdbtnMasculino.isSelected())
							sexoSelecionado = "M";
						else if (rdbtnFeminino.isSelected())
							sexoSelecionado = "F";
						
						Deficiente d = new Deficiente(textField_nome.getText().toString(),
								textField_telefone.getText().toString(),
								textField_email.getText().toString(),
								textField_curso.getText().toString(),
								textField_matricula.getText().toString(),
								sexoSelecionado,
								null,
								textField_tipoDeficiencia.getText().toString(), 1);
						
						new DAO().cadastraDeficiente(d, adm.getMatricula());
					}
				});
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
