package model;

public class MemberServiceImpl implements MemberService {
	private MemberDAO memberDAO;
	private PointDAO pointDAO;
	//생성자를 통한 DI
	public MemberServiceImpl(MemberDAO memberDAO, PointDAO pointDAO) {
		super();
		this.memberDAO = memberDAO;
		this.pointDAO = pointDAO;
	}

	@Override
	public void registerMemberAndPoint(String memberInfo, String pointInfo) {
		//트랜잭션 처리를 이후 공부 예쩡
		memberDAO.register(memberInfo);
		pointDAO.register(pointInfo);
	}

}
