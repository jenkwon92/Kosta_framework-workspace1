package test;

import org.kosta.model.service.MemberService;
import org.kosta.model.service.ProductService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotationAOP {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("spring-config.xml");
		MemberService ms=(MemberService)ctx.getBean("memberServiceImpl");//소문자로 시작하는 클래스명이 bean id
		ms.deleteMember("java");
		System.out.println(ms.findByName("아이유"));
		System.out.println(ms.findByAddress("분당"));
		ProductService ps=(ProductService)ctx.getBean("productServiceImpl");
		ps.register("오뚜기 진라면");
		System.out.println(ps.findById("1"));
		System.out.println(ps.findByMaker("오뚜기"));
		ctx.close();
		// spring-config.xml 작성 , annotation ioc, di 적용 , dl 할때 getBean() 코드추가 
		/* Annotation AOP 적용해보기 
		 * 비즈니스 계층 ( *Service ) 의 find로 시작되는 메서드에 한해 
		 * 실행시간과 클래스명,메서드명, 검색어(매개변수로 전달되는 데이터)를
		 * report.log 파일에 로깅하는 요구사항이 있다 
		 * find 계열의 메서드가 시스템 내에 여러 개가 있으므로 
		 * 횡단관심사항이 되고 이를 AOP로 설계 구현하면 효율적인 개발이 된다 
		 * 
		 * AOP 적용단계 
		 * 1. 횡단관심사항로직 클래스 정의 : org.kosta.aop.KeywordLoggingService 
		 * 2. log4j 설정파일에서 로깅 설정 
		 * 3. 스프링 설정 파일 spring-config.xml 에 Annotation 기반 AOP 설정  
		 */
	}
}











