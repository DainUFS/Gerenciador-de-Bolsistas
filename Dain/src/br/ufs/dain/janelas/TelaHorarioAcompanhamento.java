package br.ufs.dain.janelas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TelaHorarioAcompanhamento extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaHorarioAcompanhamento frame = new TelaHorarioAcompanhamento();
//					frame.setLocationRelativeTo(null);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	/**
	 * Create the frame.
	 */
	public TelaHorarioAcompanhamento (String diaCorrespondente, String horaCorrespondente) {
		
		//public void OnEvent(){
//	    Toolkit.getDefaultToolkit().beep();  
//	    if(!hasFocus()){
//	         toFront();
//	         requestFocus();
//	         setVisible(true);
//	         firePropertyChange("",false,true);
//	    }

		String diaSemana = verificaPosFixoFeira(diaCorrespondente);
		
		setLocationRelativeTo(null);
		setTitle(diaSemana + ", " + horaCorrespondente);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 436, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
	}

	private String verificaPosFixoFeira (String dia) {
		
		if (dia != "Sábado")
			return dia + "-feira";
		return dia;
	}

}
