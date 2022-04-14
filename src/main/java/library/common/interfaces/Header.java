/**
 * 
 */
package library.common.interfaces;

import java.util.Optional;

/**
 * @author Steve Brown
 *
 */
public interface Header {
	Optional<String> getTitle();
	void closeForm();
}
