package impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import bean.AccountManager;
import dao.AccountManagerDao;
import utile.ConnectionSMMS;

public class AccountManagerDaoImpl implements AccountManagerDao{
	QueryRunner queryRunner=new QueryRunner(ConnectionSMMS.createMSSQLConnection());

	@Override
	public AccountManager select(String username) {
		String sql="select * from accountManager where username=?";
		try {
			AccountManager accountManager=queryRunner.query(sql, new BeanHandler<AccountManager>(AccountManager.class),username);
			return accountManager;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		

}
	}
