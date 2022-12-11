package impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import bean.MemberBean;
import dao.MemberServiceDao;
import utile.ConnectionSMMS;

public class MemberServiceDaoImpl implements MemberServiceDao{
	
	QueryRunner queryRunner=new QueryRunner(ConnectionSMMS.createMSSQLConnection());
	
	public MemberBean select(String username) {
		
		String sql="select * from MemberTable where memberAccount=?";
		
		try {
			MemberBean memberBean=queryRunner.query(sql, new BeanHandler<MemberBean>(MemberBean.class),username);
			
			return memberBean;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		

}

}
