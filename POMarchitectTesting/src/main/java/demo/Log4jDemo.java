package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {
	
	static Logger logger = LogManager.getLogger(Log4jDemo.class);

	public static void main(String[] args) {
		System.out.println("Beginning......");
		logger.trace("TRACE Messsge");
		logger.info("INFO message");
		logger.error("Error message");
		logger.warn("Warning message");
		logger.fatal("fatal message");
		System.out.println("Ending......");
		
	}

}
