package impl;


import bean.MemberBean;
import dao.MemberDao;
import dao.MemberServiceDao;

public class MemberDaoImpl implements MemberDao {
	
	MemberServiceDao memberServiceDao=new MemberServiceDaoImpl();

	@Override
	public MemberBean login(String username, String password) {
		
		MemberBean member= null;
		
		MemberBean memberBean= memberServiceDao.select(username);
		if(memberBean!=null) {
			
			if(memberBean.getMemberPassword().equals(password)) {
				member=memberBean;
			}
		}
		return member;
	}
	
	}


