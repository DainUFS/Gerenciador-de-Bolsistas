package br.ufs.dain.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import br.ufs.dain.dao.DAO;
import br.ufs.dain.modelo.Deficiente;

public class TelaInfoDeficiente extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private String nome;
	
	public TelaInfoDeficiente(String nome) {
		setAutoRequestFocus(false);
		
		Deficiente def = new DAO().getDeficienteNome(nome);
		this.nome = nome;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 428);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel_2.add(panel);
		panel.setBorder(new TitledBorder(null, "Informa\u00E7\u00F5es Pessoais", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setLayout(new GridLayout(2, 2, 0, 5));
		
		JLabel lblNome = new JLabel("Nome: " + def.getNome());
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNome);
		
		JLabel lblMatrcula = new JLabel("Matr\u00EDcula: " + def.getMatricula());
		lblMatrcula.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatrcula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblMatrcula);
		
		JLabel lblTipoDeDeficncia = new JLabel("Tipo de Defic\u00EAncia: " + def.getTipoDeficiencia());
		lblTipoDeDeficncia.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoDeDeficncia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblTipoDeDeficncia);
		
		JLabel lblNewLabel_8 = new JLabel("Sexo: " + def.getSexo());
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_8);
		
		JPanel panel_1 = new JPanel();
		panel_2.add(panel_1);
		panel_1.setBorder(new TitledBorder(null, "Contatos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblTelefone = new JLabel("Telefone: " + def.getTelefone());
		lblTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblTelefone);
		
		JLabel lblEmail = new JLabel("E-mail: " + def.getEmail());
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblEmail);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Informa\u00E7\u00F5es Acad\u00EAmicas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Curso: " + def.getCurso());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblNewLabel);
		
	}
	
	public void abrirAba (JTabbedPane tabbedPane) {

		contentPane.setOpaque(false);
		tabbedPane.add(contentPane);
		tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(contentPane),
				getTitlePanel(tabbedPane, contentPane, "Deficiente: " + nome));

	}

	private static JPanel getTitlePanel (final JTabbedPane tabbedPane, final JPanel panel, String titulo) {

		JPanel tituloPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		tituloPanel.setOpaque(false);
		JLabel titleLbl = new JLabel(titulo);
		titleLbl.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		tituloPanel.add(titleLbl);

		JLabel closeLabel = new JLabel(" x ");
		
		closeLabel.setFont(new Font("Arial", Font.BOLD, 14));
		closeLabel.setVerticalAlignment(SwingConstants.NORTH);
		closeLabel.setHorizontalAlignment(SwingConstants.CENTER);

		closeLabel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				tabbedPane.remove(panel);
			}
			@Override
			public void mouseEntered(java.awt.event.MouseEvent evt) {
		        closeLabel.setForeground(Color.RED);
		    }
			@Override
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        closeLabel.setForeground(Color.BLACK);
		    }
		});
		tituloPanel.add(closeLabel);

		return tituloPanel;
	}

}
