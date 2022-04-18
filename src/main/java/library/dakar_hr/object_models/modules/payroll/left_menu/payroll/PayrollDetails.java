package library.dakar_hr.object_models.modules.payroll.left_menu.payroll;

import core_data.CoreData;
import library.common.panels.JsPanelWithIFrame;

/**
 * @author Steve Brown
 *
 */
public final class PayrollDetails extends JsPanelWithIFrame {
	public static final String MENU_TITLE = "Payroll Details";
	public static final String PANEL_TITLE = "PAY_DETAILS";
	public static final String MENU_PARENT_NAME = "Payroll";
	
	public PayrollDetails(CoreData coreData) {
		super(coreData, PANEL_TITLE);
	}

	// Elements

	// Tabs
}