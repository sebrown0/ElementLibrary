/**
 * 
 */
package library.dakar_hr.left_menu;

import java.util.Optional;

import library.common.forms.ContainerAction;



/**
 * @author SteveBrown
 * @version 1.0
 * 	Initial
 * @since 1.0
 */
public interface LeftMenuLoadItem {	
	Optional<ContainerAction> clickAndLoad(Class<?> clazz); 
}
