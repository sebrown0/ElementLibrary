/**
 * 
 */
package library.common.forms;

import context_manager.ContextState;
import context_manager.states.StateFactorySetter;
import helpers.Closable;
import library.common.helpers.title.PageTitle;

/**
 * @author Steve Brown
 *
 */
public interface ContainerAction extends Closable {
	PageTitle getTitle();	
	StateFactorySetter getStateFactorySetter();
	ContextState getMyContext();
}
