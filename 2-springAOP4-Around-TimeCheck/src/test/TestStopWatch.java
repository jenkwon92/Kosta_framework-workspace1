package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StopWatch;

//메서드 실행 소요시간을 측정하기 위한 단위 테스트
class DemoService {
	/*******cross cutting concern***************/
	private Logger log = LogManager.getLogger(getClass());
	public void getList() {
		// 스프링에서 제공하는 StopWatch 테스트
		/*******cross cutting concern***************/
		StopWatch watch = new StopWatch();
		watch.start();
		/****************************************/
		try {
			Thread.sleep(1100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("core list 작업");
		/*******cross cutting concern***************/
		watch.stop();
		long time = watch.getTotalTimeMillis();
		if(time>=500 && time<1000) {
			log.warn("DemoService getList time:" +time);
		}else if(time >=1000) {
			log.error("DemoService getList time:" +time);
		}
		System.out.println("DemoService getList time :" + time);
		/*******************************************/
	}
}

public class TestStopWatch {
	public static void main(String[] args) {
		DemoService service = new DemoService();
		service.getList();
	}
}
