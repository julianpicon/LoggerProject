package co.com.belatrix.logger.resources;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.FileHandler;

import co.com.belatrix.logger.config.BelatrixConfiguration;
import co.com.belatrix.logger.exception.HandlerException;
import co.com.belatrix.logger.exception.LogFileException;

public class FileManager implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private BelatrixConfiguration config;
	
	public FileManager(BelatrixConfiguration config) {
		super();
		this.config = config;
	}
	
	public File getLogFile() {
		File logFile = new File(this.config.getProperty("logger.logFilePath"));
		if (!logFile.exists()) {
			try {
				logFile.createNewFile();
			} catch (IOException e) {
				throw new LogFileException("Error create new log file.", e);
			}
		}
		return logFile;
	}
	
	public FileHandler getFileHandler() {
		try {
			getLogFile();
			return new FileHandler(this.config.getProperty("logger.logFilePath"));
		} catch (SecurityException | IOException e) {
			throw new  HandlerException("Error get file handler.", e);
		}
	}

}
