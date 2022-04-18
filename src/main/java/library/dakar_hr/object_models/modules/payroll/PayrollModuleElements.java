package library.dakar_hr.object_models.modules.payroll;


import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;

import context_manager.ContextId;
import context_manager.ContextIdGetter;
import context_manager.ContextManager;
import context_manager.ContextState;
import context_manager.contexts.Context;
import context_manager.states.StateFactorySetter;
import core_data.CoreData;
import library.common.forms.ContainerAction;
import library.common.helpers.title.PageTitle;
import library.common.interfaces.IFrame;
import library.common.panels.JsPanelHeaderBar;
import library.dakar_hr.contexts.ContextPayroll;
import library.dakar_hr.entities.company.Company;
import library.dakar_hr.left_menu.LeftMenu;
import library.dakar_hr.nav.nav_bar_elements.NavBarElementStrategy;
import library.dakar_hr.nav.quick_links.QuickLink;
import library.dakar_hr.nav.quick_links.QuickLinkPayroll;
import library.dakar_hr.object_models.modules.payroll.left_menu.LeftMenuPayroll;
import library.dakar_hr.object_models.modules.payroll.top_right_nav.NavBarPayrollElements;
import library.dakar_hr.pages.homepage.HomePage;
import library.dakar_hr.pages.homepage.HomePagePayroll;
import library.dakar_hr.pages.homepage.loader.HomePageElements;
//import object_models.modules.payroll.top_right_nav.NavBarPayrollElements;
//import object_models.top_right_nav_bar.payroll.NavBarPayrollElements;
import providers.ModuleNames;

/**
 * @author SteveBrown
 * @version 1.0
 * 	Initial
 * @version 1.1
 * 	Get the HomePage from ModuleElements.
 * @since 1.0
 *
 * The required elements of the payroll module.
 * 
 */
public class PayrollModuleElements implements HomePageElements {
	private WebDriver driver;
	private CoreData coreData;
	private Company company;
		
	public PayrollModuleElements(Company company) {
		this.company = company;
	}

	@Override
	public void setCoreData(CoreData coreData) {
		this.coreData = coreData;
		this.driver = coreData.getWebDriver();
	}

	@Override
	public Context getContextForModule() { 	
		// TODO - REMOVE ANONYMOUS CLASSES
		return new ContextPayroll(
				coreData, 
				new ContextIdGetter() {			
						@Override
						public ContextId getContextId() {							
							return new ContextId("Payroll Module", "Payroll Module");
						}
						@Override
						public String getContextExpectedName() {
							return "Payroll Module";
						}
					}, 
				new ContainerAction() {
						@Override
						public StateFactorySetter getStateFactorySetter() {
							// TODO Auto-generated method stub
							return new StateFactorySetter() {							
								@Override
								public ContextManager getContextManager() {
									return coreData.getContextManager();
								}
								@Override
								public WebDriver getWebDriver() {
									return driver;
								}							
								@Override
								public IFrame getIFrame() {
									return null;
								}
								@Override
								public JsPanelHeaderBar setJsPanelHeaderBar() {
									return null;
								}							
							};
						}
						
					@Override
					public void close() {
						LogManager.getLogger().error("*** NOT IMPLEMENTED ***");					
					}					
					@Override
					public PageTitle getTitle() {
						LogManager.getLogger().error("*** NOT IMPLEMENTED ***");
						return null;
					}

					@Override
					public ContextState getMyContext() {
						LogManager.getLogger().error("*** NOT IMPLENTED ***");
						System.out.println("PayrollModuleLoader.ContextPayroll.getMyContext() *** NOT IMPLENTED ***"); // TODO - remove or log 	
						return null;
					}					
				});				
	}
		
	@Override
	public NavBarElementStrategy getElementStrategy(ContextManager contextManager) {
		return new NavBarPayrollElements(coreData);
	}

	@Override
	public QuickLink getQuickLinkToLoadModule() {
		return new QuickLinkPayroll(driver);
	}

	@Override
	public String getModuleName() {
		return ModuleNames.PAYROLL_NAME;
	}

	@Override
	public void setLeftMenuElements(LeftMenu menu) {
		menu.setElements(new LeftMenuPayroll());
	}

	@Override
	public HomePage getHomePage() {
		return new HomePagePayroll(coreData);
	}

	@Override
	public Company getCompany() {
		return company;
	}
		
}