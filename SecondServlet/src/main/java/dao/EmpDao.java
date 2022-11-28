package dao;

import java.util.List;

import bean.Emp;

public interface EmpDao {
	public List<Emp> selectAll();
	public Emp select(int id);
	
    public int delete(int id); 
    
    public int update(Emp emp); 
    
    

}
