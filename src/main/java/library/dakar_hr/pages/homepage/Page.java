package library.dakar_hr.pages.homepage;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;

import context_manager.ContextState;
import context_manager.states.StateFactorySetter;
import helpers.Closable;
import library.common.forms.ContainerAction;
import library.common.helpers.title.PageTitle;
import library.common.helpers.title.TitlePage;

/**
 * @author Steve Brown
 *
 */
public class Page implements ContainerAction, Closable {
	protected WebDriver driver;
	private PageTitle title;	
	private String expectedTitle;
	
	public Page(WebDriver driver, String expectedTitle) {
		this.driver = driver;
	}
	
	@Override
	public void close() {
		LogManager.getLogger().error("closeElement not implemented for Page");
	}

	@Override
	public PageTitle getTitle() {
		if(title == null) {
			title = new TitlePage(expectedTitle, driver);
		}
		return title;
	}

	@Override
	public StateFactorySetter getStateFactorySetter() {
		LogManager.getLogger().error("*** NOT IMPLEMENTED ***");
		return null;
	}

	@Override
	public ContextState getMyContext() {
		// TODO Auto-generated method stub
		LogManager.getLogger().error("*** NOT IMPLENTED ***");
		System.out.println("Page.getMyContext() *** NOT IMPLENTED ***"); // TODO - remove or log 	
		return null;
	}
		
}
