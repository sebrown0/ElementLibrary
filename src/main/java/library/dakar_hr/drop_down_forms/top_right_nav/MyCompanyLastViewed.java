/**
 * 
 */
package library.dakar_hr.drop_down_forms.top_right_nav;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import library.common.helpers.element.Closable;

/**
 * @author Steve Brown
 *
 */
public class MyCompanyLastViewed implements Closable {
	private WebDriver driver;
	private String title;
	
	public MyCompanyLastViewed(WebDriver driver, String title) {
		this.driver = driver;
		this.title = title;
	}
	
	// Actions
	@Override
	public void close() {
		WebElement navBar = driver.findElement(By.cssSelector("header[class='app-header navbar']"));
		navBar.click();
	}
	
	// Elements

	// Tabs
	
	// Getters & Setters
	public String getTitle() {
		return title;
	}
}
