package library.dakar_hr.object_models.modules.payroll.left_menu.employee_others;

import library.common.panels.JsPanelWithIFrame;
import library.dakar_hr.pages.homepage.CoreData;

/**
 * @author Steve Brown
 *
 */
public final class EmployeePayrollStatistics extends JsPanelWithIFrame {
	public static final String MENU_TITLE = "Employee Payroll Statistics";
	public static final String PANEL_TITLE = "Payroll Other Statistics";
	public static final String MENU_PARENT_NAME = "Employee Statistics";
	
	public EmployeePayrollStatistics(CoreData coreData) {
		super(coreData, PANEL_TITLE);
	}

	// Elements

	// Tabs
}