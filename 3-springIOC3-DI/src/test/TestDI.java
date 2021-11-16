package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.MemberService;

public class TestDI {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("spring-config.xml");
		MemberService memberService = (MemberService) factory.getBean("memberService"); //DL(Dependency Lookup)
		System.out.println(memberService.findMemberById("java"));
		factory.close();
	}
}
