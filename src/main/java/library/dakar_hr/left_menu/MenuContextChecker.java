/**
 * 
 */
package library.dakar_hr.left_menu;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;

import context_manager.ContextLoader;
import context_manager.ContextManager;
import context_manager.ContextState;
import library.common.forms.ContainerAction;

/**
 * @author SteveBrown
 * @version 1.0
 * @since 1.0
 */
public class MenuContextChecker {
	private ContextManager contextManager;	
	
	public MenuContextChecker(ContextManager contextManager) {
		this.contextManager = contextManager;
	}
	
	public boolean isExistingContext(Optional<ContextState> cs) {
		if(cs != null) {
			return cs.isPresent();	
		}else {
			return false;
		}		
	}
	public Optional<ContainerAction> getExistingContainerFromContext(String name, ContextState cs) {
		LogManager.getLogger().debug("[" + name + "] already exists. Switching to that context and retrieving container");					
		ContainerAction el = cs.getContinerAction();				
		return Optional.of(el);
	}
	public void setExistingAsCurrent(Optional<ContainerAction> elementContainer) {
		elementContainer.ifPresent(e -> {
			ContextLoader loader = new ContextLoader(contextManager);
			loader.setContainerItemAsCurrentContext(elementContainer);	
		});
		
	}
}
