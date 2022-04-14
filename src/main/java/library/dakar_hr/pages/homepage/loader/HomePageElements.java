package library.dakar_hr.pages.homepage.loader;

import context_manager.ContextManager;
import context_manager.contexts.Context;
import library.dakar_hr.entities.company.Company;
import library.dakar_hr.left_menu.LeftMenu;
import library.dakar_hr.nav.nav_bar_elements.NavBarElementStrategy;
import library.dakar_hr.nav.quick_links.QuickLink;
import library.dakar_hr.pages.homepage.CoreData;
import library.dakar_hr.pages.homepage.HomePage;


/**
 * @author SteveBrown
 * @version 1.0
 * 	Initial
 * @version 1.1
 * 	Add setCoreData(...)
 * @version 1.2
 * 	Renamed 
 * @since 1.0
 *
 * This is passed to ModuleLoader so it can load the 
 * correct elements for the module.
 *  
 */
public interface HomePageElements {
	void setCoreData(CoreData coreData);
	void setLeftMenuElements(LeftMenu menu);
	
	HomePage getHomePage();
	Context getContextForModule();
	NavBarElementStrategy getElementStrategy(ContextManager contextManager);
	QuickLink getQuickLinkToLoadModule();	
	String getModuleName();	
	Company getCompany();
}
