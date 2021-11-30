package test;

import org.kosta.model.mapper.MovieMapper;
import org.kosta.model.vo.DirectorVO;
import org.kosta.model.vo.MovieVO;
import org.springframework.context.support.ClassPathXmlApplicationContext;
// Movie table에 영화정보를 등록하는 예제(영화 정보등록시 감독아이디도 함께 등록)
// MovieVO has a DirectorVO 를 MyBatis 로 처리하는 예제  
public class TestSpringMyBatis2 {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("spring-mybatis-config.xml");
		MovieMapper mapper=(MovieMapper)ctx.getBean("movieMapper");
		//영화 정보를 등록 
		DirectorVO dvo=new DirectorVO();
		dvo.setDirectorId(1);//감독아이디를 할당 
		MovieVO movie=new MovieVO();
		movie.setTitle("괴물");
		movie.setGenre("SF");
		movie.setAttendance(2000);
		movie.setDirectorVO(dvo);
		mapper.registerMovie(movie);
		System.out.println(movie+" 등록완료");
		ctx.close();
	}
}








