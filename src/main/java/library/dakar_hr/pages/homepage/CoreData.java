/**
 * 
 */
package library.dakar_hr.pages.homepage;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import context_manager.ContextManager;

/**
 * @author SteveBrown
 * @version 1.0
 * 	Initial
 * @since 1.0
 * 
 * Data required by many objects in the app.
 */
public interface CoreData {
	WebDriver getWebDriver();
	ContextManager getContextManager();
	Logger getLogger();
}
