package org.kosta.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {
	private SqlSessionTemplate template;

	@Autowired
	public AccountDAOImpl(SqlSessionTemplate template) {
		super();
		this.template = template;
	}
	
	@Override
	public AccountVO findAccountById(String id) {
		return template.selectOne("account.findAccountById",id);
	}

	@Override
	public List<AccountVO> getAllAccountList() {
		return template.selectList("account.getAllAccountList");
	}

	@Override
	public void registerAccount(AccountVO accountVO) {
		template.insert("account.registerAccount",accountVO);
		
	}
	
	
}
