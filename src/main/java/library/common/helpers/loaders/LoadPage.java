/**
 * 
 */
package library.common.helpers.loaders;

import library.common.exceptions.IncorrectPageException;

/**
 * @author SteveBrown
 *
 */
public interface LoadPage {
	void loadUsingURI() throws IncorrectPageException;
}
