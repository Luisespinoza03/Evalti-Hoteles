package conectorBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConexion {
	
	public static Connection getConexion() {
		
		Connection con = null;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/evalti";
			String user = "root";
			String pass = "";
			
			con = DriverManager.getConnection(url,user,pass);
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el driver");
			e.printStackTrace();
		} catch (SQLException e) {
		System.out.println("Error en la BD");
			e.printStackTrace();
		}
		
		
		return con;

	}



	
}
