package model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MemberService {
	private Logger logger= LogManager.getLogger(getClass());
	public void logteset() {
		System.out.println("MemeberService logtest");
		logger.fatal("fatal log test");
		logger.error("error log test");
		logger.warn("warn log test");
		logger.info("info log test");
		logger.debug("debug log test");
		logger.trace("trace log test");
	}
}
