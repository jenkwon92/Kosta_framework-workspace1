package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.MemberService;
import model.ProductService;

public class TestAOP {
	/**
	 * 현 시스템 내의 회원 서비스와 상품 서비스의 검색 계열 (find*) 메서드에만
	 * 별도의 공통기능을 적용
	 * -> 이를 위해 서비스 내의 검색 계열의 모든 메서드에 직접 로직을 삽입
	 * 		-> 반복적인 개발 작업이 불가피, 이후 공통 로직 변경시 다시 여러 부분을 작업
	 * 
	 * ---> AOP 를 적용 (2-springAOP1-solution)
	 * 
	 * 1. Maven pom.xml에 aop 라이브러리 (aspectjweaver)
	 * 2. 공통관심사 (횡단관심사 cross cutting concern) 로직을 정의: aop.common.LoggingService
	 * 3. AOP  설정(xml or annotation) 을 적용해서 Core Concern 에 Cross Cutting Concern을 적용 (weaving)
	 * @param args
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		MemberService ms = (MemberService)ctx.getBean("memberService");
		ProductService ps = (ProductService)ctx.getBean("productService");
		ms.register("java 아이유 오리");
		System.out.println(ms.findMemberById("spring"));
		ps.deleteProductByNo(1);
		System.out.println(ps.findProductByNo(11));
		System.out.println(ps.findProductListByMaker("LG"));
		ctx.close();
	}
}
