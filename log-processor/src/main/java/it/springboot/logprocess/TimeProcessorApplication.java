package it.springboot.logprocess;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Import;
import org.springframework.integration.annotation.Transformer;

@EnableBinding(Processor.class)
@SpringBootApplication
@Import(RegExUtil.class)
public class TimeProcessorApplication {

	private static Logger logger = LoggerFactory.getLogger(TimeProcessorApplication.class);
	
	@Autowired
	RegExUtil regExUtil;
	
	// @Transformer(inputChannel = Processor.INPUT, outputChannel =
	// Processor.OUTPUT)
	public Object transform(Long timestamp) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		String date = dateFormat.format(timestamp) + " Ciao";
		return date;
	}

//	@Transformer(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
	public Object transformString(String logLine) {

		return logLine + " Process";
	}
	
	@Transformer(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
	public ApacheLog transformApacheLog(String logLine) {

		logger.info("Log line: " + logLine);
		
		return regExUtil.getLog(logLine);
	}

	public static void main(String[] args) {
		SpringApplication.run(TimeProcessorApplication.class, args);
	}
}
