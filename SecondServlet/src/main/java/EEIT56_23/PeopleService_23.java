package EEIT56_23;

import java.util.List;

public interface PeopleService_23 {
	
	public List< PeopleBean_23> showAll();
	
	public  PeopleBean_23 showById(int id);
	
	public int removeById(int id);
	
	public int modify(PeopleBean_23 bean);
	
	void saveData(PeopleBean_23 bean);
	
	 public void saveNoIncome(PeopleBean_23 bean);
	
	 void saveTest(PeopleBean_23 bean);

	 public PeopleBean_23 selectAge(int id);
	 
	 public PeopleBean_23 findImageById(int Id);
	 
	 public List<PeopleBean_23> selectByIdOrName(int id,String name);
	 
}
