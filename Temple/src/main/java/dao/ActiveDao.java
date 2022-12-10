package dao;

import java.util.List;

import bean.Active;
import bean.Page;


public interface ActiveDao {
	public List<Active> selectAll();
	public Active select(int id);
	
    public int delete(int id); 
    
    public int update(Active active); 
    
    public List<Active> selectAll(Page page);
    
    public int selectCount();
    
    public int insert(Active active);

}
