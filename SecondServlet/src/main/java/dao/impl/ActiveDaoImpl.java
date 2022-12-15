package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import bean.Active;
import bean.Page;
import dao.ActiveDao;
import utile.ConnectionSMMS;

public class ActiveDaoImpl implements ActiveDao{
	QueryRunner queryRunner=new QueryRunner();

	@Override
	public List<Active> selectAll() {
		String sql="select * from templeActive";
		try {
			List< Active> activeList =queryRunner.query(ConnectionSMMS.createConnection(), sql,new BeanListHandler<Active>(Active.class) {
			 public List<Active> handle(ResultSet rs) throws SQLException{
               
               List<Active> ac=new ArrayList<>();
				 while(rs.next()) {
            	 Active active=new Active();
                     active.setActiveID(rs.getInt("activeID"));
                     active.setActiveName(rs.getString("activeName"));
                     active.setActiveImg(rs.getBlob("activeImg"));
                     active.setActiveDescription(rs.getString("activeDescription"));
                     active.setActiveStartDate(rs.getString("activeStartDate"));
                     active.setActiveEndDate(rs.getString("activeEndDate"));
                     active.setActiveLocation(rs.getString("activeLocation"));
                     active.setActiveHost(rs.getString("activeHost"));
                     ac.add(active);
              }
              return ac;
             }
            });
            return activeList;


     } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
     }
     return null;
 }

	@Override
	public Active select(int id) {
		String sql="select * from templeActive where activeID=?";
		try {
			Active active=queryRunner.query(ConnectionSMMS.createConnection(),sql, new BeanHandler<Active>(Active.class){

                public Active handle(ResultSet rs) throws SQLException{
                    Active ac = new Active();
                 while(rs.next()) {
                	 ac.setActiveID(rs.getInt("activeID"));
                     ac.setActiveName(rs.getString("activeName"));
                     ac.setActiveImg(rs.getBlob("activeImg"));
                     ac.setActiveDescription(rs.getString("activeDescription"));
                     ac.setActiveStartDate(rs.getString("activeStartDate"));
                     ac.setActiveEndDate(rs.getString("activeEndDate"));
                     ac.setActiveLocation(rs.getString("activeLocation"));
                     ac.setActiveHost(rs.getString("activeHost"));
                 }
                 return ac;
                }
               },id);
               return active;


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

	@Override
	public int delete(int id) {
		String sql="delete from templeActive where activeID=?";
		try {
			int result= queryRunner.update(ConnectionSMMS.createConnection(),sql,id);
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(Active active) {
		String sql="update templeActive set activeName=?,activeImg=?,activeDescription=?,activeStartDate=?,activeEndDate=?,activeLocation=?,activeHost=? where activeID=?";
		try {
			int result= queryRunner.update(ConnectionSMMS.createConnection(),sql,active.getActiveName(),active.getActiveImg(),active.getActiveDescription(),
					active.getActiveStartDate(),active.getActiveEndDate(),active.getActiveLocation(),active.getActiveHost(),active.getActiveID());
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Active> selectAll(Page page) {
		String sql="SELECT TOP   (?) * FROM templeActive WHERE (activeID NOT IN (SELECT TOP (?) activeid FROM templeActive ORDER BY activeID)) ORDER BY activeID";
		
		List<Active> activeList=null;
		try {
			activeList = queryRunner.query(ConnectionSMMS.createConnection(), sql,new BeanListHandler<Active>(Active.class) {
				 public List<Active> handle(ResultSet rs) throws SQLException{
			      
			      List<Active> ac=new ArrayList<>();
					 while(rs.next()) {
			   	 Active active=new Active();
			            active.setActiveID(rs.getInt("activeID"));
			            active.setActiveName(rs.getString("activeName"));
			            active.setActiveImg(rs.getBlob("activeImg"));
			            active.setActiveDescription(rs.getString("activeDescription"));
			            active.setActiveStartDate(rs.getString("activeStartDate"));
			            active.setActiveEndDate(rs.getString("activeEndDate"));
			            active.setActiveLocation(rs.getString("activeLocation"));
			            active.setActiveHost(rs.getString("activeHost"));
			            ac.add(active);
			     }
			     return ac;
			    }
			   },page.getPageSize(),page.getStartRows());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
           return activeList;
		
		
	}

	@Override
	public int selectCount() {
		String sql="select count(*) from templeActive";
		try {
			return queryRunner.query(ConnectionSMMS.createConnection(), sql,new  ScalarHandler<>());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	@Override
	public int insert(Active active) {
		String sql="insert into templeActive (activeName,activeImg,activeDescription,activeStartDate,activeEndDate,activeLocation,activeHost) values(?,?,?,?,?,?,?)";
		try {
			 int result= queryRunner.update(ConnectionSMMS.createConnection(),sql,active.getActiveName(),active.getActiveImg(),active.getActiveDescription(),
					 active.getActiveStartDate(),active.getActiveEndDate(),active.getActiveLocation(),active.getActiveHost());
		System.out.println(result);
			 return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}
	

}
