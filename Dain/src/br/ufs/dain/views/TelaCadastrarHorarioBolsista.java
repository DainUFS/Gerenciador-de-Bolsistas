package br.ufs.dain.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import br.ufs.dain.dao.DAO;
import br.ufs.dain.modelo.Bolsista;
import br.ufs.dain.modelo.Horario;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastrarHorarioBolsista extends JFrame {

	private JPanel contentPane;

	Horario horario;
	Bolsista bolsista;

	String seg = "", ter = "", qua = "", qui = "", sex = "", sab = "";
	String nome;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */

	public TelaCadastrarHorarioBolsista() {

		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 10, 5, 5));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(17, 7, 0, 0));

		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		DefaultListModel listModel = new DefaultListModel();
		ArrayList<Bolsista> listaBolsista = new DAO().buscarBolsistas();

		for (int i = 0; i < listaBolsista.size(); i++)
			listModel.addElement(listaBolsista.get(i).getNome());

		list.setModel(listModel);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);

		panel_1.add(list);

		//
		list.setSelectedIndex(0);

		nome = (String) list.getSelectedValue();
		// System.out.println(nome);
		//

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);

		organizaHorario(panel);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new DAO().cadastrHorarioBolsista(horario, "Stanley Kubrick");
			}
		});
		panel_2.add(btnSalvar);

		JScrollPane scrollPane = new JScrollPane(panel_1);
		contentPane.add(scrollPane, BorderLayout.WEST);
	}

	private void organizaHorario(JPanel panel) {

		String[] horarios = { "07:00h - 08:00h", "08:00h - 09:00h", "09:00h - 10:00h", "10:00h - 11:00h",
				"11:00h - 12:00h", "12:00h - 13:00h", "13:00h - 14:00h", "14:00h - 15:00h", "15:00h - 16:00h",
				"16:00h - 17:00h", "17:00h - 18:00h", "18:00h - 19:00h", "19:00h - 20:00h", "20:00h - 21:00h",
				"21:00h - 22:00h", "22:00h - 23:00h" };
		String[] colunas = { "Horário", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado" };

		short contador = 0;

		// 119 é o número de (horarios * colunas) + colunas
		for (int i = 0; i < (horarios.length * colunas.length) + colunas.length; i++) {

			if (i < colunas.length) {
				JLabel label = new JLabel(colunas[i]);
				label.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(label);
			} else if (i % (colunas.length) == 0) {
				JLabel horas = new JLabel(horarios[contador]);
				horas.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(horas);
				contador++;
			} else {

				int numeroCelula = i % colunas.length;
				String diaCorrespondente = colunas[numeroCelula];
				String horaCorrespondente = horarios[contador - 1];

				JCheckBox checkBox = new JCheckBox();
				checkBox.setHorizontalAlignment(SwingConstants.CENTER);
				checkBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (checkBox.isSelected()) {
							if (diaCorrespondente.equals(colunas[1])) {
								seg = horaCorrespondente + "|" + seg;
								System.out.println(seg);
							}
							if (diaCorrespondente.equals(colunas[2]))
								ter = horaCorrespondente + "|" + ter;
							if (diaCorrespondente.equals(colunas[3]))
								qua = horaCorrespondente + "|" + qua;
							if (diaCorrespondente.equals(colunas[4]))
								qui = horaCorrespondente + "|" + qui;
							if (diaCorrespondente.equals(colunas[5]))
								sex = horaCorrespondente + "|" + sex;
							if (diaCorrespondente.equals(colunas[6]))
								sab = horaCorrespondente + "|" + sab;
						} else {
							if (diaCorrespondente.equals(colunas[1]))
								seg = seg.replace(horaCorrespondente + "|", "");
							if (diaCorrespondente.equals(colunas[2]))
								ter = ter.replace(horaCorrespondente + "|", "");
							if (diaCorrespondente.equals(colunas[3]))
								qua = qua.replace(horaCorrespondente + "|", "");
							if (diaCorrespondente.equals(colunas[4]))
								qui = qui.replace(horaCorrespondente + "|", "");
							if (diaCorrespondente.equals(colunas[5]))
								sex = sex.replace(horaCorrespondente + "|", "");
							if (diaCorrespondente.equals(colunas[6]))
								sab = sab.replace(horaCorrespondente + "|", "");
						}
						horario = new Horario(seg, ter, qua, qui, sex, sab);
					}
				});
				panel.add(checkBox);
			}
		}
	}
}
