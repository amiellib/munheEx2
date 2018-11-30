package algorithmnew;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import GIS.My_GIS_element;
import GIS.My_GIS_layer;
import GIS.My_GIS_project;
import GIS.My_meta_data;
import Geom.My_geom_element;

/**
 * This class takes a path and converts all CSV files in the  to 1 kml file 
 * @author Shilo Gilor and Amiel Liberman
 *
 */
public class MultiCSV {
	/**
	 * 
	 * @param path_of_csv the path of the CSV where needed to convert to a GIS layer
	 * @return a GIS layer full with the data in the CSV file
	 * @throws IOException Exception
	 * @throws NumberFormatException Exception
	 * @throws ParseException Exception
	 */
	public My_GIS_layer convertCSVToKML(String path_of_csv) throws IOException, NumberFormatException, ParseException
	{
		
		My_GIS_layer gis_layer = new My_GIS_layer(new My_meta_data(new Date().getTime(), null , "7f00ffff"));	
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
					, new My_meta_data((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(row[3])).getTime(), null, "red"),
					row[0], row[1], row[2], row[4], row[5], row[9] , row[10]);
			gis_layer.add(gis_element);
			kmlmiddle = kmlmiddle + gis_element.toStringOfGISElements("50147814");
			line = br.readLine();
		}  
		return gis_layer;
	}
	/**
	 * 
	 * @param dir  the path of the files where needed to convert the csv's
	 * @param out_dir the path of the location to save the KML file
	 * @param out_name the name to give the KML file
	 * @return a GIS project full with the data in the file path
	 * @throws IOException Exception
	 * @throws NumberFormatException Exception
	 * @throws ParseException Exception
	 */
	public My_GIS_project multiCSV(String dir,String out_dir,String out_name) throws IOException, NumberFormatException, ParseException
	{
		My_GIS_project gis_project = new My_GIS_project(null);
		File[] filesInDirectory = new File(dir).listFiles();
		for(File f : filesInDirectory)
		{
			String filePath = f.getAbsolutePath();
			String fileExtenstion = filePath.substring(filePath.lastIndexOf(".") + 1,filePath.length());
			if("csv".equals(fileExtenstion))
			{
				My_GIS_layer gis_layer =convertCSVToKML(filePath);
				gis_project.add(gis_layer);
			}
		}
		Writer fwriter;
		try {
			fwriter = new FileWriter(out_dir+"/"+ out_name  +".kml");
			fwriter.write(gis_project.toStringOfGISProject());
			fwriter.flush();
			fwriter.close();
		}catch (IOException e1) {
			e1.printStackTrace();
		} 
		return gis_project;
	}
}
