/**
 * 
 */
package library.common.exceptions;

/**
 * @author Steve Brown
 *
 */
public class IncorrectPageException extends Exception {
	private static final long serialVersionUID = 1L;

	public IncorrectPageException(String errMsg) {
		super(errMsg);
	}
}
