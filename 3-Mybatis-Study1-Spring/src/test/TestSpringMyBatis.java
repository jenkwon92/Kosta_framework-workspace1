package test;

import java.util.Map;

import org.kosta.model.MemberDAO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringMyBatis {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mybatis-config.xml");
		/*
		AccountDAO dao = (AccountDAO) ctx.getBean("accountDAOImpl");
		String id="11";
		System.out.println(dao.findAccountById(id));
		//dao.registerAccount(new AccountVO("3","손흥민",2000));
		List<AccountVO> list = dao.getAllAccountList();
		for(AccountVO vo:list)
			System.out.println(vo);
		*/
		MemberDAO memberDAO = (MemberDAO)ctx.getBean("memberDAOImpl");
		//1. 아이디로 회원검색
		/*
		String id="java";
		System.out.println("id로 검색"+memberDAO.findMemberById(id));
		*/
		//2. 회원가입
		/*
		MemberVO paramVO = new MemberVO("mybatis","a","손흥민","오리");
		if(memberDAO.findMemberById(paramVO.getId())==null) {
			memberDAO.register(paramVO);
			System.out.println(paramVO+"회원 등록완료");
		}else {
			System.out.println("아이디가 중복되어 회원 등록할 수 없습니다");
		}
		*/
		//3. 주소로 회원리스트 조회
		/*
		String address="오리";
		List<MemberVO> list = memberDAO.findMemberListByAddress(address);
		for(MemberVO vo:list){
			System.out.println(vo);
		}
		*/
		//4.이름과 주소로 회원리스트 조회 (검색어가 여러개일 경우)
		//전달해야 할 정보(이름, 주소) 가 여러개일 경우에는
		//Object (VO or DTO) 또는 Map으로 전달가능
		/*
		MemberVO vo =new MemberVO(null,null,"아이유","오리");
		List<MemberVO> list = memberDAO.findMemberListByNameAndAddress(vo);
		for(MemberVO mvo:list)
			System.out.println(mvo);
		*/
		//5.회원정보수정
		/*
		System.out.println("수정전 : "+memberDAO.findMemberById("spring"));
		MemberVO vo = new MemberVO("spring","b","이강인","판교");
		memberDAO.updateMember(vo);
		System.out.println("수정후 : "+memberDAO.findMemberById("spring"));
		*/
		//6. 회원정보삭제
		/*
		System.out.println("삭제전: "+memberDAO.findMemberById("spring"));
		//template.delete()를 이용
		String id = "spring";
		memberDAO.deleteMemberById(id);
		System.out.println("삭제후: "+memberDAO.findMemberById("spring"));
		*/
		//7. 회원아이디로 조회환 회원정보를 Map으로 반환
		String id="java";
		Map<String,String> map = memberDAO.findMemberMapById(id);
		System.out.println(map);
		ctx.close();
	}
}
