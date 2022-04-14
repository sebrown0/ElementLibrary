package library.dakar_hr.object_models.modules.personnel;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;

import context_manager.ContextId;
import context_manager.ContextIdGetter;
import context_manager.ContextManager;
import context_manager.ContextState;
import context_manager.contexts.Context;
import context_manager.states.StateFactorySetter;
import library.common.forms.ContainerAction;
import library.common.helpers.title.PageTitle;
import library.common.interfaces.IFrame;
import library.common.panels.JsPanelHeaderBar;
import library.dakar_hr.contexts.ContextPersonnel;
import library.dakar_hr.entities.company.Company;
import library.dakar_hr.left_menu.LeftMenu;
import library.dakar_hr.nav.nav_bar_elements.NavBarElementStrategy;
import library.dakar_hr.nav.quick_links.QuickLink;
import library.dakar_hr.nav.quick_links.QuickLinkPersonnel;
import library.dakar_hr.object_models.modules.personnel.top_right_nav.NavBarPersonnelElements;
import library.dakar_hr.pages.homepage.CoreData;
import library.dakar_hr.pages.homepage.HomePage;
import library.dakar_hr.pages.homepage.HomePagePersonnel;
import library.dakar_hr.pages.homepage.loader.HomePageElements;
import providers.ModuleNames;


/**
 * @author SteveBrown
 * @version 1.0
 * 	Initial
 * @since 1.0
 *
 */
public class PersonnelModuleElements implements HomePageElements {
	private WebDriver driver;
	private CoreData coreData;
	private Company company;
	
	public PersonnelModuleElements(Company company) {
		this.company = company;
	}
	
	@Override
	public void setCoreData(CoreData coreData) {
		this.coreData = coreData;
		this.driver = coreData.getWebDriver();
	}
	
	@Override
	public NavBarElementStrategy getElementStrategy(ContextManager contextManager) {
		return new NavBarPersonnelElements(coreData);
	}

	@Override
	public QuickLink getQuickLinkToLoadModule() {
		return new QuickLinkPersonnel(driver);
	}

	@Override
	public String getModuleName() {
		return ModuleNames.PERSONNEL_NAME;
	}

	@Override
	public void setLeftMenuElements(LeftMenu menu) {
		LogManager.getLogger().error("Not implemented");
		
	}

	@Override
	public Context getContextForModule() {		
		return new ContextPersonnel(
				coreData, 
				new ContextIdGetter() {			
						@Override
						public ContextId getContextId() {							
							return new ContextId("Personnel Module", "Personnel Module");
						}
						@Override
						public String getContextExpectedName() {
							return "Personnel Module";
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
						System.out.println("PersonnelModuleElements.ContextPayroll.getMyContext() *** NOT IMPLENTED ***"); // TODO - remove or log 	
						return null;
					}					
				});	
	}
	
	@Override
	public HomePage getHomePage() {		
		return new HomePagePersonnel(coreData);
	}

	@Override
	public Company getCompany() {
		return company;
	}
}