package test;

import org.kosta.model.board.BoardService;
import org.kosta.model.member.DuplicateIdException;
import org.kosta.model.member.MemberService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPerformanceCheck {
	/*
	  요구 사항
	  기존 회원 및 게시판 서비스 제공하는 시스템의 성능을 체크
	  
	  서비를 제공하는 각 메서드의 실행 소요시간을 레별별로 체크해서 리포트를 제공해야 한다
	  
	  리포트는 0.5초 이상 1초 미만 소요시에는 log.warn (core cross name과 method name, 실행 소요시간)
	  1초 초과시에는 log.error ( core class name과 method name 실행 소요시간)
	  로 report.log 파일에 로깅하도록 한다
	  위와 같은 로그는 예외 발생 여부와 관계없이 모두 로깅되어야 한다
	  
	  개발단계
	  1. 로그  : Log4j -> 단위테스트
	  2. 소요시간체크 : Spring Framework에서 제공하는 StopWatch util class를 이용 -> 단위 테스트 test.TestStopWatch
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext factory=new ClassPathXmlApplicationContext("spring-config.xml");
		BoardService bs=(BoardService)factory.getBean("boardService");
		MemberService ms=(MemberService)factory.getBean("memberService");
		System.out.println("main:"+bs.find());
		System.out.println("main:"+bs.findAllList());
		ms.findMember();
		ms.findAllMember();
		try {
			ms.register("java", "아이유");
		} catch (DuplicateIdException e) {
			System.out.println("main:"+e.getMessage());
		}
		factory.close();
	}
}




