package dao;

import java.sql.Blob;
import java.util.List;

import javax.servlet.http.Part;

import bean.Account;

public interface AccountDao {
	
	public List<Account> selectAll();
	
	public Account select(Integer id);
	
	public int delete(Integer id); 
	
//	public int update(Account account, Blob image); 
    	
	public int update(Account account);//多加圖片

	public int add(Account account);
	




    
    

}
