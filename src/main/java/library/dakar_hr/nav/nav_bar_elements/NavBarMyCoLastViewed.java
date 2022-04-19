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
public class NavBarMyCoLastViewed extends NavBarElement { 
	public static final String ORIGINAL_NAME = "My Company / Last Viewed";
	
	public NavBarMyCoLastViewed(CoreData coreData) {
		super(coreData, ORIGINAL_NAME);
	}	

	@Override
	public Closable clickElement() {
		WebElement el = super.getNavBar().findElement(By.xpath(".//li/a/i[contains(@class, 'fa fa-building')]"));
		el.click();
//		return new MyCompanyLastViewed(driver, ORIGINAL_NAME);
		System.out.println("[NavBarMyCoLastViewed] -> MyCompanyLastViewed not implemented."); // TODO - remove or log
		return null;
	}
}
