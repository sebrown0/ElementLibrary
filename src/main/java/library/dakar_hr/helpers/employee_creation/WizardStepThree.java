/**
 * 
 */
package library.dakar_hr.helpers.employee_creation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import content.EmployeeContent;
import control_mapping.PageMap;
import helpers.Jquery;

/**
 * @author SteveBrown
 * @version 1.0
 *  Initial 	
 * @since 1.0
 *
 */
public class WizardStepThree extends WizardStep {
	
	public WizardStepThree(PageMap pageMap, WebDriver driver, int stepNumber) {
		super(pageMap, driver, stepNumber);
		
		super.loadAndWaitForStep(3);				
	}

	@Override
	public WizardStepExecutor writeValues(EmployeeContent emp) {
//		pageMap.getCombo("Select a Tax Status").writeInput(EnumNameGetter.getName(emp.getTaxStatus()));
		pageMap.getCombo("Select a Tax Status").writeInput(emp.getTaxStatus());
//		pageMap.getCombo("Select an Employment Type").writeInput(EnumNameGetter.getName(emp.getEmploymentType()));
		pageMap.getCombo("Select an Employment Type").writeInput(emp.getEmploymentType());
		pageMap.getCombo("Select a Paygroup").writeInput(emp.getPayGroup());
		pageMap.getCombo("Select a Department").writeInput(emp.getDepartment());
		pageMap.getCombo("Select a Schedule").writeInput(emp.getSchedule());
//		pageMap.getCombo("Full Time or Part Time ?").writeInput(EnumNameGetter.getName(emp.getEmploymentType()));
		pageMap.getCombo("Full Time or Part Time ?").writeInput(emp.getEmploymentType());		
		pageMap.getCombo("Special Part Timer ?").writeInput(emp.isSpecialPartTimer() == true ? "Yes" : "No");
		pageMap.getCombo("Select a Grade").writeInput(emp.getGrade());
		pageMap.getCombo("Select a Cost Center").writeInput(emp.getCostCentre());
		return this;
	}

	@Override
	public WizardStepExecutor getNext() {
		WebElement nextBtn = driver.findElement(super.byNext);		
		Jquery.goToElement(driver, nextBtn);
		return new WizardStepFour(pageMap, driver, 4);	
	}
}