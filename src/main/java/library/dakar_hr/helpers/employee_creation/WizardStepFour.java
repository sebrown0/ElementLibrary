/**
 * 
 */
package library.dakar_hr.helpers.employee_creation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import content.EmployeeContent;
import library.common.control_mapping.PageMap;
import library.common.helpers.jquery.Jquery;
//import site_mapper.jaxb.pom.content.EmployeeContent;

/**
 * @author SteveBrown
 * @version 1.0
 *  Initial 	
 * @since 1.0
 */
public class WizardStepFour extends WizardStep {
	
	public WizardStepFour(PageMap pageMap, WebDriver driver, int stepNumber) {
		super(pageMap, driver, stepNumber);
		
		super.loadAndWaitForStep(4);
	}

	@Override
	public WizardStepExecutor writeValues(EmployeeContent emp) {		
		//DO NOTHING
		return this;
	}

	@Override
	public WizardStepExecutor getNext() {
		WebElement nextBtn = driver.findElement(super.byNext);		
		Jquery.goToElement(driver, nextBtn);
		return new WizardStepFive(pageMap, driver, 5);	
	}
}
