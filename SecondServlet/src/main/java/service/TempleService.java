package service;

import java.sql.SQLException;
import java.util.List;

import bean.templeBean;
import dao.TempleDao;

public class TempleService { 
	TempleDao tmpDao = new TempleDao();
	public List<templeBean> selectAll() {
		return null;
	}
	public void removeTmp(String templeId) throws SQLException {
	}
	public void insertTemple(templeBean tmpb) throws SQLException {
		
	}


}
