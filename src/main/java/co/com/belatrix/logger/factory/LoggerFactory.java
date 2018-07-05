package co.com.belatrix.logger.factory;

import co.com.belatrix.logger.LoggerConsole;
import co.com.belatrix.logger.LoggerDatabase;
import co.com.belatrix.logger.LoggerFile;
import co.com.belatrix.logger.config.BelatrixConfiguration;
import co.com.belatrix.logger.config.DefaultConfiguration;
import co.com.belatrix.logger.enums.LoggerType;
import co.com.belatrix.logger.exception.LoggerTypeException;
import co.com.belatrix.logger.interfaces.BelatrixLogger;

public class LoggerFactory {
	
	private LoggerFactory() {
		super();
	}
	
	public static BelatrixLogger getLogger(String type) {
		if (LoggerType.FILE.getType().equals(type)) {
			return new LoggerFile(new DefaultConfiguration());
		} else if (LoggerType.CONSOLE.getType().equals(type)) {
			return new LoggerConsole(new DefaultConfiguration());
		} else if (LoggerType.DATABASE.getType().equals(type)) {
			return new LoggerDatabase(new DefaultConfiguration());
		} else {
			throw new LoggerTypeException("Invalid configuration | Logger type not valid!");
		}
	}
	
	public static BelatrixLogger getLogger(String type, BelatrixConfiguration configuration) {
		if (LoggerType.FILE.getType().equals(type)) {
			return new LoggerFile(configuration);
		} else if (LoggerType.CONSOLE.getType().equals(type)) {
			return new LoggerConsole(configuration);
		} else if (LoggerType.DATABASE.getType().equals(type)) {
			return new LoggerDatabase(configuration);
		} else {
			throw new LoggerTypeException("Logger type not valid!");
		}
	}

}
