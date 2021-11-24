package org.kosta.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
//@Mapper 어노테이션을 명시하면 프레임워크에서 구현체(Proxy : DAOImpl)를 자동 생성한다
@Mapper
public interface AccountDAO {

	AccountVO findAccountById(String id);
	List<AccountVO> getAllAccountList();
	void registerAccount(AccountVO accountVO);
}