package org.kosta.model;

import java.util.List;
import java.util.Map;

public interface MemberDAO {
	public MemberVO findMemberById(String id);

	public void register(MemberVO paramVO);

	public List<MemberVO> findMemberListByAddress(String address);

	public List<MemberVO> findMemberListByNameAndAddress(MemberVO vo);

	public void updateMember(MemberVO memberVO);

	public void deleteMemberById(String id);

	public Map<String,String> findMemberMapById(String id);

}