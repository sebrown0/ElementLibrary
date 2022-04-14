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
public class NavBarUserAvatar extends NavBarElement {
	public static final String ORIGINAL_NAME = "User Avatar";
	
	public NavBarUserAvatar(CoreData coreData) {
		super(coreData, ORIGINAL_NAME);
	}
			
	@Override
	public Closable clickElement() {
		WebElement el = driver.findElement(By.cssSelector("a[class='nav-link nav-pill user-avatar']"));
		el.click();
		System.out.println("[NavBarUserAvatar] not implemented."); // TODO - remove or log
		return new NoElement(ORIGINAL_NAME);		
//		return new UserAvatar(driver, ORIGINAL_NAME);
	}
}