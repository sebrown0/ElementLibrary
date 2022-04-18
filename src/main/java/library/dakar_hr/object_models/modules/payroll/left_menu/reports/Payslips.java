package library.dakar_hr.object_models.modules.payroll.left_menu.reports;

import core_data.CoreData;
import library.common.panels.JsPanelWithIFrame;

/**
 * @author Steve Brown
 *
 */
public final class Payslips extends JsPanelWithIFrame {
	public static final String MENU_TITLE = "Payslips";
	public static final String PANEL_TITLE = "Payslips";
	public static final String MENU_PARENT_NAME = "Reports";

	public Payslips(CoreData coreData) {
		super(coreData, PANEL_TITLE);
	}

	// Elements

	// Tabs
}