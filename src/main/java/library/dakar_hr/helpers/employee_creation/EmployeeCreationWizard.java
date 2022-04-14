/**
 * 
 */
package library.dakar_hr.helpers.employee_creation;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import content.EmployeeContent;
import control_mapping.MapControl;
import control_mapping.MapControlCombo;
import control_mapping.MapControlText;
import control_mapping.MappingStrategy;
import control_mapping.PageMap;
import control_mapping.PageMapper;
import library.common.forms.FormFadeShow;
import library.dakar_hr.pages.homepage.CoreData;
//import object_models.forms.FormFadeShow;

/**
 * @author SteveBrown
 * @version 1.0
 * @since 1.0
 *
 */
public class EmployeeCreationWizard {	
	private Logger logger = LogManager.getLogger();
	private PageMapper mapper;
	private PageMap pageMap;
	private WebDriver driver;
	private CoreData coreData;
	
	public static final String PANEL_TITLE = "Employee Creation Wizard";		
	
	public EmployeeCreationWizard(CoreData coreData) {
		this.coreData = coreData;
		driver = coreData.getWebDriver();		
		mapper = new PageMapper(new MappingStrategyWizard(driver));
		pageMap = mapper.mapControls().getPageMap();			
	}
	
	// Use this if were not interested in the confirmation form.
	public void createEmployeeIgnoreConfirmation(EmployeeContent emp)  {
		logger.debug("Creating employee with wizard");		
		executeSteps(emp);
		
		FormFadeShow frm = new FormFadeShow(coreData);
		frm.close();
	}
	// Use this if we want the confirmation form.
	public FormFadeShow createEmployeeAndGetConfirmation(EmployeeContent emp)  {
		logger.debug("Creating employee with wizard. Returning confirmation form");		
		executeSteps(emp);		
		return getConfirmationForm();
	}
	private void executeSteps(EmployeeContent emp) {
		WizardStepExecutor step1 = new WizardStepOne(pageMap, driver, 1);
		WizardStepExecutor step2 = writeValuesForStepAndMoveNext(step1, emp);
		WizardStepExecutor step3 = writeValuesForStepAndMoveNext(step2, emp);		
		WizardStepExecutor step4 = writeValuesForStepAndMoveNext(step3, emp);
		WizardStepExecutor step5 = writeValuesForStepAndMoveNext(step4, emp);
		step5.writeValues(emp).getNext();
	}
	private WizardStepExecutor writeValuesForStepAndMoveNext(WizardStepExecutor step, EmployeeContent emp) {
		step.writeValues(emp);
		return step.getNext();
	}	
	private FormFadeShow getConfirmationForm() {		
		return new FormFadeShow(coreData);
	}
	
	/*
	 * This object's mapping strategy.
	 */
	private class MappingStrategyWizard implements MappingStrategy{
		private WebDriver driver;
		
		public MappingStrategyWizard(WebDriver driver) {
			this.driver = driver;
		}

		public List<MapControl> getList() {
			MapControl[] objs = {
					new MapControlText(driver, By.cssSelector("input[type='text']"), "placeholder"),
					new MapControlCombo(driver, By.cssSelector("span[role='combobox']"), "textContent")};

			return List.of(objs);
		}		
	}
	
}
