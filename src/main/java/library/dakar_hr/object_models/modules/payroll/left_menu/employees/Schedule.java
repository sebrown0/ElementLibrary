package library.dakar_hr.object_models.modules.payroll.left_menu.employees;

import core_data.CoreData;
import library.common.panels.JsPanelWithIFrame;

/**
 * @author Steve Brown
 *
 */
public class Schedule extends JsPanelWithIFrame {
	public static final String MENU_TITLE = "Schedule";
	public static final String PANEL_TITLE = MENU_TITLE;	
	public static final String MENU_PARENT_NAME = "Employees";
	
	public Schedule(CoreData coreData) {
		super(coreData, PANEL_TITLE);
	}

	// Elements

	// Tabs
}
