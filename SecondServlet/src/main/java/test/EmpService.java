package test;

import java.util.List;

public interface EmpService {
	public List<Emp> showAllEmp();
	
	public Emp showEmp(int id);
	
	public int removeEmp(int id);
	public int modify(Emp emp);

}
