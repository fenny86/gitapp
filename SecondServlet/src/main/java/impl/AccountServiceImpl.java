package impl;

import java.util.List;

import bean.Account;
import dao.AccountDao;
import service.AccountService;

public class AccountServiceImpl implements AccountService{
	AccountDao accountDao=new AccountDaoImpl();
	@Override
	public List<Account> showAllAccount() {
		List<Account> accountList=null;
		
		List<Account> temp= accountDao.selectAll();
		if(temp!=null) {
			accountList=temp;
		}
		return accountList;
	}
	@Override
	public int removeAccount(int id) {
		int result=accountDao.delete(id);
		return result;
		
	}
	@Override
	public int modify(Account account) {
		int result= accountDao.update(account);
		return result;
	}
	
	
	@Override
	public Account showAccount(int id) {
		Account account=accountDao.select(id);
		return account;
	}
	@Override
	public int add(Account account) {
		int result= accountDao.add(account);
		return result;
	}

}
