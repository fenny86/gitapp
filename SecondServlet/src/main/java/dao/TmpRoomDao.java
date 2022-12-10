package dao;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.jasper.compiler.NewlineReductionServletWriter;

import bean.report;
import bean.templeBean;
import bean.templeRoomBean;
import utile.ConnectionSMMS;

public class TmpRoomDao {
	QueryRunner queryRunner=new QueryRunner(ConnectionSMMS.createMSSQLConnection());

//	public  MapListHandler selectAll(String templeId) {
//		String sql="select t.templeId,t.address,"+"tr.singleroom,tr.doubleroom,tr.tripleroom,tr.quadrupleroom,tr.dormitoryroom"
//				+ " from Temple t cross join Templeroom tr where t.templeId = ?";
//		try {
//			List<report> beans = queryRunner.query(sql, new BeanListHandler<report>(report.class),templeId);
//			System.out.println(beans);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} 
//		return null;
//	}
	public  List<report> selectAll(String templeId,String[] room) {
		String room1=Arrays.toString(room).replace("[","").replace("]","");
		String sql="select t.templeId,t.address,"+room1+" from Temple t cross join Templeroom tr where t.templeId = ?";
		try {
			List<report> beans = queryRunner.query(sql, new BeanListHandler<report>(report.class),templeId);
			return beans;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	
}
