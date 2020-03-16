package agentie;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Agenti {

	private JFrame frame;
	private JFrame frame1;
	private JFrame frame2;
	private JPanel log;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agenti window = new Agenti();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Agenti() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Kusadasi");
		frame1=new JFrame();
		frame1.setBounds(100,100,450,300);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		frame2=new JFrame();
		frame2.setBounds(100,100,450,300);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Connect as client");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(12, 159, 184, 56);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Connect as administrator");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login p=new Login();
				p.setVisible(true);
				frame.setVisible(false);
				
				
				
			}
		});
		btnNewButton_1.setBounds(236, 159, 184, 56);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblPleaseLogIn = new JLabel("Bun venit la agentie");
		lblPleaseLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseLogIn.setBounds(132, 61, 146, 56);
		frame.getContentPane().add(lblPleaseLogIn);
	}
	Connection db=null;
	public  void Login() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
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
					Meniuadmin ad=new Meniuadmin();
					ad.setVisible(true);
					frame.setVisible(false);
					
				}
				//catch(Exception ex){
						//JOptionPane.showMessageDialog(null,"Eroare la conectare");
					//}
				//}
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

	private void setContentPane(JPanel log2) {
		// TODO Auto-generated method stub
		
	}
}
