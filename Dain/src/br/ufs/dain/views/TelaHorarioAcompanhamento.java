package br.ufs.dain.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import br.ufs.dain.dao.DAO;
import br.ufs.dain.modelo.Bolsista;

import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaHorarioAcompanhamento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private String dia;
	private String hora;

	/**
	 * Create the frame.
	 */
	public TelaHorarioAcompanhamento (String diaCorrespondente, String horaCorrespondente) {
		
		setTitle(atribuiPosFixoFeira(dia) + ", " + hora);

		this.dia = diaCorrespondente;
		this.hora = horaCorrespondente;

		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 912, 500);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 10, 5, 10));
		
		JScrollPane scrollPane = new JScrollPane(panel);
		contentPane.add(scrollPane, BorderLayout.SOUTH);

		contentPane.add(scrollPane, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblNewLabel = new JLabel(atribuiPosFixoFeira(dia));
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel lblNewLabel_1 = new JLabel(hora);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 4, 0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_7.add(panel_3);
		panel_3.setBorder(new EmptyBorder(5, 3, 5, 3));
		panel_3.setLayout(new GridLayout(1, 2, 10, 10));
		
		JList<String> list_1 = getLista();
		JScrollPane scroll_1 = new JScrollPane(list_1);
		scroll_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_3.add(scroll_1);
		
		JList<String> list_2 = getLista();
		JScrollPane scroll_2 = new JScrollPane(list_2);
		scroll_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_3.add(scroll_2);
		
		JPanel panel_8 = new JPanel();
		panel_7.add(panel_8, BorderLayout.SOUTH);
		panel_8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_apoio = new JPanel();
		panel_apoio.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Apoio", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.add(panel_apoio);
		
		JLabel lblXxx = new JLabel("xxx");
		panel_apoio.add(lblXxx);
		
		JPanel panel_dain = new JPanel();
		panel_dain.setBorder(new TitledBorder(null, "Dain", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		JLabel lblNewLabel_2 = new JLabel("<html><body></body></html>");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 13));
		panel_dain.add(lblNewLabel_2);
		panel_2.add(panel_dain);
		
		JPanel panel_bicen = new JPanel();
		panel_bicen.setBorder(new TitledBorder(null, "Bicen", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		JLabel lblNewLabel_3 = new JLabel("<html><body></body></html>");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 13));
		panel_bicen.add(lblNewLabel_3);
		panel_2.add(panel_bicen);
		
		JButton btnRelacionarAssistidobolsista = new JButton("Apoio");
		panel_8.add(btnRelacionarAssistidobolsista);
		
		JButton btnAdicionarDain = new JButton("Dain");
		btnAdicionarDain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				atualizaLabel(panel_dain, list_1);
			}
		});
		panel_8.add(btnAdicionarDain);
		
		JButton btnAdicionarBicen = new JButton("Bicen");
		btnAdicionarBicen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizaLabel(panel_bicen, list_1);
			}
		});
		panel_8.add(btnAdicionarBicen);
				
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new EmptyBorder(10, 0, 10, 0));
		panel.add(panel_9, BorderLayout.SOUTH);
		panel_9.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnSalvar = new JButton("Salvar");
		panel_9.add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		panel_9.add(btnLimpar);
	}

	private String atribuiPosFixoFeira (String dia) {

		if (dia != "Sábado")
			return dia + "-feira";
		return dia;
	}

	public void abrirAba (JTabbedPane tabbedPane) {

		contentPane.setOpaque(false);
		tabbedPane.add(contentPane);
		tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(contentPane),
				getTitlePanel(tabbedPane, contentPane, atribuiPosFixoFeira(dia) + ", " + hora));

	}

	private static JPanel getTitlePanel(final JTabbedPane tabbedPane, final JPanel panel, String titulo) {

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
	
	private JList<String> getLista () {
		
		JList<String> list = new JList<String>();
		list.setBorder(new EmptyBorder(1, 1, 1, 1));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		ArrayList<Bolsista> listaBolsista = new DAO().buscarBolsistas();
		
		for (int i = 0; i < listaBolsista.size(); i++) {
			String horarioLivre = null;
			if (dia.equals("Segunda"))
				horarioLivre = new DAO().buscarHorarioBolsista(listaBolsista.get(i).getMatricula()).getSegunda();
			else if (dia.equals("Terça"))
				horarioLivre = new DAO().buscarHorarioBolsista(listaBolsista.get(i).getMatricula()).getTerca();
			else if (dia.equals("Quarta"))
				horarioLivre = new DAO().buscarHorarioBolsista(listaBolsista.get(i).getMatricula()).getQuarta();
			else if (dia.equals("Quinta"))
				horarioLivre = new DAO().buscarHorarioBolsista(listaBolsista.get(i).getMatricula()).getQuinta();
			else if (dia.equals("Sexta"))
				horarioLivre = new DAO().buscarHorarioBolsista(listaBolsista.get(i).getMatricula()).getSexta();
			else
				horarioLivre = new DAO().buscarHorarioBolsista(listaBolsista.get(i).getMatricula()).getSabado();

			if (horarioLivre.contains(hora + "|"))
				listModel.addElement(listaBolsista.get(i).getNome() + "          ");
		}
		list.setModel(listModel);
		
		return list;
	}
	
	private void atualizaLabel (JPanel panel, JList<String> list) {
		
		JLabel label = (JLabel) panel.getComponent(0);
		String s = label.getText();
		s = s.replace("<html>", "");
		s = s.replace("</html>", "");
		s = s.replace("<body>", "");
		s = s.replace("</body>", "");
		if (s.equals(""))
			label.setText(list.getSelectedValue());
		else
			label.setText("<html><body>" + s + "<br>" + list.getSelectedValue() + "</html></body>");
	}
}
