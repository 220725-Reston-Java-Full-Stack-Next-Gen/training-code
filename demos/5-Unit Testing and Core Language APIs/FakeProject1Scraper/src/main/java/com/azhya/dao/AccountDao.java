package com.azhya.dao;

import com.azhya.models.Account;

public interface AccountDao {

	public int insertAccount(Account account, int userId);
}
