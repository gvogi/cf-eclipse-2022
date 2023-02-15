package gr.aueb.cf.tsapp;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gr.aueb.cf.tsapp.util.DBUtil;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JButton;
//import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Connection conn;

	/**
	 * Create the frame.
	 */
	public Menu() {
//		addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowOpened(WindowEvent e) {
//                             //Protocol     // Full DNS  //db name //server time zone mandatory from 8.0 and above			
////				String url = "jdbc:mysql://localhost:3306/schooldb?serverTimeZone=UTC";
////				String username = "gvogi2";
////				String password = "Innerserv3r2";
//				
//				try {
////					Class.forName("com.mysql.cj.jdbc.Driver"); // load db driver
////					conn = DriverManager.getConnection(url, username, password);
//					conn = DBUtil.getConnection();
//					System.out.println("Connection Established!");
//				} catch (SQLException e1) {
//					e1.printStackTrace();
//			}// catch (ClassNotFoundException e2) {
////					e2.printStackTrace();
////				}
//			}
//		});
	
		setTitle("Διαχείριση Εκπαιδευτικού Συστήματος");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblQuality1 = new JLabel("Ποιότητα στην Εκπαίδευση");
		lblQuality1.setForeground(new Color(0, 0, 0));
		lblQuality1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblQuality1.setBounds(61, 20, 310, 25);
		contentPane.add(lblQuality1);
		
		JLabel lblQuality2 = new JLabel("Ποιότητα στην Εκπαίδευση");
		lblQuality2.setForeground(new Color(0, 128, 0));
		lblQuality2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblQuality2.setBounds(63, 22, 310, 25);
		contentPane.add(lblQuality2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 74, 414, 2);
		contentPane.add(separator);
		
		JButton btnTeachers = new JButton("");
		btnTeachers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getMenu().setEnabled(false);	
				Main.getSearchForm().setVisible(true);
			}
		});
		btnTeachers.setBounds(10, 87, 40, 40);
		contentPane.add(btnTeachers);
		
		JLabel lblTeachers = new JLabel("Εκπαιδευτές");
		lblTeachers.setForeground(new Color(178, 34, 34));
		lblTeachers.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTeachers.setBounds(61, 87, 110, 40);
		contentPane.add(lblTeachers);
		
		JButton btnStudents = new JButton("");
		btnStudents.setBounds(10, 138, 40, 40);
		contentPane.add(btnStudents);
		
		JLabel lblStudents = new JLabel("Εκπαιδευόμενοι");
		lblStudents.setForeground(new Color(178, 34, 34));
		lblStudents.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStudents.setBounds(61, 138, 130, 40);
		contentPane.add(lblStudents);
	}

//	public static Connection getConn() {
//		return conn;
//	}

}
