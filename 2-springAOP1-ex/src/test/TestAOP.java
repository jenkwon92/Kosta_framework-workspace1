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
	 * ---> AOP 를 적용 (2-springAOP1-solution 에서 확인)
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		MemberService ms = (MemberService)ctx.getBean("memberService");
		ProductService ps = (ProductService)ctx.getBean("productService");
		ms.register("java 아이유 오리");  //java 아이유 오리회원정보등록
		System.out.println(ms.findMemberById("spring")); //java 아이유 오리회원정보등록 spring 아이디에 대한 회원정보
		ps.deleteProductByNo(1); //1 상품번호 상품 정보 삭제
		System.out.println(ps.findProductByNo(11)); //**시스템 횡단 관심사(공통기능)** 11 상품번호 상품정보
		System.out.println(ps.findProductListByMaker("LG")); //시스템횡단 관심사 [카스, 테라, 참이슬]
		ctx.close();
	}
}
