package model;

public interface MemberService {
	String findMemberById(String id);
	void register(String memberInfo);
}
