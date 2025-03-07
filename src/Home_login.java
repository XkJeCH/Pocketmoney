
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Home_login extends JFrame {

	public JFrame frmPocketMoney;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home_login window = new Home_login();
					window.frmPocketMoney.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home_login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPocketMoney = new JFrame();
		frmPocketMoney.setTitle("Pocket money");
		frmPocketMoney.setBounds(100, 100, 800, 520);
		frmPocketMoney.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPocketMoney.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Modern No. 20", Font.BOLD, 30));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPocketMoney.setVisible(false);
				Login main2= new Login();
				main2.framelogin.setVisible(true);
			}
			
		});
		btnNewButton.setBounds(266, 191, 225, 66);
		frmPocketMoney.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.setFont(new Font("Modern No. 20", Font.BOLD, 30));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPocketMoney.setVisible(false);
				Register re= new Register();
				re.regis_frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(266, 297, 225, 66);
		frmPocketMoney.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Pocket Money");
		lblNewLabel.setFont(new Font("Modern No. 20", Font.BOLD, 40));
		lblNewLabel.setBounds(254, 57, 252, 89);
		frmPocketMoney.getContentPane().add(lblNewLabel);
	}
}
