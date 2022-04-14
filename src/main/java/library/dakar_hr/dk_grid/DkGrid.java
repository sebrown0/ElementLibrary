/**
 * 
 */
package library.dakar_hr.dk_grid;

import java.time.Duration;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import context_manager.ContextManager;
import library.common.controls.getters.ElementGetter;
import library.common.controls.interfaces.Control;
import library.dakar_hr.dk_grid.buttons.GridButton;
import library.dakar_hr.dk_grid.buttons.SaveChanges;
import library.dakar_hr.enums.GridButtonNames;
import library.dakar_hr.object_models.dialog.DialogOkCancel;

/**
 * @author Steve Brown
 * @since 1.0
 * @version 1.0 
 */
public class DkGrid <T extends KeyStrategyRow> implements Control {
	private DkGridToolBarReader toolBarReader;
	private DkGridContentReader<?> contentReader;
	
	private DkGridToolBar toolBar;
	private DkGridHeader gridHeader;	
	private DkGridContent<T> gridContent;

	private WebElement myContainer;
	private WebDriver driver;
	private By locator;
	private KeyStrategyRow keyStrategyRows;
	private WebDriverWait wait;		 
	private ContextManager contextManager;
	private boolean gridLoaded;
	private boolean toolBarLoaded;
	private boolean contentLoaded;
	
	public DkGrid(WebDriver driver, By locator, KeyStrategyRow keyStrategyRows, ContextManager cm) {
		this.driver = driver;
		this.locator = locator;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		this.setGridElement(driver);
		this.setColumnHeaders();
		this.keyStrategyRows = keyStrategyRows;
		this.toolBar = new DkGridToolBar();
		this.gridContent = new DkGridContent<>();
		this.toolBarReader = new DkGridToolBarReader(driver, toolBar);
		this.contentReader = new DkGridContentReader<>(myContainer, gridContent, keyStrategyRows, gridHeader);
		this.contextManager = cm;
	}
	
	private void setGridElement(WebDriver driver) {
		By contentLocator = By.id("dkrGrid");		
		wait.until(ExpectedConditions.visibilityOfElementLocated(contentLocator)); 	
		myContainer = driver.findElement(contentLocator);			
	}
	
	private void setColumnHeaders() {
		gridHeader = new DkGridHeader();		
		gridHeader.setColumnHeaders(myContainer);
	}
	
	public DkGridHeader getGridHeader() {
		return gridHeader;
	}
	
	public DkGrid<T> loadGridIfNecessary() {
		if(!gridLoaded) {
			loadToolBar();
			loadContent();	
		}		
		return this;
	}
	
	public DkGridToolBar getToolBar() {
		if(!toolBarLoaded) {
			loadToolBar();
		}
		return toolBar;
	}
	private void loadToolBar() {
		toolBarReader.read();
		toolBarLoaded = true;
	}	
		
	public DkGridContent<T> getLoadedContent() {
		if(!contentLoaded) {
			loadContent();
		}
		return gridContent;
	}
	private void loadContent() {
		contentReader.readContent();
		contentLoaded = true;
	}
	public void reloadAllContent() {
		gridContent = new DkGridContent<>();
		contentReader = new DkGridContentReader<>(myContainer, gridContent, keyStrategyRows, gridHeader);
		loadContent();
	}
	
	private void reloadWithNewRow() {		
		getReader().readFirstRow();		
	}
	
	private DkGridContentReader<?> getReader(){
		if(contentReader == null) {
			contentReader = new DkGridContentReader<>(myContainer, getContent(), keyStrategyRows, gridHeader);
		}
		return contentReader;
	}
	
	private DkGridContent<T> getContent() {
		if(gridContent == null) {
			gridContent = new DkGridContent<>();
		}
		return gridContent;
	}
	
	public Cell getCell(Row<?> row, String colName) {
		return gridContent.getCell(row.getRowIdx(), colName);
	}
	public Cell getCell(Integer rowIdx, String colName) {
		return gridContent.getCell(rowIdx, colName);
	}
	
	public DialogOkCancel saveRecord() {
		Optional<GridButton> addRec = getToolBar().getButton(GridButtonNames.BTN_SAVE);
		DialogOkCancel frm = null;
		
		if(addRec.isPresent()) {
			SaveChanges save = (SaveChanges) addRec.get(); 
			frm = save.clickButton(driver, contextManager);
		}
		return frm;
	}
	
	public void addRecord() {
		Optional<GridButton> addRec = getToolBar().getButton(GridButtonNames.BTN_ADD);
		addRec.ifPresent(a -> { 
			a.clickButton();
			reloadWithNewRow();
		});		
	}
	
	public void printContent() {
		gridContent.getRows().entrySet().forEach(e -> {
			System.out.println("Row Num: " + e.getKey()); 
			e.getValue().getCells().forEach(c -> {
				System.out.println("  " + c.getColName() + ":" + c.getOriginalValue().get()); 	
			});
		});
	}
	
	@Override // Control
	public boolean isAvailable() {
		myContainer = new ElementGetter(driver).getElementIfClickable(this);
		return (myContainer != null) ? true : false;
	}	
	
	@Override //Control
	public By getLocator() {
		return locator;
	}

	@Override //Control
	public WebDriver getDriver() {
		return driver;
	}	

	@Override //Control
	public WebElement getElement() {
		return myContainer;
	}
	/*
	 * Was having problems with reloading content.
	 * Changing the selector for the content seems 
	 * to have solved it.
	 * However, if problems continue reinstate this.
	 */
//	private void waitForContent() {
//		int findRowNum = gridContent.getLastRowNum() + 1;
//		By contentLocator = By.xpath("//div[@role='row' and @row-index='" + findRowNum + "']");		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(contentLocator));
//	}
}
