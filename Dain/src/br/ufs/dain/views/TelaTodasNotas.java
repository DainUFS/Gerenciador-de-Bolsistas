
package br.ufs.dain.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import br.ufs.dain.dao.DAO;
import br.ufs.dain.modelo.Nota;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Component;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Toolkit;

public class TelaTodasNotas extends JFrame {

	private JPanel contentPane;
	
	private final short SCROLL_SPEED = 12;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaTodasNotas frame = new TelaTodasNotas();
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
	public TelaTodasNotas() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 651, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.getVerticalScrollBar().setUnitIncrement(SCROLL_SPEED);
		scrollPane.getHorizontalScrollBar().setUnitIncrement(SCROLL_SPEED);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel lblNewLabel = new JLabel("Todas as Notas");
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		contentPane.add(scrollPane);
				
		ArrayList<Nota> notas = new DAO().TodasAsNota();
		
		for (int i = 0; i < notas.size(); i++) {
			
	
			JPanel panel_2 = new JPanel();
	
			int x = i;
			
			JPanel panel_interno = new JPanel();
			panel_interno.setLayout(new BorderLayout());
			JTextArea textArea = new JTextArea();
			textArea.setEditable(false);
			textArea.setLineWrap(true);
			textArea.setText(notas.get(i).getAnotacao() + "\nNota criada em: " + notas.get(i).getData() +
					" por " + notas.get(i).getAdm().getNome());
			panel_interno.add(BorderLayout.CENTER, textArea);
			panel_interno.add(BorderLayout.SOUTH, panel_2);
			
			panel.add(panel_interno);
		}		
	}

}
