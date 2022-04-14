package library.dakar_hr.object_models.modules.payroll.left_menu.absence_statistics;

import library.common.panels.JsPanelWithIFrame;
import library.dakar_hr.pages.homepage.CoreData;

/**
 * @author Steve Brown
 *
 */
public final class EmployeeAccruals extends JsPanelWithIFrame {
	public static final String MENU_TITLE = "Employee Accruals";
	public static final String PANEL_TITLE = "Leave Accruals";
	public static final String MENU_PARENT_NAME = "Absence Statistics";

	public EmployeeAccruals(CoreData coreData) {
		super(coreData, PANEL_TITLE);
	}

	// Elements

	// Tabs
}