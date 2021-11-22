package model;

public class MemberServiceImpl implements MemberService{

	@Override
	public void register(String memberInfo) {
		System.out.println(memberInfo+"회원정보등록");
		
	}

	@Override
	public String findMemberById(String id) {
		System.out.println("**시스템 횡단 괌심사(공통기능)**");
		return id+"아이디에 대한 회원정보";
	}
	
}
