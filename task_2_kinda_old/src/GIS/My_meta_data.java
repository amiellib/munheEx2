package GIS;

import Geom.Point3D;

public class My_meta_data implements Meta_data{

	private long UTC;
	private Point3D orientation;
	private String colour;
	public My_meta_data(long UTC, Point3D orientation , String colour) {
		super();
		this.UTC = UTC;
		this.orientation = orientation;
		this.colour = colour;
	}
	@Override
	public long getUTC() {
		return UTC;
	}

	@Override
	public Point3D get_Orientation() {
		return orientation;
	}
	
	@Override
	public String toString() {
		return "My_meta_data [UTC=" + UTC + ", orientation=" + orientation + "]";
	}
	public String getColour() {
		return colour;
	}

}
