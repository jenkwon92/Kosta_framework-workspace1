package org.kosta.model.test;

import java.util.List;

import org.kosta.model.mapper.MovieMapper;
import org.kosta.model.vo.DirectorVO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringMyBatis {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mybatis-config.xml");
		MovieMapper mapper= (MovieMapper)ctx.getBean("movieMapper"); //DL
		//DirectorVO dvo = new DirectorVO("봉준호","아카데미 수상");
		DirectorVO dvo = new DirectorVO("고레에다","칸 수상");
		mapper.registerDirector(dvo);
		System.out.println(dvo+"감독 등록완료");
		List<DirectorVO> list = mapper.getAllDirectorList();
		for(DirectorVO vo: list)
			System.out.println(vo);
		ctx.close();
	}
}
