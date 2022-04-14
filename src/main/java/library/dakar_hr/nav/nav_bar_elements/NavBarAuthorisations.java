/**
 * 
 */
package library.dakar_hr.nav.nav_bar_elements;

import org.openqa.selenium.By;

import helpers.Closable;
import library.dakar_hr.nav.NavBarElement;
import library.dakar_hr.pages.homepage.CoreData;
import strategies.ClickUsingJavaScript;

/**
 * @author Steve Brown
 *
 */
public class NavBarAuthorisations extends NavBarElement {
	private static final By LOCATOR = By.xpath("html/body/form/header/ul[4]/li[1]/a/i");
	public static final String ORIGINAL_NAME = "Authorisations";
	
	public NavBarAuthorisations(CoreData coreData) {
		super(coreData, ORIGINAL_NAME);
	}
	
	@Override
	public String getOriginalName() {
		return ORIGINAL_NAME;
	}

	@Override
	public Closable clickElement() {
		ClickUsingJavaScript.performClick(driver, LOCATOR);
//		return new EmployeeCreation(super.coreData);
		System.out.println("[NavBarAuthorisations] CANNOT RETURN EmployeeCreation"); // TODO - remove or log 	
		return null;
	}

}
