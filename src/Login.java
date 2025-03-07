

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import java.io.*;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;


public class Login {

	public JFrame framelogin;
	private JPasswordField pass;
	private JTextField use;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.framelogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
		framelogin = new JFrame();
		framelogin.setTitle("Login");
		framelogin.setBounds(100, 100, 800, 519);
		framelogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framelogin.getContentPane().setLayout(null);
		
		pass = new JPasswordField();
		pass.setBounds(359, 209, 225, 40);
		framelogin.getContentPane().add(pass);
		
		use = new JTextField();
		use.setBounds(359, 101, 225, 40);
		framelogin.getContentPane().add(use);
		use.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Modern No. 20", Font.BOLD, 30));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userFile = "Register.txt"; // ชื่อไฟล์ข้อมูลผู้ใช้
			    String username = use.getText(); // ข้อมูลชื่อผู้ใช้จาก Text Field
			    String password = String.valueOf(pass.getPassword()); // ข้อมูลรหัสผ่านจาก Text Field
			    boolean found = false; // ตัวแปรสำหรับเก็บสถานะการเจอข้อมูลผู้ใช้ในไฟล์
			    try {
			        Scanner read = new Scanner(new File(userFile));
			        while(read.hasNext()) {
			            String line = read.nextLine();
			            String[] a1 = line.split(", ");
			            if(a1[0].equals(username) && a1[1].equals(password)) {
			                found = true;
			                break; // หาเจอข้อมูลผู้ใช้แล้ว ไม่ต้องอ่านต่อ
			            }
			        }
			        if(found) { // เจอข้อมูลผู้ใช้
			            JOptionPane.showMessageDialog(null, "Success");
			            use.setText("");
			            pass.setText("");
			            framelogin.setVisible(false);
			            Home tf = new Home();
			            tf.main_frame.setVisible(true);
			        } else { // ไม่เจอข้อมูลผู้ใช้
			            JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.WARNING_MESSAGE);
			            use.setText("");
			            pass.setText("");
			        }
			    } catch (FileNotFoundException e1) { // ไม่พบไฟล์ผู้ใช้
			        JOptionPane.showMessageDialog(null, "Error reading user file.", "Error", JOptionPane.WARNING_MESSAGE);
			        e1.printStackTrace();
			    }
				
			}
		});
		btnNewButton.setBounds(276, 329, 225, 66);
		framelogin.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Enter Username  :");
		lblNewLabel.setFont(new Font("Modern No. 20", Font.BOLD, 30));
		lblNewLabel.setBounds(115, 109, 234, 32);
		framelogin.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Password :");
		lblNewLabel_1.setFont(new Font("Modern No. 20", Font.BOLD, 30));
		lblNewLabel_1.setBounds(115, 217, 225, 32);
		framelogin.getContentPane().add(lblNewLabel_1);
		
		JButton back = new JButton("<");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				framelogin.setVisible(false);
				Home_login   hl = new Home_login  ();
				hl.frmPocketMoney.setVisible(true);
			}
		});
		back.setFont(new Font("Tahoma", Font.BOLD, 30));
		back.setBackground(Color.WHITE);
		back.setBounds(27, 19, 85, 36);
		framelogin.getContentPane().add(back);
	}
}
