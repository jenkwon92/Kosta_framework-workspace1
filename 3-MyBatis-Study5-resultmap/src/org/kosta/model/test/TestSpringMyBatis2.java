package org.kosta.model.test;

import org.kosta.model.mapper.MovieMapper;
import org.kosta.model.vo.DirectorVO;
import org.kosta.model.vo.MovieVO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//Movie table에 영화정보를 등록, 영화와 감독정보를 join해서 조회
//MovieVO has a DirectorVO를 MyBatis 로 처리하는 예제 (MyBatis resultmap을 이용)
public class TestSpringMyBatis2 {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mybatis-config.xml");
		MovieMapper mapper = (MovieMapper) ctx.getBean("movieMapper");

		// 영화 정보를 등록
		DirectorVO dvo = new DirectorVO();
		dvo.setDirectorId(1); // 감독 아이디를 할당
		MovieVO movie = new MovieVO();
		movie.setTitle("기생충");
		movie.setGenre("코미디");
		movie.setAttendance(1000);
		movie.setDirectorVO(dvo);
		mapper.registerMovie(movie);
		System.out.println(dvo + "등록완료");
		ctx.close();
	}
}
