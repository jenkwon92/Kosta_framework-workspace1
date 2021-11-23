package org.kosta.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect // AOP 담당 객체임을 알리는 어노테이션
@Component //bean 생성을 위한 어노테이션
public class KeywordLoggingService {
	private Logger log = LogManager.getLogger(getClass());
	/*
	 * AOP Annotation 설정
	 * @Before : core 실행전에 적용되는 advice
	 * pointcut : public - 접근제어자, * - return type 모두 허용(void 포함), org.kosta.model.service. - 해당 패키지 하위 요소,
	 * 					*Service - Service로 마치는 인터페이스 또는 클래스, find* - find로 시작되는 메서드들, (..) - 매개변수 0~*
	 */
	@Before("execution(public * org.kosta.model.service.*Service.find*(..))")
	public void logging(JoinPoint point) {
		//core의 클래스명, 메서드명
		String cn = point.getTarget().getClass().getName(); //클래스명
		String mn = point.getSignature().getName(); //메서드명
		//core에서 전달받는 매개변수의 인자값들을 반환받는다
		Object params[] = point.getArgs();
		String keyword = ""; //검색어
		for(int i=0; i<params.length; i++) {
			keyword +=params[i]+" ";
		}
		log.info(cn+" "+mn+" "+keyword);
	}
}
	