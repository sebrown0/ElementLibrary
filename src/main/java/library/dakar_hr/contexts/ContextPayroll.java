/**
 * 
 */
package library.dakar_hr.contexts;

import context_manager.ContextIdGetter;
import context_manager.FirstContext;
import context_manager.contexts.Context;
import core_data.CoreData;
import library.common.forms.ContainerAction;


/**
 * @author SteveBrown
 * @version 1.0
 * 	Initial
 * @since 1.0
 *
 */
public final class ContextPayroll extends Context implements FirstContext {
	
	public ContextPayroll(CoreData coreData, ContextIdGetter idGetter, ContainerAction containerAction) {
		super(coreData, idGetter, containerAction);
		
	}
}
