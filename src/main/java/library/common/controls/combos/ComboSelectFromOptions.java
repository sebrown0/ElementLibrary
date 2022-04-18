/**
 * 
 */
package library.common.controls.combos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core_data.CoreData;

/**
 * @author Steve Brown
 *
 * Can only select an item from an existing list.
 * 
 */
public class ComboSelectFromOptions extends Combo {

	public ComboSelectFromOptions(CoreData coreData, WebElement combo, By locator) {
		super(coreData, combo, locator);	
	}

}
