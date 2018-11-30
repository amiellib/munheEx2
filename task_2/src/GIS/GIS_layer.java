package GIS;
import java.util.Set;
/**
 * This interface represents a GIS layer with many elements
 * @author Shilo Gilor and Amiel Liberman
 *
 */
public interface GIS_layer extends Set<GIS_element>{
	public Meta_data get_Meta_data(); 
	
}
