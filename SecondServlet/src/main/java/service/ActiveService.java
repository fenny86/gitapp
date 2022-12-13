package service;

import java.util.List;

import bean.Active;


public interface ActiveService {
public List<Active> showAllActive();
	
	public Active showActive(int id);
	
	public int removeActive(int id);
	public int modify(Active active);
	
	
	public int add(Active active);
	

}
