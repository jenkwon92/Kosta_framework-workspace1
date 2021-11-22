package model;

public class MemberDAOImpl implements MemberDAO {
	@Override
	public String findMemberById(String id) {
		if(id.equals("java"))
			return "java 아이유 오리";
		else
			return null;
	}
}
