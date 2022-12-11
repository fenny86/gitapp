package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import bean.templeBean;
import utile.ConnectionSMMS;

public class TempleDao {
	QueryRunner queryRunner=new QueryRunner(ConnectionSMMS.createMSSQLConnection());

	//查詢
	public  List<templeBean> selectAll(String templeId) {
		String sql="select * from Temple where templeId = ?";
		try {
			List<templeBean> beans= queryRunner.query(sql, new BeanListHandler<templeBean>(templeBean.class),templeId);
			return beans;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}
	//新增
	public void insertTemple(templeBean tmpb) throws SQLException {

		String sql="insert into Temple (templeId,templeName,deitiesName,"
				+ "administrative,address,register,sect,phone,principal,other,"
				+ "WGS84X,WGS84Y,Uniform_numbers) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] parms= {tmpb.getTempleId(),tmpb.getTempleName(),tmpb.getDeitiesName(),tmpb.getAdministrative(),tmpb.getAddress(),tmpb.getRegister(),tmpb.getSect(),tmpb.getPhone(),tmpb.getPrincipal(),tmpb.getOther(),
				tmpb.getWGS84X(),tmpb.getWGS84Y(),tmpb.getUniformnumbers()};
		queryRunner.update(sql, parms);

	}
	//修改
	public void updateTemple(templeBean tmpb) throws SQLException {

		String sql="UPDATE Temple SET templeName=?, deitiesName=?, administrative=?, address=?, register=?, sect=?, phone=?, principal=?, other=?, WGS84X=?, WGS84Y=?, Uniform_numbers=? WHERE templeId = ?";
		Object[] parms= {tmpb.getTempleName(),tmpb.getDeitiesName(),tmpb.getAdministrative(),tmpb.getAddress(),tmpb.getRegister(),tmpb.getSect(),tmpb.getPhone(),tmpb.getPrincipal(),tmpb.getOther(),
				tmpb.getWGS84X(),tmpb.getWGS84Y(),tmpb.getUniformnumbers(),tmpb.getTempleId()};
		queryRunner.update(sql, parms);

	}
	
	//刪除
	public void removeTmp(String templeId) throws SQLException {
		
		String sql="delete from Temple where templeId = ?";
		try {
			
			int row = queryRunner.update(sql, templeId);
			System.out.println(row);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updatePivture(InputStream input) throws SQLException, FileNotFoundException {
		String sql="UPDATE Temple SET other=? where templeId='123'";
		queryRunner.update(sql, input);
	}
}