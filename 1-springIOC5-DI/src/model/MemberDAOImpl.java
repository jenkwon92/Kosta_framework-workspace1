package model;

import java.sql.SQLException;

import javax.sql.DataSource;

public class MemberDAOImpl implements MemberDAO{
	private DataSource dataSource;
	
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
