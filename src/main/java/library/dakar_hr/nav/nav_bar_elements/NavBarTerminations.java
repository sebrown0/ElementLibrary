/**
 * 
 */
package library.dakar_hr.nav.nav_bar_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helpers.Closable;
import helpers.NoElement;
import library.dakar_hr.nav.NavBarElement;
import library.dakar_hr.pages.homepage.CoreData;

/**
 * @author Steve Brown
 *
 */
public class NavBarTerminations extends NavBarElement {
	public static final String ORIGINAL_NAME = "Terminations";
	
	public NavBarTerminations(CoreData coreData) {
		super(coreData, ORIGINAL_NAME);
	}
	
	@Override
	public Closable clickElement() {
		WebElement el = super.getNavBar().findElement(By.xpath(".//li/a/i[contains(@class, 'fa fa-user-times')]"));
		el.click();
		System.out.println("[NavBarTerminations] not implemented."); // TODO - remove or log
		return new NoElement(ORIGINAL_NAME);		
//		return new Terminations(driver, ORIGINAL_NAME);
	}
}