package br.ufs.dain.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import br.ufs.dain.dao.DAO;
import br.ufs.dain.modelo.Bolsista;
import br.ufs.dain.modelo.Horario;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

public class TelaCadastrarHorarioBolsista extends JFrame {

	private JPanel contentPane;

	private JButton btnSalvar;
	private JButton btnLimpar;

	private String matricula;

	private String[] horarios = { "07:00h - 08:00h", "08:00h - 09:00h", "09:00h - 10:00h", "10:00h - 11:00h",
			"11:00h - 12:00h", "12:00h - 13:00h", "13:00h - 14:00h", "14:00h - 15:00h", "15:00h - 16:00h",
			"16:00h - 17:00h", "17:00h - 18:00h", "18:00h - 19:00h", "19:00h - 20:00h", "20:00h - 21:00h",
			"21:00h - 22:00h", "22:00h - 23:00h" };

	private String[] colunas = { "Horário", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado" };

	private JCheckBox[] arrayCheckBox = new JCheckBox[96];

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					TelaCadastrarHorarioBolsista frame = new TelaCadastrarHorarioBolsista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaCadastrarHorarioBolsista() {

		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 794, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setTitle("Cadastrar Horário de Bolsista");		

		preencherPainelPrincipal();
	}

	private JList getLista () {

		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		DefaultListModel listModel = new DefaultListModel();
		ArrayList<Bolsista> listaBolsista = new DAO().buscarBolsistas();

		for (int i = 0; i < listaBolsista.size(); i++)
			listModel.addElement(listaBolsista.get(i).getNome());

		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if (!arg0.getValueIsAdjusting()) {
					// se nenhum ítem estiver selecionado, nada acontece
					if (list.getSelectedIndex() != -1) {
						btnSalvar.setEnabled(false);
						matricula = listaBolsista.get(list.getSelectedIndex()).getMatricula();
						atualizarPainel(matricula);
						isCheckBoxVazio();
					}
				}
			}
		});

		list.setModel(listModel);
		list.setSelectedIndex(0);

		return list;
	}

	private void preencherPainelPrincipal () {

		JPanel panel_checkbox = new JPanel();
		panel_checkbox.setLayout(new GridLayout(17, 7, 0, 0));
		preencherCheckBox(panel_checkbox);

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salvarHorario(matricula);
			}
		});

		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i = 0; i < arrayCheckBox.length; i++)
					arrayCheckBox[i].setSelected(false);
				btnLimpar.setEnabled(false);
				btnSalvar.setEnabled(true);
			}
		});

		JPanel panel_lista = new JPanel();
		panel_lista.add(getLista());
		contentPane.add(panel_lista, BorderLayout.WEST);

		JPanel panel_botoes = new JPanel();
		panel_botoes.add(btnSalvar);
		panel_botoes.add(btnLimpar);

		JPanel panel_checkbox_botoes = new JPanel();
		panel_checkbox_botoes.setBorder(new EmptyBorder(0, 10, 0, 0));
		panel_checkbox_botoes.setLayout(new BorderLayout(0, 0));

		JPanel panel_nome = new JPanel();
		panel_checkbox_botoes.add(panel_nome, BorderLayout.NORTH);
		panel_nome.setLayout(new GridLayout(2, 1, 0, 0));

		JLabel label_nome = new JLabel();
		label_nome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_nome.setHorizontalAlignment(SwingConstants.LEFT);
		label_nome.setText("Nome do bolsista");
		panel_nome.add(label_nome);

		JLabel lblCursoDoBolsista = new JLabel("Curso do bolsista");
		lblCursoDoBolsista.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_nome.add(lblCursoDoBolsista);

		panel_checkbox_botoes.add(panel_checkbox, BorderLayout.CENTER);
		panel_checkbox_botoes.add(panel_botoes, BorderLayout.SOUTH);
		contentPane.add(panel_checkbox_botoes, BorderLayout.CENTER);

		JScrollPane scrollPane = new JScrollPane(panel_lista);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane, BorderLayout.WEST);
	}

	private void preencherCheckBox (JPanel panel) {

		int contador1 = 0;
		int contador2 = 0;

		// 119 é o número de (horarios * colunas) + colunas
		for (int i = 0; i < (horarios.length * colunas.length) + colunas.length; i++) {

			if (i < colunas.length) {

				JLabel label = new JLabel(colunas[i]);
				label.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(label);
			}
			else if (i % (colunas.length) == 0) {

				JLabel horas = new JLabel(horarios[contador1]);
				horas.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(horas);
				contador1++;
			}
			else {

				arrayCheckBox[contador2] = new JCheckBox();
				arrayCheckBox[contador2].setHorizontalAlignment(SwingConstants.CENTER);
				arrayCheckBox[contador2].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						btnSalvar.setEnabled(true);
						isCheckBoxVazio();
					}
				});
				panel.add(arrayCheckBox[contador2]);
				contador2++;
			}
		}
	}

	private void salvarHorario (String matricula) {

		int contador = 0;
		String seg = "";
		String ter = "";
		String qua = "";
		String qui = "";
		String sex = "";
		String sab = "";

		for (int i = 0; i < arrayCheckBox.length; i++) {

			//if (arrayCheckBox[i].isSelected())

			if (i % 6 == 0) {
				if (arrayCheckBox[i].isSelected())
					seg = horarios[contador] + "|" + seg;
				else
					seg = seg.replace(horarios[contador] + "|", "");
				System.out.println(/*i + " :: " + horarios[contador]*/seg);
			}
			//	System.out.println(contador + ": Seg\n" + horarios[contador]);
			else if (i % 6 == 1) {
				if (arrayCheckBox[i].isSelected())
					ter = horarios[contador] + "|" + ter;
				else
					ter = ter.replace(horarios[contador] + "|", "");
			}
			//	System.out.println(contador + ": Ter\n" + horarios[contador]);
			else if (i % 6 == 2) {
				if (arrayCheckBox[i].isSelected())
					qua = horarios[contador] + "|" + qua;
				else
					qua = qua.replace(horarios[contador] + "|", "");
			}
			//	System.out.println(contador + ": Qua\n" + horarios[contador]);
			else if (i % 6 == 3) {
				if (arrayCheckBox[i].isSelected())
					qui = horarios[contador] + "|" + qui;
				else
					qui = qui.replace(horarios[contador] + "|", "");
			}
			//	System.out.println(contador + ": Qui\n" + horarios[contador]);
			else if (i % 6 == 4) {
				if (arrayCheckBox[i].isSelected())
					sex = horarios[contador] + "|" + sex;
				else
					sex = sex.replace(horarios[contador] + "|", "");
			}
			//	System.out.println(contador + ": Sex\n" + horarios[contador]);
			else {
				if (arrayCheckBox[i].isSelected())
					sab = horarios[contador] + "|" + sab;
				else
					sab = sab.replace(horarios[contador] + "|", "");
				contador++;
			}
			//	System.out.println(contador + ": Sab\n" + horarios[contador]);
		}

		Horario horario = new DAO().buscarHorarioBolsista(matricula);
		String segunda = horario.getSegunda();
		String terca = horario.getTerca();
		String quarta = horario.getQuarta();
		String quinta = horario.getQuinta();
		String sexta = horario.getSexta();
		String sabado = horario.getSabado();

		System.out.println(seg.equals(segunda));

		//if (seg.equals(segunda) && ter.equals(terca) && qua.equals(quarta)
		//	&& qui.equals(quinta) && sex.equals(sexta) && sab.equals(sabado))
		//	JOptionPane.showMessageDialog(panel, "Nenhuma alteração foi feita!");
		//else
		new DAO().cadastrHorarioBolsista(new Horario(seg, ter, qua, qui, sex, sab), matricula);
		btnSalvar.setEnabled(false);

	}

	private void atualizarPainel (String matric) {

		int contador = 0;

		Horario horario = new DAO().buscarHorarioBolsista(matric);
		String segunda = horario.getSegunda();
		String terca = horario.getTerca();
		String quarta = horario.getQuarta();
		String quinta = horario.getQuinta();
		String sexta = horario.getSexta();
		String sabado = horario.getSabado();

		//System.out.println(horarios[0] + "\n" + segunda);

		for (int i = 0; i < arrayCheckBox.length; i++) {
			if (i % 6 == 0)
				if (segunda.contains(horarios[contador])) {
					arrayCheckBox[i].setSelected(true);
					arrayCheckBox[i].setBackground(Color.RED);
				}
				else
					arrayCheckBox[i].setSelected(false);

			else if (i % 6 == 1)
				if (terca.contains(horarios[contador]))
					arrayCheckBox[i].setSelected(true);
				else
					arrayCheckBox[i].setSelected(false);

			else if (i % 6 == 2)
				if (quarta.contains(horarios[contador]))
					arrayCheckBox[i].setSelected(true);
				else
					arrayCheckBox[i].setSelected(false);

			else if (i % 6 == 3)
				if (quinta.contains(horarios[contador]))
					arrayCheckBox[i].setSelected(true);
				else
					arrayCheckBox[i].setSelected(false);

			else if (i % 6 == 4)
				if (sexta.contains(horarios[contador]))
					arrayCheckBox[i].setSelected(true);
				else
					arrayCheckBox[i].setSelected(false);

			else {
				if (sabado.contains(horarios[contador]))
					arrayCheckBox[i].setSelected(true);
				else
					arrayCheckBox[i].setSelected(false);
				contador++;
			}
		}
	}

	private void isCheckBoxVazio () {

		boolean checkBoxVazio = true;

		for (int i = 0; i < arrayCheckBox.length; i++)
			if (arrayCheckBox[i].isSelected()) {
				checkBoxVazio = false;
				break;
			}

		if (checkBoxVazio)
			btnLimpar.setEnabled(false);
		else
			btnLimpar.setEnabled(true);
	}
}