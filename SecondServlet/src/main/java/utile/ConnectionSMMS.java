package utile;

import java.beans.Statement;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class  ConnectionSMMS {
	public static HikariDataSource createMSSQLConnection() {
<<<<<<< HEAD
		HikariConfig config = new HikariConfig("C:\\_SpringBoot\\workspaceA\\SecondServlet\\src\\main\\java\\jdbc.properties");
=======
		HikariConfig config = new HikariConfig("C:\\Users\\User\\Documents\\git\\SecondServlet\\src\\main\\java\\jdbc.properties");
>>>>>>> b0239461085ec8ad8d51f47448042716c8779ba0
		HikariDataSource ds = new HikariDataSource(config);
		return ds;
	}
}
