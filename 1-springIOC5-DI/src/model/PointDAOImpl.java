package model;

import java.sql.SQLException;

import javax.sql.DataSource;

public class PointDAOImpl implements PointDAO {
	private DataSource dataSource;
	//dbcp를 DI 즉 
	public PointDAOImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	@Override
	public void register(String pointInfo) {
		try {
			System.out.println(pointInfo+ " 포인트 정보를 db에 등록 "+dataSource.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
