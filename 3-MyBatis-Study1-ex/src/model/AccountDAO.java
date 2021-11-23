package model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import factory.SqlSessionFactoryBean;

public class AccountDAO {
	private static AccountDAO instance=new AccountDAO();
	private SqlSessionFactory factory;
	private AccountDAO() {
		factory=SqlSessionFactoryBean.getInstance().getObject();
	}
	public static AccountDAO getInstance(){
		return instance;
	}
	public AccountVO findAccountById(String id) {
		AccountVO vo = null;
		SqlSession session = null;
		try {
			session = factory.openSession(); //session을 받아옴
			//selectOne 1.매개변수 mapper sql id, 2. 매개변수 검색조건
			vo = session.selectOne("account.findAccountById",id); //첫번째는 xml의 sql 아이디, 두번째는 검색 조건 
		}finally {
			session.close();
		}
		return vo;
	}
}

















