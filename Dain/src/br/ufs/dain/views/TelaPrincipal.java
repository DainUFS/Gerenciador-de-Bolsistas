package br.ufs.dain.views;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Font;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
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
import br.ufs.dain.modelo.Deficiente;
import br.ufs.dain.modelo.Horario;
import br.ufs.dain.modelo.Nota;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;

	private JButton[] arrayButton = new JButton[96];

	private final static short SCROLL_SPEED = 12;

	private ArrayList<Bolsista> bolsistas = new DAO().buscarBolsistas();
	private ArrayList<Administrador> adms = new DAO().buscarAdm();
	private ArrayList<Deficiente> deficientes = new DAO().buscarDeficiente();

	private String[] horarios = { "07:00h - 08:00h", "08:00h - 09:00h", "09:00h - 10:00h", "10:00h - 11:00h",
			"11:00h - 12:00h", "12:00h - 13:00h", "13:00h - 14:00h", "14:00h - 15:00h", "15:00h - 16:00h",
			"16:00h - 17:00h", "17:00h - 18:00h", "18:00h - 19:00h", "19:00h - 20:00h", "20:00h - 21:00h",
			"21:00h - 22:00h", "22:00h - 23:00h" };

	private String[] colunas = { "Hor�rio", "Segunda", "Ter�a", "Quarta", "Quinta", "Sexta", "S�bado" };

	public TelaPrincipal(Administrador adm) {

		getMenuBar(adm);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/br/ufs/dain/resources/logoDainIcone.png")));

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
		panelCentro.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		panelCentro.setBorder(new EmptyBorder(10, 5, 10, 5));
		panelCentro.setLayout(new GridLayout(17, 7, 2, 2));

		JScrollPane scrollPane = new JScrollPane(panelCentro);
		scrollPane.getVerticalScrollBar().setUnitIncrement(SCROLL_SPEED);
		scrollPane.getHorizontalScrollBar().setUnitIncrement(SCROLL_SPEED);
		tabbedPane.addTab("Tabela Principal", null, scrollPane, null);

		//
		JPanel panel = new JPanel();

		JPanel panel_1 = new JPanel();

		JScrollPane scrollPane_1 = new JScrollPane(panel);
		scrollPane_1.getVerticalScrollBar().setUnitIncrement(SCROLL_SPEED);
		scrollPane_1.getHorizontalScrollBar().setUnitIncrement(SCROLL_SPEED);
		panel.setLayout(new BorderLayout(0, 0));

		panel.add(getTree());
		JScrollPane scrollPane_2 = new JScrollPane(panel_1);
		scrollPane_2.getVerticalScrollBar().setUnitIncrement(SCROLL_SPEED);
		scrollPane_2.getHorizontalScrollBar().setUnitIncrement(SCROLL_SPEED);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{100, 0};
		gbl_panel_1.rowHeights = new int[]{29, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		/*DAO dao = new DAO();
				ArrayList<Nota> todasNotas = dao.TodasAsNota();
				
				for (int i = 0; i < todasNotas.size(); i++) {
					
					int x = i;
					
					JPanel panel_interno = new JPanel();
					panel_interno.setLayout(new BorderLayout());
				
					
					JLabel label_adm_1 = new JLabel();
					GridBagConstraints gbc_label_adm_1 = new GridBagConstraints();
					label_adm_1.setText(todasNotas.get(i).getAnotacao());
					gbc_label_adm_1.insets = new Insets(0, 0, 5, 0);
					gbc_label_adm_1.fill = GridBagConstraints.BOTH;
					gbc_label_adm_1.gridx = 0;
					gbc_label_adm_1.gridy = 0;
					panel_1.add(label_adm_1, gbc_label_adm_1);
					
					panel_interno.add(BorderLayout.CENTER, label_adm_1);
					
					panel.add(panel_interno);
				}	**/
		DAO dao = new DAO();
		ArrayList<Nota> todasNotas = dao.TodasAsNota();
		for (int i = 0; i < todasNotas.size(); i++) {
			JLabel label_adm_1 = new JLabel(todasNotas.get(i).getAnotacao().toString());
			GridBagConstraints gbc_label_adm_1 = new GridBagConstraints();
			gbc_label_adm_1.insets = new Insets(0, 0, 5, 0);
			gbc_label_adm_1.fill = GridBagConstraints.BOTH;
			gbc_label_adm_1.gridx = 0;
			gbc_label_adm_1.gridy = 0;
			panel_1.add(label_adm_1, gbc_label_adm_1);
		}
				
				
				
				/*JLabel label_adm_2 = new JLabel("New label");
				GridBagConstraints gbc_label_adm_2 = new GridBagConstraints();
				gbc_label_adm_2.insets = new Insets(0, 0, 5, 0);
				gbc_label_adm_2.gridx = 0;
				gbc_label_adm_2.gridy = 1;   
				panel_1.add(label_adm_2, gbc_label_adm_2);
				
				JLabel label_adm_3 = new JLabel("New label");
				GridBagConstraints gbc_label_adm_3 = new GridBagConstraints();
				gbc_label_adm_3.insets = new Insets(0, 0, 5, 0);
				gbc_label_adm_3.gridx = 0;
				gbc_label_adm_3.gridy = 2;
				panel_1.add(label_adm_3, gbc_label_adm_3);
				
				JLabel label_adm_4 = new JLabel("New label");
				GridBagConstraints gbc_label_adm_4 = new GridBagConstraints();
				gbc_label_adm_4.insets = new Insets(0, 0, 5, 0);
				gbc_label_adm_4.gridx = 0;
				gbc_label_adm_4.gridy = 3;
				panel_1.add(label_adm_4, gbc_label_adm_4);
				
				JLabel label_adm_5 = new JLabel("New label");
				GridBagConstraints gbc_label_adm_5 = new GridBagConstraints();
				gbc_label_adm_5.gridx = 0;
				gbc_label_adm_5.gridy = 4;
				panel_1.add(label_adm_5, gbc_label_adm_5);*/

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

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		contentPane.add(panel_2, BorderLayout.SOUTH);

		JLabel label_Nomeadm = new JLabel(adm.getNome());
		panel_2.add(label_Nomeadm);

		organizaTabela(panelCentro);
		distribuiNomes();
	}

	private void organizaTabela(JPanel panel) {

		int contador1 = 0;
		int contador2 = 0;

		// 119 � o n�mero de (horarios * colunas) + colunas
		for (int i = 0; i < (horarios.length * colunas.length) + colunas.length; i++) {

			if (i < colunas.length) {
				JLabel label = new JLabel(colunas[i]);
				label.setFont(new Font("Arial", Font.PLAIN, 13));
				label.setBorder(UIManager.getBorder("FormattedTextField.border"));
				label.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(label);
			} else if (i % (colunas.length) == 0) {
				JLabel horas = new JLabel(horarios[contador1]);
				horas.setFont(new Font("Arial", Font.PLAIN, 13));
				horas.setBorder(UIManager.getBorder("FormattedTextField.border"));
				horas.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(horas);
				contador1++;
			} else {

				int numeroCelula = i % colunas.length;
				String diaCorrespondente = colunas[numeroCelula];
				String horaCorrespondente = horarios[contador1 - 1];

				arrayButton[contador2] = new JButton();
				arrayButton[contador2].setContentAreaFilled(false);
				arrayButton[contador2].setBorder(UIManager.getBorder("FormattedTextField.border"));
				arrayButton[contador2].setBorderPainted(true);
				arrayButton[contador2].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				arrayButton[contador2].setToolTipText(diaCorrespondente + ", " + horaCorrespondente);

				// fun��o para chamar nova tela ao clicar em bot�o
				arrayButton[contador2].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent event) {
						new TelaHorarioAcompanhamento(diaCorrespondente, horaCorrespondente).abrirAba(tabbedPane);
						tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
					}
				});
				panel.add(arrayButton[contador2]);
				contador2++;
			}
		}
	}

	private void distribuiNomes () {

		ArrayList<Bolsista> bolsistas = new DAO().buscarBolsistas();

		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < bolsistas.size(); i++) {

					int contador = 0;

					Horario horario = new DAO().buscarHorarioBolsista(bolsistas.get(i).getMatricula());
					String segunda = horario.getSegunda();
					String terca = horario.getTerca();
					String quarta = horario.getQuarta();
					String quinta = horario.getQuinta();
					String sexta = horario.getSexta();
					String sabado = horario.getSabado();

					for (int j = 0; j < arrayButton.length; j++) {

						if (j % 6 == 0)
							if (segunda.contains(horarios[contador] + "|"))
								inserirNomeTabela(bolsistas.get(i).getMatricula(), j);
							else
								arrayButton[j].setSelected(false);

						else if (j % 6 == 1)
							if (terca.contains(horarios[contador] + "|"))
								inserirNomeTabela(bolsistas.get(i).getMatricula(), j);
							else
								arrayButton[j].setSelected(false);

						else if (j % 6 == 2)
							if (quarta.contains(horarios[contador] + "|"))
								inserirNomeTabela(bolsistas.get(i).getMatricula(), j);
							else
								arrayButton[j].setSelected(false);

						else if (j % 6 == 3)
							if (quinta.contains(horarios[contador] + "|"))
								inserirNomeTabela(bolsistas.get(i).getMatricula(), j);
							else
								arrayButton[j].setSelected(false);

						else if (j % 6 == 4)
							if (sexta.contains(horarios[contador] + "|"))
								inserirNomeTabela(bolsistas.get(i).getMatricula(), j);
							else
								arrayButton[j].setSelected(false);

						else {
							if (sabado.contains(horarios[contador] + "|"))
								inserirNomeTabela(bolsistas.get(i).getMatricula(), j);
							else
								arrayButton[j].setSelected(false);
							contador++;
						}
					}
				}
			}
		}).start();
	}

	private void inserirNomeTabela (String matricula, int indice) {

		Bolsista b = new DAO().getBolsistaMatricula(matricula);
		String s = arrayButton[indice].getText();
		s = s.replace("<html>", "");
		s = s.replace("</html>", "");
		s = s.replace("<body>", "");
		s = s.replace("</body>", "");
		if (s.equals(""))
			arrayButton[indice].setText(b.getNome());
		else
			arrayButton[indice].setText("<html><body>" + s + "<br>" + b.getNome());
	}

	private void getMenuBar (Administrador adm) {

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		setJMenuBar(menuBar);

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

		JMenuItem mntmDeficiente = new JMenuItem("Assistido");
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

		JMenu mnItem_2 = new JMenu("Hor\u00E1rio");
		menuBar.add(mnItem_2);

		JMenuItem mntmHorrioDoBolsista = new JMenuItem("Bolsistas");
		mnItem_2.add(mntmHorrioDoBolsista);

		JMenuItem mntmHorrios = new JMenuItem("Assistidos");
		mnItem_2.add(mntmHorrios);

		mntmHorrioDoBolsista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastrarHorarioBolsista telaCadastrarHorarioBolsista = new TelaCadastrarHorarioBolsista();
				telaCadastrarHorarioBolsista.setLocationRelativeTo(null);
				telaCadastrarHorarioBolsista.setVisible(true);
			}
		});

		mntmHorrios.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TelaCadastrarHorarioDeficiente telaCadastrarHorarioDeficiente = new TelaCadastrarHorarioDeficiente();
				telaCadastrarHorarioDeficiente.setLocationRelativeTo(null);
				telaCadastrarHorarioDeficiente.setVisible(true);
			}
		});

		JMenu mnNotas = new JMenu("Notas");
		menuBar.add(mnNotas);

		JMenuItem mntmNova = new JMenuItem("Nova Nota");
		mntmNova.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaNovaNota telaNovaNota = new TelaNovaNota(adm.getMatricula(), null);
				telaNovaNota.setLocationRelativeTo(null);
				telaNovaNota.setVisible(true);
			}
		});
		mnNotas.add(mntmNova);

		JMenuItem mntmMinhasNotas = new JMenuItem("Minhas Notas");
		mntmMinhasNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaMinhasNotas telaMinhasNotas = new TelaMinhasNotas(adm);
				telaMinhasNotas.setLocationRelativeTo(null);
				telaMinhasNotas.setVisible(true);
			}
		});
		mnNotas.add(mntmMinhasNotas);

		JMenu mnNewMenu_3 = new JMenu("Conta");
		menuBar.add(mnNewMenu_3);

		JMenuItem mntmDetalhes = new JMenuItem("Minha Conta");
		mntmDetalhes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaMinhaConta minhaConta = new TelaMinhaConta(adm);
				minhaConta.setLocationRelativeTo(null);
				minhaConta.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmDetalhes);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(contentPane, "Deseja realmente sair, " + adm.getNome() + "?", "Sair",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (n == JOptionPane.YES_OPTION) {
					TelaLogin telaLogin = new TelaLogin();
					telaLogin.setLocationRelativeTo(null);
					telaLogin.setVisible(true);
					dispose();
				}
			}
		});
		mnNewMenu_3.add(mntmSair);

		JMenu mnNewMenu_4 = new JMenu("Ajuda");
		menuBar.add(mnNewMenu_4);

		JMenuItem mntmExibirAjuda = new JMenuItem("Exibir Ajuda");
		mntmExibirAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaExibirAjuda exibirAjuda = new TelaExibirAjuda();
				exibirAjuda.setLocationRelativeTo(null);
				exibirAjuda.setVisible(true);
			}
		});
		mnNewMenu_4.add(mntmExibirAjuda);

		JSeparator separator = new JSeparator();
		mnNewMenu_4.add(separator);

		JMenuItem mntmSobre = new JMenuItem("Sobre o Sistema");
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSobre telaSobre = new TelaSobre();
				telaSobre.setLocationRelativeTo(null);
				telaSobre.setVisible(true);
			}
		});
		mnNewMenu_4.add(mntmSobre);
	}

	private JTree getTree () {

		DefaultMutableTreeNode nodeAdministradores = new DefaultMutableTreeNode("Administradores (" + adms.size() + ")");
		DefaultMutableTreeNode nodeBolsistas = new DefaultMutableTreeNode("Bolsistas (" + bolsistas.size() + ")");
		DefaultMutableTreeNode nodeDeficientes = new DefaultMutableTreeNode("Assistidos (" + deficientes.size() + ")");

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
						for (int i = 0; i < adms.size(); i++)
							nodeAdministradores.add(new DefaultMutableTreeNode(adms.get(i).getNome()));
							add(nodeAdministradores);

						for (int i = 0; i < bolsistas.size(); i++)
							nodeBolsistas.add(new DefaultMutableTreeNode(bolsistas.get(i).getNome()));
							add(nodeBolsistas);

						for (int i = 0; i < deficientes.size(); i++)
							nodeDeficientes.add(new DefaultMutableTreeNode(deficientes.get(i).getNome()));
							add(nodeDeficientes);
					}
				});
		tree.setModel(model);

		tree.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {}

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
					//Object nodeInfo = node.getUserObject();
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
					//Object nodeInfo = node.getUserObject();
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

		if(tree.getRowCount() != rowCount) {
			expandAllNodes(tree, rowCount, tree.getRowCount());
		}
	}
}