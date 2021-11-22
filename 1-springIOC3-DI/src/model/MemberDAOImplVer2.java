package model;

public class MemberDAOImplVer2 implements MemberDAO {
	@Override
	public String findMemberById(String id) {
		if(id.equals("java"))
			return "java 아이유 오리  ver2 검색기능향상";
		else
			return null;
	}
}
