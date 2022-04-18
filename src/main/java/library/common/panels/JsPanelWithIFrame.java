/**
 * 
 */
package library.common.panels;

import org.openqa.selenium.By;

import core_data.CoreData;
import library.common.interfaces.IFrame;

/**
 * @author SteveBrown
 * @version 1.0
 * 	Initial
 * @version 1.1
 * 	Remove getIFrameAsElement().
 * @since 1.0
 *
 */
public abstract class JsPanelWithIFrame extends JsPanel implements JsPanelContext { //, IframeSwitcher {
	private IFrame iFrame;

	// USE FOR TESTING WHEN WE WANT A BLANK OBJECT
	public JsPanelWithIFrame() {}
	
	public JsPanelWithIFrame(CoreData coreData, String expectedTitle) {
		super(coreData, expectedTitle);
	
		loadIframe();
	}
	
	@Override //JsPanel
	protected void setContextState() {
		By byLocator = By.cssSelector("iframe[title='" + super.expectedTitle + "']");
		iFrame = new IFrame(driver, byLocator);		
		super.getHeaderBar(); // CAUSES NEW STATE HEADER TO BE CREATED & ADDED TO THE QUEUE. TODO - remove this side effect.		
	}
	
	private void loadIframe() {		
		super.manager
			.moveToNextStateInCurrentContext()
			.switchToMe();	 	
		super.manager.setLatestCallingStateToCurrent();
	}	
		
	@Override
	public JsPanelWithIFrame getPanelWithIFrame() {
		return this;
	}
	
	@Override 	// StateFactorySetter
	public IFrame getIFrame() {
		return iFrame;
	}
		
}
