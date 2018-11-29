package algorithmnew;

import java.io.IOException;

import GIS.My_GIS_project;


public class main {

	public static void main(String[] args) throws IOException {
		MultiCSV multiCSV = new MultiCSV() ;
		My_GIS_project GIS_proj=multiCSV.multiCSV("C:\\Users\\amiel\\Desktop\\Ex2 munhe\\Ex2\\data","C:\\Users\\amiel\\Desktop\\Ex2 munhe\\Ex2\\data","test");
		
	}

}
