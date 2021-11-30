package org.kosta.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.model.vo.DirectorVO;
import org.kosta.model.vo.MovieVO;
//현 인터페이스를 구현하는 Proxy 객체를 생성하기 위해 아래 어노테이션을 명시한다 
@Mapper
public interface MovieMapper {
	public void registerDirector(DirectorVO directorVO);
	public List<DirectorVO> getAllDirectorList();
	public void registerMovie(MovieVO movie);
	public List<MovieVO> getAllMovieList();
	public MovieVO findMovieAndDirectorVOById(int i);
}
