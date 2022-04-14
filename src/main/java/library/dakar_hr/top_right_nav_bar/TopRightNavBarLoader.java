/**
 * 
 */
package library.dakar_hr.top_right_nav_bar;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import context_manager.ContextManager;
import context_manager.ContextState;
import helpers.ClassFieldGetter;
import library.common.forms.ContainerAction;
import library.dakar_hr.left_menu.MenuContextChecker;
import library.dakar_hr.nav.NavBarElement;


/**
 * @author SteveBrown
 * @version 1.0
 * @since 1.0
 *
 * Actions that can be performed on a TopRightNavBar object.
 */
public class TopRightNavBarLoader {
	private Logger logger = LogManager.getLogger();
	private ContextManager contextManager;	
	private TopRightNavBarElements navBarElements;
	private MenuContextChecker menuContextChecker;
	
	public TopRightNavBarLoader(ContextManager contextManager, TopRightNavBarElements navBarElements) {
		this.contextManager = contextManager;
		this.navBarElements = navBarElements;
		this.menuContextChecker = new MenuContextChecker(contextManager);
	}
	
	public Optional<ContainerAction> clickAndLoad(Class<?> clazz) {		
		contextManager.switchToTopRightNavBar();
		ClassFieldGetter fieldGetter = new ClassFieldGetter(clazz);
		return loadElement(fieldGetter);
	}

	/*
	 * Returns either an existing or new ContainerAction.
	 * ContainerAction is a JsPanel, Form etc that has ContextState in the form of: myContext.
	 */
	private Optional<ContainerAction> loadElement(ClassFieldGetter fieldGetter) {
		Optional<ContainerAction> elementContainer = Optional.empty();		
//		Optional<String> elementName = fieldGetter.getOriginalName();
		Optional<String> elementName = fieldGetter.getMenuItemName();
				
		if(elementName.isPresent()) {
			String name = elementName.get();
			NavBarElement e =  navBarElements.getElement(name);
					
			logger.info("Loading [" + name + "]");
			
			try {								
				Optional<ContextState> cs = contextManager.findContext(e);				
				if(menuContextChecker.isExistingContext(cs)) {
					elementContainer = menuContextChecker.getExistingContainerFromContext(name, cs.get());
					menuContextChecker.setExistingAsCurrent(elementContainer);					
				}else {					
					elementContainer = Optional.of((ContainerAction) e.clickElement());
					logger.debug("[" + elementContainer.get().toString() + "] does not exist. Creating now");
				}						
			} catch (Exception ex) {
				logger.error("Could not get menu element [" + name + "] [" + ex.getMessage() + "]");				 	
			}	
		}else {
			logger.error("Could not get menu element.");
		}
		return elementContainer; 
	}

}
