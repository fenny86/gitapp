package utile;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class  ConnectionSMMS {
	public static HikariDataSource createMSSQLConnection() {
		HikariConfig config = new HikariConfig("C:\\git1\\SecondServlet\\src\\main\\java\\jdbc.properties");
		HikariDataSource ds = new HikariDataSource(config);
		return ds;
	
	}
}
