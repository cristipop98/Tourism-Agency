package agentie;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
/**
 * Connect to Database
 * @author hany.said
 */
public class DatabaseConnection extends Meniuadmin{
	public static void main(String[] args) {
		try {
			String host="jdbc:mysql://localhost:3306/agentie_turism";
			String user="root";
			String pass="";
			Connection con=DriverManager.getConnection(host,user,pass);
			Statement st1=con.createStatement();
			JOptionPane.showMessageDialog(null,"Conectare reusita");
			
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Eroare la conectare");
		}
	}
}