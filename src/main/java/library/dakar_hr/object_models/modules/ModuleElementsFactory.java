/**
 * 
 */
package library.dakar_hr.object_models.modules;

import org.apache.logging.log4j.LogManager;

import library.dakar_hr.entities.company.Company;
import library.dakar_hr.object_models.modules.payroll.PayrollModuleElements;
import library.dakar_hr.object_models.modules.personnel.PersonnelModuleElements;
import library.dakar_hr.pages.homepage.loader.HomePageElements;

/**
 * @author SteveBrown
 * @version 1.0
 * 	Initial
 * @since 1.0
 */
public class ModuleElementsFactory {
	public static HomePageElements getModuleElements(String moduleName, Company company) {
		HomePageElements elements = null;
		
		switch (moduleName) {
		case "Payroll":
			elements = new PayrollModuleElements(company);
			break;
		case "Personnel":
			elements = new PersonnelModuleElements(company);
			break;

		default:
			LogManager.getLogger().error("Not implemented for [" + moduleName + "]");
		}
		
		return elements;
	}
}
