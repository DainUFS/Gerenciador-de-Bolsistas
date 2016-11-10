package br.ufs.dain.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import br.ufs.dain.dao.DAO;
import br.ufs.dain.modelo.Administrador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JPasswordField;

public class TelaNovoAdm extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	
	private JTextField textField_nome;
	private JTextField textField_matricula;
	private JTextField textField_telefone;
	private JTextField textField_email;
	private JPasswordField passwordField_senha;
	private JPasswordField passwordField_senhaNovamente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaNovoAdm dialog = new TelaNovoAdm();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaNovoAdm() {
		
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Murilo\\Documents\\GitHub\\Gerenciador-de-Bolsistas\\Dain\\img\\icon\\icone_adm.png"));
		setResizable(false);
		setTitle("Adicionar Administrador");
		setBounds(100, 100, 350, 490);
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
				JLabel lblCadastreUmNovo = new JLabel("Cadastre um novo administrador");
				lblCadastreUmNovo.setIcon(null);
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
		panel_1_2.setLayout(new GridLayout(4, 1, 0, 0));
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
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Acesso ao sistema", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.add(panel_1);
			panel_1.setLayout(new GridLayout(4, 1, 0, 0));
			{
				JLabel lblSenha = new JLabel("Senha:");
				panel_1.add(lblSenha);
			}
			{
				passwordField_senha = new JPasswordField();
				panel_1.add(passwordField_senha);
			}
			{
				JLabel lblDigiteNovamente = new JLabel("Digite novamente:");
				panel_1.add(lblDigiteNovamente);
			}
			{
				passwordField_senhaNovamente = new JPasswordField();
				panel_1.add(passwordField_senhaNovamente);
			}
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
					public void actionPerformed(ActionEvent arg0) {
						
						Administrador adm = new Administrador(textField_nome.getText().toString(),
								textField_telefone.getText().toString(),
								textField_email.getText().toString(),
								textField_matricula.getText().toString(),
								passwordField_senha.getText().toString(), 1);
						
						new DAO().cadastrarAdm(adm);
						
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
