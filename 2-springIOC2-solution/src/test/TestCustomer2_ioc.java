package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.TicketService;

public class TestCustomer2_ioc {
	public static void main(String[] args) {
		//기존 제어방식 : 필요한 컴포넌트를 생성해서 사용
		//AsianaTicketService service = new AsianaTicketService();
		//service.asianaTicketing();
		//만약 항공사를 변경해야 한다면
		//KalTicketService service = new KalTicketService();
		//service.kalTicketing();
		//위와 같이 객체 생성부 및 기능 호출부를 변경해야 한다
		//의존하는 컴포넌트를 변경하기 위해서는 사용하는 측의 코드 영역에 변화는 불가피하다

		//IOC 적용 -> 결합도를 느슨하게 한다
	    //1. 대상 컴포넌트들의 계층구조를 형성 : 인터페이스 TicketService 추상메서드 ticketing()
		//2.spring 설정(ioc.xml)을 통해 spring ioc container 에게 컴포넌트 bean 생성할 것을 명시
		
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("ioc.xml");
		//bean id를 이용한 검색을 통해 bean(or component or 의존성)을 확보 ->DL (Dependency Lookup)
		TicketService service = (TicketService)factory.getBean("ticket");
		service.ticketing();
		factory.close();
	}
}
