package org.kosta.aop.common;
/*
 * Cross Cutting Concern : 공통 횡단 관심사항을 정의한 클래스
 */
public class TimeLoggingService {
	public void logging() {
		System.out.println("*AOP*");
	}
}
