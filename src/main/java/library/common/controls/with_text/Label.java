/**
 * 
 */
package library.common.controls.with_text;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import library.common.controls.getters.TextGetter;

/**
 * @author SteveBrown
 * @version 1.0
 * 	Initial
 * @since 1.0
 */
public class Label extends ControlWithText {

	public Label(WebDriver driver, By locator) {
		super(driver, locator);	
	}
	
	@Override //DisplayedText
	public String getText() {
		return new TextGetter(elContainer, this).getText();
	}
}
