package gr.aueb.cf.tsapp;



import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

public class InsertForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLastname;
	private JTextField txtFirstname;
//	private PreparedStatement p;// = conn.prepareStatement(sql);



	/**
	 * Create the frame.
	 */
	public InsertForm() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				txtLastname.setText("");
				txtFirstname.setText("");
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
				String sql = "INSERT INTO TEACHERS (LASTNAME, FIRSTNAME) VALUES (?, ?)";
				String inputLastname;
				String inputFirstname;
				int n;
				
				try (Connection conn = DBUtil.getConnection();
						PreparedStatement p = conn.prepareStatement(sql);){
					
					
					inputLastname = txtLastname.getText().trim();
					inputFirstname = txtFirstname.getText().trim();
					
					if (inputLastname.equals("") || (inputFirstname.equals(""))) {
						return;
					}
					
					p.setString(1, inputLastname);
					p.setString(2, inputFirstname);					
					n = p.executeUpdate(); // Command for update/delete to db
					JOptionPane.showMessageDialog(null, n + " records inserted", "INSERT", JOptionPane.PLAIN_MESSAGE);
					
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
		
		JLabel lblLastname = new JLabel("Επώνυμο");
		lblLastname.setBounds(10, 24, 78, 19);
		panel.add(lblLastname);
		lblLastname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastname.setForeground(new Color(220, 20, 60));
		lblLastname.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblFirstname = new JLabel("'Ονομα");
		lblFirstname.setBounds(33, 62, 55, 19);
		panel.add(lblFirstname);
		lblFirstname.setForeground(new Color(220, 20, 60));
		lblFirstname.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFirstname.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtLastname = new JTextField();
		txtLastname.setBounds(98, 25, 150, 20);
		panel.add(txtLastname);
		txtLastname.setColumns(50);
		
		txtFirstname = new JTextField();
		txtFirstname.setBounds(98, 63, 150, 20);
		panel.add(txtFirstname);
		txtFirstname.setColumns(50);
	}
}
