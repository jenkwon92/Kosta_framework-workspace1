package test;

import model.KalTicketService;

public class TestCustomer {
	public static void main(String[] args) {
		//AsianaTicketService service = new AsianaTicketService();
		//service.asianaTicketing();
		//만약 항공사를 변경해야 한다면
		KalTicketService service = new KalTicketService();
		service.kalTicketing();
		//위와 같이 객체 생성부 및 기능 호출부를 변경해야 한다
		//의존하는 컴포넌트를 변경하기 위해서는 사용하는 측의 코드 영역에 변화는 불가피하다
	}
}
