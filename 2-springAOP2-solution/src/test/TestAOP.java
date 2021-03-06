package test;

import org.kosta.community.NoticeCommunityService;
import org.kosta.model.member.MemberService;
import org.kosta.model.product.ProductService;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestAOP {
	/**
	 * 요구사항 
	 * 현재 시스템에서 서비스(회원관리,상품관리) 중인 팩키지 org.kosta.model 이하의 Service 계열의 하위 구현 클래스의 
	 * find 즉 검색 계열의 메서드들을 대상으로 어떤 서비스(메서드 실행)가 언제 실행되는 지를
	 * 특정 파일(report.log)에 시간정보와 실행 클래스 및 메서드 정보를 로깅하도록 한다 
	 * 
	 * - 1안)  각 core에 직접 시간정보 + 파일에 출력하는 IO 로직 구현 -> 생산성, 유지보수성이 낮다
	 * - 2안) Component or Library 를 이용해 각 core에서 import 해서 사용 -> 위의 첫번째 안보다 효율적
	 * 		Log4j Component 를 이용해 개발 -> 별도의 프로젝트에서 단위테스트 (2-springAOP2-ex2-log4j-test)
	 * 		적용단계 1. maven dependency (library) Log4j
	 * 					 2. log4j2.xml
	 * 					 3. core의 대상 메서드에 로깅 기능을 적용 (info level로 로깅)
	 * 
	 * 		횡단관심사(cross cutting concern) 인 로깅 작업을 log4j 컴포넌트를 이용해 
	 * 		각 core 에서는 import 후 logging 기능 코드 작업을 진행
	 * 		-> 1안에 비해 작업을 많이 줄였지만 여전히 반복적인 작업은 불가피하다
	 * 
	 * - 3안) AOP 를 적용하면 기존 CORE 에 변경없이 별도의 모듈에서 
	 * 			횡단관심사(cross cutting concern) 인 로깅 작업을 반영하게 할 수 있다
	 * 			-> 2-springAOP2-solution 에서 AOP 적용하여 효율적으로 개발하고 운영하도록 한다
	 * 
	 * 		실제 : Core Concern (회원, 상품 관리의 검색 계열 메서드)
	 * 				Cross Cutting Concern (검색 계열의 info level logging -> 실행 시간 서비스메서드명을 report.log 파일에 로깅)
	 * 
	 * 		구현단계
	 * 		1.Cross Cutting 공통 또는 횡단관심사의 로직을 정의하는 class
	 * 			org.kosta.aop.common.TimeLoggingService logging()
	 * 		2. spring aop 설정
	 * @param args
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext factory=new ClassPathXmlApplicationContext("spring-config.xml");
		MemberService ms=(MemberService)factory.getBean("memberService");
		ProductService ps=(ProductService)factory.getBean("productService");
		//AOP를 적용하지 않은 상태에서는 org.kosta.model.memeber.MemberServiceImpl가 출력
		//AOP를 적용한 상태에서는 com.sun.proxy.$Proxy2가 출력
		//AOP 적용시 객체는 실제 Core 타겟 객체(MemberServiceImpl)가아닌 Proxy(대리인) 객체가 스프링 컨테이너에 의해
		//반환되어 실행된다
		System.out.println(ms.getClass().getName());
		System.out.println(ps.getClass().getName());
		ms.findMemberById();
		ms.registerMember();
		ms.findMemberListByAddress();
		ps.deleteProduct();
		ps.findProductById();
		ps.findProductListByMaker();
		//신규 서비스 추가
		NoticeCommunityService ns = (NoticeCommunityService)factory.getBean("noticeCommunityService");
		ns.findNotice();
		ns.findNoticeList();
		factory.close();
	}
}











