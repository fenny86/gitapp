package impl;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Part;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zaxxer.hikari.HikariDataSource;

import bean.Account;
import dao.AccountDao;
import utile.ConnectionSMMS;

public class AccountDaoImpl implements AccountDao{
QueryRunner queryRunner=new QueryRunner(ConnectionSMMS.createMSSQLConnection());
//	@Override
//	public List<Account> selectAll() {
//		String sql="select * from account";
//		try {
//			List<Account> accountList= queryRunner.query(sql, new BeanListHandler<Account>(Account.class));
//			return accountList;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} 
//		return null;
//	}
//	

	@Override
	public List<Account> selectAll(){
		String sql = "select * from account";
		try {
			List<Account> accountList = queryRunner.query(sql, new BeanListHandler<Account>(Account.class) {
				
				public List<Account> handle(ResultSet rs) throws SQLException{
					List<Account> accountList= new ArrayList();
					while(rs.next()) {
						Account ac = new Account();
						ac.setId(rs.getInt("id"));
						ac.setAccount(rs.getString("account"));
						ac.setPassword(rs.getString("password"));
						ac.setImage(rs.getBlob("img"));

						accountList.add(ac);
					}
					return accountList;
				}
			});
				return accountList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int delete(Integer id) {
		String sql="delete from account where id=?";
		try {
			int result= queryRunner.update(sql,id);
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public int update(Account account) {
		String sql="update account set account=?,password=?,img=? where id=?";
		try {
			int result= queryRunner.update(sql,account.getAccount(),account.getPassword(),account.getImage(),account.getId());
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
//	@Override
//	public int update(Account account) {
//		String sql="update account set account=?,password=? where id=?";
//		try {
//			int result= queryRunner.update(sql,account.getAccount(),account.getPassword(),account.getId());
//			return result;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return 0;
//	}
	

//	@Override
//	public int update(Account account,Blob image) { 
//		String sql="update account set img=? where id=?";
//		try {
//			int result= queryRunner.update(sql,account.getImage(),account.getId());
//			return result;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return 0;
//	}
	
	@Override
	public Account select(Integer id) {
		String sql="select * from account where id=?";
		
		
		 try {
			 Account classbean = queryRunner.query(sql, new BeanHandler<Account>(Account.class){
			    
			    public Account handle(ResultSet rs) throws SQLException{
			    	Account ac = new Account();
			     while(rs.next()) {
						ac.setId(rs.getInt("id"));
						ac.setAccount(rs.getString("account"));
						ac.setPassword(rs.getString("password"));
						ac.setImage(rs.getBlob("img"));
			     }
			     return ac;
			    }
			   },id);
			   return classbean;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
