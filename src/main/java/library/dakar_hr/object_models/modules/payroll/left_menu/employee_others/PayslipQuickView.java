package library.dakar_hr.object_models.modules.payroll.left_menu.employee_others;

import core_data.CoreData;
import library.common.panels.JsPanelWithIFrame;

/**
 * @author Steve Brown
 *
 */
public final class PayslipQuickView extends JsPanelWithIFrame {
	public static final String MENU_TITLE = "Payslip Quick View";
	public static final String PANEL_TITLE = "Payslip Quick View";
	public static final String MENU_PARENT_NAME = "Employee Statistics";
	
	public PayslipQuickView(CoreData coreData) {
		super(coreData, PANEL_TITLE);
	}

	// Elements

	// Tabs
}