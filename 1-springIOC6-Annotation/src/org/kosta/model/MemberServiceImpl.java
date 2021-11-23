package org.kosta.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//비즈니스 계층에 명시하는 컴포넌트 계열 어노테이션 ,Spring Container에 의해 소문자로 시작하는 클래스명을 id로 하는 bean 생성됨
@Service
public class MemberServiceImpl implements MemberService {
	//Dependency Injection : 필드(or 인스턴스변수)를 통한 의존성 주입
	//@Autowired 는 스프링 컨테이너에 생성된 bean 중에 일치되는 타입의 bean 을 주입
	@Autowired
	private MemberDAO memberDAO;
	
	//Dependency Injection : 생성자를 통한 의존성 주입
	//@Autowired 는 스프링 컨테이너에 생성된 bean 중에 일치되는 타입의 bean 을 주입
	/*
	@Autowired
	public MemberServiceImpl(MemberDAO memberDAO) {
		super();
		this.memberDAO = memberDAO;
		System.out.println("DI: "+memberDAO);
	}
	 */
	
	@Override
	public void register(String memberInfo) {
		//System.out.println(getClass().getName()+" register");
		memberDAO.register(memberInfo);
	}
}
