package application.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO_Padrao {
	
	private Connection con;

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		String host = "localhost";
		String nomeBD = "clinica";
		String user = "root";
		String senha = "alunofatec";
		
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		
		con = DriverManager.getConnection(
				String.format("jdbc:jtds:sqlserver://%s:1433;databaseName=%s;user=%s;password=%s",
						host, nomeBD, user, senha));
		return con;
	}
}
