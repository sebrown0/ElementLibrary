/**
 * 
 */
package library.dakar_hr.providers.employee;

import library.dakar_hr.dto.Employee;

/**
 * @author SteveBrown
 * @version 1.0
 *  Initial
 * @since 1.0
 *
 */
public interface RandomEmployeeProvider {
	Employee getAnyEmpWithRandomCode();
}
