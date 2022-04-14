/**
 * 
 */
package library.dakar_hr.object_models.modules.personnel;

import context_manager.ContextIdGetter;
import context_manager.FirstContext;
import context_manager.contexts.Context;
import library.common.forms.ContainerAction;
import library.dakar_hr.pages.homepage.CoreData;


/**
 * @author SteveBrown
 * @version 1.0
 * @since 1.0
 *
 */
public final class ContextPersonnel extends Context implements FirstContext {
	
	public ContextPersonnel(CoreData coreData, ContextIdGetter idGetter, ContainerAction containerAction) {
		super(coreData, idGetter, containerAction);
		
	}
}
