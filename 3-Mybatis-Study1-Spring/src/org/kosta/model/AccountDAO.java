package org.kosta.model;

import java.util.List;

public interface AccountDAO {

	AccountVO findAccountById(String id);
	List<AccountVO> getAllAccountList();
	void registerAccount(AccountVO accountVO);
}