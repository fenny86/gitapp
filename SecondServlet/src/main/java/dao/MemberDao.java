package dao;

import bean.MemberBean;

public interface MemberDao {
	public MemberBean login(String username,String password);

}
