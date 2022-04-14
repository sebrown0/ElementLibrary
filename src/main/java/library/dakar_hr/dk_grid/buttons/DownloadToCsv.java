/**
 * 
 */
package library.dakar_hr.dk_grid.buttons;

import library.dakar_hr.enums.GridButtonNames;
import library.element.ElementButton;


/**
 * @author SteveBrown
 * @version 1.0
 * @since 1.0
 */
public class DownloadToCsv extends GridButton {
	public DownloadToCsv(ElementButton elmntBtn) {
		super(elmntBtn, GridButtonNames.BTN_DOWNLOAD_TO_CSV);
	}
}
