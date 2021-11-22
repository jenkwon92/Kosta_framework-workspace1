package org.kosta.model.member;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MemberServiceImpl implements MemberService {
	private Logger logger = LogManager.getLogger(getClass());
	@Override
	public void findMemberById() {	
		System.out.println("아이디로 회원검색");
		logger.info("findMemberById");
	}
	@Override
	public void registerMember() {
		System.out.println("회원가입");
	}
	@Override
	public void findMemberListByAddress() {		
		System.out.println("주소로 회원리스트검색");
		logger.info("findMemberListByAddress");
	}
}
