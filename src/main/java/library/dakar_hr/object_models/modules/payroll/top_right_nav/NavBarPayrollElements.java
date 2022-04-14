package library.dakar_hr.object_models.modules.payroll.top_right_nav;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.WebDriver;

import library.dakar_hr.nav.NavBarElement;
import library.dakar_hr.nav.nav_bar_elements.NavBarElementStrategy;
import library.dakar_hr.nav.nav_bar_elements.NavBarEmployeeCreation;
import library.dakar_hr.nav.quick_links.QuickLinks;
import library.dakar_hr.nav.quick_links.QuickLinksPayroll;
import library.dakar_hr.pages.homepage.CoreData;
/**
* Generated Class.
* ----------------
* Source:  C:/Users/SteveBrown/eclipse-workspace/2021/DTest/src/main/resources/site_map/site_map.xml
* Author:  SteveBrown
* Version: 1.0.0
* Created: 12/04/2022 13:30:10
*/

public class NavBarPayrollElements implements NavBarElementStrategy {
	private Map<String, NavBarElement> elements;
	private WebDriver driver;
	private CoreData coreData;

	public NavBarPayrollElements(CoreData coreData) {
		this.coreData = coreData;
		this.driver = coreData.getWebDriver();
		setElements();
	}

	private void setElements(){
		elements = Stream.of(new Object[][] {{
			NavBarEmployeeCreation.ORIGINAL_NAME, new NavBarEmployeeCreation(coreData)}
		}).collect(Collectors.toMap(data -> (String) data[0], data -> (NavBarElement) data[1])); 
	}

	@Override
	public Map<String, NavBarElement> getElements() {
		return elements;
	}

	@Override
	public QuickLinks getQuickLinks() {
		return new QuickLinksPayroll(driver);
	}
}