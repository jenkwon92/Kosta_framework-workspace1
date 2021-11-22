package model;

public class MemberDAOImpl implements MemberDAO {
	@Override
	public String findMemberById(String id) {
	if(id.equals("java"))
		return "java 아이유 오리 version2 검색기능향상";
	else
		return null;
	}
}
