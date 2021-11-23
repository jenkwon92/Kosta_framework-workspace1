package org.kosta.model.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Override
	public void deleteMember(String id) {
		System.out.println(getClass().getName()+" "+id+" deleteMember");
	}

	@Override
	public String findByName(String name) {
		System.out.println(getClass().getName()+" "+name+" findByName");
		return name+" 회원정보";
	}
	@Override
	public String findByAddress(String address) {
		System.out.println(getClass().getName()+" "+address+" findByAddress");
		return address+"회원리스트";		
	}

}
