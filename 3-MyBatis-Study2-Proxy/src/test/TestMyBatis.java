package test;

import org.kosta.model.AccountDAO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMyBatis {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mybatis-config.xml");
		AccountDAO accountDAO  = (AccountDAO)ctx.getBean("accountDAO");
		System.out.println(accountDAO); //Proxy가 나옴 MapperProxy객체 - 프레임워트에서 생성하는 DAOImpl 구현체임
		System.out.println(accountDAO.findAccountById("1"));
		ctx.close();
	}

}
