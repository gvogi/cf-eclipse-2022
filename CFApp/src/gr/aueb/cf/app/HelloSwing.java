package gr.aueb.cf.app;

import javax.swing.*;

public class HelloSwing {
	
	public static void main(String[] args) {
		
		JFrame helloFrame = new JFrame();
		helloFrame.setTitle("Hello Coding Factory");
		helloFrame.setSize(400, 200);
		helloFrame.setLocationRelativeTo(null);
		helloFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		helloFrame.setVisible(true);
	}

}
