package test;

import org.springframework.util.StopWatch;

//메서드 실행 소요시간을 측정하기 위한 단위 테스트
class DemoService {
	public void getList() {
		// 스프링에서 제공하는 StopWatch 테스트
		/*******cross cutting concern***************/
		StopWatch watch = new StopWatch();
		watch.start();
		/****************************************/
		try {
			Thread.sleep(1200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("core list 작업");
		/*******cross cutting concern***************/
		watch.stop();
		long time = watch.getTotalTimeMillis();
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
