package service;

import java.util.List;

import bean.Emp;

public interface EmpService {
	public List<Emp> showAllEmp();
	
	public Emp showEmp(int id);
	
	public int removeEmp(int id);
	public int modify(Emp emp);

}
