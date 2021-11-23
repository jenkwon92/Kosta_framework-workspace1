package org.kosta.model;

import org.springframework.stereotype.Repository;
//영속성 계층의 bean 생성시 사용하는 어노테이션 , 
//spring container는 소문자로 시작하는 클래스명을 bean id로 저장
//@Repository

//기본적으로 생성되는 아이디가 아닌 다른 bean id로 설정하고자 할때는
//아래와 같이 하면 된다
//@Repository("memberDAO")

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Override
	public void register(String memberInfo) {
		System.out.println(getClass().getName()+" register "+memberInfo);
	}
}
