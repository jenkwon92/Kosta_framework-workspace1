package org.kosta.model.vo;

public class DirectorVO {
	private int directorId;//컬럼명은 director_id , spring-mybatis 설정에 의해 자동 매핑 
	private String directorName;// db의 underscore와 application의 camelcase가 자동 매핑
	private String intro;
	public DirectorVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DirectorVO(String directorName, String intro) {
		super();
		this.directorName = directorName;
		this.intro = intro;
	}
	public DirectorVO(int directorId, String directorName, String intro) {
		super();
		this.directorId = directorId;
		this.directorName = directorName;
		this.intro = intro;
	}
	public int getDirectorId() {
		return directorId;
	}
	public void setDirectorId(int directorId) {
		this.directorId = directorId;
	}
	public String getDirectorName() {
		return directorName;
	}
	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	@Override
	public String toString() {
		return "DirectorVO [directorId=" + directorId + ", directorName=" + directorName + ", intro=" + intro + "]";
	}
	
}
