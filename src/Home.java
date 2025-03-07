import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class Home  {
	
	public JFrame main_frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.main_frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		main_frame = new JFrame();
		main_frame.setBounds(100, 100, 800, 519);
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_frame.getContentPane().setLayout(null);
		
		
		JLabel hello = new JLabel("Pocket  Money");
		hello.setFont(new Font("Modern No. 20", Font.BOLD, 30));
		hello.setBounds(290, 69, 196, 61);
		main_frame.getContentPane().add(hello);
       
		
		
		/*JLabel lblNewLabel_1 = new JLabel("เลขบัญชี");
		lblNewLabel_1.setFont(new Font("TH Sarabun New", Font.BOLD, 30));
		lblNewLabel_1.setBounds(74, 89, 92, 41);
		main_frame.getContentPane().add(lblNewLabel_1);
        try {
	        FileReader fileReader = new FileReader("Register.txt");
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	        String lastLine = null;
	        String currentLine;
	        while((currentLine = bufferedReader.readLine()) != null) {
	            lastLine = currentLine;
	        }
	        
	        if (lastLine != null) {
	            String[] data = lastLine.split(", ");
	            String number = data[2];
                JLabel myb = new JLabel(number);
                myb.setFont(new Font("TH Sarabun New", Font.BOLD, 30));
                myb.setBounds(211, 66, 175, 41);
        		main_frame.getContentPane().add(myb); 
	        }
	        bufferedReader.close();
	    } catch(IOException ex) {
	        ex.printStackTrace();
	    }*/
		
		 
         
            
	        
		JButton tranfer = new JButton("Tranfer");
		tranfer.setFont(new Font("Modern No. 20", Font.BOLD, 30));
		tranfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_frame.setVisible(false);
				Tranfer tf = new Tranfer ();
				tf.Tranfer_frame.setVisible(true);
			}
		});
		tranfer.setBounds(57, 308, 225, 66);
		main_frame.getContentPane().add(tranfer);
		
		JButton deposit = new JButton("Deposit");
		deposit.setFont(new Font("Modern No. 20", Font.BOLD, 30));
		deposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_frame.setVisible(false);
				Deposit dp = new Deposit ();
				dp.deposit_frame.setVisible(true);
			}
		});
		deposit.setBounds(57, 166, 225, 66);
		main_frame.getContentPane().add(deposit);
		
		JButton withdraw = new JButton("Withdraw");
		withdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_frame.setVisible(false);
				Withdraw wd = new Withdraw ();
				wd.withdraw_frame.setVisible(true);
			}
		});
		withdraw.setFont(new Font("Modern No. 20", Font.BOLD, 30));
		withdraw.setBounds(505, 166, 225, 66);
		main_frame.getContentPane().add(withdraw);
		
		
		JButton logout = new JButton("Logout");
		logout.setFont(new Font("Modern No. 20", Font.BOLD, 30));
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_frame.setVisible(false);
				Home_login   hl = new Home_login  ();
				hl.frmPocketMoney.setVisible(true);
			}
		});
		logout.setBounds(286, 406, 225, 66);
		main_frame.getContentPane().add(logout);
		
		JButton check = new JButton("Check");
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_frame.setVisible(false);
				balance   hl = new balance  ();
				hl.balance_frame.setVisible(true);
			}
		});
		check.setFont(new Font("Modern No. 20", Font.BOLD, 30));
		check.setBounds(505, 308, 225, 66);
		main_frame.getContentPane().add(check);

		
	}
}
