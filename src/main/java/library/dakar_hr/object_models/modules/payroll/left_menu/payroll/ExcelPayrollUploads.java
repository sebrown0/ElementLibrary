package library.dakar_hr.object_models.modules.payroll.left_menu.payroll;

import core_data.CoreData;
import library.common.panels.JsPanelWithIFrame;

/**
 * @author Steve Brown
 *
 */
public final class ExcelPayrollUploads extends JsPanelWithIFrame {
	public static final String MENU_TITLE = "Excel Payroll Uploads";
	public static final String PANEL_TITLE = "Excel Payroll Adjustment Uploads";
	public static final String MENU_PARENT_NAME = "Payroll";
	
	public ExcelPayrollUploads(CoreData coreData) {
		super(coreData, PANEL_TITLE);
	}

	// Elements

	// Tabs
}