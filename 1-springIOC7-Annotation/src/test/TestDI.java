package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.MemberService;

public class TestDI {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("spring-config.xml");
		MemberService ms = (MemberService)factory.getBean("memberServiceImpl"); //DL
		ms.registerMemberAndPoint("아이유 오리","cgv 10000");
		//dbcp test
		System.out.println(factory.getBean("dbcp"));
		factory.close();
	}
}
