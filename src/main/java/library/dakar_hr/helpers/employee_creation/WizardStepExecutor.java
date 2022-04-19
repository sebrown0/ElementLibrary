/**
 * 
 */
package library.dakar_hr.helpers.employee_creation;

import org.openqa.selenium.StaleElementReferenceException;

import content.EmployeeContent;

//import site_mapper.jaxb.pom.content.EmployeeContent;

/**
 * @author SteveBrown
 * @version 1.0
 *  Initial 	
 * @since 1.0
 */
public interface WizardStepExecutor {
	int getStepNumber();
	
	WizardStepExecutor writeValues(EmployeeContent emp) throws StaleElementReferenceException;
//	WizardStepExecutor writeValues(Employee emp) throws StaleElementReferenceException;
	WizardStepExecutor getNext();
}
