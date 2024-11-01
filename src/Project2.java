import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Project2
 * This program reads road volume and speed data, processes it, and writes it to an output file.
 *
 * @author Suphakrit Jinaongkan
 * @version 1.0.
 * @since 2024-10-14
 */
public class Project2 {

	public static void main(String[] args) throws ParseException {
		// Create Scanner to read user input
		Scanner scnr = new Scanner(System.in);
		ArrayList<RoadVolume> volumeList = null; // To store loaded road volume data
		ArrayList<RoadSpeed> speedList = null;   // To store loaded road speed data
		String volumeFileName;                   // Variable for the volume data file name
		String speedFileName;                    // Variable for the speed data file name
		boolean validInput = false;              // Tracks whether valid input files have been provided

		// Loop until valid file paths are entered
		while (!validInput) {
			try {
				// Prompt user for volume and speed data file paths
				System.out.print("Enter Path and Name of Volume and Speed Data File: ");
				volumeFileName = scnr.next(); // Read volume file name
				speedFileName = scnr.next();  // Read speed file name

				// Load Volume Data
				System.out.println("Loading Volume Data");
				volumeList = FileHandler.loadVolumeData(volumeFileName);

				// Load Speed Data
				System.out.println("Loading Speed Data");
				speedList = FileHandler.loadSpeedData(speedFileName);

				validInput = true; // Set to true if data loads successfully

			} catch (FileNotFoundException e) {
				// Handle case where the file is not found
				System.out.println("File not found Error: " + e.getMessage());
			} finally {
				System.out.println(); // Print a new line for readability
			}
		}

		// Create road sections using loaded volume and speed data
		createRoadSection(volumeList, speedList);

		// Close the scanner to prevent resource leaks
		scnr.close();
	}

	/**
	 * Creates road sections by matching volume and speed data based on date and time.
	 * Writes the resulting sections to an output file.
	 *
	 * @param volumeList List of RoadVolume objects
	 * @param speedList List of RoadSpeed objects
	 */
	public static void createRoadSection(ArrayList<RoadVolume> volumeList, ArrayList<RoadSpeed> speedList) {
		ArrayList<RoadSection> sectionList = new ArrayList<>(); // Stores matched sections

		// Match volumes and speeds based on date and time
		for (RoadVolume volume : volumeList) {
			for (RoadSpeed speed : speedList) {
				// Format dates to ensure matching
				SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
				String formattedVolumeDate = dateFormat.format(volume.getData());
				String formattedSpeedDate = dateFormat.format(speed.getDate());

				// Check if date and time match between volume and speed entries
				if (formattedVolumeDate.equals(formattedSpeedDate) && volume.getTime().equals(speed.getTime())) {
					RoadSection roadSection = new RoadSection(volume, speed); // Create new road section
					sectionList.add(roadSection); // Add section to list
					break; // Exit inner loop once a match is found
				}
			}
		}

		// Write the matched sections to an output file
		FileHandler.writeRoadSectionData(sectionList);
	}

}
