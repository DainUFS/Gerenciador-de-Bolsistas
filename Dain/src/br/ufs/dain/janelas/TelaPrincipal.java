package br.ufs.dain.janelas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class TelaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTabbedPane tabbedPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					TelaPrincipal frame = new TelaPrincipal();
					frame.setLocationRelativeTo(null);
					//frame.pack();
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
		setBounds(100, 100, 812, 578);

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

		//

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		JPanel panelCentro = new JPanel();
		panelCentro.setLayout(new GridLayout(17, 7, 2, 2));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JScrollPane scrollPane_1 = new JScrollPane(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel.add(btnNewButton_1);
		contentPane.add(scrollPane_1, BorderLayout.WEST);
		
		JScrollPane scrollPane = new JScrollPane(panelCentro);
		tabbedPane.addTab("Tabela Principal", null, scrollPane, null);
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, tabbedPane, scrollPane_1);
		splitPane.setResizeWeight(0.8);
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		organizaTabela(panelCentro);
	}

	private void organizaTabela (JPanel panel) {

		String [] horarios = {"07:00h - 08:00h", "08:00h - 09:00h", "09:00h - 10:00h", "10:00h - 11:00h",
				"11:00h - 12:00h", "12:00h - 13:00h", "13:00h - 14:00h", "14:00h - 15:00h", "15:00h - 16:00h",
				"16:00h - 17:00h", "17:00h - 18:00h", "18:00h - 19:00h", "19:00h - 20:00h", "20:00h - 21:00h",
				"21:00h - 22:00h", "22:00h - 23:00h"};
		String [] colunas = {"Horário", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado"};

		short contador = 0;
		
		// 119 é o número de (horarios * colunas) + colunas
		for (int i = 0; i < (horarios.length * colunas.length) + colunas.length; i++) {

			if (i < colunas.length) {
				JLabel label = new JLabel(colunas[i]);
				label.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(label);
			}
			else if (i % (colunas.length) == 0) {
				JLabel horas = new JLabel(horarios[contador]);
				horas.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(horas);
				contador++;
			}
			else {
				
				JButton button = new JButton(String.valueOf(i));
				panel.add(button);
				button.setFocusPainted(false);
				//button.setContentAreaFilled(false);
				
				if (i == 100)
					button.setText("<html><body>Murilo  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Almeida<br>"
											 + "Formiga &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Negão<br>"
											 + "Yuri    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Zezão</body></html>");
				
				int numeroCelula = i % colunas.length;
				String diaCorrespondente = colunas[numeroCelula];
				String horaCorrespondente = horarios[contador - 1];

				// função para chamar nova tela ao clicar em botão
				button.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent event) {

						//System.err.println("Hey!");
						TelaHorarioAcompanhamento telaHA = new TelaHorarioAcompanhamento(diaCorrespondente, horaCorrespondente);
						if (telaHA.isActive() && !telaHA.hasFocus()) {
							telaHA.toFront();
						} else {

							new TelaHorarioAcompanhamento(diaCorrespondente, horaCorrespondente).abrirAba(tabbedPane);

						}
					}
				});

			}
		}
	}
}