/**
 * 
 */
package library.dakar_hr.dk_grid.buttons;

import org.openqa.selenium.WebDriver;

import context_manager.ContextManager;
import library.dakar_hr.enums.GridButtonNames;
import library.dakar_hr.object_models.dialog.DialogOkCancel;
import library.element.ElementButton;

/**
 * @author SteveBrown
 * @version 1.0
 * @since 1.0
 */
public class SaveChanges extends GridButton {
	public SaveChanges(ElementButton elmntBtn) {
		super(elmntBtn, GridButtonNames.BTN_SAVE);
	}
	
	public DialogOkCancel clickButton(WebDriver driver, ContextManager cm) {
		elmntBtn.click();
		return new DialogOkCancel(driver);
	}

}
