/**
 * 
 */
package library.common.controls.combos;

import org.openqa.selenium.By;

import core_data.CoreData;
import utils.text_utils.RemoveX;
import utils.text_utils.TextExtractor;
import utils.text_utils.TextSanitiser;
import utils.text_writer.TextWriter;

/**
 * @author Steve Brown
 * @since 1.0
 * @version 1.0	
 */
public class ComboWriteAndSelect extends ComboSelectFromList {
	protected TextWriter writer;
	
	public ComboWriteAndSelect(CoreData coreData, By findBy, By resultsBy, TextWriter writer) {
		super(coreData, findBy, resultsBy);
		
		this.writer = writer;
	}
	
	public String getAllText() {	
		return super.getComboElement().getText();
	}
	
	public String getDefaultText() {
		TextExtractor txtExt = new TextExtractor(super.getComboElement(), new RemoveX());
		return txtExt.getFirstOccurenceOfTextFromElement();
	}
	
	public String getText(TextSanitiser sanitiser) {
		TextExtractor txtExt = new TextExtractor(super.getComboElement(), sanitiser);
		return txtExt.getFirstOccurenceOfTextFromElement();
	}
	
	public void writeText(String txt) {
		writer.writeText(txt);
	}
	
}
