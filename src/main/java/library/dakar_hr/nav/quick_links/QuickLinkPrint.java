	/**
 * 
 */
package library.dakar_hr.nav.quick_links;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Steve Brown
 *
 */
public class QuickLinkPrint extends QuickLink {
	private static final By LOCATOR = By.xpath(".//a/i[contains(@class, 'fa fa-print')]");	
	
	public QuickLinkPrint(WebDriver driver) {
		super(driver, LOCATOR);
	}	
	
}
