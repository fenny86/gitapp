package impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import bean.Emp;
import dao.EmpDao;
import utile.ConnectionSMMS;

public class EmpDaoImpl implements EmpDao{
QueryRunner queryRunner=new QueryRunner(ConnectionSMMS.createMSSQLConnection());
	@Override
	public List<Emp> selectAll() {
		String sql="select * from emp";
		try {
			List<Emp> empList= queryRunner.query(sql, new BeanListHandler<Emp>(Emp.class));
			return empList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
	@Override
	public int delete(int id) {
		String sql="delete from emp where id=?";
		try {
			int result= queryRunner.update(sql,id);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public int update(Emp emp) {
		String sql="update emp set name=?,salary=?,age=? where id=?";
		try {
			int result= queryRunner.update(sql,emp.getName(),emp.getSalary(),emp.getAge(),emp.getId());
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public Emp select(int id) {
		String sql="select * from emp where id=?";
		try {
			Emp emp=queryRunner.query(sql, new BeanHandler<Emp>(Emp.class),id);
			return emp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
