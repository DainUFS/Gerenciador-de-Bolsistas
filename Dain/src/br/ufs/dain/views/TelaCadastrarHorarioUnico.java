package br.ufs.dain.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import br.ufs.dain.dao.DAO;
import br.ufs.dain.modelo.Bolsista;
import br.ufs.dain.modelo.Horario;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class TelaCadastrarHorarioUnico extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JPanel panel_nome = new JPanel();
	
	private JButton btnSalvar;
	private JButton btnLimpar;

	private String matriculaSelecionada;
	private String nomeSelecionado;
	private String cursoSelecionado;

	private JLabel labelNome;
	private JLabel labelCurso;

	private boolean isSalvo = true;

	private int indexSelecionado;
	JTextArea textArea;
	
	private String[] horarios = { "07:00h - 08:00h", "08:00h - 09:00h", "09:00h - 10:00h", "10:00h - 11:00h",
			"11:00h - 12:00h", "12:00h - 13:00h", "13:00h - 14:00h", "14:00h - 15:00h", "15:00h - 16:00h",
			"16:00h - 17:00h", "17:00h - 18:00h", "18:00h - 19:00h", "19:00h - 20:00h", "20:00h - 21:00h",
			"21:00h - 22:00h", "22:00h - 23:00h" };

	private String[] colunas = { "Horário", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado" };

	private JCheckBox[] arrayCheckBox = new JCheckBox[96];

	public TelaCadastrarHorarioUnico(Bolsista b) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastrarHorarioBolsista.class.getResource("/br/ufs/dain/resources/icon_hor_bol.png")));

		setLocationRelativeTo(null);
		setBounds(100, 100, 830, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setTitle("Cadastrar Hor\u00E1rio");
		
		nomeSelecionado = b.getNome();
		cursoSelecionado = b.getCurso();
		matriculaSelecionada = b.getMatricula();

		preencherPainelPrincipal();

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (!isSalvo)
					alertaSalvar();
				if (isSalvo)
					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				else
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		});
	}

	private void alertaSalvar () {

		int opcaoEscolhida = JOptionPane.showConfirmDialog(contentPane,
				"<html>Deseja salvar as alterações feitas em <b>" + nomeSelecionado + "</b> antes de sair?</html>",
				"Há alterações não salvas", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

		if (opcaoEscolhida == JOptionPane.YES_OPTION)
			salvarHorario();
		else if (opcaoEscolhida == JOptionPane.CANCEL_OPTION ||
				opcaoEscolhida == JOptionPane.CLOSED_OPTION)
			isSalvo = false;
		else
			isSalvo = true;
	}

	private void preencherPainelPrincipal () {

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salvarHorario();
			}
		});

		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i = 0; i < arrayCheckBox.length; i++)
					arrayCheckBox[i].setSelected(false);
				btnLimpar.setEnabled(false);
				btnSalvar.setEnabled(true);
				isSalvo = false;
			}
		});

		JPanel panel_botoes = new JPanel();
		panel_botoes.add(btnSalvar);
		panel_botoes.add(btnLimpar);

		JPanel panel_checkbox_botoes = new JPanel();
		panel_checkbox_botoes.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_checkbox_botoes.setLayout(new BorderLayout(0, 2));

		panel_nome.setBorder(new EmptyBorder(0, 0, 2, 0));
		panel_checkbox_botoes.add(panel_nome, BorderLayout.NORTH);
		panel_nome.setLayout(new GridLayout(2, 1, 0, 0));
		preencherInfo();

		JPanel panel = new JPanel();
		panel_checkbox_botoes.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_checkbox = new JPanel();
		panel.add(panel_checkbox, BorderLayout.CENTER);
		panel_checkbox.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_checkbox.setLayout(new GridLayout(17, 7, 0, 0));
		preencherCheckBox(panel_checkbox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(3, 3, 3, 3));
		panel.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 5));

		textArea = new JTextArea();
		textArea.setText("");
		panel_1.add(textArea);
		
		JLabel lblDigiteASua = new JLabel("Digite a sua justificativa por n\u00E3o poder trabalhar nos hor\u00E1rios selecionados (obrigat\u00F3rio)");
		lblDigiteASua.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDigiteASua.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblDigiteASua, BorderLayout.NORTH);
		panel_checkbox_botoes.add(panel_botoes, BorderLayout.SOUTH);

		JPanel panel_dica = new JPanel();
		panel_dica.setBackground(new Color(255, 255, 153));
		contentPane.add(panel_dica, BorderLayout.NORTH);

		JPanel panel_ = new JPanel();
		panel_.setBorder(new EmptyBorder(5, 0, 0, 0));
		panel_.setLayout(new BorderLayout(0, 0));
		panel_.add(panel_checkbox_botoes, BorderLayout.CENTER);
		contentPane.add(panel_);

		JLabel lblSelecioneUmBolsista = new JLabel("Selecione os hor\u00E1rios em que voc\u00EA n\u00E3o pode exercer sua fun\u00E7\u00E3o.");
		panel_dica.add(lblSelecioneUmBolsista);
		
		JScrollPane scrollPane = new JScrollPane(panel_checkbox_botoes);
		contentPane.add(scrollPane, BorderLayout.CENTER);
	}

	private void preencherInfo () {
		
		labelNome = new JLabel();
		labelNome.setText(nomeSelecionado);
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelNome.setHorizontalAlignment(SwingConstants.LEFT);

		labelCurso = new JLabel();
		labelCurso.setText(cursoSelecionado);
		labelCurso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelNome.setHorizontalAlignment(SwingConstants.LEFT);

		panel_nome.add(labelNome);
		panel_nome.add(labelCurso);
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
						isSalvo = false;
						isCheckBoxVazio();
					}
				});
				panel.add(arrayCheckBox[contador2]);
				contador2++;
			}
		}
	}

	private void salvarHorario () {

		int contador = 0;
		String seg = "";
		String ter = "";
		String qua = "";
		String qui = "";
		String sex = "";
		String sab = "";

		for (int i = 0; i < arrayCheckBox.length; i++) {
			if (i % 6 == 0) {
				if (arrayCheckBox[i].isSelected())
					seg = horarios[contador] + "|" + seg;
				else
					seg = seg.replace(horarios[contador] + "|", "");
			}
			else if (i % 6 == 1) {
				if (arrayCheckBox[i].isSelected())
					ter = horarios[contador] + "|" + ter;
				else
					ter = ter.replace(horarios[contador] + "|", "");
			}
			else if (i % 6 == 2) {
				if (arrayCheckBox[i].isSelected())
					qua = horarios[contador] + "|" + qua;
				else
					qua = qua.replace(horarios[contador] + "|", "");
			}
			else if (i % 6 == 3) {
				if (arrayCheckBox[i].isSelected())
					qui = horarios[contador] + "|" + qui;
				else
					qui = qui.replace(horarios[contador] + "|", "");
			}
			else if (i % 6 == 4) {
				if (arrayCheckBox[i].isSelected())
					sex = horarios[contador] + "|" + sex;
				else
					sex = sex.replace(horarios[contador] + "|", "");
			}
			else {
				if (arrayCheckBox[i].isSelected())
					sab = horarios[contador] + "|" + sab;
				else
					sab = sab.replace(horarios[contador] + "|", "");
				contador++;
			}
		}
		
		if(!textArea.getText().equals("")){
			new DAO().cadastrarHorarioBolsista(new Horario(seg, ter, qua, qui, sex, sab), matriculaSelecionada);
			btnSalvar.setEnabled(false);
			isSalvo = true;
		}else{
			JOptionPane.showMessageDialog(getContentPane(), "Digite a Justificativa!");
		}

		
	}

	private void atualizarPainel () {

		int contador = 0;

		Horario horario = new DAO().buscarHorarioBolsista(matriculaSelecionada);
		//		String segunda = horario.getSegunda();
		//		String terca = horario.getTerca();
		//		String quarta = horario.getQuarta();
		//		String quinta = horario.getQuinta();
		//		String sexta = horario.getSexta();
		//		String sabado = horario.getSabado();

		//System.out.println(horarios[0] + "\n" + segunda);

		for (int i = 0; i < arrayCheckBox.length; i++) {
			if (i % 6 == 0 && horario != null)
				if (horario.getSegunda().contains(horarios[contador]))
					arrayCheckBox[i].setSelected(true);
				else
					arrayCheckBox[i].setSelected(false);

			else if (i % 6 == 1 && horario != null)
				if (horario.getTerca().contains(horarios[contador]))
					arrayCheckBox[i].setSelected(true);
				else
					arrayCheckBox[i].setSelected(false);

			else if (i % 6 == 2 && horario != null)
				if (horario.getQuarta().contains(horarios[contador]))
					arrayCheckBox[i].setSelected(true);
				else
					arrayCheckBox[i].setSelected(false);

			else if (i % 6 == 3 && horario != null)
				if (horario.getQuinta().contains(horarios[contador]))
					arrayCheckBox[i].setSelected(true);
				else
					arrayCheckBox[i].setSelected(false);

			else if (i % 6 == 4 && horario != null)
				if (horario.getSexta().contains(horarios[contador]))
					arrayCheckBox[i].setSelected(true);
				else
					arrayCheckBox[i].setSelected(false);

			else {
				if ( horario != null && horario.getSabado().contains(horarios[contador]))
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