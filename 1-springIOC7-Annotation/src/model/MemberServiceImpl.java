package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Service : 비즈니스 계층, 비즈니스 로직을 정의, 트랜잭션 처리
 *
 */
@Service
public class MemberServiceImpl implements MemberService {
	private MemberDAO memberDAO;
	private PointDAO pointDAO;
	//생성자를 통한 DI
	@Autowired
	public MemberServiceImpl(MemberDAO memberDAO, PointDAO pointDAO) {
		super();
		this.memberDAO = memberDAO;
		this.pointDAO = pointDAO;
	}

	@Override
	public void registerMemberAndPoint(String memberInfo, String pointInfo) {
		//트랜잭션 처리를 이후 공부 예정
		memberDAO.register(memberInfo);
		pointDAO.register(pointInfo);
	}

}
