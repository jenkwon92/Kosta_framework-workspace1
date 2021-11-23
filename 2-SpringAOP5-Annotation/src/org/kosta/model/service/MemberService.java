package org.kosta.model.service;

public interface MemberService {
	public void deleteMember(String id);
	public String findByName(String name);
	public String findByAddress(String address);
}
