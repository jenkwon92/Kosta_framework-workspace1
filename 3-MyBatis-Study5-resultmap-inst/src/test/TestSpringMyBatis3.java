package test;

import java.util.List;

import org.kosta.model.mapper.MovieMapper;
import org.kosta.model.vo.MovieVO;
import org.springframework.context.support.ClassPathXmlApplicationContext;
// Movie table의 영화와 감독정보를 join해서 조회 
// MovieVO has a DirectorVO 를 MyBatis 로 처리하는 예제 ( MyBatis resultmap 을 이용 ) 
// 영화리스트 조회 ( 영화제목과 감독명 리스트를 조회 )
public class TestSpringMyBatis3 {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("spring-mybatis-config.xml");
		MovieMapper mapper=(MovieMapper)ctx.getBean("movieMapper");
		//영화 타이틀과 감독명을 join 해서 리스트를 조회 
		List<MovieVO> list=mapper.getAllMovieList();
		for(MovieVO vo:list)
			System.out.println(vo.getTitle()+" "+vo.getDirectorVO().getDirectorName());
		ctx.close();
	}
}








