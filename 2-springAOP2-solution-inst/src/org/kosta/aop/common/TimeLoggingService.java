package org.kosta.aop.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;

/*
 * Cross Cutting Concern : 공통 횡단 관심사항을 정의한 클래스 
 */
public class TimeLoggingService {
	private Logger logger=LogManager.getLogger(getClass());
	//실제 타겟( core ) 정보를 확인하기 위해 매개변수로 JoinPoint 를 명시한다 
	public void logging(JoinPoint point) {
		//System.out.println("*AOP*");
		//실제 타겟 Core 클래스명과 메서드명을 반환 
		String className=point.getTarget().getClass().getName();
		String methodName=point.getSignature().getName();
		//실제 타겟 코어의 클래스명과 메서드명을 로깅  
		logger.info("*AOP 적용 *"+className+" "+methodName);
	}
}


