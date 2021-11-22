package aop.common;
//시스템의 공통 or 횡단관심사를 정의한 클래스
public class LoggingService {
	public void findLogging() {
		System.out.println("**시스템 횡단 관심사(공통기능)**AOP");
	}
}
