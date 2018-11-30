package GIS;

import java.util.Set;
/**
 * This interface represents a GIS project with many layers and its meta data
 * @author Shilo Gilor and Amiel Liberman
 *
 */
public interface GIS_project extends Set<GIS_layer>{
	public Meta_data get_Meta_data(); 
	
}
