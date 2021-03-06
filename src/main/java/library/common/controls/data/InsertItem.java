/**
 * 
 */
package library.common.controls.data;

import root.test_adders.TestAdderWithData;

/**
 * @author SteveBrown
 * @version 1.0
 * @since 1.0
 */
public interface InsertItem {
	/* 
	 * Use a TestDataInserter, 
	 * (found from the item's insertWith) 
	 * to insert the value.
	 * 
	 */
	void insert(Object item, TestAdderWithData testAdder);
//	void insert(Object item, Object testAdder);
	/*
	 * No TestDataInserter is specified so try using send keys
	 * on the control. 
	 */
	void insert(String value);
}
