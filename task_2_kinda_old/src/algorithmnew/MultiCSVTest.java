package algorithmnew;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.text.ParseException;

import org.junit.jupiter.api.Test;

import GIS.My_GIS_project;

class MultiCSVTest {

	@Test
	void testConvertCSVToKML() throws IOException, NumberFormatException, ParseException {
		MultiCSV multiCSV = new MultiCSV() ;
		My_GIS_project GIS_proj=multiCSV.multiCSV("C:\\Users\\amiel\\Desktop\\Ex2 munhe\\Ex2\\data","C:\\Users\\amiel\\Desktop\\Ex2 munhe\\Ex2\\data","test");
		
	}

	@Test
	void testMultiCSV() {
		
	}

}
