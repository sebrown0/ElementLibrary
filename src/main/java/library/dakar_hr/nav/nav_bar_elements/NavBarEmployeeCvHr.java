/**
 * 
 */
package library.dakar_hr.nav.nav_bar_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core_data.CoreData;
import helpers.Closable;
import library.dakar_hr.nav.NavBarElement;
import strategies.ClickUsingJavaScript;

/**
 * @author Steve Brown
 *
 */
public class NavBarEmployeeCvHr extends NavBarElement {
	public static final String ORIGINAL_NAME = "Employee CV";
	
	public NavBarEmployeeCvHr(CoreData coreData) {
		super(coreData, ORIGINAL_NAME);
	}
			
	@Override
	public Closable clickElement() {
		WebElement el = super.getNavBar().findElement(By.xpath(".//li/a/i[contains(@class, 'fa fa-user')]"));
		ClickUsingJavaScript.performClick(driver, el);
//		return new EmployeeCvHr(super.coreData);
		System.out.println("[NavBarEmployeeCvHr] -> EmployeeCvHr not implemented."); // TODO - remove or log
		return null;
	}
}
