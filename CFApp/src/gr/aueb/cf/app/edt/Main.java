package gr.aueb.cf.app.edt;

import java.awt.EventQueue;

public class Main {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { //new Runnable() is an anonymous class
			@Override
			public void run() {
				MainFrame main = new MainFrame();
				main.setVisible(true);
			}
		});
	}
}
