package File_format;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.text.ParseException;

import org.junit.jupiter.api.Test;

import GIS.My_GIS_layer;
import algorithmnew.MultiCSV;

class Csv2kmlTest {

	@Test
	void testConvertCSVToKML() {
		Csv2kml  csv2kml= new Csv2kml() ;
		try {
			My_GIS_layer GIS_proj=csv2kml.convertCSVToKML("/Users/shilo/Desktop/kmls/WigleWifi_20171201110209.csv","/Users/shilo/Desktop/kmls","testsinglecsv");
		} catch (NumberFormatException | IOException | ParseException e) {
			fail("file didnt load");
			e.printStackTrace();
		}
	}
}
