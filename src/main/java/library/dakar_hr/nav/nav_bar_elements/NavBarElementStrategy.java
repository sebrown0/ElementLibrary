/**
 * 
 */
package library.dakar_hr.nav.nav_bar_elements;

import java.util.Map;

import library.dakar_hr.nav.NavBarElement;
import library.dakar_hr.nav.quick_links.QuickLinks;

/**
 * @author SteveBrown
 *
 */
public interface NavBarElementStrategy {
	Map<String, NavBarElement> getElements();
	QuickLinks getQuickLinks();
}
