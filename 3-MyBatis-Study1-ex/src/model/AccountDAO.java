package model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import factory.SqlSessionFactoryBean;

public class AccountDAO {
	private static AccountDAO instance = new AccountDAO();
	private SqlSessionFactory factory;

	private AccountDAO() {
		factory = SqlSessionFactoryBean.getInstance().getObject();
	}

	public static AccountDAO getInstance() {
		return instance;
	}

	public AccountVO findAccountById(String id) {
		AccountVO vo = null;
		SqlSession session = null;
		try {
			session = factory.openSession(); // session을 받아옴
			// selectOne 1.매개변수 mapper sql id, 2. 매개변수 검색조건
			vo = session.selectOne("account.findAccountById", id); // 첫번째는 xml의 sql 아이디, 두번째는 검색 조건
		} finally {
			session.close();
		}
		return vo;
	}

	public void registerAccount(AccountVO vo) {
		SqlSession session = null;
		try {
			// default ->autocommit false
			// autocommit 설정 openSession(true)
			session = factory.openSession();
			// vo는 db에 insert 정보(pstmt.setXXX(1,id)....)
			session.insert("account.registerAccount", vo);
			session.commit(); // 수동커밋모드가 기본이므로 명시적으로 commit
		} finally {
			// 커밋되지 않으면 자동 롤백이 된다
			session.close();
		}
	}

	public List<AccountVO> getAllAccountList() {
		List<AccountVO> list = null;
		SqlSession session = null;
		try {
			session = factory.openSession();
			list = session.selectList("account.getAllAccountList");
		} finally {
			session.close();
		}
		return list;
	}

}
