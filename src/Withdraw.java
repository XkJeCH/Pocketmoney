

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Withdraw {

	public JFrame withdraw_frame;
	private JTextField numAc;
	private JTextField nummoney;
	public int total;
	public int total1;
	protected JTextField money1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Withdraw window = new Withdraw();
					window.withdraw_frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Withdraw() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		withdraw_frame = new JFrame();
		withdraw_frame.setBounds(100, 100, 800, 519);
		withdraw_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		withdraw_frame.getContentPane().setLayout(null);
		
		numAc = new JTextField();
		numAc.setBounds(370, 149, 225, 40);
		withdraw_frame.getContentPane().add(numAc);
		numAc.setColumns(10);
		
		nummoney = new JTextField();
		nummoney.setBounds(370, 267, 225, 40);
		withdraw_frame.getContentPane().add(nummoney);
		nummoney.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("WITHDRAW");
		lblNewLabel.setFont(new Font("Modern No. 20", Font.BOLD, 30));
		lblNewLabel.setBounds(253, 78, 186, 34);
		withdraw_frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Account number : ");
		lblNewLabel_1.setFont(new Font("Modern No. 20", Font.BOLD, 30));
		lblNewLabel_1.setBounds(89, 156, 236, 33);
		withdraw_frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Amount of money : ");
		lblNewLabel_1_1.setFont(new Font("Modern No. 20", Font.BOLD, 30));
		lblNewLabel_1_1.setBounds(89, 273, 252, 34);
		withdraw_frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Bath");
		lblNewLabel_1_1_1.setFont(new Font("Modern No. 20", Font.BOLD, 30));
		lblNewLabel_1_1_1.setBounds(641, 274, 69, 33);
		withdraw_frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JButton btnNewButton = new JButton("WITHDRAW");
		btnNewButton.setFont(new Font("Modern No. 20", Font.BOLD, 30));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList user = new ArrayList();
				ArrayList password = new ArrayList();
				ArrayList number = new ArrayList();
				ArrayList money = new ArrayList();
				
				setMoney1(nummoney);
				
				try {
					Scanner read = new Scanner(new File("Register.txt"));
					while(read.hasNext()) {
						String line = read.nextLine();
						String[] a1 = line.split(", ");
						user.add(a1[0]);
						password.add(a1[1]);
						number.add(a1[2]);}
					
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Invalid Input","Error",JOptionPane.WARNING_MESSAGE);
				}
				if(nummoney.getText().isEmpty()|| numAc.getText().isEmpty()) 
				{JOptionPane.showMessageDialog(null, "Invalid Input","Error",JOptionPane.WARNING_MESSAGE);}
				else {
					try {
						if(numAc.getText().matches("\\d+")== false)  {
							JOptionPane.showMessageDialog(null, "Not number in num1","Error",JOptionPane.WARNING_MESSAGE);
							numAc.setText("");
						}
						else if(nummoney.getText().matches("\\d+")== false)  {
							
							JOptionPane.showMessageDialog(null, "Not number in num2","Error",JOptionPane.WARNING_MESSAGE);
							nummoney.setText("");
						}
						else {
						
						if(number.contains(numAc.getText())) {
	
							setMoney1(nummoney);
							File inputFile = new File ("C:\\Users\\chani\\OOP_653380088_2\\money.txt");
							File tempFile =new File ("C:\\Users\\chani\\OOP_653380088_2\\tempmoney.txt");
							
							BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\chani\\OOP_653380088_2\\money.txt"));
							BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\chani\\OOP_653380088_2\\tempmoney.txt"));
							if(nummoney.getText().matches("\\d+")== true) {
								String line="";
								while((line = reader.readLine()) != null) {
									String[] a1 = line.split(", ");
						 			money.add(a1[1]);
									if(a1[0].equals(numAc.getText())) {
										total1= Integer.parseInt(a1[1]);
										int value = Integer.parseInt(getMoney1());
										int num2 =total1-value;
										writer.write(numAc.getText()+", "+num2+"\n");
									}else {
										writer.write(line+"\n");
									}
								}
								
							}
							
							JOptionPane.showMessageDialog(null, "withdraw success");
							numAc.setText("");
							nummoney.setText("");
							 writer.close(); 
						     reader.close(); 
						     inputFile.delete();
						     boolean successful = tempFile.renameTo(inputFile);
					        System.out.println(successful);
							withdraw_frame.setVisible(false);
							Home main2= new Home();
							main2.main_frame.setVisible(true);}
						else {
							JOptionPane.showMessageDialog(null, "Invalid Input","Error",JOptionPane.WARNING_MESSAGE);
							numAc.setText("");
							nummoney.setText("");
						}}}
					catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "invalid","Error",JOptionPane.WARNING_MESSAGE);
						numAc.setText("");
						nummoney.setText("");
					}
				}
			}
		});
		btnNewButton.setBounds(253, 380, 225, 66);
		withdraw_frame.getContentPane().add(btnNewButton);
		
		JButton back = new JButton("<");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				withdraw_frame.setVisible(false);
				Home ma = new Home();
				ma.main_frame.setVisible(true);
			}
		});
		back.setFont(new Font("Tahoma", Font.BOLD, 30));
		back.setBackground(Color.WHITE);
		back.setBounds(8, 24, 85, 36);
		withdraw_frame.getContentPane().add(back);
		
	}

	public String getMoney1() {
		return money1.getText();
	}

	public void setMoney1(JTextField money1) {
		this.money1 = money1;
	}
	
}
