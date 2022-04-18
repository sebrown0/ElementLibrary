package library.dakar_hr.object_models.modules.payroll.left_menu.payroll;

import core_data.CoreData;
import library.common.forms.FormModal;

/**
 * @author Steve Brown
 *
 */
public final class CloseAndLockPayroll extends FormModal {
	public static final String MENU_TITLE = "Close & Lock Payroll";
	public static final String PANEL_TITLE = "Close & Lock Payroll";
	public static final String MENU_PARENT_NAME = "Payroll";
	
	public CloseAndLockPayroll(CoreData coreData) {
		super(coreData, PANEL_TITLE);
		setMyContainers();
	}
	
	@Override
	public void setMyContainers() {
		// None		
	}
	
	// Elements

	// Tabs
}