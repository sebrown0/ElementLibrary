/**
 * 
 */
package library.legacy_dakar.element;

import library.element.DataKey;
import library.legacy_dakar.enums.GridButtonNames;

//import library.dakar_hr.enums.GridButtonNames;

/**
 * @author Steve Brown
 *
 */
public class ButtonData implements DataKey {
	private GridButtonNames name;
	private String faFa;
	
	public ButtonData(GridButtonNames name) {
		this.name = name;	
	}
	
	public ButtonData(GridButtonNames name, String faFa) {
		this.name = name;
		this.faFa = faFa;
	}
	
	public String getBtnName() {
		return name.getName();
	}
	public void setBtnName(GridButtonNames name) {
		this.name = name;
	}
	public String getBtnFaFa() {
		return faFa;
	}
	public void setBtnFaFa(String faFa) {
		this.faFa = faFa;
	}

	
	@Override // DataKey
	public String getDataKey() {
		return getBtnFaFa();
	}	
	
}
