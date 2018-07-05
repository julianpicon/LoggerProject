package co.com.belatrix.logger;

import java.text.DateFormat;
import java.util.Date;

import org.apache.logging.log4j.util.Strings;

import co.com.belatrix.logger.config.BelatrixConfiguration;
import co.com.belatrix.logger.enums.MessageType;
import co.com.belatrix.logger.exception.MessageException;
import co.com.belatrix.logger.interfaces.BelatrixLogger;
import co.com.belatrix.logger.resources.DatabaseManager;

public class LoggerDatabase implements BelatrixLogger {
	
	private DatabaseManager manager;
	
	public LoggerDatabase(BelatrixConfiguration configuration) {
		this.manager = DatabaseManager.getInstance(configuration);
	}
	
	public void addMessage(String message) {
		if (Strings.isBlank(message)) {
			throw new MessageException("Message must be specified");
		}
		String errorMessage = "message " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + message;
		this.manager.insertMessageBD(errorMessage, MessageType.MESSAGE.getId());
	}

	public void addWarning(String message) {
		if (Strings.isBlank(message)) {
			throw new MessageException("Warning must be specified");
		}
		String errorMessage = "warning " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + message;
		this.manager.insertMessageBD(errorMessage, MessageType.WARNING.getId());
	}

	public void addError(String message) {
		if (Strings.isBlank(message)) {
			throw new MessageException("Error must be specified");
		}
		String errorMessage = "error " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + message;
		this.manager.insertMessageBD(errorMessage, MessageType.ERROR.getId());
	}

}