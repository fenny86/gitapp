package utile;

import java.beans.Statement;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbutils.QueryRunner;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class  ConnectionSMMS {
	public static HikariDataSource createMSSQLConnection() {
		HikariConfig config = new HikariConfig("D:\\java\\Temple\\src\\main\\java\\jdbc.properties");
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
	}
	
	
	}

