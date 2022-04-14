/**
 * 
 */
package library.dakar_hr.dk_grid;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import library.dakar_hr.dk_grid.buttons.GridButton;
import library.dakar_hr.enums.GridButtonNames;
import library.element.ElementInput;
import library.element.ElementPointInTime;

/**
 * @author Steve Brown
 * @since 1.0
 * @version 1.0 
 */
public class DkGridToolBar {
	private Map<String, GridButton> buttons = new HashMap<>();
	private Optional<ElementInput> overallFilter;
	private Optional<ElementPointInTime> pointInTime;
	
	/*
	 * Buttons
	 */
	public void addButton(GridButton btn) {	
		buttons.putIfAbsent(btn.buttonName().getName(), btn);
	}
	
	public Optional<GridButton> getButton(GridButtonNames key){
		Optional<GridButton>  btn = Optional.ofNullable(buttons.get(key.getName()));
		return btn;
	}
	public Map<String, GridButton> getButtons() {
		return buttons;
	}
	/*
	 * Overall Filter
	 */
	public void setOverallFilter(ElementInput overallFilter) {
		this.overallFilter = Optional.ofNullable(overallFilter);
	}
	public Optional<ElementInput> getOverallFilter() {
		return overallFilter;
	}
	/*
	* Point in time
	*/
	public void setPointInTime(ElementPointInTime pit) {
		this.pointInTime = Optional.ofNullable(pit);
	}
	public Optional<ElementPointInTime> getPointInTime() {
		return pointInTime;
	}
}
