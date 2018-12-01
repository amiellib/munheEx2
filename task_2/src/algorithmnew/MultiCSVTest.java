package algorithmnew;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.text.ParseException;

import org.junit.jupiter.api.Test;

import GIS.My_GIS_layer;
import GIS.My_GIS_project;

class MultiCSVTest {

	@Test
	void testConvertCSVToKML() {
		MultiCSV multiCSV = new MultiCSV() ;
		try {
			My_GIS_project GIS_proj=multiCSV.multiCSV("/Users/shilo/Desktop/kmls","/Users/shilo/Desktop/kmls","test");
		} catch (NumberFormatException | IOException | ParseException e) {
			fail("file cant be found , or written");
			e.printStackTrace();
		} 
	}

	@Test
	void testMultiCSV() {
		MultiCSV multiCSV = new MultiCSV() ;
		try {
			My_GIS_layer GIS_proj=multiCSV.convertCSVToKML("/Users/shilo/Desktop/kmls/WigleWifi_20171201110209.csv");
		} catch (NumberFormatException | IOException | ParseException e) {
			fail("file cant be found , or written");
			e.printStackTrace();
		}

	}

}
