package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class HSQLconnection {

	public Connection getConnection() {

		Connection connection = null;
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");
		} catch (Exception e) {
			System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
			e.printStackTrace();
		}
		return connection;
	}
}
