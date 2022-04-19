/**
 * 
 */
package library.dakar_hr.nav.nav_bar_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core_data.CoreData;
import library.common.helpers.element.Closable;
import library.dakar_hr.nav.NavBarElement;

/**
 * @author Steve Brown
 *
 */
public class NavBarNotifications extends NavBarElement {
	public static final String ORIGINAL_NAME = "Notifications";
	
	public NavBarNotifications(CoreData coreData) {
		super(coreData, ORIGINAL_NAME);
	}
	
	@Override
	public Closable clickElement() {
		WebElement el = super.getNavBar().findElement(By.xpath(".//li/a/i[contains(@class, 'fa fa-sticky-note')]"));
		el.click();	
//		return new AllNotifications(driver, ORIGINAL_NAME);
		System.out.println("[NavBarNotifications] -> AllNotifications not implemented."); // TODO - remove or log
		return null;
	}
}
