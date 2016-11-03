package br.ufs.dain.janelas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

import br.ufs.dain.dao.DAO;
import br.ufs.dain.dominio.Administrador;
import java.awt.Dimension;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;


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
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//					TelaPrincipal frame = new TelaPrincipal();
//					frame.setLocationRelativeTo(null);
//					// frame.pack();
//					frame.setVisible(true);
//					frame.setExtendedState(MAXIMIZED_BOTH);
//				} catch (Exception e) {
//					e.printStackTrace();
//
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal(Administrador adm) {
		setMinimumSize(new Dimension(500, 400));

		setIconImage(Toolkit.getDefaultToolkit().getImage("..\\Dain\\img\\logoDain.jpg")); // aqui
																							// tem
																							// q
																							// setar
																							// diferente
		setExtendedState(MAXIMIZED_BOTH);
		setTitle("Divis\u00E3o de A\u00E7\u00F5es Inclusivas - Dain");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 346);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnItem = new JMenu("Arquivo");
		menuBar.add(mnItem);

		JMenu mnNewMenu = new JMenu("New menu");
		mnItem.add(mnNewMenu);

		JMenu mnItem_1 = new JMenu("Cadastrar");
		mnItem_1.setMnemonic('C');
		menuBar.add(mnItem_1);
		
		JMenuItem mntmBolsista = new JMenuItem("Bolsista");
		mntmBolsista.setIcon(new ImageIcon(getClass().getResource("/br/ufs/dain/img/icone_bolsista.png")));
		mntmBolsista.setMnemonic('B');
		mntmBolsista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaNovoBolsista tnv = new TelaNovoBolsista(adm);
				tnv.setLocationRelativeTo(null);
				tnv.setVisible(true);
			}
		});
		mnItem_1.add(mntmBolsista);
		
		JMenuItem mntmDeficiente = new JMenuItem("Deficiente");
		mntmDeficiente.setIcon(new ImageIcon(getClass().getResource("/br/ufs/dain/img/icone_deficiente.png")));
		mntmDeficiente.setMnemonic('D');
		mntmDeficiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaNovoDeficiente tnd = new TelaNovoDeficiente(adm);
				tnd.setLocationRelativeTo(null);
				tnd.setVisible(true);
			}
		});
		mnItem_1.add(mntmDeficiente);
		
		JMenuItem mntmAdministrador = new JMenuItem("Administrador");
		mntmAdministrador.setIcon(new ImageIcon(getClass().getResource("/br/ufs/dain/img/icone_adm.png")));
		mntmAdministrador.setMnemonic('A');
		mntmAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaNovoAdm tna = new TelaNovoAdm();
				tna.setLocationRelativeTo(null);
				tna.setVisible(true);
			}
		});
		mnItem_1.add(mntmAdministrador);
		
		JSeparator separator = new JSeparator();
		mnItem_1.add(separator);
		
		JMenuItem mntmHorrios = new JMenuItem("Hor\u00E1rios");
		mnItem_1.add(mntmHorrios);

		JMenu mnItem_2 = new JMenu("Editar");
		menuBar.add(mnItem_2);

		JMenu mnNewMenu_2 = new JMenu("Sistema");
		menuBar.add(mnNewMenu_2);

		JMenu mnNewMenu_3 = new JMenu("Conta");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmDetalhes = new JMenuItem("Detalhes");
		mnNewMenu_3.add(mntmDetalhes);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mnNewMenu_3.add(mntmSair);

		JMenu mnNewMenu_4 = new JMenu("Ajuda");
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mnNewMenu_4.add(mntmSobre);

		//

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(2, 2, 2, 2));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		JPanel panelCentro = new JPanel();
		panelCentro.setBorder(new EmptyBorder(0, 0, 10, 20));
		panelCentro.setLayout(new GridLayout(17, 7, 2, 2));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);

		JScrollPane scrollPane_1 = new JScrollPane(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JTree tree = new JTree();
		panel.add(tree);
		
		JLabel label_adm = new JLabel(adm.getNome());
		panel.add(label_adm);
		contentPane.add(scrollPane_1, BorderLayout.WEST);

		JScrollPane scrollPane = new JScrollPane(panelCentro);
		tabbedPane.addTab("Tabela Principal", null, scrollPane, null);

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, tabbedPane, scrollPane_1);
		splitPane.setResizeWeight(0.8);
		contentPane.add(splitPane, BorderLayout.CENTER);

		organizaTabela(panelCentro);
	}

	private void organizaTabela(JPanel panel) {

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

				JButton button = new JButton(String.valueOf(i));
				panel.add(button);
				button.setFocusPainted(false);
				button.setToolTipText(diaCorrespondente + ", " + horaCorrespondente);
				// button.setContentAreaFilled(false);

				if (i == 100)
					button.setText(
							"<html><body><font style=\"color:red\">Murilo</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Almeida<br>"
									+ "<font style=\"color:green\">Formiga</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Negão<br></body></html>");

				// função para chamar nova tela ao clicar em botão
				button.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent event) {

						if (false) {
								System.out.println("Nada, Nada, Nada, Nada!");
						} else {

							new TelaHorarioAcompanhamento(diaCorrespondente, horaCorrespondente).abrirAba(tabbedPane);

						}
					}
				});

			}
		}
	}
	
	private void expandAllNodes (JTree tree, int startingIndex, int rowCount) {
	    for(int i = startingIndex; i < rowCount; ++i){
	        tree.expandRow(i);
	    }

	    if(tree.getRowCount() != rowCount){
	        expandAllNodes(tree, rowCount, tree.getRowCount());
	    }
	}
}