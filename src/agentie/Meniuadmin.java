package agentie;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.EventQueue;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.sql.ResultSetMetaData;



import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import java.awt.Color;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

public class Meniuadmin extends JFrame {

	private JPanel menuad;
	//Connection connection=null;
	//Statement mystQbj=null;
	//ResultSet reobj=null;
	private Connection mystObj;
	private String host = "jdbc:mysql://localhost:3306/agentie_turism";
	private String user = "root";
	private String pass = "";
	private Connection con;
	private JTable table;
	private AdaugaClienti panelAdaugaClienti;
	private JFrame frame;
	private JPanel client;
	private JTextField CNP;
	private JTextField nume;
	private JTextField adresa;
	private JTextField oras;
	private JTextField mail;
	private JTextField telefon;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Meniuadmin frame = new Meniuadmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	class TableData extends Meniuadmin{
		public int getColumnCount()
		{
			return 3;
		}
		public Object getValueAt(int arg0,int arg1)
		{
			return "Table";
		}
	}
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Meniuadmin() {
		connectDB();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 958, 591);
		menuad = new JPanel();
		menuad.setToolTipText("");
		menuad.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(menuad);
		menuad.setLayout(null);
		
		
		
		
		
		JButton btnNewButton = new JButton("Clienti");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String SQL1="SELECT * FROM Clienti";
				try {
				Statement st1=con.createStatement();
				ResultSet rs=st1.executeQuery(SQL1);
				ResultSetMetaData rsmd=rs.getMetaData();
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				model.setRowCount(0);
				int colCount=rsmd.getColumnCount();
				int i;
				Object[] row=new Object[6];
				for(i=1;i<=colCount;i++)
					row[i-1]=rsmd.getColumnName(i).toUpperCase();
				model.addRow(row);
				while(rs.next()) {
					for(i=1;i<=colCount;i++) {
						row[i-1]=rs.getObject(i);
					}
					model.addRow(row);
				}
				}
				catch(Exception ex1)
				{
					JOptionPane.showMessageDialog(null,"Eroare de vizualizare");
				}
			}
			
			
			}
			);
		btnNewButton.setBounds(22, 32, 122, 25);
		menuad.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Destinatii");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SQL1="SELECT * FROM Destinatii";
				try {
				Statement st1=con.createStatement();
				ResultSet rs=st1.executeQuery(SQL1);
				ResultSetMetaData rsmd=rs.getMetaData();
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				model.setRowCount(0);
				int colCount=rsmd.getColumnCount();
				int i;
				Object[] row=new Object[7];
				for(i=1;i<=colCount;i++)
					row[i-1]=rsmd.getColumnName(i).toUpperCase();
				model.addRow(row);
				while(rs.next()) {
					for(i=1;i<=colCount;i++) {
						row[i-1]=rs.getObject(i);
					}
					model.addRow(row);
				}
				}
				catch(Exception ex1)
				{
					JOptionPane.showMessageDialog(null,"Eroare de vizualizare");
				}
				
			}
		});
		btnNewButton_1.setBounds(22, 80, 122, 25);
		menuad.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Rezervari");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SQL1="SELECT * FROM Rezervari";
				try {
				Statement st1=con.createStatement();
				ResultSet rs=st1.executeQuery(SQL1);
				ResultSetMetaData rsmd=rs.getMetaData();
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				model.setRowCount(0);
				int colCount=rsmd.getColumnCount();
				int i;
				Object[] row=new Object[7];
				for(i=1;i<=colCount;i++)
					row[i-1]=rsmd.getColumnName(i).toUpperCase();
				model.addRow(row);
				while(rs.next()) {
					for(i=1;i<=colCount;i++) {
						row[i-1]=rs.getObject(i);
					}
					model.addRow(row);
				}
				}
				catch(Exception ex1)
				{
					JOptionPane.showMessageDialog(null,"Eroare de vizualizare");
				}
			}
		});
		btnNewButton_2.setBounds(22, 134, 122, 25);
		menuad.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Plecari");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SQL1="select data,oras from plecari order by data asc;\r\n";
				try {
				Statement st1=con.createStatement();
				ResultSet rs=st1.executeQuery(SQL1);
				ResultSetMetaData rsmd=rs.getMetaData();
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				model.setRowCount(0);
				int colCount=rsmd.getColumnCount();
				int i;
				Object[] row=new Object[7];
				for(i=1;i<=colCount;i++)
					row[i-1]=rsmd.getColumnName(i).toUpperCase();
				model.addRow(row);
				while(rs.next()) {
					for(i=1;i<=colCount;i++) {
						row[i-1]=rs.getObject(i);
					}
					model.addRow(row);
				}
				}
				catch(Exception ex1)
				{
					JOptionPane.showMessageDialog(null,"Eroare de vizualizare");
				}
			}
		});
		btnNewButton_3.setBounds(22, 183, 122, 25);
		menuad.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Hoteluri");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SQL1="select * from hoteluri";
				try {
				Statement st1=con.createStatement();
				ResultSet rs=st1.executeQuery(SQL1);
				ResultSetMetaData rsmd=rs.getMetaData();
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				model.setRowCount(0);
				int colCount=rsmd.getColumnCount();
				int i;
				Object[] row=new Object[7];
				for(i=1;i<=colCount;i++)
					row[i-1]=rsmd.getColumnName(i).toUpperCase();
				model.addRow(row);
				while(rs.next()) {
					for(i=1;i<=colCount;i++) {
						row[i-1]=rs.getObject(i);
					}
					model.addRow(row);
				}
				}
				catch(Exception ex1)
				{
					JOptionPane.showMessageDialog(null,"Eroare de vizualizare");
				}
			}
		});
		btnNewButton_4.setBounds(22, 231, 122, 25);
		menuad.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Hoteluri Spania");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SQL1="select hoteluri.nume from hoteluri,destinatii where destinatii.tara='Spania' and destinatii.oras=hoteluri.locatie;";
				try {
				Statement st1=con.createStatement();
				ResultSet rs=st1.executeQuery(SQL1);
				ResultSetMetaData rsmd=rs.getMetaData();
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				model.setRowCount(0);
				int colCount=rsmd.getColumnCount();
				int i;
				Object[] row=new Object[7];
				for(i=1;i<=colCount;i++)
					row[i-1]=rsmd.getColumnName(i).toUpperCase();
				model.addRow(row);
				while(rs.next()) {
					for(i=1;i<=colCount;i++) {
						row[i-1]=rs.getObject(i);
					}
					model.addRow(row);
				}
				}
				catch(Exception ex1)
				{
					JOptionPane.showMessageDialog(null,"Eroare de vizualizare");
				}
				
			}
				
				
			}
		);
		btnNewButton_5.setBounds(805, 32, 123, 25);
		menuad.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Adauga Client");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 300, 400);
				client=new JPanel();
				client.setBorder(new EmptyBorder(0, 0, 0, 0));
				setContentPane(client);
				client.setLayout(null);
				
				JLabel ll1 = new JLabel("CNP");
				ll1.setHorizontalAlignment(SwingConstants.CENTER);
				ll1.setBounds(20, 5, 146, 56);
				client.add(ll1);
				
				CNP=new JTextField();
				CNP.setBounds(150,26,86,20);
				client.add(CNP);
				CNP.setColumns(10);
				
				JLabel ll2 = new JLabel("nume");
				ll2.setHorizontalAlignment(SwingConstants.CENTER);
				ll2.setBounds(20, 51, 146, 56);
				client.add(ll2);
				
				nume=new JTextField();
				nume.setBounds(150,72,86,20);
				client.add(nume);
				nume.setColumns(10);
				
				JLabel ll3 = new JLabel("adresa");
				ll3.setHorizontalAlignment(SwingConstants.CENTER);
				ll3.setBounds(20, 95, 146, 56);
				client.add(ll3);
				
				adresa=new JTextField();
				adresa.setBounds(150,118,86,20);
				client.add(adresa);
				adresa.setColumns(10);
				
				JLabel ll4 = new JLabel("oras");
				ll4.setHorizontalAlignment(SwingConstants.CENTER);
				ll4.setBounds(20, 145, 146, 56);
				client.add(ll4);
				
				oras=new JTextField();
				oras.setBounds(150,164,86,20);
				client.add(oras);
				oras.setColumns(10);
				
				JLabel ll5 = new JLabel("mail");
				ll5.setHorizontalAlignment(SwingConstants.CENTER);
				ll5.setBounds(20, 190, 146, 56);
				client.add(ll5);
				
				mail=new JTextField();
				mail.setBounds(150,210,86,20);
				client.add(mail);
				mail.setColumns(10);
				
				JLabel ll6 = new JLabel("telefon");
				ll6.setHorizontalAlignment(SwingConstants.CENTER);
				ll6.setBounds(45, 240, 86, 56);
				client.add(ll6);
				
				telefon=new JTextField();
				telefon.setBounds(150,256,86,20);
				client.add(telefon);
				telefon.setColumns(10);
				
				JButton btnNewButton_110=new JButton("Inserare");
				btnNewButton_110.setBounds(150, 290, 100, 56);
				client.add(btnNewButton_110);
				try {
					String querry= "insert into Clienti values(?,?,?,?,?,?)";
					PreparedStatement std=con.prepareStatement(querry);
					std.setInt(1,198656847);
					std.setString(2,"Moldovan Simona");
					std.setString(3,"str.Papucului nr 30");
					std.setString(4,"Cluj-Napoca");
					std.setString(5,"moldovan.simo@gmail.com");
					std.setString(6,"073456980716");
					std.execute();
				}
				catch(Exception exe)
				{
					JOptionPane.showMessageDialog(null,"Eroare de inserare");
				}
			}
		}
			
		);
		
		btnNewButton_6.setBounds(805, 80, 123, 25);
		menuad.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Alege dupa pret");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SQL1="select destinatie,(pret/nrpersoane) from pachete order by (pret/nrpersoane) asc;";
				try {
				Statement st1=con.createStatement();
				ResultSet rs=st1.executeQuery(SQL1);
				ResultSetMetaData rsmd=rs.getMetaData();
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				model.setRowCount(0);
				int colCount=rsmd.getColumnCount();
				int i;
				Object[] row=new Object[7];
				for(i=1;i<=colCount;i++)
					row[i-1]=rsmd.getColumnName(i).toUpperCase();
				model.addRow(row);
				while(rs.next()) {
					for(i=1;i<=colCount;i++) {
						row[i-1]=rs.getObject(i);
					}
					model.addRow(row);
				}
				}
				catch(Exception ex1)
				{
					JOptionPane.showMessageDialog(null,"Eroare de vizualizare");
				}
				
			}
		});
		btnNewButton_7.setBounds(805, 134, 123, 25);
		menuad.add(btnNewButton_7);
		
		table = new JTable();
		table.setToolTipText("jkbjb");
		table.setSurrendersFocusOnKeystroke(true);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBorder(new MatteBorder(1,1,1,1,(Color) new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(new Object[][] {},new String[] {"CNP","nume","adresa","oras","mail","telefon"}));
		table.setBounds(170, 10, 600, 500);
		menuad.add(table);
		
		JButton btnNewButton_10 = new JButton("Pachete");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SQL1="select * from pachete";
				try {
				Statement st1=con.createStatement();
				ResultSet rs=st1.executeQuery(SQL1);
				ResultSetMetaData rsmd=rs.getMetaData();
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				model.setRowCount(0);
				int colCount=rsmd.getColumnCount();
				int i;
				Object[] row=new Object[7];
				for(i=1;i<=colCount;i++)
					row[i-1]=rsmd.getColumnName(i).toUpperCase();
				model.addRow(row);
				while(rs.next()) {
					for(i=1;i<=colCount;i++) {
						row[i-1]=rs.getObject(i);
					}
					model.addRow(row);
				}
				}
				catch(Exception ex1)
				{
					JOptionPane.showMessageDialog(null,"Eroare de vizualizare");
				}
			}
		});
		btnNewButton_10.setBounds(22, 279, 122, 25);
		menuad.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("Agentie");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SQL1="select * from agentie";
				try {
				Statement st1=con.createStatement();
				ResultSet rs=st1.executeQuery(SQL1);
				ResultSetMetaData rsmd=rs.getMetaData();
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				model.setRowCount(0);
				int colCount=rsmd.getColumnCount();
				int i;
				Object[] row=new Object[7];
				for(i=1;i<=colCount;i++)
					row[i-1]=rsmd.getColumnName(i).toUpperCase();
				model.addRow(row);
				while(rs.next()) {
					for(i=1;i<=colCount;i++) {
						row[i-1]=rs.getObject(i);
					}
					model.addRow(row);
				}
				}
				catch(Exception ex1)
				{
					JOptionPane.showMessageDialog(null,"Eroare de vizualizare");
				}
				
			}
		});
		btnNewButton_11.setBounds(22, 327, 122, 25);
		menuad.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("Cancel");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_12.setBounds(805, 485, 123, 25);
		menuad.add(btnNewButton_12);
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
			//JOptionPane.showMessageDialog(null,"Conectat");
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,"Eroare la conectare SQL");
			
		}
	}
}
