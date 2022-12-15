package dao;

import java.sql.SQLException;

import bean.Post;

public class PostDaoAction {

	public static void main(String[] args) throws SQLException {

		PostDao pDao = new PostDao();
//		Post sbi = pDao.searchById(null);
//		System.out.println(sbi.toString());
		pDao.searchAll();
//		pDao.add(null, "JAVA CLASS", "2022-12-07", "123456789", "10", "1", "987654321");
//		pDao.delete(1);
//		pDao.update(1, "JAVA CLASS", "2022-12-07", "123456789", "10", "1", "987654321");
	}

}
