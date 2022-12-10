package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.MapListHandler;

import bean.photoBean;
import bean.report;
import bean.templeBean;
import bean.templeRoomBean;
import dao.TmpRoomDao;
import dao.photoDao;

public class test001 {

	public static void main(String[] args) throws SQLException, FileNotFoundException {
//		File file = new File("C:\\Users\\User\\Desktop\\123.jpg");
//		InputStream input = new FileInputStream(file);
//		TempleDao tpDao= new TempleDao();
//		List<templeBean> beans = tpDao.selectAll();
//		

//		tpDao.removeTmp("");
//		tpDao.insertTemple(null);
//		templeBean tmpb = new templeBean("123", "", "", "", "12", "12", "12", "1", "1", "1", 1.1, 1.1, 123);
//		tpDao.insertTemple(tmpb);
//		tpDao.updateTemple(tmpb);
//		tpDao.updateTemple(tmpb);
//		photoBean pb1 = new photoBean(1,input);
//		photoDao pd = new photoDao();
//		pd.insert(pb1);
		TmpRoomDao trd = new TmpRoomDao();
		String[] room = {"tr.singleroom,tr.doubleroom,tr.tripleroom"};
		List<report> beans=trd.selectAll("1766323",room);
//		MapListHandler beans = trd.selectAll("1766323");
		System.out.println(beans);
		
	}
}
