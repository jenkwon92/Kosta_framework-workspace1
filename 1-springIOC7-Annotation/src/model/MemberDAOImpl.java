package model;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository  //컴포넌트 계열
public class MemberDAOImpl implements MemberDAO{
	private DataSource dataSource;
	
	//생성자 여러개일때는 자동주입이 안되므로, 써보는 연습을 하자
	//한개만있을때는 자동주입이 가능하므로 생략가능
	@Autowired
	public MemberDAOImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public void register(String memeberInfo) {
		try {
			System.out.println(memeberInfo+ " 회원정보를 db에 등록 "+dataSource.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
