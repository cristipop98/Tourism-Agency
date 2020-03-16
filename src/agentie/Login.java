package agentie;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel log;
	private JTextField textField;
	private JTextField textField_1;
	private JPanel frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	Connection db=null;
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		log = new JPanel();
		log.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(log);
		log.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Email:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(25, 89, 91, 33);
		log.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(25, 135, 91, 33);
		log.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(141, 96, 176, 22);
		log.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(141, 142, 176, 22);
		log.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Log in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=textField.getText();
				String pas=textField_1.getText();
				if(username.equals("admin@gmail.com") && pas.equals("12345"))
				{
					DatabaseConnection();
					JOptionPane.showMessageDialog(null,"Conectare reusita");
					Meniuadmin ad=new Meniuadmin();
					ad.setVisible(true);
				//	frame.setVisible(false);
					
				}
				else
				{
					JOptionPane.showMessageDialog(frame,"Wrong Email/Password");
				}
					
			}

			private void DatabaseConnection() {
				// TODO Auto-generated method stub
				
			}
		});
		btnNewButton.setBounds(75, 202, 97, 25);
		log.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(263, 202, 97, 25);
		log.add(btnNewButton_1);
	}
	
}