package org.kosta.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper //현 인터페이스를 implements 하는 Proxy  구현체를 생성하기 위한 어노테이션(어너테이션)
public interface HumanResourceMapper {

	List<Map<String, Object>> getAllDepartmentList();

	Map<String, String> findEmployeeAndDeptByEmpNo(int empno);

	List<Map<String, Object>> findEmployeeAndDeptListOuterJoin();

	List<Map<String, Object>> getEmpGroupByDeptno();

	List<Map<String, Object>> getEmpGroupByDeptnoOuterJoin();

}
