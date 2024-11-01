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
	 * Use to handle the files specifically for volume data
	 * Parse data into the roadVolume object and stores them in a list
	 * @param filename Names of the file that will interact with volume data
	 * @return return an arraylist on each line of the Volume Data using comma to split the content
	 * @throws ParseException if data parsing fails
	 * @throws FileNotFoundException if the file input is not exist
	 */
	public static ArrayList<RoadVolume> loadVolumeData(String filename) throws ParseException, FileNotFoundException {
		ArrayList<RoadVolume> volumeList = new ArrayList<>(); // List to store volume data
		File file = new File(filename);
		Scanner fileScanner = new Scanner(file); // Scanner for reading file contents

		// Skip header line if present
		if (fileScanner.hasNextLine()) {
			fileScanner.nextLine();
		}

		SimpleDateFormat inputFormat = new SimpleDateFormat("MM/dd/yy"); // Original date format
		SimpleDateFormat outputFormat = new SimpleDateFormat("MM/dd/yyyy"); // Target date format

		try {
			// Read and process each line of the file
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String[] data = line.split(",");

				// Parse date and format it
				Date inputDate = inputFormat.parse(data[0]);
				String inputString = outputFormat.format(inputDate);
				Date outputDate = outputFormat.parse(inputString);

				// Extract and parse other data fields
				String time = data[1];
				int volumeSensor1 = Integer.parseInt(data[2]);
				int volumeSensor2 = Integer.parseInt(data[3]);
				int volumeSensor3 = Integer.parseInt(data[4]);
				int volumeSensor4 = Integer.parseInt(data[5]);

				// Create a RoadVolume object and add it to the list
				RoadVolume roadVolume = new RoadVolume(outputDate, time, volumeSensor1, volumeSensor2, volumeSensor3, volumeSensor4);
				volumeList.add(roadVolume);
			}
		} catch (ParseException | NumberFormatException e) {
			// Handle parsing errors gracefully
			System.out.println("Error parsing data: " + e.getMessage());
		} finally {
			// Close the scanner to prevent resource leaks
			fileScanner.close();
			System.out.println("Volume Data Loaded");
		}

		return volumeList;
	}

	/**
	 * Use to handle the files by
	 * @param filename Names of the file that will interact with volume data
	 * @return return an arraylist on each line of the Volume Data using comma to split the content
	 * @throws ParseException if data parsing fails
	 * @throws FileNotFoundException if the file input is not exist
	 */
	public static ArrayList<RoadSpeed> loadSpeedData(String filename) throws ParseException, FileNotFoundException {
		ArrayList<RoadSpeed> speedList = new ArrayList<>(); // List to store speed data
		File file = new File(filename);
		Scanner fileScanner = new Scanner(file); // Scanner for reading file contents
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd"); // Date format for parsing speed data

		// Skip header line if present
		if (fileScanner.hasNextLine()) {
			fileScanner.nextLine();
		}

		try {
			// Read and process each line of the file
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String[] data = line.split(",");

				// Parse date and other data fields
				Date stringDate = formatDate.parse(data[0]);
				String time = data[1];
				double speedSensor1 = Double.parseDouble(data[2]);
				double speedSensor2 = Double.parseDouble(data[3]);

				// Create a RoadSpeed object and add it to the list
				RoadSpeed roadSpeed = new RoadSpeed(stringDate, time, speedSensor1, speedSensor2);
				speedList.add(roadSpeed);
			}
		} catch (ParseException | NumberFormatException e) {
			// Handle parsing errors gracefully
			System.out.println("Error parsing speed data: " + e.getMessage());
		} finally {
			// Close the scanner to prevent resource leaks
			fileScanner.close();
			System.out.println("Speed Data Loaded");
		}

		return speedList;
	}

	/**
	 * Writes road section data to a CSV file.
	 * The CSV file includes headers and formatted data from RoadSection objects.
	 *
	 * @param sectionList List of RoadSection objects to be written to file
	 */
	public static void writeRoadSectionData(ArrayList<RoadSection> sectionList) {
		try {
			// Create or overwrite the output file
			FileWriter fileWriter = new FileWriter("Road_Section_Data.csv");

			// Write headers
			fileWriter.write("Date,Time,Volume_Sensor_2003,Volume_Sensor_2004,Volume_Sensor_2005,Volume_Sensor_2006,Speed_Sensor_2282,Speed_Sensor_2293,Volume_Total,Volume_Avg,Speed_Avg\n");

			// Write each road section data as a row in the CSV file
			for (RoadSection roadSection : sectionList) {
				String rowData = roadSection.getFileData();
				fileWriter.write(rowData + "\n");
			}

			System.out.println("Road Section Data created");

			// Close the file writer to save and release resources
			fileWriter.close();
		} catch (IOException e) {
			// Handle file writing errors gracefully
			System.out.println("Error writing to file: " + e.getMessage());
		}
	}
}
