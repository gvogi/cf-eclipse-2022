package gr.aueb.cf.app.edt;

import java.awt.event.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class MainFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	public MainFrame() {
		this.setSize(800, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Hello CF AUEB");
		
		JPanel contentPane = new JPanel();
		this.setContentPane(contentPane);
		
		JButton btn = new JButton("Warning Button");
		btn.addActionListener(new ActionListener( ) {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Message", "Title", JOptionPane.WARNING_MESSAGE);
			}
		});
		
		JButton btn2 = new JButton("Confirm Button");
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(null, "Message", "Title", JOptionPane.YES_NO_OPTION);
				if (answer == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, "Message", "Title", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Message", "Title", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		contentPane.add(btn);
		contentPane.add(btn2);
		
	}
}
