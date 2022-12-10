package service;

import java.util.List;

import bean.Active;
import bean.Page;


public interface ActiveService {
public List<Active> showAllActive();
	
	public Active showActive(int id);
	
	public int removeActive(int id);
	public int modify(Active active);
	
	public List<Active> showAllActive(Page page);
	
	public int add(Active active);
	

}
