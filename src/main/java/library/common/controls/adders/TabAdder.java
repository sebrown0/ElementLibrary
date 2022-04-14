/**
 * 
 */
package library.common.controls.adders;

import java.util.List;

import org.openqa.selenium.By;

import control_builder.control_getters.ControlGetter;
import control_data.ControlData;

/**
 * @author SteveBrown
 * @version 1.0
 * 	Initial
 * @since 1.0
 *
 */
public class TabAdder implements ControlAdder {
	@Override
	public void addElement(ControlGetter controlGetter, List<ControlData> controlData) {
		controlData.add(
				new ControlData(
						controlGetter
								.setParent(By.cssSelector("div[class='tab-content']"))));
	}	
}
