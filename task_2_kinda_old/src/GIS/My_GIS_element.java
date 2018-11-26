package GIS;

import Geom.Geom_element;
import Geom.My_geom_element;
import Geom.Point3D;

public class My_GIS_element implements GIS_element{
	
	private String MAC , SSID , AuthMode , FirstSeen , Channel , RSSI , AccuracyMeters , Type;
	private My_geom_element geom;
	private My_meta_data data;
	

	public My_GIS_element(My_geom_element geom, My_meta_data data, String mAC, String sSID, String authMode, String firstSeen, String channel, String rSSI,
			String accuracyMeters, String type) {
		super();
		MAC = mAC;
		SSID = sSID;
		AuthMode = authMode;
		FirstSeen = firstSeen;
		Channel = channel;
		RSSI = rSSI;
		AccuracyMeters = accuracyMeters;
		Type = type;
		this.geom = geom;
		this.data = data;
	}

	@Override
	public Geom_element getGeom() {
		return geom;
	}

	@Override
	public Meta_data getData() {
		return data;
	}

	@Override
	public void translate(Point3D vec) {
		// TODO Auto-generated method stub
		
	}

	public Point3D getMy_geom() {
		return geom.getMy_geom();
	}

	public String getSSID() {
		return SSID;
	}
	
	public String getMAC() {
		return MAC;
	}
	public String getAuthMode() {
		return AuthMode;
	}

	public String getFirstSeen() {
		return FirstSeen;
	}

	public String getChannel() {
		return Channel;
	}

	public String getRSSI() {
		return RSSI;
	}

	public String getAccuracyMeters() {
		return AccuracyMeters;
	}

	public String getType() {
		return Type;
	}

	public String toStringOfGISElements() {
		
		return "\t<Placemark>\n" +
				"\t<name><![CDATA[" + SSID + "]]></name>\n" +
				"<ExtendedData>\n 	     <Data name=\"MAC\">"
				+ "  <value>" + MAC + "</value>"
				+ "    </Data>      <Data name=\"AuthMode\">	  "
				+ "  <value>" + AuthMode + "</value>"
				+ "    </Data>      <Data name=\"FirstSeen\">	  "
				+ "  <value>" + FirstSeen + "</value>"
				+ "    </Data>      <Data name=\"Channel\">	  "
				+ "  <value>" + Channel + "</value>"
				+ "    </Data>      <Data name=\"RSSI\">	  "
				+ "  <value>" + RSSI + "</value>"
				+ "    </Data>      <Data name=\"AccuracyMeters\">	  "
				+ "  <value>" + AccuracyMeters + "</value>"
				+ "    </Data>      <Data name=\"Type\">	  "
				+ "  <value>" + Type + "</value>"
				+ "  </Data>	   "
				+ " </ExtendedData>"
				+"<styleUrl>#red</styleUrl>\n"+
				"\t<Point>\n" +
				"\t\t<coordinates>"+getMy_geom().x()+","+getMy_geom().y()+","+getMy_geom().z()+ "</coordinates>\n" +
				"\t</Point>\n" +
				"\t</Placemark>\n";
	}


}
