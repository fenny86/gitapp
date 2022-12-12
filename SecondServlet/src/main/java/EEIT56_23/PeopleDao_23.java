package EEIT56_23;

import java.util.List;

public interface PeopleDao_23 {
	public List< PeopleBean_23> selectAll();
	
	public  PeopleBean_23 selectById(int id);
	
	public int delete(int id); 
    
    public int update( PeopleBean_23 bean); 
    
    void save(PeopleBean_23 bean);//insert
    
    public void saveNoIncome(PeopleBean_23 bean);
    
    void saveTest(PeopleBean_23 bean);//insert
    
    PeopleBean_23 selectAge(int id);

	PeopleBean_23 findImageById(int Id);
    
	public List<PeopleBean_23> selectByIdOrName(int id,String name);

}
