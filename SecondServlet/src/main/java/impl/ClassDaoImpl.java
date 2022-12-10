package impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import bean.ClassBean;
import dao.ClassDao;
import utile.ConnectionSMMS;

public class ClassDaoImpl implements ClassDao {
	QueryRunner queryRunner = new QueryRunner(ConnectionSMMS.createMSSQLConnection());

	@Override
	public List<ClassBean> selectAll(){
		String sql = "select * from ClassTables";
		try {
			List<ClassBean> classList = queryRunner.query(sql, new BeanListHandler<ClassBean>(ClassBean.class) {
				
				public List<ClassBean> handle(ResultSet rs) throws SQLException{
					List<ClassBean> classList= new ArrayList();
					while(rs.next()) {
						ClassBean cb = new ClassBean();
						cb.setClassId(rs.getInt("classId"));
						cb.setClassName(rs.getString("className"));
						cb.setClassTeacher(rs.getString("classTeacher"));
						cb.setClassPrice(rs.getDouble("classPrice"));
						cb.setDiscount(rs.getDouble("discount"));
						cb.setClassPicture(rs.getBlob("classPicture"));
						cb.setClassCategory(rs.getString("classCategory"));
						classList.add(cb);
					}
					return classList;
				}
			});
				return classList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public int delete(int classId) {
		String sql = "delete from ClassTables where classId=?";
		try {
			int result = queryRunner.update(sql, classId);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	@Override
	public ClassBean findById(int classId) {
		String sql = "select * from ClassTables where classId=?";
		try {
			ClassBean classbean = queryRunner.query(sql, new BeanHandler<ClassBean>(ClassBean.class){
				
				public ClassBean handle(ResultSet rs) throws SQLException{
					ClassBean cb = new ClassBean();
					while(rs.next()) {
						cb.setClassId(rs.getInt("classId"));
						cb.setClassName(rs.getString("className"));
						cb.setClassTeacher(rs.getString("classTeacher"));
						cb.setClassPrice(rs.getDouble("classPrice"));
						cb.setDiscount(rs.getDouble("discount"));
						cb.setClassPicture(rs.getBlob("classPicture"));
						cb.setClassCategory(rs.getString("classCategory"));
					}
					return cb;
				}
			},classId);
			return classbean;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int updateClass(ClassBean classBean, long sizeInBytes) {
		String sql = "UPDATE ClassTables SET " 
				+ "className=?,  classTeacher=?, classPrice = ?, "
				+ " classPicture=?, classCategory=? where classId=?";
		if (sizeInBytes == -1) { // 不修改圖片
			int r = updateClass(classBean);//取用另一個沒圖片的更新方法
			return r;
		}
		try {
			int result= queryRunner.update(sql,classBean.getClassName(),classBean.getClassTeacher(),classBean.getClassPrice(),classBean.getClassPicture(),classBean.getClassCategory(),classBean.getClassId());
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;		
	}

	
	@Override
	public int updateClass(ClassBean classBean) {
		String sql = "update ClassTables set className=?,classTeacher=?,classPrice=?,classCategory=? where classId=?";
		try {
			int result = queryRunner.update(sql, classBean.getClassName(), classBean.getClassTeacher(),
					classBean.getClassPrice(), classBean.getClassCategory(),
					classBean.getClassId());
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}


	@Override
	public int save(ClassBean classBean) {
		String sql = "INSERT INTO ClassTables " 
				+ " (classId, className, classTeacher, classPrice, "
				+ " classPicture, classCategory) " 
				+ " VALUES (?, ?, ?, ?, ?, ?)";
		try {
			
			int result= queryRunner.update(sql,classBean.getClassId(),classBean.getClassName(),classBean.getClassTeacher(),classBean.getClassPrice(),classBean.getClassPicture(),classBean.getClassCategory());
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
		
	}




}
