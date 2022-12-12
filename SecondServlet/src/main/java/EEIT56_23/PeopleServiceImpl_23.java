package EEIT56_23;

import java.util.List;

public class PeopleServiceImpl_23 implements PeopleService_23 {

	PeopleDao_23 peopleDao = new PeopleDaoImpl_23();

	@Override
	public List<PeopleBean_23> showAll() {
		List<PeopleBean_23> list = null;

		List<PeopleBean_23> tlist = peopleDao.selectAll();
		if (tlist != null) {
			list = tlist;
		}
		return list;
	}

	@Override
	public PeopleBean_23 showById(int id) {
		PeopleBean_23 bean = peopleDao.selectById(id);
		return bean;
	}

	@Override
	public int removeById(int id) {
		int result = peopleDao.delete(id);
		return result;
	}

	@Override
	public int modify(PeopleBean_23 bean) {
		System.out.println(22222222);
		int result = peopleDao.update(bean);
		return result;
	}

	@Override
	public void saveData(PeopleBean_23 bean) {
		peopleDao.save(bean);
	}
	
	 public void saveNoIncome(PeopleBean_23 bean) {
		 peopleDao.saveNoIncome(bean);
	 }

	public void saveTest(PeopleBean_23 bean) {
		peopleDao.saveTest(bean);
	}

	public PeopleBean_23 selectAge(int id) {
		return peopleDao.selectAge(id);
	}
	
	public PeopleBean_23 findImageById(int Id) {
		return peopleDao.findImageById(Id);
	}
	
	public List<PeopleBean_23> selectByIdOrName(int id,String name) {
		List<PeopleBean_23> list = null;

		List<PeopleBean_23> tlist =peopleDao.selectByIdOrName(id,name);
		if (tlist != null) {
			list = tlist;
		}
		return list;
//		return peopleDao.selectByIdOrName(id,name);
	}

}
