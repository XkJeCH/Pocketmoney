

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Deposit {
	
	public JFrame deposit_frame;
	protected JTextField money1;
	public String mon;
	public int numAccount;
	private JTextField nummoney;
	public int m2;
	private JTextField numAc;
	public int total;
	public int total1 =0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deposit window = new Deposit();
					window.deposit_frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Deposit() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		deposit_frame = new JFrame();
		deposit_frame.setBounds(100, 100, 800, 519);
		deposit_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		deposit_frame.getContentPane().setLayout(null);
		
		nummoney = new JTextField();
		nummoney.setBounds(394, 228, 255, 40);
		deposit_frame.getContentPane().add(nummoney);
		nummoney.setColumns(10);
		
		JButton btnNewButton = new JButton("SUBMIT");
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
							File inputFile = new File ("C:\\\\Users\\\\chani\\\\OOP_653380088_2\\money.txt");
							File tempFile =new File ("C:\\\\Users\\\\chani\\\\OOP_653380088_2\\tempmoney.txt");
							
							BufferedReader reader = new BufferedReader(new FileReader("C:\\\\Users\\\\chani\\\\OOP_653380088_2\\money.txt"));
							BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\\\Users\\\\chani\\\\OOP_653380088_2\\tempmoney.txt"));
							if(nummoney.getText().matches("\\d+")== true) {
								String line="";
								while((line = reader.readLine()) != null) {
									String[] a1 = line.split(", ");
						 			money.add(a1[1]);
									if(a1[0].equals(numAc.getText())) {
										total1= Integer.parseInt(a1[1]);
										int value = Integer.parseInt(getMoney1());
										int num2 =total1+value;
										writer.write(numAc.getText()+", "+num2+"\n");
									}else {
										writer.write(line+"\n");
									}
								}
								/*for(int i =0;i<number.size();i++) {
									if(numAc.getText().equals(number.get(i))) {
										total = Integer.parseInt(money.get(i).toString());
									}
								}
								int value = Integer.parseInt(getMoney1());
								System.out.println(number);
								System.out.println(value);
								System.out.println(total);
								total1= value+total;*/
							}
							
							JOptionPane.showMessageDialog(null, "Deposit success");
							numAc.setText("");
							nummoney.setText("");
							 writer.close(); 
						     reader.close(); 
						     inputFile.delete();
						     boolean successful = tempFile.renameTo(inputFile);
					        System.out.println(successful);
							deposit_frame.setVisible(false);
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
		btnNewButton.setBounds(326, 375, 225, 66);
		deposit_frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("DEPOSIT");
		lblNewLabel_1.setFont(new Font("Modern No. 20", Font.BOLD, 30));
		lblNewLabel_1.setBounds(326, 40, 152, 51);
		deposit_frame.getContentPane().add(lblNewLabel_1);
		
		numAc = new JTextField();
		numAc.setBounds(394, 126, 255, 40);
		deposit_frame.getContentPane().add(numAc);
		numAc.setColumns(10);
		
		JButton back = new JButton("<");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deposit_frame.setVisible(false);
				Home ma = new Home();
				ma.main_frame.setVisible(true);
			}
		});
		back.setFont(new Font("Tahoma", Font.BOLD, 30));
		back.setBackground(Color.WHITE);
		back.setBounds(10, 29, 85, 36);
		deposit_frame.getContentPane().add(back);
		
		JLabel lblNewLabel_1_1 = new JLabel("Account number  :");
		lblNewLabel_1_1.setFont(new Font("Modern No. 20", Font.BOLD, 30));
		lblNewLabel_1_1.setBounds(103, 133, 255, 33);
		deposit_frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Amount of money : ");
		lblNewLabel_1_1_1.setFont(new Font("Modern No. 20", Font.BOLD, 30));
		lblNewLabel_1_1_1.setBounds(103, 234, 255, 34);
		deposit_frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Bath");
		lblNewLabel_1_1_1_1.setFont(new Font("Modern No. 20", Font.BOLD, 30));
		lblNewLabel_1_1_1_1.setBounds(676, 235, 69, 33);
		deposit_frame.getContentPane().add(lblNewLabel_1_1_1_1);
	}

	public String getMoney1() {
		return money1.getText();
	}

	public void setMoney1(JTextField money1) {
		this.money1 = money1;
	}

	public JTextField getName() {
		return numAc;
	}

	public void setName(JTextField name) {
		this.numAc = name;
	}
}
