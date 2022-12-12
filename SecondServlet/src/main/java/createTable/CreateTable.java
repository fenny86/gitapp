package createTable;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import utile.ConnectionSMMS;

public class CreateTable {
	
	static QueryRunner queryRunner=new QueryRunner(ConnectionSMMS.createMSSQLConnection());
    public static void creatOrderTable() {
		
		String sql="Create TABLE OrderTable "
				+ "(orderNumber int NOT NULL IDENTITY Primary Key, "
				+ " memberId	    int, " 
				+ " customerEmail    	varchar(50), " 
				+ " customerPhone    	varchar(50), " 
				+ " orderStatus    	varchar(50), " 
				+ " orderDate    	datetime2, " 
				+ " orderPrice    	Money, " 
				+ " )";
		try {
			queryRunner.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	
	public static void creatClassTables() {
		
		String sql="Create TABLE ClassTables "
				+ "(classId int Primary Key, "
				+ " className			varchar(50), " 
				+ " classTeacher    	varchar(28), " 
				+ " classPrice			Money, "
				+ " discount   		    Money," 
				+ " classPicture		varbinary(max), "
				+ " classCategory		varchar(28), " 
				+ " )";
		try {
			queryRunner.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
      public static void creatMemberTable() {
		
		String sql="Create TABLE MemberTable "
				+ "(memberId int  Primary Key, "
				+ " memberAccount	    varchar(50), " 
				+ " memberPassword    	varchar(50), " 
				+ " )";
		try {
			queryRunner.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	
	public static void main(String args[]) {
		
		creatClassTables();
		creatMemberTable();
		creatOrderTable();
	}
}

