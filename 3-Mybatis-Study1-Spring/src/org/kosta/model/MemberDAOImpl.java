package org.kosta.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
	private SqlSessionTemplate template;

	@Autowired
	public MemberDAOImpl(SqlSessionTemplate template){
		super();
		this.template = template;
	}

	@Override
	public MemberVO findMemberById(String id) {
		return template.selectOne("member.findMemberById",id);
	}

	@Override
	public void register(MemberVO paramVO) {
		template.insert("member.register",paramVO);		
	}

	@Override
	public List<MemberVO> findMemberListByAddress(String address) {
		return template.selectList("member.findMemberListByAddress",address);
	}

	@Override
	public List<MemberVO> findMemberListByNameAndAddress(MemberVO vo) {
		return template.selectList("member.findMemberListByNameAndAddress",vo);
	}
	
	@Override
	public void updateMember(MemberVO memberVO) {
		template.update("member.updateMember",memberVO);
	}

	@Override
	public void deleteMemberById(String id) {
		template.delete("member.deleteMemberById",id);
	}

	@Override
	public Map<String, String> findMemberMapById(String id) {
		return template.selectOne("member.findMemberMapById", id);
	}
}
