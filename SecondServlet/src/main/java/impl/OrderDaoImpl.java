package impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import bean.OrderBean;
import dao.OrderDao;
import utile.ConnectionSMMS;

public class OrderDaoImpl implements OrderDao{
	
	QueryRunner queryRunner = new QueryRunner(ConnectionSMMS.createMSSQLConnection());


	@Override
	public int save(OrderBean ob) {
		String sql = "INSERT INTO OrderTable " 
				+ " (memberId, customerEmail, customerPhone, "
				+ " orderStatus, orderDate,orderPrice) " 
				+ " VALUES (?, ?, ?, ?, ?, ?)";
		try {
			
			int result= queryRunner.update(sql,ob.getMemberId(),ob.getCustomerEmail(),ob.getCustomerPhoneStr(),ob.getOrderStatus(),ob.getOrderDate(),ob.getOrderPrice());
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
		
	}

	@Override
	public OrderBean findById(int orderNumber) {
		String sql = "select * from OrderTable where orderNumber=?";
		try {
			OrderBean orderBean = queryRunner.query(sql, new BeanHandler<OrderBean>(OrderBean.class),orderNumber);
			return orderBean;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<OrderBean> findByMemberId(int memberId) {
		String sql = "select * from OrderTable where memberId=?";
		try {
			
			List<OrderBean> orderBean= queryRunner.query(sql, new BeanListHandler<OrderBean>(OrderBean.class),memberId);
			return orderBean;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


}
