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
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import br.ufs.dain.dao.DAO;
import br.ufs.dain.modelo.Bolsista;
import br.ufs.dain.modelo.Horario;

public class TelaInfoBolsista extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private String nome;
	
	public TelaInfoBolsista(String nome) {
		setAutoRequestFocus(false);
		
		Bolsista bol = new DAO().getBolsistaNome(nome);
		this.nome = nome;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel_2.add(panel);
		panel.setBorder(new TitledBorder(null, "Informa\u00E7\u00F5es Pessoais", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setLayout(new GridLayout(1, 2, 0, 5));
		
		JLabel lblNome = new JLabel("Nome: " + bol.getNome());
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNome);
		
		JLabel lblMatrcula = new JLabel("Matr\u00EDcula: " + bol.getMatricula());
		lblMatrcula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblMatrcula);
		
		JPanel panel_1 = new JPanel();
		panel_2.add(panel_1);
		panel_1.setBorder(new TitledBorder(null, "Contatos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblTelefone = new JLabel("Telefone: " + bol.getTelefone());
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblTelefone);
		
		JLabel lblEmail = new JLabel("E-mail: " + bol.getEmail());
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblEmail);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Informa\u00E7\u00F5es Acad\u00EAmicas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Curso: " + bol.getCurso());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblNewLabel);
		
		String atividade;
		switch (bol.getTipoAtividade()) {
		case 0:
			atividade = "Nenhum";
			break;
		case 1:
			atividade = "Apoio";
			break;
		case 2:
			atividade = "Dain";
			break;
		default:
			atividade = "Bicen";
		}
		
		JLabel lblNewLabel_1 = new JLabel("Atividade: " + atividade);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblNewLabel_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Hor\u00E1rio de Trabalho", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(6, 1, 0, 5));
		
		Horario h = new DAO().buscarHorarioBolsistaT(bol.getMatricula());
		
		JLabel lblNewLabel_2;
		if(!h.getSegunda().equals(""))
			lblNewLabel_2 = new JLabel("Segunda: " + h.getSegunda());
		else
			lblNewLabel_2 = new JLabel("Segunda: " + "Não trabalha nesse dia");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(lblNewLabel_2);
		
		
		JLabel lblNewLabel_3;
		if(!h.getTerca().equals(""))
			lblNewLabel_3 = new JLabel("Ter\u00E7a: " + h.getTerca());
		else
			lblNewLabel_3 = new JLabel("Ter\u00E7a: " + "Não trabalha nesse dia");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4;
		if(!h.getQuarta().equals(""))
			lblNewLabel_4 = new JLabel("Quarta: " + h.getQuarta());
		else
			lblNewLabel_4 = new JLabel("Quarta: " + "Não trabalha nesse dia");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(lblNewLabel_4);
		
		
		JLabel lblNewLabel_5;
		if(!h.getQuinta().equals(""))
			lblNewLabel_5 = new JLabel("Quinta: " + h.getQuinta());
		else
			lblNewLabel_5 = new JLabel("Quinta: " + "Não trabalha nesse dia");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(lblNewLabel_5);
		
		
		JLabel lblNewLabel_6;
		if(!h.getSexta().equals(""))
			lblNewLabel_6 = new JLabel("Sexta: " + h.getSexta());
		else
			lblNewLabel_6 = new JLabel("Sexta: " + "Não trabalha nesse dia");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(lblNewLabel_6);
		
		
		JLabel lblNewLabel_7;
		if(!h.getSabado().equals(""))
			lblNewLabel_7 = new JLabel("Sab\u00E1do: " + h.getSabado());
		else 
			lblNewLabel_7 = new JLabel("Sab\u00E1do: " + "Não trabalha nesse dia");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(lblNewLabel_7);
	}
	
	public void abrirAba (JTabbedPane tabbedPane) {

		contentPane.setOpaque(false);
		tabbedPane.add(contentPane);
		tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(contentPane),
				getTitlePanel(tabbedPane, contentPane, "Bolsista: " + nome));

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
