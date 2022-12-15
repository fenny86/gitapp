package createTable;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import utile.ConnectionSMMS;

public class CreateTable_23 {
	
	static QueryRunner queryRunner=new QueryRunner(ConnectionSMMS.createMSSQLConnection());
    public static void creatOrderTable() {
		
		String sql="Create TABLE People_23 "
				+ "(userID int not null Primary Key, "
				+ " userAge　int not null, " 
				+ " Name    	varchar(50) not null, " 
				+ " sex varchar(10) not null, " 
				+ " Address varchar(50) , " 
				+ " person_img    varbinary(MAX), " 
				+ " star_sign varchar(50), " 
				+ " emotion varchar(100), " 
				+ " Profession varchar(50), " 
				+ " personality varchar(MAX), " 
				+ " hobby varchar(100), " 
				+ " dream varchar(MAX), " 
				+ " introduction varchar(MAX), " 
				+ " religion varchar(100), " 
				+ " income money, " 
				+ " sex_orientation varchar(50), " 
				+ " )";
		try {
			queryRunner.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	
	public static void main(String args[]) {

		creatOrderTable();
	}
}

