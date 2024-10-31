import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileHandler {

	/**
	 * 
	 * Load volume data from the specified file into a list
	 * 
	 * @param filename
	 * @throws FileNotFoundException if the file not found
	 * @throws ParseException if there's an error parsing dates
	 */
	public static ArrayList<RoadVolume> loadVolumeData(String filename) throws ParseException, FileNotFoundException {
		
		ArrayList<RoadVolume> volumeList = new ArrayList<RoadVolume>();
		File file = new File(filename);
		Scanner fileScanner = new Scanner(file);
		if(fileScanner.hasNextLine()) {
			fileScanner.nextLine();
		}
		SimpleDateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy");
		try{
			while(fileScanner.hasNextLine()){
				String line = fileScanner.nextLine();
				String[] data = line.split(",");
				Date stringDate = formatDate.parse(data[0]);
				String time = data[1];
				int volumeSensor1 = Integer.parseInt(data[2]);
				int volumeSensor2 = Integer.parseInt(data[3]);
				int volumeSensor3 = Integer.parseInt(data[4]);
				int volumeSensor4 = Integer.parseInt(data[5]);

				RoadVolume roadVolume = new RoadVolume(stringDate, time, volumeSensor1, volumeSensor2, volumeSensor3, volumeSensor4);
				volumeList.add(roadVolume);


			}//end of while
		}// end of try

		catch (ParseException | NumberFormatException e){
//			throw new FileNotFoundException(e.getMessage());
			System.out.println(e.getMessage());
		}
		finally {
			

				fileScanner.close();

            System.out.println("Volume Data Loaded");
		}

		return volumeList;
	}    // end of loadVolumeData method

	/**
	 * Load speed data from the specified file into a list
	 * @param filename
	 * @return
	 * @throws FileNotFoundException
	 * @throws ParseException
	 */
	public static ArrayList<RoadSpeed> loadSpeedData(String filename) throws ParseException, FileNotFoundException {
		ArrayList<RoadSpeed> speedList = new ArrayList<RoadSpeed>();

		File file = new File(filename);
		Scanner fileScanner = new Scanner(file); 
		SimpleDateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy");
		if(fileScanner.hasNextLine()) {
			fileScanner.nextLine();
		}

		try {
			while(fileScanner.hasNextLine()){
				String line = fileScanner.nextLine();
				String[] data = line.split(",");
				//working on this line
				Date stringDate = formatDate.parse(data[0]);
				String time = data[1];
				double speedSensor1 = Double.parseDouble(data[2]);
				double speedSensor2 = Double.parseDouble(data[3]);


				RoadSpeed roadSpeed = new RoadSpeed(stringDate, time, speedSensor1, speedSensor2);
				speedList.add(roadSpeed);     
			}//end of while
		}// end of try

		catch (ParseException | NumberFormatException e) {
//			throw new FileNotFoundException(e.getMessage());
			System.out.println("Error input" + e.getMessage());
		}
		finally {
            fileScanner.close();
            System.out.println("Speed Data Loaded");

		}
		return speedList;
	}

	public static void writeRoadSectionData(ArrayList<RoadSection> sectionList){
		try {
			FileWriter fileWriter = new FileWriter("Road_Section_Data.csv");
			fileWriter.write("Date,Time,Volume_Sensor_2003,Volume_Sensor_2004,Volume_Sensor_2005,Volume_Sensor_2006,Speed_Sensor_2282,Speed_Sensor_2293,Volume_Total,Volume_Avg,Speed_Avg");

			for(RoadSection roadSection: sectionList) {
				String rowData = roadSection.getFileData();
				fileWriter.write(rowData + "\n");
			}

			System.out.println("Road Section Data created");
			fileWriter.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
