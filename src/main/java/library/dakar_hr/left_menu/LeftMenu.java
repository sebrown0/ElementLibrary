/**
 * 
 */
package library.dakar_hr.left_menu;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import context_manager.CallingState;
import context_manager.ContextManager;
import context_manager.ContextState;
import context_manager.states.State;
import context_manager.states.StateLeftMenu;
import control_mapping.MenuMap;
import library.common.forms.ContainerAction;
import library.dakar_hr.pages.homepage.CoreData;



/**
 * @author SteveBrown
 * @version 1.0
 * 	Initial
 * @since 1.0
 *
 */
public class LeftMenu implements CallingState, LeftMenuLoadItem {
	private Map<String, WebElement> anchors;	
	private WebDriver driver;
	private Logger logger;
	private LeftMenuElements elements;	
	private LeftMenuMapper menuMapper;	
	private ContextManager contextManager;
	private LeftMenuActions menuActions;
	
	public LeftMenu(CoreData hp) {
		this.driver = hp.getWebDriver();
		this.contextManager = hp.getContextManager();
		this.logger = hp.getLogger();
		this.contextManager.setLatestCallingState(this);		
		
		mapAnchors();
		menuActions = new LeftMenuActions(hp, anchors, menuMapper);
	}

	private void mapAnchors() {
		menuMapper = new LeftMenuMapper(driver);		
		try {
			this.anchors = new MenuMap(new LeftMenuFactory(driver)).getAnchors().get();
		} catch (InterruptedException | ExecutionException e) {
			logger.error("Unable to get anchors from menu map");
		}
	}

	@Override
	public Optional<ContainerAction> clickAndLoad(Class<?> clazz) {		
		Optional<ContainerAction> action = menuActions.clickAndLoad(clazz);
		return action;		
	}
	
	public LeftMenuActions clickParent(String prntName) {		
		LeftMenuActions action = menuActions.clickParent(prntName); 
		return action;		
	}
		
	/*
	 *  Getters & Setters		
	 */
	public Map<String, Optional<List<String>>> getActualMenu(){
		return menuMapper.map().getMenu();		
	}
	
	public void setElements(LeftMenuElements elements) {
		this.elements = elements;		
	}
	
	public LeftMenuElements getElements() {
		return elements;
	}

	@Override
	public State getState(ContextState context) { 
		return new StateLeftMenu(context, driver);
	}

}
