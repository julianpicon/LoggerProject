package co.com.belatrix.logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.com.belatrix.logger.config.DefaultConfiguration;
import co.com.belatrix.logger.enums.LoggerType;
import co.com.belatrix.logger.exception.LoggerTypeException;
import co.com.belatrix.logger.factory.LoggerFactory;
import co.com.belatrix.logger.interfaces.BelatrixLogger;
import co.com.belatrix.logger.resources.FileManager;

public class LoggerFileTest {
	
	@Before
	public final void baseSetUp() {}
	
	@After
	public final void baseTearDown() {}
	
	@Test
    public void testLoggerFactory_FileType() {
		BelatrixLogger logger = LoggerFactory.getLogger(LoggerType.FILE.getType());
        assertEquals(true, logger instanceof LoggerFile);
    }
	
	@Test(expected = LoggerTypeException.class)
    public void testLoggerFactory_TypeNoValid() {
		BelatrixLogger logger = LoggerFactory.getLogger("noValid");
		//...
    }
	
	@Test
    public void testFileManager_HandlerValid() {
		FileManager fileManager = new FileManager(new DefaultConfiguration());
		assertNotNull(fileManager.getFileHandler());
    }
	
	@Test
    public void testLoggerFile_addMessageInfo() {
		BelatrixLogger logger = LoggerFactory.getLogger(LoggerType.FILE.getType());
		logger.addMessage("Test - Message Info ");
        assertEquals(true, logger instanceof LoggerFile);
    }
	
	@Test
    public void testLoggerFile_addMultipleMessage() {
		BelatrixLogger logger = LoggerFactory.getLogger(LoggerType.FILE.getType());
		logger.addMessage("Test Multiple - Message Info!");
		logger.addWarning("Test Multiple - Message Warning!");
        assertEquals(true, logger instanceof LoggerFile);
    }
	
}
