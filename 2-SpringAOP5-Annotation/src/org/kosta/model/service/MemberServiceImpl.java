package org.kosta.model.service;

import org.kosta.model.dao.MemberDAO;

public class MemberServiceImpl implements MemberService {
	
	private MemberDAO memberDAO;
	
	public MemberServiceImpl(MemberDAO memberDAO) {
		super();
		this.memberDAO = memberDAO;
	}
	@Override
	public void deleteMember(String id) {
		memberDAO.deleteMember(id);
	}
	@Override
	public String findByName(String name) {
		return memberDAO.findByName(name);
	}
	@Override
	public String findByAddress(String address) {
		return memberDAO.findByAddress(address);
	}

}
