package service;

import java.util.List;

import bean.Active;
import bean.Page;
import dao.ActiveDao;
import dao.impl.ActiveDaoImpl;

public class ActiveServiceImpl implements ActiveService{
ActiveDao activeDao=new ActiveDaoImpl();
	@Override
	public List<Active> showAllActive() {
List<Active> activeList=null;
		
		List<Active> temp= activeDao.selectAll();
		if(temp!=null) {
			activeList=temp;
		}
		return activeList;
	}

	@Override
	public Active showActive(int id) {
		Active active=activeDao.select(id);
		return active;
	}

	@Override
	public int removeActive(int id) {
		int result=activeDao.delete(id);
		return result;
	}

	@Override
	public int modify(Active active) {
		int result= activeDao.update(active);
		return result;
	}

	@Override
	public List<Active> showAllActive(Page page) {
		List<Active> actives=activeDao.selectAll(page);
		int count=(int) activeDao.selectCount();
		page.setTotalCounts(count);
		return actives;
	}

	@Override
	public int add(Active active) {
		int result= activeDao.insert(active);
		return result;
	}

}
