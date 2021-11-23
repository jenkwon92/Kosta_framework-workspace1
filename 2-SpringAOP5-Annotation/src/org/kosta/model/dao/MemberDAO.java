package org.kosta.model.dao;

public interface MemberDAO {
	public void deleteMember(String id);
	public String findByName(String name);
	public String findByAddress(String address);
}
