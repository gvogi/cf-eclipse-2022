package gr.aueb.cf.tsapp;



import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.mindrot.jbcrypt.BCrypt;

import gr.aueb.cf.tsapp.util.DBUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JPasswordField;

public class InsertUser extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
//	private PreparedStatement p;// = conn.prepareStatement(sql);
	private JPasswordField txtPassword;



	/**
	 * Create the frame.
	 */
	public InsertUser() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				txtUsername.setText("");
				txtPassword.setText("");
			}
		});
		setTitle("Εισαγωγή Εκπαιδευτή");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "INSERT INTO USERS (USERNAME, PASSWORD) VALUES (?, ?)";
				String inputUsername;
				String inputPassword;
				int n;
				
				try (//Connection conn = Menu.getConn();
						Connection conn = DBUtil.getConnection();					
						PreparedStatement p = conn.prepareStatement(sql);) {
					
					
					
					inputUsername = txtUsername.getText().trim();
					inputPassword = String.valueOf(txtPassword.getPassword()).trim();
					
					// TODO check with regex
					if (inputPassword.equals("") || (inputUsername.equals(""))) {
						return;
					}
					
					int workload = 12;
					String salt = BCrypt.gensalt(workload);
					String hashedPassword = BCrypt.hashpw(inputPassword, salt);
					
					p.setString(1, inputUsername);	
					p.setString(2, hashedPassword);		
					
					n = p.executeUpdate(); // Command for update/delete to db
					JOptionPane.showMessageDialog(null, n + " records inserted", "INSERT USER", JOptionPane.PLAIN_MESSAGE);
					
				}catch (SQLException e1) {
					e1.printStackTrace();
				}				
			}
		});
		btnInsert.setBounds(225, 180, 89, 38);
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnInsert.setForeground(new Color(0, 0, 255));
		contentPane.add(btnInsert);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getSearchForm().setEnabled(true);
				Main.getInsertForm().setVisible(false);
			}
		});
		btnClose.setBounds(324, 180, 89, 38);
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnClose.setForeground(new Color(0, 0, 255));
		contentPane.add(btnClose);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 167, 414, 2);
		contentPane.add(separator);
		
		JPanel panel = new JPanel();
		panel.setBounds(56, 46, 317, 110);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 24, 97, 19);
		panel.add(lblUsername);
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setForeground(new Color(220, 20, 60));
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(23, 62, 84, 19);
		panel.add(lblPassword);
		lblPassword.setForeground(new Color(220, 20, 60));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(139, 25, 150, 20);
		panel.add(txtUsername);
		txtUsername.setColumns(50);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(139, 63, 150, 20);
		panel.add(txtPassword);
	}
}
