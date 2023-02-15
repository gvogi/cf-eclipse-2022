package gr.aueb.cf.tsapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.mindrot.jbcrypt.BCrypt;

import gr.aueb.cf.tsapp.util.DBUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LoginPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	public LoginPage() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setForeground(new Color(255, 0, 0));
		lblUsername.setBounds(67, 30, 91, 28);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setForeground(new Color(255, 0, 0));
		lblPassword.setBounds(77, 75, 86, 41);
		contentPane.add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtUsername.setBounds(168, 34, 155, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputUsername = txtUsername.getText().trim();
				String inputPassword = String.valueOf(txtPassword.getPassword()).trim();
				String password = System.getenv("TS_ADMIN_PASSWORD");
				String hashedPassword;
				
				if (inputUsername.equals("") || inputPassword.equals("")) {
					return;
				}
				
				if (inputUsername.equals("admin") && (inputPassword.equals(password))) {
					Main.getLoginPage().setVisible(false);
					Main.getSearchUser().setVisible(true);
				}else {
					String sql = "SELECT PASSWORD FROM USERS WHERE USERNAME = ?";
					
					try (Connection conn = DBUtil.getConnection();
							PreparedStatement p = conn.prepareStatement(sql);) {
						p.setString(1, inputUsername);
						ResultSet rs = p.executeQuery();
						
						if (rs.next()) {
							hashedPassword = rs.getString("PASSWORD");
						} else {
							JOptionPane.showMessageDialog(null, "User not found", "Error", JOptionPane.WARNING_MESSAGE);
							return;
						}
						if(BCrypt.checkpw(inputPassword, hashedPassword)) {
							Main.getLoginPage().setVisible(false);
						} else {
							JOptionPane.showMessageDialog(null, "Error in password", "Login Error", JOptionPane.WARNING_MESSAGE);
						}
					}catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogin.setForeground(new Color(0, 0, 255));
		btnLogin.setBounds(255, 191, 89, 41);
		contentPane.add(btnLogin);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 163, 414, 2);
		contentPane.add(separator);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPassword.setBounds(173, 87, 150, 20);
		contentPane.add(txtPassword);
	}
}
