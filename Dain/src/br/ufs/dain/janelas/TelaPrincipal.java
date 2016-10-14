package br.ufs.dain.janelas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaPrincipal extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setLocationRelativeTo(null);
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
	public TelaPrincipal() {

		setIconImage(Toolkit.getDefaultToolkit().getImage("..\\Dain\\img\\logoDain.jpg")); //aqui tem q setar diferente

		setTitle("Divis\u00E3o de A\u00E7\u00F5es Inclusivas - Dain");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnItem = new JMenu("Arquivo");
		menuBar.add(mnItem);

		JMenu mnNewMenu = new JMenu("New menu");
		mnItem.add(mnNewMenu);

		JMenu mnItem_1 = new JMenu("Cadastrar");
		mnItem_1.setMnemonic('C');
		menuBar.add(mnItem_1);

		JMenu mnNovoAluno = new JMenu("Novo Aluno");
		mnItem_1.add(mnNovoAluno);

		JMenuItem mntmBolsista = new JMenuItem("Bolsista");
		mntmBolsista.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent event) {
				new TelaNovoBolsista().setVisible(true);
			}
		});
		mnNovoAluno.add(mntmBolsista);

		JMenuItem mntmDeficinte = new JMenuItem("Defici\u00EAnte");
		mnNovoAluno.add(mntmDeficinte);

		JMenuItem mntmAdministrador = new JMenuItem("Administrador");
		mnItem_1.add(mntmAdministrador);

		JMenu mnItem_2 = new JMenu("item 3");
		menuBar.add(mnItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(17, 7, 2, 2));

		/*
		 * organiza os ítens que mostra os horários
		 * e também os botões que chamam as novas telas
		 */
		organizaTabela(panelCentro);
	}

	private void organizaTabela (JPanel panel) {

		String [] horarios = {"07:00h - 08:00h", "08:00h - 09:00h", "09:00h - 10:00h", "10:00h - 11:00h",
				"11:00h - 12:00h", "12:00h - 13:00h", "13:00h - 14:00h", "14:00h - 15:00h", "15:00h - 16:00h",
				"16:00h - 17:00h", "17:00h - 18:00h", "18:00h - 19:00h", "19:00h - 20:00h", "20:00h - 21:00h",
				"21:00h - 22:00h", "22:00h - 23:00h"};
		String [] colunas = {"Horário", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado"};

		short contador = 0;

		// 119 é o número de (linhas * colunas) + colunas
		for (int i = 0; i < 119; i++) {

			if (i < colunas.length) {
				JLabel label = new JLabel(colunas[i]);
				if (i != 0)
					label.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(label);
			}
			else if (i % (colunas.length) == 0) {
				JLabel horas = new JLabel(horarios[contador]);
				panel.add(horas);
				contador++;
			}
			else {
				JButton button = new JButton(String.valueOf(i));
				panel.add(button);
				button.setFocusPainted(false);
				button.setContentAreaFilled(false);
				int numeroCelula = i;

				// função para chamar nova tela ao clicar em botão
				button.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent event) {

						//System.err.println("Hey!");
						new TelaHorarioAcompanhamento(numeroCelula).setVisible(true);
					}
				});
			}
		}
	}
}