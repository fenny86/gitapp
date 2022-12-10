package test;

import java.util.List;

public class EmpServiceImpl implements EmpService{
EmpDao empDao=new EmpDaoImpl();
	@Override
	public List<Emp> showAllEmp() {
		List<Emp> empList=null;
		
		List<Emp> temp= empDao.selectAll();
		if(temp!=null) {
			empList=temp;
		}
		return empList;
	}
	@Override
	public int removeEmp(int id) {
		int result=empDao.delete(id);
		return result;
	}
	@Override
	public int modify(Emp emp) {
		int result= empDao.update(emp);
		return result;
	}
	@Override
	public Emp showEmp(int id) {
		Emp emp=empDao.select(id);
		return emp;
	}

}
