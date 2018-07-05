package co.com.belatrix.logger.resources;

import java.io.Serializable;
import java.util.logging.ConsoleHandler;

import co.com.belatrix.logger.config.BelatrixConfiguration;

public class ConsoleManager implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static ConsoleManager instance = null;
	
	private ConsoleManager(BelatrixConfiguration configuration) {
		super();
	}
	
	public static synchronized ConsoleManager getInstance(BelatrixConfiguration configuration) {
		if (instance == null) {
			instance = new ConsoleManager(configuration);
		}
		return instance;
	}
	
	public ConsoleHandler getConsoleHandler() {
		return new ConsoleHandler();
	}

}
