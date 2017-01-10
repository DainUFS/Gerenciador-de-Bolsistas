package br.ufs.dain.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufs.dain.dao.DAO;
import br.ufs.dain.modelo.Administrador;
import br.ufs.dain.modelo.Nota;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Panel;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.TextArea;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.JEditorPane;
import java.awt.Button;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaEditarNota extends JFrame {

	private JPanel contentPane;
	
	public TelaEditarNota(String nota, Administrador adm) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 10));
		setContentPane(contentPane);
		setResizable(false);
		
		JLabel lblNewLabel_1 = new JLabel("Editor de Notas");
		contentPane.add(lblNewLabel_1, BorderLayout.NORTH);
		
		JTextArea textArea = new JTextArea();
		textArea.setText(nota);
		textArea.setLineWrap(true);
		contentPane.add(textArea, BorderLayout.WEST);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		
		Button button = new Button("Salvar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String 	novaNota = textArea.getText().toString();
				DAO dao = new DAO();
				dao.editarNota(novaNota, nota);
				JOptionPane.showMessageDialog(null, "Nota Salva!");
				setVisible(false);
				TelaMinhasNotas telaMinhasNotas = new TelaMinhasNotas(adm);
				telaMinhasNotas.setLocationRelativeTo(null);
				telaMinhasNotas.setVisible(true);
			} 
		});
		panel.add(button);
	}

}
