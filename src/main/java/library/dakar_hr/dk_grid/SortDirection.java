/**
 * 
 */
package library.dakar_hr.dk_grid;

/**
 * @author Steve Brown
 *
 */
public enum SortDirection {
	NONE("eSortNone"), 
	ASC("eSortAsc"), 
	DESC("eSortDesc");
	
	private final String dir;
	
	private SortDirection(String dir) {
		this.dir = dir;
	}

	public String getRef() {
		return dir;
	}
}
