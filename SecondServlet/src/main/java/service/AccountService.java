package service;


import java.util.List;

import bean.Account;

public interface AccountService {
	public List<Account> showAllAccount();
	
	public Account showAccount(int id);
	
	public int removeAccount(int id);
	
	public int modify(Account account);
	
	public int add(Account account);



}
