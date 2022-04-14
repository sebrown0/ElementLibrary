/**
 * 
 */
package library.common.controls.with_text;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import dynamic_tests.test_adders.TestAdderWithData;
import dynamic_tests.test_elements.DataInserter;
import library.common.controls.data.InsertItem;
import library.common.controls.interfaces.ControlTest;

/**
 * @author SteveBrown
 * @version 1.0
 * 	Initial
 * @since 1.0
 */
public class TextOut extends ControlWithText implements InsertItem {
	private ControlTest controlTest;
	
	public TextOut(WebDriver driver, By locator, ControlTest controlTest) {
		super(driver, locator);
		
		this.controlTest = controlTest;
	}

	@Override
	public void insert(Object item, TestAdderWithData testAdder) {
		DataInserter inserter = 
				testAdder
					.getDataInserter()
						.setControl(this)
						.setControlTest(controlTest);
		
		inserter.insertData();
	}
	
	@Override
	public void insert(String value) {
		setText(value);
	}
}
