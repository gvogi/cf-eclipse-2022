package gr.aueb.cf.tsapp;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SearchUser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private String inputLastname;


	/**
	 * Create the frame.
	 */
	public SearchUser() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				txtUsername.setText("");
			}
		});
		setTitle("Search User");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
//				Main.getMenu().setEnabled(true);	
//				Main.getSearchForm().setVisible(false);	
	}
		});
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnClose.setForeground(new Color(0, 0, 255));
		btnClose.setBounds(254, 226, 89, 35);
		contentPane.add(btnClose);
		
		JPanel panel = new JPanel();
		panel.setBounds(31, 11, 312, 138);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnSearch = new JButton("Αναζήτηση");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			inputLastname = txtUsername.getText().trim();
			Main.getSearchForm().setEnabled(false);
			Main.getUpdateDeleteForm().setVisible(true);	
			}
		});
		btnSearch.setBounds(92, 76, 130, 40);
		panel.add(btnSearch);
		btnSearch.setForeground(new Color(0, 0, 255));
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtUsername = new JTextField();
		txtUsername.setBounds(54, 44, 200, 20);
		panel.add(txtUsername);
		txtUsername.setColumns(50);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(109, 11, 84, 20);
		panel.add(lblUsername);
		lblUsername.setForeground(new Color(178, 34, 34));
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(31, 160, 312, 60);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnInsert = new JButton("Εισαγωγή");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getSearchUser().setEnabled(false);	
				Main.getInsertUser().setVisible(true);
			}
		});
		btnInsert.setBounds(95, 11, 130, 40);
		panel_1.add(btnInsert);
		btnInsert.setForeground(new Color(0, 0, 255));
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 16));
	}


	public String getInputLastname() {
		return inputLastname;
	}

	
}
