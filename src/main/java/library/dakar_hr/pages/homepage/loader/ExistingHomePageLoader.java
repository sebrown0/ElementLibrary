package library.dakar_hr.pages.homepage.loader;

import core_data.CoreData;
import core_data.CoreDataLoader;
import library.dakar_hr.exceptions.HomePageElementException;
import library.dakar_hr.pages.homepage.HomePage;

//import exceptions.HomePageElementException;
//import object_models.pages.homepage.CoreData;
//import object_models.pages.homepage.CoreDataLoader;
//import object_models.pages.homepage.HomePage;

/**
 * @author SteveBrown
 * @version 1.0
 * 	Initial
 * @version 1.1
 * 	Fix bug that was stopping a new HomePage from being created.
 * @since 1.0
 * 
 * Create a new HomePage.
 * Use when there is an existing HomePage, 
 * i.e. changing the company or module.
 * 
 */
public final class ExistingHomePageLoader extends HomePageLoader {

	public ExistingHomePageLoader(CoreData coreData, HomePageElements elements, HomePage hp) throws HomePageElementException {
		super(coreData.getWebDriver(), elements);
		
		super.initialiseLoader(coreData);
		super.setCurrentCompany(hp.getCurrentCompany());
		super.hp = hp;
	}

	@Override
	public HomePage loadHomePage() {
		if(haveLoadedModuleOrCompany()) {
			createNewHomePage();
		}		
		return hp;		
	}

	// Only load if not null and different from existing module/company.
	private boolean haveLoadedModuleOrCompany() {
		return super.loadModule() || super.loadCompany();
	}

	private void createNewHomePage() {
		super.initialiseLoader(new CoreDataLoader(driver));
		super.hp = super.elements.getHomePage();
		super.initialiseHomePage(super.hp);
	}
	
}