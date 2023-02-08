package gr.aueb.cf.cfapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CodingFactoryFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CodingFactoryFrame frame = new CodingFactoryFrame();
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
	public CodingFactoryFrame() {
		setTitle("Coding Factory");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
		setSize(800, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblCODINGFACTORY = new JLabel("AUEB Coding Factory");
		lblCODINGFACTORY.setForeground(new Color(0, 0, 255));
		lblCODINGFACTORY.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCODINGFACTORY.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblCODINGFACTORY, BorderLayout.NORTH);
		
		JTextArea txtCodingFactoryRules = new JTextArea();
		txtCodingFactoryRules.setBackground(new Color(173, 216, 230));
		txtCodingFactoryRules.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtCodingFactoryRules.setText("Coding Factory Rules");
		contentPane.add(txtCodingFactoryRules, BorderLayout.CENTER);
		
		JButton btnHideShow = new JButton("HIDE");
		btnHideShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnHideShow.getText().equals("HIDE")) {
					txtCodingFactoryRules.setVisible(false);
					btnHideShow.setText("SHOW");
					btnHideShow.setForeground(Color.GREEN);
				} else {
					txtCodingFactoryRules.setVisible(true);
					btnHideShow.setText("HIDE");
					btnHideShow.setForeground(Color.ORANGE);
				}
			}
		});
		
		btnHideShow.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHideShow.setForeground(new Color(255, 0, 255));
		contentPane.add(btnHideShow, BorderLayout.WEST);
		
		JButton btnClose = new JButton("CLOSE");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnClose.setIcon(new ImageIcon(CodingFactoryFrame.class.getResource("/resources/close16.png")));
		btnClose.setForeground(new Color(0, 0, 255));
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnClose, BorderLayout.SOUTH);
	}

}
