package org.kosta.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

/*
 * Cross Cutting Concern (시스템의 여러 메서드의 실행 소요시간을 체크 )을 정의한 클래스
 */
public class PerformanceReportService {
	private Logger log = LogManager.getLogger(getClass());
	public Object timeLogging(ProceedingJoinPoint point) throws Throwable{
		Object retValue=null;
		StopWatch watch = new StopWatch();
		watch.start();
		try {
			retValue=point.proceed(); //실제 Core를 실행
			PerformanceReportService service = new PerformanceReportService();
		}finally {
			watch.stop();
			long time = watch.getTotalTimeMillis();
			if(time>=500 &&time<1000) {
				String className =point.getTarget().getClass().getName();
				String methodName = point.getSignature().getName();
				log.warn(className+" "+methodName+" "+time);
			}else if(time>=1000) {
				String className =point.getTarget().getClass().getName();
				String methodName = point.getSignature().getName();
				log.error(className+" "+methodName+" "+time);
			}
			
		}
		return retValue;
	}
}
