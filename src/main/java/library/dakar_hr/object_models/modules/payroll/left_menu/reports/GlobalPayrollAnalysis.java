package library.dakar_hr.object_models.modules.payroll.left_menu.reports;

import library.common.panels.JsPanelWithIFrame;
import library.dakar_hr.pages.homepage.CoreData;

/**
 * @author Steve Brown
 *
 */
public final class GlobalPayrollAnalysis extends JsPanelWithIFrame {
	public static final String MENU_TITLE = "Global Payroll Analysis";
	public static final String PANEL_TITLE = "Global Payroll Reports";
	public static final String MENU_PARENT_NAME = "Reports";

	public GlobalPayrollAnalysis(CoreData coreData) {
		super(coreData, PANEL_TITLE);
	}

	// Elements

	// Tabs
}