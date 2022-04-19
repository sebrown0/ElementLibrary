/**
 * 
 */
package library.dakar_hr.nav.nav_bar_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core_data.CoreData;
import library.common.helpers.element.Closable;
import library.common.helpers.element.NoElement;
import library.common.strategies.ClickUsingJavaScript;
import library.dakar_hr.nav.NavBarElement;

/**
 * @author SteveBrown
 *
 */
public class NavBarVisualReports extends NavBarElement {
	public static final String ORIGINAL_NAME = "Visual Reports";
	
	public NavBarVisualReports(CoreData coreData) {
		super(coreData, ORIGINAL_NAME);
	}

	@Override
	public Closable clickElement() {
		WebElement el = super.getNavBar().findElement(By.xpath(".//li/a/i[contains(@class, 'fa fa-bar-chart')]"));
		ClickUsingJavaScript.performClick(driver, el);
		System.out.println("[NavBarVisualReports] not implemented."); // TODO - remove or log
		return new NoElement(ORIGINAL_NAME);	
//		return new VisualReports(super.coreData);
	}
}
