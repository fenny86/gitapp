package dao;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import bean.ClassBean;

public interface ClassDao {
	//所有產品的展現
	public List<ClassBean> selectAll();
	//透過id來找尋課程資料
	public ClassBean findById(int classId);
	//透過id來刪除課程資料
	public int delete(int id); 
	//修改書本資料
	int save(ClassBean classBean);
    //新增書本資料
	int updateClass(ClassBean classBean, long sizeInBytes) ;    
	public int updateClass(ClassBean classBean);
	


}
