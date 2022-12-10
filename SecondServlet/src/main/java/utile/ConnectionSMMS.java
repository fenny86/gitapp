package utile;

//import java.beans.Statement;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class  ConnectionSMMS {
	public static HikariDataSource createMSSQLConnection() {
		HikariConfig config = new HikariConfig("C:\\SecondServlet\\src\\main\\java\\jdbc.properties");
		HikariDataSource ds = new HikariDataSource(config);
		return ds;
	}
}
