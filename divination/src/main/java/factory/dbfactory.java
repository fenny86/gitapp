package factory;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class dbfactory {
	 public static HikariDataSource createMSSQLConnection() {
		  HikariConfig con = new HikariConfig("C:\\_SpringBoot\\workspaceA\\divination\\src\\main\\java\\db.properties");
		  HikariDataSource ds = new HikariDataSource(con);
		  return ds;
		 }
}
