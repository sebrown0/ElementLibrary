/**
 * 
 */
package library.dakar_hr.dto;

import java.math.BigDecimal;

/**
 * @author Steve Brown
 *
 */

public class Allowance {	
	private String allowanceName;
	private BigDecimal allowanceAmount;
	
	public Allowance(String allowanceName, BigDecimal allowanceAmount) {
		this.allowanceName = allowanceName;
		this.allowanceAmount = allowanceAmount;
	}

	@Override
	public String toString() {
		return String.format("Allowance [allowanceName=%s, allowanceAmount=%s]", allowanceName, allowanceAmount);
	}

	public String getAllowanceName() {
		return allowanceName;
	}

	public BigDecimal getAllowanceAmount() {
		return allowanceAmount;
	}

	public void setAllowanceName(String allowanceName) {
		this.allowanceName = allowanceName;
	}

	public void setAllowanceAmount(BigDecimal allowanceAmount) {
		this.allowanceAmount = allowanceAmount;
	}	
	
	
}
