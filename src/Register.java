
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class Register extends JFrame {

	public JFrame regis_frame;
	private JTextField Username;
	private JPasswordField Pass1;
	private JPasswordField Pass2;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
					window.regis_frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		regis_frame = new JFrame();
		regis_frame.setBounds(100, 100, 800, 519);
		regis_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		regis_frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register");
		lblNewLabel.setFont(new Font("Modern No. 20", Font.BOLD, 30));
		lblNewLabel.setBounds(369, 21, 119, 40);
		regis_frame.getContentPane().add(lblNewLabel);
		
		Username = new JTextField();
		Username.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Username.setBounds(296, 126, 225, 40);
		regis_frame.getContentPane().add(Username);
		Username.setColumns(10);
		
		Pass1 = new JPasswordField();
		Pass1.setBounds(296, 224, 225, 40);
		regis_frame.getContentPane().add(Pass1);
		
		Pass2 = new JPasswordField();
		Pass2.setBounds(296, 316, 225, 40);
		regis_frame.getContentPane().add(Pass2);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList user = new ArrayList();
				ArrayList password = new ArrayList();
				if(Username.getText().isEmpty()) 
					{JOptionPane.showMessageDialog(null, "Invalid Input","Error",JOptionPane.WARNING_MESSAGE);}
				else if(Pass1.getText().isEmpty()) 
				{JOptionPane.showMessageDialog(null, "Invalid Input","Error",JOptionPane.WARNING_MESSAGE);}
				else if(Pass2.getText().isEmpty()) 
				{JOptionPane.showMessageDialog(null, "Invalid Input","Error",JOptionPane.WARNING_MESSAGE);}
				else if(user.contains(Username.getText())) 
				{JOptionPane.showMessageDialog(null, "Invalid Input","Error",JOptionPane.WARNING_MESSAGE);}
				else {
				if (Pass1.getText().equals(Pass2.getText()) ) {
				try {
					Random random = new Random();
					 int numDigits = 10;
				        StringBuilder sb = new StringBuilder();
				        for (int i = 0; i < numDigits; i++) {
				            sb.append(random.nextInt(10));
				        } String ranlist= sb.toString();
					FileWriter write = new FileWriter("Register.txt",true);
					FileWriter write1 = new FileWriter("money.txt",true);
					write.write(Username.getText()+", "+Pass1.getText()+", "+ranlist+"\n");
					write1.write(ranlist+", "+"0");
					write.close();
					write1.close();
					Username.setText("");
					Pass1.setText("");
					Pass2.setText("");
					JOptionPane.showMessageDialog(null, "Success","Success",JOptionPane.PLAIN_MESSAGE);
					regis_frame.setVisible(false);
					Home_login main2= new Home_login();
					main2.frmPocketMoney.setVisible(true);
					} catch (IOException e1) {
					e1.printStackTrace();
				}}
				else {
					JOptionPane.showMessageDialog(null, "Invalid Input1","Error",JOptionPane.WARNING_MESSAGE);
				}}}
				
			
		});
		btnNewButton.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
		btnNewButton.setBounds(296, 388, 225, 66);
		regis_frame.getContentPane().add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("Username :");
		lblNewLabel_1.setFont(new Font("Modern No. 20", Font.BOLD, 20));
		lblNewLabel_1.setBounds(172, 133, 99, 30);
		regis_frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Password  :");
		lblNewLabel_2.setFont(new Font("Modern No. 20", Font.BOLD, 20));
		lblNewLabel_2.setBounds(172, 232, 114, 21);
		regis_frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Confirm Password  :");
		lblNewLabel_3.setFont(new Font("Modern No. 20", Font.BOLD, 20));
		lblNewLabel_3.setBounds(100, 318, 186, 32);
		regis_frame.getContentPane().add(lblNewLabel_3);
		
		JButton back = new JButton("<");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regis_frame.setVisible(false);
				Home_login   hl = new Home_login  ();
				hl.frmPocketMoney.setVisible(true);
			}
		});
		back.setFont(new Font("Tahoma", Font.BOLD, 30));
		back.setBackground(Color.WHITE);
		back.setBounds(10, 25, 85, 36);
		regis_frame.getContentPane().add(back);
	}
}
