/**
 * 
 */
package library.dakar_hr.object_models.modules.payroll.top_right_nav.employees;

import static org.junit.jupiter.api.Assertions.assertTrue;

import core_data.CoreData;
import library.common.forms.FormFadeShow;
import library.dakar_hr.nav.NavBarElement;
import library.dakar_hr.nav.nav_bar_elements.NavBarEmployeeCreation;
import library.dakar_hr.pages.homepage.HomePage;
import library.dakar_hr.providers.employee.EmployeeFromXml;
import providers.XMLFileProvider;
//import site_mapper.jaxb.pom.content.EmployeeContent;

/**
 * @author SteveBrown
 * @version 1.0
 * 	Initial
 * @since 1.0
 * 
 * Create an employee using the Employee Creation Wizard.
 * 
 */
public class CreateExitingEmployee implements TestFunction {

	@Override
	public void run(CoreData coreData) {
		HomePage hp = (HomePage) coreData;
		NavBarElement navEmpWizard = 
				hp.getTopRightNavBarElement(
						NavBarEmployeeCreation.ORIGINAL_NAME).get();
		EmployeeFromXml empProvider = 
				new EmployeeFromXml(XMLFileProvider.EMPLOYEE_TESTS_FILE_PATH);
		
		// GET AN EMPLOYEE FROM XML				
		content.EmployeeContent emp = empProvider.getFirstEmployeeWithCompleteContent();
			
		// GET THE EMPLOYEE WIZARD
		EmployeeCreation	empCreation = (EmployeeCreation) navEmpWizard.clickElement();
		
		// THE EMP EXISTS SO THE RESULT SHOULD BE AN ERROR FORM.
		FormFadeShow frm = 
				empCreation.getEmployeeCreationWizard().createEmployeeAndGetConfirmation(emp);
		
		assertTrue(frm.getTitle().getActual().contains("Data Error"));
		
		//CLOSE THE ERROR FORM AND WIZARD
		frm.close();
		empCreation.close();	
		
	}

}
