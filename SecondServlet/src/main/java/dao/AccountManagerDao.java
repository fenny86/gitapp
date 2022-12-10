package dao;

import bean.AccountManager;

public interface AccountManagerDao {
	public AccountManager select(String username);

}
