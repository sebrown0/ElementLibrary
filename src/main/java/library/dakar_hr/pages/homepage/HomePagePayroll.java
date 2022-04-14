package library.dakar_hr.pages.homepage;

import java.util.Optional;

import library.common.forms.ContainerAction;
import library.dakar_hr.entities.company.Company;
import library.dakar_hr.entities.payroll.PayGroup;
import library.dakar_hr.helpers.payroll_initialise.InitialisePayroll;
import library.dakar_hr.helpers.payroll_initialise.PayrollInitialiser;
import library.dakar_hr.object_models.modules.payroll.left_menu.payroll.PayrollElement;

/**
 * @author SteveBrown
 * @version 1.0
 * 	Initial
 * @since 1.0
 */
public final class HomePagePayroll extends HomePage {

	public HomePagePayroll(CoreData coreData) {
		super(coreData);		
	}

	// Actions 
	public HomePagePayroll initialisePayroll(Company forCompany, PayGroup payGroup) {
		PayrollInitialiser initialiser = new PayrollInitialiser(this, forCompany, payGroup, super.getLeftMenu());		
		return initialiser.initialisePayroll();
	}
	
	public InitialisePayroll openInitialisePayroll() {
		return openOneOfMyElements(InitialisePayroll.class);
	}
	
//	public GlobalAdjustments openGlobalAdjustments() {
//		return openOneOfMyElements(GlobalAdjustments.class);
//	}
	
	// Helpers
	@SuppressWarnings("unchecked")
	private <T extends PayrollElement> T openOneOfMyElements(Class<T> clazz){
		T initPay = null;
		Optional<ContainerAction> initPayCont =	leftMenu.clickAndLoad(clazz);
		if(initPayCont.isPresent()) {
			initPay = (T) initPayCont.get();					
		}
		return initPay;
	}
	
	// Getters and setters
	@Override
	public String getModuleName() {
		return "Payroll";
	}

}