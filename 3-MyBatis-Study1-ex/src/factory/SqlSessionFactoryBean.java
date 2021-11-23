package factory;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * MyBatis 설정 정보(SqlSessionConfig.xml->mapper 계열xml)
 * 를 로딩하는 객체 
 * @author kosta-inst
 *
 */
public class SqlSessionFactoryBean {
	private static SqlSessionFactoryBean instance	
										=new SqlSessionFactoryBean();
	private SqlSessionFactory factory;
	private SqlSessionFactoryBean(){
		String config="mybatis/config/SqlSessionConfig.xml";
		try {
			Reader r=Resources.getResourceAsReader(config);
			factory=new SqlSessionFactoryBuilder().build(r);
			System.out.println("mybatis config loading.."+factory);
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	public static SqlSessionFactoryBean getInstance(){
		return instance;
	}
	public SqlSessionFactory getObject() {
		return factory;
	}
	public static void main(String[] args) {
		System.out.println(SqlSessionFactoryBean.getInstance().getObject());
	}
}










