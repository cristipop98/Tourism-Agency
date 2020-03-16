package agentie;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.sql.Statement;



public class AdaugaClienti extends JPanel {
	private String host = "jdbc:mysql://localhost:3306/agentie_turism";
	private String user = "root";
	private String pass = "";
	private Connection con;
	
	private JTextField CNPClient;
	private JTextField numeClient;
	private JTextField adresaClient;
	private JTextField orasClient;
	private JTextField mailClient;
	private JTextField telefonClient;
	private JButton btnIntroduceti = new JButton("Introduceti");
	private JLabel destinatieLabel;
	private JTextField DestinatietextField;

	public JTextField getCNP() {
		return CNPClient;
	}

	public JTextField getnume() {
		return numeClient;
	}

	public JTextField getadresa() {
		return adresaClient;
	}

	public JTextField getoras() {
		return orasClient;
	}
	public JTextField getmail() {
		return mailClient;
	}
	public JTextField gettelefon() {
		return telefonClient;
	}

	public AdaugaClienti()
	{
		connectDB();
		setLayout(null);
		
		JLabel lb1 = new JLabel("CNP");
		lb1.setBounds(35, 76, 85, 16);
		add(lb1);

		JLabel lb2 = new JLabel("nume");
		lb2.setBounds(35, 106, 85, 13);
		add(lb2);
		
		JLabel lb3 = new JLabel("adresa");
		lb3.setBounds(35,136 , 85, 16);
		add(lb3);

		JLabel lb4 = new JLabel("oras");
		lb4.setBounds(35, 166, 85, 13);
		add(lb4);
		
		JLabel lb5 = new JLabel("mail");
		lb4.setBounds(35, 196, 85, 13);
		add(lb5);
		
		JLabel lb6 = new JLabel("telefon");
		lb4.setBounds(35, 226, 85, 13);
		add(lb6);
		
		this.setVisible(false);
		
	}

	public void connectDB() {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Eroare la conectare");
		}
		con=null;
		try {
			con=DriverManager.getConnection(host,user,pass);
			JOptionPane.showMessageDialog(null,"Conectat");
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,"Eroare la conectare SQL");
			
		}
	}
	private void doUpdate(String upd)
	{
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(upd);
			System.out.println("Operation success!");
		} catch (SQLException e) {
			System.out.println("Operation failed: " + e);
		}
	}
	private String convertSQLString(String st)
	{
		return st.replaceAll("'","''");
	}
	public void inserareClient(String tara)
	{
		CallableStatement csmt=null;
		try {
			String sql="{call taraSpania(?)}";
			csmt=con.prepareCall(sql);
			csmt.setString(1, "Spania");
			csmt.execute();
			JOptionPane.showMessageDialog(null,"Operatia a avut succes");
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null,"Operatia nu a avut succes");
		}
	}
	}

