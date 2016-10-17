package br.ufs.dain.janelas;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;

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

		diaCorrespondente = atribuiPosFixoFeira(diaCorrespondente);
		
		setLocationRelativeTo(null);
		//setTitle(diaCorrespondente + ", " + horaCorrespondente);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 620, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel(diaCorrespondente);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblNewLabel_1 = new JLabel(horaCorrespondente);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		panel.add(lblNewLabel_1);
	}

	private String atribuiPosFixoFeira (String dia) {
		
		if (dia != "Sábado")
			return dia + "-feira";
		return dia;
	}

}
