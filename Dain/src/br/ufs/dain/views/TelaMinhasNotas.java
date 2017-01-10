package br.ufs.dain.views;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufs.dain.dao.DAO;
import br.ufs.dain.gerenciador.GerenciadorLogin;
import br.ufs.dain.modelo.Administrador;
import br.ufs.dain.modelo.Nota;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

public class TelaMinhasNotas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private final short SCROLL_SPEED = 12;

	public TelaMinhasNotas(Administrador adm) {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 730, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.getVerticalScrollBar().setUnitIncrement(SCROLL_SPEED);
		scrollPane.getHorizontalScrollBar().setUnitIncrement(SCROLL_SPEED);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		contentPane.add(scrollPane);

		ArrayList<Nota> notas = new DAO().buscarNota(adm.getMatricula());
		
		for (int i = 0; i < notas.size(); i++) {
			
			JButton editar = new JButton("Editar");
			JButton excluir = new JButton("Excluir");
			
			JPanel panel_2 = new JPanel();
			panel_2.add(editar);
			panel_2.add(excluir);
			
			int x = i;
			
			JPanel panel_interno = new JPanel();
			panel_interno.setLayout(new BorderLayout());
			JTextArea textArea = new JTextArea();
			textArea.setEditable(false);
			textArea.setLineWrap(true);
			textArea.setText(notas.get(i).getAnotacao());
			panel_interno.add(BorderLayout.CENTER, textArea);
			panel_interno.add(BorderLayout.SOUTH, panel_2);
			
			editar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new TelaNovaNota(adm.getMatricula(), notas.get(x).getAnotacao());
					String nota = textArea.getText().toString();
					TelaEditarNota edita = new TelaEditarNota(nota, adm);
					edita.setLocationRelativeTo(null);
					edita.setVisible(true);
					setVisible(false);
				}
			});
			
			excluir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DAO dao = new DAO();
					dao.deletarNota(textArea.getText().toString());
					JOptionPane.showMessageDialog(null, "Nota deletada com sucesso!");
					setVisible(false);
					TelaMinhasNotas telaMinhasNotas = new TelaMinhasNotas(adm);
					telaMinhasNotas.setLocationRelativeTo(null);
					telaMinhasNotas.setVisible(true);
					
				}
			});
			
			panel.add(panel_interno);
		}		
	}
}
