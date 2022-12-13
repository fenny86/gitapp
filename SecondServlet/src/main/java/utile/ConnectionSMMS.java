package utile;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class  ConnectionSMMS {
	public static HikariDataSource createMSSQLConnection() {
		HikariConfig config = new HikariConfig("C:\\_SpringBoot\\workspaceA\\SecondServlet\\src\\main\\java\\jdbc.properties");
		HikariDataSource ds = new HikariDataSource(config);
		return ds;
	}
	public static Connection createConnection() {
		  Connection conn=null;
		  try {
		   conn= ConnectionSMMS.createMSSQLConnection().getConnection();
		  } catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
		  return conn;	 
}}
