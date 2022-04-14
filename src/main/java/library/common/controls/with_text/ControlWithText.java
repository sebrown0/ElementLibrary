/**
 * 
 */
package library.common.controls.with_text;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import library.common.controls.getters.ElementGetter;
import library.common.controls.getters.TextGetter;
import library.common.controls.interfaces.Control;
import library.common.controls.interfaces.DisplayedText;
import library.common.controls.interfaces.SetText;
import library.common.controls.reset.ReloadContainer;

/**
 * @author SteveBrown
 * @version 1.0
 * @since 1.0
 */
public abstract class ControlWithText implements Control, SetText, DisplayedText, ReloadContainer {

	private WebDriver driver;
	private By locator;	
	private Logger logger = LogManager.getLogger(this.getClass());
	
	protected WebElement elContainer;
			
	public ControlWithText(WebDriver driver, By locator) {
		this.driver = driver;
		this.locator = locator;
		
		setElementContainer();		
	}	
	
	private void setElementContainer() {
		try {
			this.elContainer = driver.findElement(locator);	
		} catch (Exception e) {
			logger.error("Could not find control using [" + locator + "]");
		}
	}
	
	@Override //DisplayedText
	public String getText() {
		return new TextGetter(elContainer, this).getText();
	}
	
	@Override //SetText
	public void setText(String value) {		
		if(!isAvailable()) {
			reloadContainer();			
		}
		elContainer.sendKeys(value);
	}
		
	@Override //Control
	public boolean isAvailable() {
		elContainer = new ElementGetter(driver).getElementIfClickable(this);
		return (elContainer != null) ? true : false;
	}

	@Override //Control
	public By getLocator() {
		return locator;
	}

	@Override //Control
	public WebDriver getDriver() {
		return driver;
	}	

	@Override //Control
	public WebElement getElement() {
		return elContainer;
	}

	@Override //ReloadContainer
	public WebElement reloadContainer() {
		setElementContainer();
		return elContainer;
	}
}
