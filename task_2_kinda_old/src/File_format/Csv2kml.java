package File_format;

import Geom.My_geom_element;
import Geom.Point3D;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import GIS.My_GIS_layer;
import GIS.My_GIS_project;
import GIS.My_GIS_element;
import GIS.My_meta_data;

/**
 * 
 * @author Shilo Gilor and Amiel Liberman
 *
 */
public class Csv2kml 
{

	public My_GIS_layer convertCSVToKML(String path_of_csv,String path_of_kml_end_point, String kml_file_name) throws IOException
	{
		
		My_GIS_layer gis_layer = new My_GIS_layer(new My_meta_data(new Date().getTime(), null));	
		String kmlstart = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
				"<kml xmlns=\"http://www.opengis.net/kml/2.2\">\n"
				+ "<Document><Style id=\"red\"><IconStyle><Icon>"
				+ "<href>http://maps.google.com/mapfiles/ms/icons/red-dot.png</href>"
				+ "</Icon></IconStyle>"
				+ "</Style><Style id=\"yellow\"><IconStyle><Icon>"
				+ "<href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png"
				+ "</href></Icon></IconStyle></Style>"
				+ "<Style id=\"green\"><IconStyle><Icon>"
				+ "<href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href></Icon>"
				+ "</IconStyle></Style><Folder><name>Wifi Networks</name>";
		BufferedReader br = new BufferedReader(new FileReader(path_of_csv));
		br.readLine();
		br.readLine();
		String line = br.readLine();
		String  kmlmiddle = "";
		while (line != null && !line.isEmpty()) {
			if((line.replaceAll(",","")).replaceAll(" ","").isEmpty())
				break;
			String[] row = line.split(",");
			My_GIS_element gis_element = new My_GIS_element(new My_geom_element(Double.parseDouble(row[7]),Double.parseDouble(row[6]),Double.parseDouble(row[8]))
					, null, row[0], row[1], row[2], row[3], row[4], row[5], row[9] , row[10]);
			gis_layer.add(gis_element);
			kmlmiddle = kmlmiddle + gis_element.toStringOfGISElements();
			line = br.readLine();
		}
		String kmlend = "    </Folder>\n" + 
				"  </Document> \n </kml>";
		String kmldata = kmlstart + kmlmiddle + kmlend;
		Writer fwriter;
		try {
			fwriter = new FileWriter(path_of_kml_end_point+kml_file_name+".kml");
			fwriter.write(kmldata);
			fwriter.flush();
			fwriter.close();
		}catch (IOException e1) {
			e1.printStackTrace();
		}   
		return gis_layer;
	}
	public My_GIS_project multiCSV(String dir) throws IOException
	{
		My_GIS_project gis_project = new My_GIS_project(null);
		int i=0;
		File[] filesInDirectory = new File(dir).listFiles();
		for(File f : filesInDirectory)
		{
			String filePath = f.getAbsolutePath();
			String fileExtenstion = filePath.substring(filePath.lastIndexOf(".") + 1,filePath.length());
			if("csv".equals(fileExtenstion))
			{
				i++;
				gis_project.add(convertCSVToKML(filePath, "/Users/shilo/Desktop/", "kmltest_"+i));
			}
		}
		return gis_project;
	}
}
