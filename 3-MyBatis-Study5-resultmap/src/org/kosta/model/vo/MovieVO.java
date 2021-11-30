package org.kosta.model.vo;

public class MovieVO {
	private int movieId; //column name: movie_id 자동매핑
	private String title;
	private String genre;
	private int attendance;
	//aggregatrion , has a relationship
	private DirectorVO directorVO;
	public MovieVO() {
		super();
	}
	
	public MovieVO(String title, String genre, int attendance, DirectorVO directorVO) {
		super();
		this.title = title;
		this.genre = genre;
		this.attendance = attendance;
		this.directorVO = directorVO;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getAttendance() {
		return attendance;
	}

	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}

	public DirectorVO getDirectorVO() {
		return directorVO;
	}

	public void setDirectorVO(DirectorVO directorVO) {
		this.directorVO = directorVO;
	}

	@Override
	public String toString() {
		return "MovieVO [movieId=" + movieId + ", title=" + title + ", genre=" + genre + ", attendance=" + attendance
				+ ", directorVO=" + directorVO + "]";
	}
	
}
