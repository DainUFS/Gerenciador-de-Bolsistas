package br.ufs.dain.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import br.ufs.dain.dao.DAO;
import br.ufs.dain.modelo.Bolsista;
import br.ufs.dain.modelo.Deficiente;
import br.ufs.dain.modelo.Horario;
import br.ufs.dain.modelo.HorariosApoio;
import br.ufs.dain.modelo.HorariosBicen;
import br.ufs.dain.modelo.HorariosDain;
import br.ufs.dain.modelo.Acompanhamento;

public class TelaHorarioAcompanhamento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private final short SCROLL_SPEED = 12;

	private String dia;
	private String hora;

	private JButton btnDesalocar;
	private JButton btnAdicionarBicen;
	private JButton btnRelacionarAssistidobolsista;
	private JButton btnAdicionarDain;

	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;

	private ArrayList<Acompanhamento> apoio = new ArrayList<>();
	private ArrayList<Bolsista> dain = new ArrayList<>();
	private ArrayList<Bolsista> bicen = new ArrayList<>();
	
	public ArrayList<HorariosApoio> apoioH = new ArrayList<>();
	public ArrayList<HorariosBicen> dainH = new ArrayList<>();
	public ArrayList<HorariosDain> bicenH = new ArrayList<>();
	
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
		scrollPane.getVerticalScrollBar().setUnitIncrement(SCROLL_SPEED);
		scrollPane.getHorizontalScrollBar().setUnitIncrement(SCROLL_SPEED);

		contentPane.add(scrollPane, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel labelDia = new JLabel(atribuiPosFixoFeira(dia));
		panel_1.add(labelDia);
		labelDia.setFont(new Font("Tahoma", Font.PLAIN, 30));
		labelDia.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel labelHora = new JLabel(hora);
		panel_1.add(labelHora);
		labelHora.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelHora.setVerticalAlignment(SwingConstants.TOP);
		labelHora.setHorizontalAlignment(SwingConstants.LEFT);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 4, 3, 0));

		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel_7.add(panel_3);
		panel_3.setBorder(new EmptyBorder(5, 3, 5, 3));
		panel_3.setLayout(new GridLayout(2, 1, 0, 5));

		JList<String> list_1 = getListaDeficientes();
		JScrollPane scroll_1 = new JScrollPane(list_1);
		scroll_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll_1.getVerticalScrollBar().setUnitIncrement(SCROLL_SPEED);
		scroll_1.getHorizontalScrollBar().setUnitIncrement(SCROLL_SPEED);
		panel_3.add(scroll_1);

		JList<String> list_2 = getListaBolsistas();
		JScrollPane scroll_2 = new JScrollPane(list_2);
		scroll_2.getVerticalScrollBar().setUnitIncrement(SCROLL_SPEED);
		scroll_2.getHorizontalScrollBar().setUnitIncrement(SCROLL_SPEED);
		JLabel lblAssistidosQuePrecisam = new JLabel("Assistidos que precisam de apoio");
		lblAssistidosQuePrecisam.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAssistidosQuePrecisam.setHorizontalAlignment(SwingConstants.CENTER);
		scroll_1.setColumnHeaderView(lblAssistidosQuePrecisam);
		scroll_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_3.add(scroll_2);

		JLabel lblBolsistasDisponveis = new JLabel("Bolsistas dispon\u00EDveis");
		lblBolsistasDisponveis.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBolsistasDisponveis.setHorizontalAlignment(SwingConstants.CENTER);
		scroll_2.setColumnHeaderView(lblBolsistasDisponveis);

		JPanel panel_8 = new JPanel();
		panel_7.add(panel_8, BorderLayout.SOUTH);
		panel_8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panel_apoio = new JPanel();
		panel_apoio.setBorder(new TitledBorder(null, "APOIO", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, null));
		panel_2.add(panel_apoio);
		panel_apoio.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_apoio.add(lblNewLabel_2);

		JPanel panel_dain = new JPanel();
		panel_dain.setBorder(new TitledBorder(null, "DAIN", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, null));
		panel_dain.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_2.add(panel_dain);

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_dain.add(lblNewLabel_3);

		JPanel panel_bicen = new JPanel();
		panel_bicen.setBorder(new TitledBorder(null, "BICEN", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, null));
		panel_bicen.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_2.add(panel_bicen);

		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_bicen.add(lblNewLabel_4);
		
		

		btnRelacionarAssistidobolsista = new JButton("Apoio");
		btnRelacionarAssistidobolsista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String dia = labelDia.getText().toString();
				String hora = labelHora.getText().toString();
				
				Bolsista bolsista = new DAO().getBolsistaNome(list_2.getSelectedValue());
				Deficiente deficiente = new DAO().getDeficienteNome(list_1.getSelectedValue());
				Acompanhamento acompanhamento = new Acompanhamento(bolsista, deficiente, hora, dia);
				
				if(list_1.getSelectedIndex() != -1
						&& list_2.getSelectedIndex() != -1
						&& bolsista != null
						&& deficiente != null){
					
					if(!checarApoio(apoio, acompanhamento)
							&& !checarBolsista(dain, bolsista)
							&& !checarBolsista(bicen, bolsista)){
						apoio.add(acompanhamento);
						atualizaLabelApoio(panel_apoio, apoio);
					}else{
						JOptionPane.showMessageDialog(null, "Aluno e/ou Assistido já cadastado nesse horário!");
					}
				}				
				
			}
		});
		panel_8.add(btnRelacionarAssistidobolsista);

		btnAdicionarDain = new JButton("Dain");
		btnAdicionarDain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Bolsista bolsista = new DAO().getBolsistaNome(list_2.getSelectedValue());
				
				if(list_2.getSelectedIndex() != -1
						&& bolsista != null){
					
					if(!checarBolsistaApoio(apoio, bolsista)
							&& !checarBolsista(dain, bolsista)
							&& !checarBolsista(bicen, bolsista)){
						dain.add(bolsista);
						atualizaLabel(panel_dain, dain);
					}else{
						JOptionPane.showMessageDialog(null, "Aluno já cadastado nesse horário!");
					}
				}	
				
			}
		});
		panel_8.add(btnAdicionarDain);

		btnAdicionarBicen = new JButton("Bicen");
		btnAdicionarBicen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Bolsista bolsista = new DAO().getBolsistaNome(list_2.getSelectedValue());
				
				if(list_2.getSelectedIndex() != -1
						&& bolsista != null){
					
					if(!checarBolsistaApoio(apoio, bolsista)
							&& !checarBolsista(dain, bolsista)
							&& !checarBolsista(bicen, bolsista)){
						bicen.add(bolsista);
						atualizaLabel(panel_bicen, bicen);
					}else{
						JOptionPane.showMessageDialog(null, "Aluno já cadastado nesse horário!");
					}
				}	
				
			}
		});
		panel_8.add(btnAdicionarBicen);

		btnDesalocar = new JButton("Desalocar");
		btnDesalocar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String dia = labelDia.getText().toString();
				String hora = labelHora.getText().toString();
				
				Bolsista bolsista = new DAO().getBolsistaNome(list_2.getSelectedValue());
				Deficiente deficiente = new DAO().getDeficienteNome(list_1.getSelectedValue());
				Acompanhamento acompanhamento = new Acompanhamento(bolsista, deficiente, hora, dia);
				
				if (list_1.getSelectedIndex() != -1
						&& list_2.getSelectedIndex() != -1
						&& checarApoio(apoio, acompanhamento)){
						removerApoio(apoio, acompanhamento);
						atualizaLabelApoio(panel_apoio, apoio);
				}else if (list_2.getSelectedIndex() != -1 
						&& checarBolsista(dain, bolsista)){
					removerBolsista(dain, bolsista);
					atualizaLabel(panel_dain, dain);
				}else if (list_2.getSelectedIndex() != -1 
						&& checarBolsista(bicen, bolsista)){
					removerBolsista(bicen, bolsista);
					atualizaLabel(panel_bicen, bicen);
				}
				
			}
		});
		panel_8.add(btnDesalocar);

		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new EmptyBorder(10, 0, 10, 0));
		panel.add(panel_9, BorderLayout.SOUTH);
		panel_9.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String dia = labelDia.getText().toString();
				String hora = labelHora.getText().toString();
				
				for(int i = 0; i < apoio.size(); i++) 
					new DAO().tipoAtividade(apoio.get(i).getBolsista().getMatricula()
							, 1);
				
				for(int i = 0; i < dain.size(); i++) 
					new DAO().tipoAtividade(dain.get(i).getMatricula()
							, 2);
				
				for(int i = 0; i < bicen.size(); i++) 
					new DAO().tipoAtividade(bicen.get(i).getMatricula()
							, 3);
				
				String segunda = "";
				String terca = "";
				String quarta = "";
				String quinta = "";
				String sexta = "";
				String sabado = "";
				
				 switch (dia) {
		            case "Segunda-feira":
		                segunda = hora;
		                break;
		            case "Tera-feira":
		                terca = hora;
		                break;
		            case "Quarta-feira":
		                quarta = hora;
		                break;
		            case "Quinta-feira":
		                quinta = hora;
		                break;
		            case "Sexta-feira":
		                sexta = hora;
		                break;
		            default:
		                sabado = hora;
		         }
				
				 	for(int i = 0; i < apoio.size(); i++) 
					 	new DAO().hrTrabalho(dia, hora, apoio.get(i).getBolsista().getMatricula());
					
					for(int i = 0; i < dain.size(); i++) 
						new DAO().hrTrabalho(dia, hora, dain.get(i).getMatricula());
					
					for(int i = 0; i < bicen.size(); i++) 
						new DAO().hrTrabalho(dia, hora, bicen.get(i).getMatricula());
			}
		});
		panel_9.add(btnSalvar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				apoio.clear();
				bicen.clear();
				dain.clear();
				
				JLabel l_bicen = (JLabel) panel_bicen.getComponent(0);
				l_bicen.setText("");
				
				JLabel l_dain = (JLabel) panel_dain.getComponent(0);
				l_dain.setText("");
				
				JLabel l_apoio = (JLabel) panel_apoio.getComponent(0);
				l_apoio.setText("");				
			}
		});
		panel_9.add(btnLimpar);
		
		distribuiNomes();
	}
	
	private void distribuiNomes () {
		
		
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

	private JList<String> getListaBolsistas () {

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

			if (!horarioLivre.contains(hora + "|"))
				listModel.addElement(listaBolsista.get(i).getNome());
		}
		list.setModel(listModel);

		return list;
	}

	private JList<String> getListaDeficientes () {
		JList<String> list_1 = new JList<String>();
		list_1.setBorder(new EmptyBorder(1, 1, 1, 1));
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		ArrayList<Deficiente> listaDeficientes = new DAO().buscarDeficiente();

		for (int i = 0; i < listaDeficientes.size(); i++) {
			String horarioLivre = null;
			if (dia.equals("Segunda"))
				horarioLivre = new DAO().buscarHorarioDeficiente(listaDeficientes.get(i).getMatricula()).getSegunda();
			else if (dia.equals("Terça"))
				horarioLivre = new DAO().buscarHorarioDeficiente(listaDeficientes.get(i).getMatricula()).getTerca();
			else if (dia.equals("Quarta"))
				horarioLivre = new DAO().buscarHorarioDeficiente(listaDeficientes.get(i).getMatricula()).getQuarta();
			else if (dia.equals("Quinta"))
				horarioLivre = new DAO().buscarHorarioDeficiente(listaDeficientes.get(i).getMatricula()).getQuinta();
			else if (dia.equals("Sexta"))
				horarioLivre = new DAO().buscarHorarioDeficiente(listaDeficientes.get(i).getMatricula()).getSexta();
			else
				horarioLivre = new DAO().buscarHorarioDeficiente(listaDeficientes.get(i).getMatricula()).getSabado();

			if (horarioLivre.contains(hora + "|"))
				listModel.addElement(listaDeficientes.get(i).getNome());
		}
		list_1.setModel(listModel);

		return list_1;
	}

	private void atualizaLabel (JPanel panel, ArrayList<Bolsista> list) {
		
		JLabel label = (JLabel) panel.getComponent(0);

		String s = "<html><body>";
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				s += list.get(i).getNome() + "<br><br>";
			}
			s += "</html></body>";
			label.setText(s);
		} 
	}
	
	private void atualizaLabelApoio (JPanel panel, ArrayList<Acompanhamento> list) {
		
		JLabel label = (JLabel) panel.getComponent(0);

		String s = "<html><body>";
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				s += list.get(i).getBolsista().getNome() + "<br><pre>" + list.get(i).getDeficiente().getNome() + "</pre><br><br>";
			}
			s += "</html></body>";
			label.setText(s);
		}
	}
	
	private boolean checarBolsista(ArrayList<Bolsista> list, Bolsista bolsista){
		
		for(int i = 0; i < list.size(); i++)
			if(list.get(i).getMatricula().equals(bolsista.getMatricula())) return true;
		
		return false;
	}
	
	private boolean checarBolsistaApoio(ArrayList<Acompanhamento> apoio, Bolsista bolsista){
		
		for(int i = 0; i < apoio.size(); i++)
			if(apoio.get(i).getBolsista().getMatricula().equals(bolsista.getMatricula())) return true;
		
		return false;
	}
	
	private boolean checarApoio(ArrayList<Acompanhamento> apoio, Acompanhamento acompanhamento){
		
		for(int i = 0; i < apoio.size(); i++)
			if(apoio.get(i).getBolsista().getMatricula().equals(acompanhamento.getBolsista().getMatricula())
					&& apoio.get(i).getDeficiente().getMatricula().equals(acompanhamento.getDeficiente().getMatricula())
					&& apoio.get(i).getDia().equals(acompanhamento.getDia())
					&& apoio.get(i).getHora().equals(acompanhamento.getHora())
					||
					apoio.get(i).getDeficiente().getMatricula().equals(acompanhamento.getDeficiente().getMatricula())
					&& apoio.get(i).getDia().equals(acompanhamento.getDia())
					&& apoio.get(i).getHora().equals(acompanhamento.getHora())
					||
					apoio.get(i).getBolsista().getMatricula().equals(acompanhamento.getBolsista().getMatricula())
					&& apoio.get(i).getDia().equals(acompanhamento.getDia())
					&& apoio.get(i).getHora().equals(acompanhamento.getHora())) return true;
		
		return false;
	}
	
	private void removerApoio (ArrayList<Acompanhamento> apoio, Acompanhamento acompanhamento){
		
		for(int i = 0; i < apoio.size(); i++)
			if(apoio.get(i).getBolsista().getMatricula().equals(acompanhamento.getBolsista().getMatricula())
				&& apoio.get(i).getDeficiente().getMatricula().equals(acompanhamento.getDeficiente().getMatricula())
				&& apoio.get(i).getDia().equals(acompanhamento.getDia())
				&& apoio.get(i).getHora().equals(acompanhamento.getHora()))
					apoio.remove(apoio.get(i));
	}
	
	private void removerBolsista (ArrayList<Bolsista> list, Bolsista bolsista){
		for(int i = 0; i < list.size(); i++)
			if(list.get(i).getMatricula().equals(bolsista.getMatricula())) list.remove(list.get(i)); 
		
	}
	
	private void buscarHorarios(){
		DAO dao = new DAO();
		
		ArrayList<Bolsista> bDain = new ArrayList<>();
		ArrayList<Bolsista> bBicen = new ArrayList<>();
		
		bDain = dao.buscarBolsistasDain();
		bBicen = dao.buscarBolsistasBicen(); 
		
		for (int i = 0; i < bDain.size(); i++) {
			dainH.get(i).setBolsista(bDain.get(i));
			dainH.get(i).setHorario(new DAO().buscarHorarioBolsista(bDain.get(i).getMatricula()));
		}
		
		for (int i = 0; i < bBicen.size(); i++) {
			bicenH.get(i).setBolsista(bBicen.get(i));
			bicenH.get(i).setHorario(new DAO().buscarHorarioBolsista(bBicen.get(i).getMatricula()));
		}
		
		apoioH = new DAO().buscarBolsistasApoio();
	
	}
	
}
