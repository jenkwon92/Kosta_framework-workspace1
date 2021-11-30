package org.kosta.model.test;

import org.kosta.model.mapper.MovieMapper;
import org.kosta.model.vo.DirectorVO;
import org.kosta.model.vo.MovieVO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//Movie table에 영화정보를 등록, 영화와 감독정보를 join해서 조회
//MovieVO has a DirectorVO를 MyBatis 로 처리하는 예제 (MyBatis resultmap을 이용)
//영화 상세 정보를 조회 (영화 아이디에 해당하는 영화의 모든 속성과 감독의 모든 속성이 조회)
public class TestSpringMyBatis4 {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mybatis-config.xml");
		MovieMapper mapper = (MovieMapper) ctx.getBean("movieMapper");
		//영화 상세 정보를 조회 (영화 아이디에 해당하는 영화의 모든 속성과 감독의 모든 속성이 조회)
		MovieVO vo = mapper.findMovieAndDirectorVOById(1);
		if(vo!=null) {
		System.out.println(vo.getMovieId());
		System.out.println(vo.getTitle());
		System.out.println(vo.getGenre());
		System.out.println(vo.getAttendance());
		System.out.println(vo.getDirectorVO().getDirectorId());
		System.out.println(vo.getDirectorVO().getDirectorName());
		System.out.println(vo.getDirectorVO().getIntro());
		}else {
			System.out.println("조회된 정보가 없습니다");
		}
		ctx.close();
	}
}
