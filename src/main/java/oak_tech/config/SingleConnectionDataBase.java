package oak_tech.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnectionDataBase {
	
	
	private static String data = "jdbc:postgresql://localhost:5432/oak?autoReconnect=true";
	private static String user = "postgres";
	private static String password = "dev12345";
	private static Connection connection = null;
	
	static {
		conectar();
	}
	
	public SingleConnectionDataBase() {
		conectar();
	}
	
	public static void conectar() {
		try {
			if(connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(data, user, password);
				connection.setAutoCommit(false);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConnection() {
		return connection;
	}

}
