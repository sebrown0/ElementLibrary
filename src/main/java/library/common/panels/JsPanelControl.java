/**
 * 
 */
package library.common.panels;

import java.util.Optional;

import library.common.controls.interfaces.Control;
import library.common.controls.interfaces.ControlName;

/**
 * @author SteveBrown
 * @version 1.0
 * @since 1.0
 *
 */
public interface JsPanelControl {
	Optional<Control> getControl(ControlName cntrlName);
}
