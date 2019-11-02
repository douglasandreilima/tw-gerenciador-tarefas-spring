package br.unisul.ia.vizinhos;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

public class FileLogger {

	private static final String FILE_APPENDER_NAME = "FILE_APPENDER";
	private Logger logger = null;

	public FileLogger() {
		initLogger("log/", "log");
	}

	private void initLogger(String filePath, String fileName) {
		PatternLayout layout = new PatternLayout();
		String conversionPattern = "%-7p %d [%t] %c %x - %m%n";
		layout.setConversionPattern(conversionPattern);

		RollingFileAppender fileAppender = new RollingFileAppender();
		fileAppender.setName(FILE_APPENDER_NAME);
		fileAppender.setFile(filePath + fileName);

		fileAppender.setFile(filePath + fileName);
		fileAppender.setAppend(true);
		fileAppender.setLayout(layout);
		fileAppender.activateOptions();

		logger = LogManager.getRootLogger();
		logger.addAppender(fileAppender);
	}

	public Logger getLogger() {
		return logger;
	}
}
