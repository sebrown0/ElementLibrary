package library.dakar_hr.helpers.login;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import library.dakar_hr.entities.user.User;
import library.dakar_hr.exceptions.HomePageElementException;
import library.dakar_hr.pages.LoadablePage;
import library.dakar_hr.pages.homepage.CoreData;
import library.dakar_hr.pages.homepage.CoreDataLoader;
import library.dakar_hr.pages.homepage.HomePage;
import library.dakar_hr.pages.homepage.loader.HomePageElements;
import library.dakar_hr.pages.homepage.loader.NewHomePageLoader;

/**
 * @author SteveBrown
 * @version 1.0
 * 	Initial
 * @version 1.1
 * 	Load module from here and not HomePage.
 * 	Return the correct HomePage for the module.
 * @version 1.2
 * 	Get HomePage from NewHomePageLoader.
 * @version 1.3
 *  Handle HomePageElementException when trying to load HomePage.
 * @since 1.0
 *
 * Try to login a user and return the HomePage.
 */

public class UserLoginPage extends LoadablePage {
	private HomePageElements homePageElements;
	private CoreData coreData;
	private Logger logger = LogManager.getLogger();
	
	private By byUserName = By.name("user");
	private By byUserPassword = By.name("password");
	private By byBtnLogin = By.className("login100-form-btn");	
	
	// Just login.
	public UserLoginPage(WebDriver driver, String loginPageUri) {
		super(driver, "None", loginPageUri);		
		
		setCoreData();
	}	
	// Login with ModuleElements so a HomePage can be returned.
	public UserLoginPage(WebDriver driver, String loginPageUri, HomePageElements homePageElements) {
		super(driver, "None", loginPageUri);		
		
		setCoreData();
		setHomePageElements(homePageElements);
	}
		
	private void setCoreData() {
		coreData = new CoreDataLoader(driver);
	}
	private void setHomePageElements(HomePageElements homePageElements) {
		this.homePageElements = homePageElements;
		this.homePageElements.setCoreData(coreData);
	}
	
	public HomePage loginValidUser(User user) {
		driver.findElement(byUserName).sendKeys(user.getName());
		driver.findElement(byUserPassword).sendKeys(user.getPswd());
		driver.findElement(byBtnLogin).click();
		
		return getHomePageIfModuleSupplied();
	}
	
	private HomePage getHomePageIfModuleSupplied() {
		if(homePageElements == null) {
			logger.error("No module supplied");			
			return null;
		}else {
			return loadHomePage();
		}
	}
	
	private HomePage loadHomePage() {		
		NewHomePageLoader loader;
		try {
			loader = new NewHomePageLoader(driver, homePageElements);
			return loader.loadHomePage();
		} catch (HomePageElementException e) {
			logger.error("Cannot load homepage.");
		}
		return null;
	}
	
}