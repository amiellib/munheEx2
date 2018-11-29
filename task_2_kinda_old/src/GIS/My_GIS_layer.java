package GIS;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class My_GIS_layer implements GIS_layer{
	

    private Set<GIS_element> my_set = new HashSet<GIS_element>();
	private My_meta_data data;


	public My_GIS_layer(My_meta_data data) {
		super();
		this.data = data;
	}
	
	@Override
	public int size() {
		
		return my_set.size();
	}


	@Override
	public boolean isEmpty() {
		return my_set.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return my_set.contains(o);
	}

	@Override
	public Iterator<GIS_element> iterator() {
		return my_set.iterator();
	}

	@Override
	public Object[] toArray() {
		return my_set.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return my_set.toArray(a);
	}

	@Override
	public boolean add(GIS_element e) {
		
		return my_set.add(e);
	}

	@Override
	public boolean remove(Object o) {
		return my_set.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return my_set.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends GIS_element> c) {
		return my_set.addAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return my_set.retainAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return my_set.removeAll(c);
	}

	@Override
	public void clear() {
		my_set.clear();		
	}

	@Override
	public Meta_data get_Meta_data() {
		return data;
	}


	public String toStringOfGISLayer() 
	{
		String final_string ="<Folder><name>Wifi Networks</name>"
				+"<Style>"
				+ "<LineStyle>\n" + 
				"    <color>"+ data.getColour()+"</color>\n" + 
				"  </LineStyle>\n" + 
				"</Style>";
		for(GIS_element element: my_set)
		{
			final_string+= ((My_GIS_element)element).toStringOfGISElements();
		}
		final_string +=  "    </Folder>\n";
		return final_string;
	}
	
}
