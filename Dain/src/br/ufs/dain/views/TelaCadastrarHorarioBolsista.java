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

public class TelaCadastrarHorarioBolsista extends JFrame {

	private JPanel contentPane;

	Horario horario;

	String nome;
	String matricula;
	String seg, ter, qua, qui, sex, sab;

	String[] horarios = { "07:00h - 08:00h", "08:00h - 09:00h", "09:00h - 10:00h", "10:00h - 11:00h",
			"11:00h - 12:00h", "12:00h - 13:00h", "13:00h - 14:00h", "14:00h - 15:00h", "15:00h - 16:00h",
			"16:00h - 17:00h", "17:00h - 18:00h", "18:00h - 19:00h", "19:00h - 20:00h", "20:00h - 21:00h",
			"21:00h - 22:00h", "22:00h - 23:00h" };

	String[] colunas = { "Horário", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado" };

	JCheckBox[] arrayCheckBox = new JCheckBox[96];


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

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 10, 5, 5));
		panel.setLayout(new GridLayout(17, 7, 0, 0));
		contentPane.add(panel, BorderLayout.CENTER);
		preenchePainel(panel);

		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		ArrayList<Bolsista> listaBolsista = new DAO().buscarBolsistas();

		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if (!arg0.getValueIsAdjusting()) {
					matricula = listaBolsista.get(list.getSelectedIndex()).getMatricula();
					setaPainel(matricula);
				}
			}
		});

		DefaultListModel listModel = new DefaultListModel();

		for (int i = 0; i < listaBolsista.size(); i++)
			listModel.addElement(listaBolsista.get(i).getNome() + " (" + listaBolsista.get(i).getMatricula() + ")");

		list.setModel(listModel);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);

		panel_1.add(list);
		list.setSelectedIndex(0);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(seg != null && ter != null && qua != null && qui != null && sex != null && sab != null){
					new DAO().cadastrHorarioBolsista(new Horario(seg, ter, qua, qui, sex, sab), matricula);
					JOptionPane.showMessageDialog(panel, "Horárario Salvo!");
				}else
					JOptionPane.showMessageDialog(panel, "Nenhuma alteração foi feita!");
//				System.out.println("Segunda: " + seg + "\nTerça: " + ter + "\nQuarta: " + qua
//						+ "\nQuinta: " + qui + "\nSsexta: " + sex + "\nSábado: " + sab);
			}
		});
		panel_2.add(btnSalvar);
		
		JButton btnNewButton = new JButton("Limpar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i = 0; i < 96; i++)
					arrayCheckBox[i].setSelected(false);
					
			}
		});
		panel_2.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane(panel_1);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane, BorderLayout.WEST);

	}

	private void preenchePainel (JPanel panel) {

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

				int numeroCelula = i % colunas.length;
				String diaCorrespondente = colunas[numeroCelula];
				String horaCorrespondente = horarios[contador1 - 1];

				arrayCheckBox[contador2] = new JCheckBox();
				arrayCheckBox[contador2].setHorizontalAlignment(SwingConstants.CENTER);
				arrayCheckBox[contador2].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						setaCliqueCheckBox();
					}
				});

				panel.add(arrayCheckBox[contador2]);
				contador2++;
			}
		}
	}

	private void setaCliqueCheckBox () {

		int contador = 0;
		seg = "";
		ter = ""; 
		qua = "";
		qui = "";
		sex = "";
		sab = "";

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
	}

	private void setaPainel (String matric) {

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
				if (segunda.contains(horarios[contador]))
					arrayCheckBox[i].setSelected(true);
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
}


//	if (arrayCheckBox[1].isSelected()) {
//		if (diaCorrespondente.equals(colunas[1])) {
//			seg = horaCorrespondente + "|" + seg;
//			System.out.println(seg);
//		}
//		if (diaCorrespondente.equals(colunas[2]))
//			ter = horaCorrespondente + "|" + ter;
//		if (diaCorrespondente.equals(colunas[3]))
//			qua = horaCorrespondente + "|" + qua;
//		if (diaCorrespondente.equals(colunas[4]))
//			qui = horaCorrespondente + "|" + qui;
//		if (diaCorrespondente.equals(colunas[5]))
//			sex = horaCorrespondente + "|" + sex;
//		if (diaCorrespondente.equals(colunas[6]))
//			sab = horaCorrespondente + "|" + sab;
//	} else {
//		if (diaCorrespondente.equals(colunas[1]))
//			seg = seg.replace(horaCorrespondente + "|", "");
//		if (diaCorrespondente.equals(colunas[2]))
//			ter = ter.replace(horaCorrespondente + "|", "");
//		if (diaCorrespondente.equals(colunas[3]))
//			qua = qua.replace(horaCorrespondente + "|", "");
//		if (diaCorrespondente.equals(colunas[4]))
//			qui = qui.replace(horaCorrespondente + "|", "");
//		if (diaCorrespondente.equals(colunas[5]))
//			sex = sex.replace(horaCorrespondente + "|", "");
//		if (diaCorrespondente.equals(colunas[6]))
//			sab = sab.replace(horaCorrespondente + "|", "");
//	}
//	new Horario(seg, ter, qua, qui, sex, sab);
//}