package dao;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import bean.photoBean;
import bean.templeBean;
import utile.ConnectionSMMS;

public class photoDao {

	QueryRunner queryRunner=new QueryRunner(ConnectionSMMS.createMSSQLConnection());
	
	
	public void insert(photoBean pb1) throws SQLException {
		String sql="insert into photo (Id,photo) VALUES(?,?)";
		Object[] parms= {pb1.getId(),pb1.getPhoto()};
		queryRunner.update(sql, parms);
	}
	
	public  List<photoBean> selectAll(int Id) {
		String sql="select * from photo where Id = ?";
		try {
			List<photoBean> beans= queryRunner.query(sql, new BeanListHandler<photoBean>(photoBean.class)
					
					{public photoBean handle(ResultSet rs) throws SQLException{
				photoBean ac = new photoBean();
             while(rs.next()) {
                    ac.setId(rs.getInt("id"));
                    ac.setPhoto(rs.getBinaryStream("photo"));
             }
             return ac;
            }
           },Id);
//			return beans;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}
//	 public Account select(Integer id) {
//	        String sql="select * from account where id=?";
//
//
//	         try {
//	             Account classbean = queryRunner.query(sql,
//							new BeanHandler<Account>(Account.class)
//				{
//					public Account handle(ResultSet rs) throws SQLException{
//	                    Account ac = new Account();
//	                 while(rs.next()) {
//	                        ac.setId(rs.getInt("id"));
//	                        ac.setAccount(rs.getString("account"));
//	                        ac.setPassword(rs.getString("password"));
//	                        ac.setImage(rs.getBlob("img"));
//
//	                 }
//	                 return ac;
//	                }
//	               },id);
//	               return classbean;
//
//
//	        } catch (SQLException e) {
//	            // TODO Auto-generated catch block
//	            e.printStackTrace();
//	        }
//	        return null;
//	    }
}