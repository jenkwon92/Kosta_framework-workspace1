package model;
/*
 * Service : 비즈니스(서비스) 계층의 컴포넌트 
 * 			   트랜잭션 처리를 위한 컴포넌트 
 */
public class MemberServiceImpl implements MemberService {
	//느슨한 결합도를 위해 인터페이스 타입으로 참조 
	private MemberDAO memberDAO;
	//스프링 IOC(	or DI ) Container에서 memberDAO 구현체를 주입 -> Dependency Injection , DI 
	public MemberServiceImpl(MemberDAO memberDAO) {
		super();
		this.memberDAO = memberDAO;
	}
	@Override
	public String findMemberById(String id) {
		return memberDAO.findMemberById(id);
	}
}





