package library.dakar_hr.object_models.modules.payroll.left_menu.payroll;

import core_data.CoreData;
import library.common.panels.JsPanelWithIFrame;

/**
 * @author Steve Brown
 *
 */
public final class CalculatePayroll extends JsPanelWithIFrame {
	public static final String MENU_TITLE = "Calculate Payroll";
	public static final String PANEL_TITLE = "Payroll Calculation";;
	public static final String MENU_PARENT_NAME = "Payroll";
	
	public CalculatePayroll(CoreData coreData) {
		super(coreData, PANEL_TITLE);
	}

	// Elements

	// Tabs
}