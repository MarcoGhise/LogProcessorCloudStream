package it.springboot.logprocess;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExUtil {

	private final static String REGEX = "^(\\S+)\\s-\\s-\\s\\[(\\S+)\\s\\+\\d+\\]\\s\"(GET|POST)\\s(\\S+)\\s(\\S+)\"\\s(\\d+)\\s\\d+$";

	private Pattern r;
	
	public RegExUtil()
	{
		// Create a Pattern object		
		r = Pattern.compile(REGEX);
	}
	
	public ApacheLog getLog(String logLine) {
		
		// Now create matcher object.
		Matcher m = r.matcher(logLine);
		ApacheLog log = new ApacheLog();

		if (m.find()) {

			log.setIp(m.group(1));
			log.setDate(m.group(2));
			log.setMethod(m.group(3));
			log.setUrl(m.group(4));
			log.setProtocol(m.group(5));
			log.setHttpCode(m.group(6));
		}

		return log;
	}
}
