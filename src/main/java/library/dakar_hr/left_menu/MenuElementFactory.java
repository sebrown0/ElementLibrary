/**
 * 
 */
package library.dakar_hr.left_menu;

import library.common.forms.ContainerAction;

/**
 * @author SteveBrown
 * @version 1.0
 * 	Initial
 * @since 1.0
 */
public interface MenuElementFactory {
	ContainerAction getElementForName(String elementName);
}
