package br.ufs.dain.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;

public class TelaExibirAjuda extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaExibirAjuda frame = new TelaExibirAjuda();
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
	public TelaExibirAjuda() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaExibirAjuda.class.getResource("/br/ufs/dain/resources/icon_ajuda.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblAjuda = new JLabel("Ajuda ");
		lblAjuda.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAjuda.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblAjuda);
	}

}
