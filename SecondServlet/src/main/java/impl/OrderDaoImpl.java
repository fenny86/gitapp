package impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import bean.ClassBean;
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
			
			int result= queryRunner.update(sql,ob.getMemberId(),ob.getCustomerEmail(),ob.getCustomerPhone(),ob.getOrderStatus(),ob.getOrderDate(),ob.getOrderPrice());
			
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

	@Override
	public void persistOrder(OrderBean ob) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void persistOrder(OrderBean ob) {
//		Connection con = null;
//		try {
//			con = ds.getConnection();
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			throw new RuntimeException(ex.getMessage());
//		}
//		try {
//			log.info("處理訂單之Service:交易開始");
//			// 交易開始
//			con.setAutoCommit(false);
//			// 檢查未付款餘額是否超過限額，並更新未付款餘額
//			memberDao.setConnection(con);
//			log.info("處理訂單之Service: 1. 準備處理會員之未付款餘額");
//			memberService.checkUnpaidAmount(ob);
//			 
//			log.info("處理訂單之Service: 2. 準備再次檢查並調整每項商品的庫存量");
//			// 檢查所有訂單明細所訂購之商品的庫存數量是否足夠
//			checkStock(ob, con);
//			
//			// 儲存訂單
//			log.info("處理訂單之Service: 3. 準備儲存訂單");
//			orderDao.setConnection(con);
//			orderDao.save(ob);
//			con.commit();
//		} catch (Exception e) {
//			try {
//				con.rollback();
//				System.out.println("發生異常，交易回滾.....,原因: " + e.getMessage());
//			} catch (SQLException e1) {
//				throw new RuntimeException(e1);
//			}
//			throw new RuntimeException(e);
//		} finally {
//			try {
//				con.setAutoCommit(true);
//				con.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//				throw new RuntimeException(e.getMessage());
//			}
//		}
//	}
//
}
