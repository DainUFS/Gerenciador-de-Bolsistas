package br.ufs.dain.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import br.ufs.dain.dao.DAO;
import br.ufs.dain.modelo.Administrador;
import br.ufs.dain.modelo.Bolsista;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTabbedPane tabbedPane;
	
	private final short SCROLL_SPEED = 10;
	
	public TelaPrincipal(Administrador adm) {
		
		getMenuBar(adm);
		setIconImage(Toolkit.getDefaultToolkit().getImage("..\\Dain\\img\\logoDain.jpg"));
		// aqui
		// tem
		// q
		// setar
		// diferente

		setExtendedState(MAXIMIZED_BOTH);
		setTitle("Divis\u00E3o de A\u00E7\u00F5es Inclusivas - Universidade Federal de Sergipe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 346);

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
		scrollPane.getVerticalScrollBar().setUnitIncrement(SCROLL_SPEED);
		scrollPane.getHorizontalScrollBar().setUnitIncrement(SCROLL_SPEED);
		tabbedPane.addTab("Tabela Principal", null, scrollPane, null);

		//
		JPanel panel = new JPanel();

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));

		JScrollPane scrollPane_1 = new JScrollPane(panel);
		scrollPane_1.getVerticalScrollBar().setUnitIncrement(SCROLL_SPEED);
		scrollPane_1.getHorizontalScrollBar().setUnitIncrement(SCROLL_SPEED);
		panel.setLayout(new BorderLayout(0, 0));

		panel.add(getTree());
		JScrollPane scrollPane_2 = new JScrollPane(panel_1);
		scrollPane_2.getVerticalScrollBar().setUnitIncrement(SCROLL_SPEED);
		scrollPane_2.getHorizontalScrollBar().setUnitIncrement(SCROLL_SPEED);

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
						new TelaHorarioAcompanhamento(diaCorrespondente, horaCorrespondente).abrirAba(tabbedPane);
						tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);					}
				});
			}
		}
	}
	
	private void getMenuBar (Administrador adm) {
		
		JMenuBar menuBar = new JMenuBar();
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

		JMenu mnItem_2 = new JMenu("Editar");
		menuBar.add(mnItem_2);

		JMenuItem mntmHorrioDoBolsista = new JMenuItem("Hor\u00E1rio do Bolsista");
		mnItem_2.add(mntmHorrioDoBolsista);

		JMenuItem mntmHorrios = new JMenuItem("Hor\u00E1rio dos Deficiente");
		mnItem_2.add(mntmHorrios);
		mntmHorrioDoBolsista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastrarHorarioBolsista telaCadastrarHorarioBolsista = new TelaCadastrarHorarioBolsista();
				telaCadastrarHorarioBolsista.setLocationRelativeTo(null);
				telaCadastrarHorarioBolsista.setVisible(true);
			}
		});

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
	}
	
	private JTree getTree () {

		ArrayList<Bolsista> bolsistas = new DAO().buscarBolsistas();

		DefaultMutableTreeNode nodeAdministradores = new DefaultMutableTreeNode("Administradores");
		DefaultMutableTreeNode nodeBolsistas = new DefaultMutableTreeNode("Bolsistas (" + bolsistas.size() + ")");
		DefaultMutableTreeNode nodeDeficientes = new DefaultMutableTreeNode("Deficientes");

		JTree tree = new JTree();
		tree.setShowsRootHandles(true);
		tree.setBorder(new EmptyBorder(3, 2, 3, 2));
		tree.setRootVisible(false);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		DefaultTreeModel model = new DefaultTreeModel(
				new DefaultMutableTreeNode("JTree") {
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;
					{
						nodeAdministradores.add(new DefaultMutableTreeNode("blue"));
//						nodeAdministradores.add(new DefaultMutableTreeNode("violet"));
//						nodeAdministradores.add(new DefaultMutableTreeNode("red"));
//						nodeAdministradores.add(new DefaultMutableTreeNode("yellow"));
						add(nodeAdministradores);

						for (int i = 0; i < bolsistas.size(); i++)
							nodeBolsistas.add(new DefaultMutableTreeNode(bolsistas.get(i).getNome()));
						add(nodeBolsistas);

						nodeDeficientes.add(new DefaultMutableTreeNode("hot dogs"));
//						nodeDeficientes.add(new DefaultMutableTreeNode("pizza"));
//						nodeDeficientes.add(new DefaultMutableTreeNode("ravioli"));
//						nodeDeficientes.add(new DefaultMutableTreeNode("bananas"));
						add(nodeDeficientes);
					}
				});
		tree.setModel(model);
		
		tree.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub	
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub	
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					DefaultMutableTreeNode node = (DefaultMutableTreeNode)
		                       tree.getLastSelectedPathComponent();
					if (node == null) return;
					if (node.isNodeAncestor(nodeBolsistas) && !node.equals(nodeBolsistas)) {
						new TelaInfoBolsista(node.toString()).abrirAba(tabbedPane);
						tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
					} else if (node.isNodeAncestor(nodeAdministradores) && !node.equals(nodeAdministradores)) {
						new TelaInfoAdm(node.toString()).abrirAba(tabbedPane);
						tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
					} else if (node.isNodeAncestor(nodeDeficientes) && !node.equals(nodeDeficientes)) {
						new TelaInfoDeficiente(node.toString()).abrirAba(tabbedPane);
						tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
					}
					/* retrieve the node that was selected */ 
	                Object nodeInfo = node.getUserObject();
				}
			}
		});
		
		tree.addMouseListener(new MouseAdapter() {
			@Override
	        public void mouseClicked(MouseEvent e) {
	            if (e.getClickCount() == 2) {
	                DefaultMutableTreeNode node = (DefaultMutableTreeNode)
	                       tree.getLastSelectedPathComponent();
	                if (node == null) return;
	                if (node.isNodeAncestor(nodeBolsistas) && !node.equals(nodeBolsistas)) {
						new TelaInfoBolsista(node.toString()).abrirAba(tabbedPane);
						tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
					} else if (node.isNodeAncestor(nodeAdministradores) && !node.equals(nodeAdministradores)) {
						new TelaInfoAdm(node.toString()).abrirAba(tabbedPane);
						tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
					} else if (node.isNodeAncestor(nodeDeficientes) && !node.equals(nodeDeficientes)) {
						new TelaInfoDeficiente(node.toString()).abrirAba(tabbedPane);
						tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
					}
	                /* retrieve the node that was selected */ 
	                Object nodeInfo = node.getUserObject();
	            }
	        }
	    });

		expandAllNodes(tree, 0, 3);

		return tree;
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