/**
 * 
 */
package library.common.controls.getters;

import java.util.Optional;

import library.common.controls.interfaces.Control;

/**
 * @author SteveBrown
 * @version 1.0
 * 	Initial
 * @since 1.0
 */
public interface PanelControlGetter <R extends Control> {
	Optional<R> getControl();
}
