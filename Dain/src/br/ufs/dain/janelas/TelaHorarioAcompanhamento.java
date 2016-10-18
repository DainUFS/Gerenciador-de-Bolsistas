package br.ufs.dain.janelas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class TelaHorarioAcompanhamento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public TelaHorarioAcompanhamento (String diaCorrespondente, String horaCorrespondente) {

		diaCorrespondente = atribuiPosFixoFeira(diaCorrespondente);

		setLocationRelativeTo(null);
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

	public void createAndShowGUI(JTabbedPane tabbedPane) {

		JPanel panel = new JPanel();

		panel.setOpaque(false);
		tabbedPane.add(panel);
		tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(panel), getTitlePanel(tabbedPane, panel, ", "));
		
		//return panel;
	}

	private static JPanel getTitlePanel(final JTabbedPane tabbedPane, final JPanel panel, String title) {

		JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		titlePanel.setOpaque(false);
		JLabel titleLbl = new JLabel(title);
		titleLbl.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		titlePanel.add(titleLbl);
		JButton closeButton = new JButton("x");

		closeButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				tabbedPane.remove(panel);
			}
		});
		titlePanel.add(closeButton);

		return titlePanel;
	}

}
