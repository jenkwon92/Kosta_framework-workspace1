package org.kosta.model.member;

public class MemberServiceImpl implements MemberService {
	@Override
	public void findMemberById() {	
		System.out.println("아이디로 회원검색");
	}
	@Override
	public void registerMember() {
		System.out.println("회원가입");
	}
	@Override
	public void findMemberListByAddress() {		
		System.out.println("주소로 회원리스트검색");
	}
}
