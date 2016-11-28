package br.ufs.dain.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import br.ufs.dain.dao.DAO;
import br.ufs.dain.modelo.Administrador;
import br.ufs.dain.modelo.Bolsista;
import br.ufs.dain.modelo.Deficiente;

import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.UIManager;
import java.awt.Insets;

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
		setTitle("Divis\u00E3o de A\u00E7\u00F5es Inclusivas - Universidade Federal de Sergipe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 346);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(2, 2, 2, 2));
		menuBar.setBorderPainted(false);
		setJMenuBar(menuBar);

		JMenu mnItem = new JMenu("Arquivo");
		menuBar.add(mnItem);

		JMenu mnNewMenu = new JMenu("New menu");
		mnItem.add(mnNewMenu);

		JMenu mnItem_1 = new JMenu("Cadastrar");
		mnItem_1.setMnemonic('C');
		menuBar.add(mnItem_1);
		
		JMenuItem mntmBolsista = new JMenuItem("Bolsista");
		mntmBolsista.setIcon(new ImageIcon(getClass().getResource("/br/ufs/dain/resources/icone_bolsista.png")));
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
		mntmDeficiente.setIcon(new ImageIcon(getClass().getResource("/br/ufs/dain/resources/icone_deficiente.png")));
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
		mntmAdministrador.setIcon(new ImageIcon(getClass().getResource("/br/ufs/dain/resources/icone_adm.png")));
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
		
		JMenuItem mntmHorrioDoBolsista = new JMenuItem("Hor\u00E1rio do Bolsista");
		mntmHorrioDoBolsista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastrarHorarioBolsista telaCadastrarHorarioBolsista = new TelaCadastrarHorarioBolsista();
				telaCadastrarHorarioBolsista.setLocationRelativeTo(null);
				telaCadastrarHorarioBolsista.setVisible(true);
			}
		});
		mnItem_1.add(mntmHorrioDoBolsista);
		
		JMenuItem mntmHorrios = new JMenuItem("Hor\u00E1rio dos Deficiente");
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
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		JPanel panelCentro = new JPanel();
		panelCentro.setBackground(new Color(204, 204, 255));
		panelCentro.setBorder(new EmptyBorder(0, 0, 10, 20));
		panelCentro.setLayout(new GridLayout(17, 7, 2, 2));
		
		JScrollPane scrollPane = new JScrollPane(panelCentro);
		tabbedPane.addTab("Tabela Principal", null, scrollPane, null);
		
		//
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		ArrayList<Bolsista> bolsistas = new DAO().buscarBolsistas();
		
		JTree tree = new JTree();
		tree.setBorder(new EmptyBorder(3, 2, 3, 2));
		tree.setRootVisible(false);
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("JTree") {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("Administradores");
						node_1.add(new DefaultMutableTreeNode("blue"));
						node_1.add(new DefaultMutableTreeNode("violet"));
						node_1.add(new DefaultMutableTreeNode("red"));
						node_1.add(new DefaultMutableTreeNode("yellow"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Bolsistas");
					for (int i = 0; i < bolsistas.size(); i++)
						node_1.add(new DefaultMutableTreeNode(bolsistas.get(i).getNome()));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Deficientes");
						node_1.add(new DefaultMutableTreeNode("hot dogs"));
						node_1.add(new DefaultMutableTreeNode("pizza"));
						node_1.add(new DefaultMutableTreeNode("ravioli"));
						node_1.add(new DefaultMutableTreeNode("bananas"));
					add(node_1);
				}
			}
		));
		expandAllNodes(tree, 0, 3);
		panel.add(tree);
		JScrollPane scrollPane_2 = new JScrollPane(panel_1);
		
		JLabel label_adm = new JLabel(adm.getNome());
		panel_1.add(label_adm);

		JSplitPane splitPane_1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, scrollPane_1, scrollPane_2);
		splitPane_1.setContinuousLayout(true);
		splitPane_1.setResizeWeight(0.5);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane_1, BorderLayout.EAST);
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, tabbedPane, splitPane_1);
		splitPane.setContinuousLayout(true);
		splitPane.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		splitPane.setResizeWeight(0.8);
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		organizaTabela(panelCentro);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JLabel label_Nomeadm = new JLabel(adm.getNome());
		panel_2.add(label_Nomeadm);
	}

	private void organizaTabela(JPanel panel) {

		String[] horarios = { "07:00h - 08:00h", "08:00h - 09:00h", "09:00h - 10:00h", "10:00h - 11:00h",
				"11:00h - 12:00h", "12:00h - 13:00h", "13:00h - 14:00h", "14:00h - 15:00h", "15:00h - 16:00h",
				"16:00h - 17:00h", "17:00h - 18:00h", "18:00h - 19:00h", "19:00h - 20:00h", "20:00h - 21:00h",
				"21:00h - 22:00h", "22:00h - 23:00h" };
		String[] colunas = { "Hor�rio", "Segunda", "Ter�a", "Quarta", "Quinta", "Sexta", "S�bado" };

		short contador = 0;

		// 119 � o n�mero de (horarios * colunas) + colunas
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
									+ "<font style=\"color:green\">Formiga</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Neg�o<br></body></html>");

				// fun��o para chamar nova tela ao clicar em bot�o
				button.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent event) {
							new TelaHorarioAcompanhamento(diaCorrespondente, horaCorrespondente).abrirAba(tabbedPane);
							tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);					}
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