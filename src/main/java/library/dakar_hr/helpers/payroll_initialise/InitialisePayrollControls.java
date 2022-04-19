package library.dakar_hr.helpers.payroll_initialise;

import java.util.List;

import org.openqa.selenium.By;

import control_data.ControlData;
import factories.ControlDataFactory;
import library.common.controls.interfaces.ControlTest;
import library.dakar_hr.enums.control_names.CommonControlNames;
import library.dakar_hr.enums.control_names.PayrollControlNames;
import library.element.ElementControls;

/**
 * @author SteveBrown
 * @version 1.0
 * 	Initial
 * @since 1.0
 * 
 * The controls that are in the body (iFrame) of the form.
 * Other controls, i.e. the close button are got dynamically.
 * 
 */
public class InitialisePayrollControls implements ElementControls {
	private ControlDataFactory controlFactory;
	private ControlTest controlTest;
	
	/*
	 * Passing ControlTest because buildButton requires it.
	 * This is because dynamic tests require the ControlTest (panel)
	 * to load/get the control for loading test data.
	 * 
	 * TODO - Replace this with site mapped version.
	 */
	public InitialisePayrollControls(ControlDataFactory controlFactory, ControlTest controlTest) {
		this.controlFactory = controlFactory;		
	}

	@Override
	public List<ControlData> getControls() {
		return List.of(
			controlFactory
				.buildTextSelect(
						CommonControlNames.COMPANY, 
						By.cssSelector("select[name='SelectComp']"))
				.getControlData(),
			
			controlFactory
				.buildTextSelect(
						PayrollControlNames.PAY_GROUP, 
						By.cssSelector("select[name='SelectPayg']"))
				.getControlData(),
			
			controlFactory
				.buildTextSelect(
						PayrollControlNames.PAY_PERIODS, 
						By.cssSelector("select[name='SelectPays']"))
				.getControlData(),
			
			controlFactory
				.buildButton(
						CommonControlNames.CLOSE,
						By.cssSelector("button[class='btn btn-primary']"), controlTest)
				.getControlData(),		
				
			controlFactory
				.buildButton(
						PayrollControlNames.INIT_PAYROLL,
						By.cssSelector("div[type='button'][class='btn btn-warning']"), controlTest)
				.getControlData()		
		);	
	}

}