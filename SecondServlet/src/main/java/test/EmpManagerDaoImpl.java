package test;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import utile.ConnectionSMMS;

public class EmpManagerDaoImpl implements EmpManagerDao{
	QueryRunner queryRunner=new QueryRunner(ConnectionSMMS.createMSSQLConnection());

	@Override
	public EmpManager select(String username) {
		String sql="select * from empManager where username=?";
		try {
			EmpManager empManager=queryRunner.query(sql, new BeanHandler<EmpManager>(EmpManager.class),username);
			return empManager;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		

}
	}
