package Dao;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;


public class ConnectionManagement {
	
	static Connection conn = null;
	
	private ConnectionManagement() {}
	
	public static Connection getConnectionManagement() {
		try {
			
			if(conn==null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stok_kart?user=root&password=veritas_817");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	

//---------------------------------------
//	public Connection conn = null;
//	
//	public ConnectionManagement() {
//		connDb();
//	}
//	
//	
//	public Connection connDb() {
//		try {
//			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stok_kart?user=root&password=veritas_817");
//			
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
//		return conn;
//	}
//	

	
	
}
