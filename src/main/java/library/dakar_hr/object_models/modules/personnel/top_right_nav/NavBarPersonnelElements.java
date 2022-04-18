package library.dakar_hr.object_models.modules.personnel.top_right_nav;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import core_data.CoreData;
import library.dakar_hr.nav.NavBarElement;
import library.dakar_hr.nav.nav_bar_elements.NavBarDakarIntelligence;
import library.dakar_hr.nav.nav_bar_elements.NavBarElementStrategy;
import library.dakar_hr.nav.nav_bar_elements.NavBarEmpGridView;
import library.dakar_hr.nav.nav_bar_elements.NavBarEmployeeCVPayroll;
import library.dakar_hr.nav.nav_bar_elements.NavBarEmployeeCreation;
import library.dakar_hr.nav.nav_bar_elements.NavBarEmployeeCvHr;
import library.dakar_hr.nav.nav_bar_elements.NavBarMyCoLastViewed;
import library.dakar_hr.nav.nav_bar_elements.NavBarNewEmployments;
import library.dakar_hr.nav.nav_bar_elements.NavBarNotifications;
import library.dakar_hr.nav.nav_bar_elements.NavBarOrganisationChart;
import library.dakar_hr.nav.nav_bar_elements.NavBarTerminations;
import library.dakar_hr.nav.nav_bar_elements.NavBarVisualReports;
import library.dakar_hr.nav.quick_links.QuickLinks;
import library.dakar_hr.nav.quick_links.QuickLinksPersonnel;

/**
 * @author Steve Brown
 * 
 * Set a map of personnel elements for the top right nav bar.
 * 	Key: 	Name of the element.
 * 	Value:	Object representing the element.
 */
public class NavBarPersonnelElements implements NavBarElementStrategy {
	private Map<String, NavBarElement> elements;
	private CoreData coreData;
	
	public NavBarPersonnelElements(CoreData coreData) {
		this.coreData = coreData;
		setElements();
	}

	private void setElements(){
		elements = Stream.of(new Object[][] {
			{NavBarEmployeeCreation.ORIGINAL_NAME, new NavBarEmployeeCreation(coreData)},
			{NavBarEmployeeCVPayroll.ORIGINAL_NAME, new NavBarEmployeeCvHr(coreData)},
			{NavBarEmpGridView.ORIGINAL_NAME, new NavBarEmpGridView(coreData)},			
			{NavBarVisualReports.ORIGINAL_NAME, new NavBarVisualReports(coreData)},
			{NavBarDakarIntelligence.ORIGINAL_NAME, new NavBarDakarIntelligence(coreData)},
			{NavBarOrganisationChart.ORIGINAL_NAME, new NavBarOrganisationChart(coreData)},
			{NavBarMyCoLastViewed.ORIGINAL_NAME, new NavBarMyCoLastViewed(coreData)},			
			{NavBarNotifications.ORIGINAL_NAME, new NavBarNotifications(coreData)},
			{NavBarNewEmployments.ORIGINAL_NAME, new NavBarNewEmployments(coreData)},
			{NavBarTerminations.ORIGINAL_NAME, new NavBarTerminations(coreData)}			
		}).collect(Collectors.toMap(data -> (String) data[0], data -> (NavBarElement) data[1]));		
	}

	@Override
	public Map<String, NavBarElement> getElements() {
		return elements;
	}

	@Override
	public QuickLinks getQuickLinks() {
		return new QuickLinksPersonnel(coreData.getWebDriver());
	}
}