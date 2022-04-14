package library.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import library.date_picker.DatePickerDay;
import library.date_picker.DateSetter;

public final class ElementPointInTime {
	private WebDriver driver;
	private WebElement element;
	
	public ElementPointInTime(WebDriver driver, WebElement element) {
		this.driver = driver;
		this.element = element;
	}

	public DateSetter click() {
		element.click();
		return new DatePickerDay(driver);
	}
}
