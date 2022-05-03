/**
 * 
 */
package library.utils;

/**
 * @author SteveBrown
 * @version 1.0
 * @since 1.0
 * 
 * Any library used by SiteMapper or DTest
 * should implement this so that the path 
 * to the XML file used can be found.
 * 
 */
public interface XmlFileLocator {
	String getPathToFile();
}
