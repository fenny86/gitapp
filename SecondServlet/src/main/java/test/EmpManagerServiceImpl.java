package test;

public class EmpManagerServiceImpl implements EmpManagerService{
EmpManagerDao empDao=new EmpManagerDaoImpl();
	@Override
	public EmpManager login(String username, String password) {
		EmpManager empManager= null;
		EmpManager temp=empDao.select(username);
		if(temp!=null) {
			if(temp.getPassword().equals(password)) {
				empManager=temp;
			}
		}
		return empManager;
	}

}
