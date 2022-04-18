/**
 * 
 */
package library.common.controls.combos;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core_data.CoreData;
import library.common.exceptions.ElementDoesNotExistException;
import library.dakar_hr.dk_grid.Cell;
import library.dakar_hr.dk_grid.Popup;
import utils.text_writer.TextWriterComboDefault;

/**
 * @author Steve Brown
 * @since 1.0
 * @version 1.0
 */
public final class PopupComboSelect extends ComboWriteAndSelect implements Popup {
	private Cell cell;
	
	public PopupComboSelect(CoreData coreData, WebElement select, Cell cell) {
		super(
				coreData, 
				By.cssSelector("span[class='select2-container select2-container--default select2-container--open']"), 
				By.className("select2-results"), 
				new TextWriterComboDefault(coreData));
	
		this.cell = cell;
		openSelectionContainer(driver, select);
	}
	
	/*
	 * When a cell is double clicked it provides a selection box that
	 * must be clicked again to show the 'dropdown' selection, thus
	 * open the 'select2-container'.
	 */
	private void openSelectionContainer(WebDriver driver, WebElement select) {
		try {
			WebElement arrow = select.findElement(By.className("select2-selection__arrow"));
			arrow.click();	
		} catch (Exception e) {
			new ElementDoesNotExistException("Could not get selection arrow").run();
		}		
	}
	
	/*
	 * Write text as normal but close the
	 * selection afterwards.
	 */
	@Override
	public void writeText(String txt) {
		writer.writeText(txt);
		cell.getMyElement().sendKeys(Keys.ENTER);
	}
	
}
