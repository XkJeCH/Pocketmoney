

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import java.io.*;
import javax.swing.JTextField;
import java.awt.Color;

public class balance {

	public JFrame balance_frame;
	private JTextField id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					balance window = new balance();
					window.balance_frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public balance() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		balance_frame = new JFrame();
		balance_frame.setBounds(100, 100, 800, 519);
		balance_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		balance_frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Balance  :");
		lblNewLabel.setFont(new Font("Modern No. 20", Font.BOLD, 30));
		lblNewLabel.setBounds(95, 220, 140, 45);
		balance_frame.getContentPane().add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 41));
		lblNewLabel_1.setBounds(334, 194, 284, 105);
		balance_frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("CHECK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				File inputFile = new File ("C:\\\\Users\\\\chani\\\\OOP_653380088_2\\money.txt");
				File tempFile =new File ("C:\\\\Users\\\\chani\\\\OOP_653380088_2\\tempmoney.txt");
				BufferedReader reader = new BufferedReader(new FileReader("C:\\\\Users\\\\chani\\\\OOP_653380088_2\\money.txt"));
				BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\\\Users\\\\chani\\\\OOP_653380088_2\\tempmoney.txt"));
				String line;
				while((line = reader.readLine()) != null) {
					String[] a1 = line.split(", ");
					if(a1[0].equals(id.getText())) {
						lblNewLabel_1.setText(a1[1]+"฿");
					}else {
						writer.write(line+"\n");
					}
				}
				
				
				
				
				
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Invalid Input","Error",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Modern No. 20", Font.BOLD, 30));
		btnNewButton.setBounds(334, 366, 225, 60);
		balance_frame.getContentPane().add(btnNewButton);
		
		id = new JTextField();
		id.setText("");
		id.setBounds(334, 117, 225, 40);
		balance_frame.getContentPane().add(id);
		id.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Enter your ID  :");
		lblNewLabel_2.setFont(new Font("Modern No. 20", Font.BOLD, 30));
		lblNewLabel_2.setBounds(95, 121, 208, 36);
		balance_frame.getContentPane().add(lblNewLabel_2);
		
		JButton back = new JButton("<");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				balance_frame.setVisible(false);
				Home ma = new Home();
				ma.main_frame.setVisible(true);
			}
		});
		back.setFont(new Font("Tahoma", Font.BOLD, 30));
		back.setBackground(Color.WHITE);
		back.setBounds(10, 10, 85, 36);
		balance_frame.getContentPane().add(back);
		
		JLabel lblBalance = new JLabel("BALANCE");
		lblBalance.setFont(new Font("Modern No. 20", Font.BOLD, 30));
		lblBalance.setBounds(334, 35, 155, 34);
		balance_frame.getContentPane().add(lblBalance);
	}
}
