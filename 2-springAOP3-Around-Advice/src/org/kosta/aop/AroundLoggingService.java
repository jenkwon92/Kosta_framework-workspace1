package org.kosta.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.kosta.model.InventoryException;

public class AroundLoggingService {
	// ProceedingJoinPoint : Around Advice 적용시 사용하는 객체 , 실제[ target을 실행]하는
	// [proceed() 메서드]를 가지고 있다
	public Object aroundLogging(ProceedingJoinPoint point) throws Throwable {
		// 실제 core target 에서 전달받는 매개변수의 데이터를 확인한다
		Object params[] = point.getArgs();
		for (int i = 0; i < params.length; i++) {
			System.out.println("**AOP 에서 확인한 매개변수 인자값정보**" + params[i]);
		}

		System.out.println("**AOP Before Advice**");
		Object retValue = null;
		try {
			retValue = point.proceed();// 실제 target core를 실행
			if (retValue != null) {
				// retValue+=" aop"; //core의 리턴값도 제어 가능하다
				System.out.println("**AOP After return value**" + retValue);
			}
		} catch (InventoryException ie) { //재고 예외가 발생할 시 관리자에게 메세지 전달하는 횡단 관심사를 적용
			System.out.println("**AOP After Throwing Advice** 재고담당자에게 메세지를 전달");
			throw ie; //throw : exception 발생, 이유는 기존 시스템의 실행 흐름을 유지하기 위해
		}finally {
			String className = point.getTarget().getClass().getName();
			String methodName = point.getSignature().getName();
			System.out.println("**AOP After Advice**" +className+" "+methodName);
		}

		return retValue;
	}

}