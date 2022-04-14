package library.dakar_hr.object_models.modules.payroll.left_menu;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DynamicTest;
import org.openqa.selenium.By;

import control_builder.control_getters.ControlGetter;
import control_builder.control_getters.group.ControlGetterGroup;
import control_builder.control_getters.group.ControlGetterInputGroup;
import control_builder.control_getters.single.ControlGetterTextOut;
import control_data.ControlData;
import dynamic_tests.annotations.TestControl;
import library.common.panels.JsPanelWithIFrame;
import library.dakar_hr.pages.homepage.CoreData;
import site_mapper.annotations.SiteMap;


/**
* Generated Class.
* ----------------
* Source:  C:/Users/SteveBrown/eclipse-workspace/2021/DTest/src/main/resources/site_map/site_map.xml
* Author:  SteveBrown
* Version: 1.0.0
* Created: 08/04/2022 14:15:12
*/

@SuppressWarnings("unused")
public class Documents extends JsPanelWithIFrame {
	@SiteMap(author="SteveBrown", version="1.0.0", date="08/04/2022")
	public static final String PANEL_TITLE = "Employee Document Management";
	@SiteMap(author="SteveBrown", version="1.0.0", date="08/04/2022")
	public static final String MENU_TITLE = "Documents";
	@SiteMap(author="SteveBrown", version="1.0.0", date="08/04/2022")
	public static final String MENU_PARENT_NAME = "";

	@SiteMap(author="SteveBrown", version="1.0.0", date="08/04/2022")
	public Documents(){}

	@SiteMap(author="SteveBrown", version="1.0.0", date="08/04/2022")
	public Documents(CoreData coreData){
		super(coreData, PANEL_TITLE);
		buildMyControls();
	}

	@SiteMap(author="SteveBrown", version="1.0.0", date="08/04/2022")
	private void buildMyControls() {
		ControlGetter formID =
			new ControlGetterTextOut("FormID", coreData, By.id("FORM_ID"), this);
		ControlGetterGroup empLookup =
			new ControlGetterInputGroup("EmpLookup", coreData, By.cssSelector("div[class='input-group']"))
				.addControls(Arrays.asList(formID));
		var myControls =
			List.of(
				new ControlData(empLookup)
			);
		super.buildPanelControls(myControls);
	}



	@SiteMap(author="SteveBrown", version="1.0.0", date="08/04/2022")
	@TestControl(type="element", subtype="TextOut")
	public DynamicTest TextOutFormIDFunctionTest () {
		return DynamicTest.dynamicTest("[TextOutFormIDFunctionTest] *NOT IMPLEMENTED*", () -> assertTrue(true));
	}

}