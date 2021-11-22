package model;

public class MemberServiceImpl implements MemberService{
	@Override
	public String findMemberById(String id) {
		//아래 공통 or 횡단관심사 로직은 AOP로 처리
		//System.out.println("**시스템 횡단 괌심사(공통기능)**");
		return id+"아이디에 대한 회원정보";
	}
	
	@Override
	public void register(String memberInfo) {
		System.out.println(memberInfo+"회원정보등록");
	}
}
