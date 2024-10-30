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
 * @author Suphakrit Jinaongkan
 * @version 1.0.
 * @since 2024-10-14
 */
public class Project2 {

	public static void main(String[] args) throws ParseException {
		// prompt user for input file
		Scanner scnr = new Scanner(System.in);
		ArrayList<RoadVolume> volumeList = null;
		ArrayList<RoadSpeed> speedList = null;
		String volumeFileName;
		String speedFileName;
//		boolean validInput = false;

		while(volumeList == null) {
			try {
				System.out.print("Enter Path and Name of Volume and Speed Data File: ");
				volumeFileName = scnr.next();
				
				volumeList = FileHandler.loadVolumeData(volumeFileName);	
				System.out.println("Loading Volume Data");
				if(volumeList != null) {
					System.out.println("Volume Data loaded");
				}
				
//				validInput = true;			
				
			}
			catch(FileNotFoundException e) {
				System.out.println("File not found " + e.getMessage());
			}	
		}
		
		
		while(speedList == null) {
			try {
				speedFileName = scnr.next();
				speedList = FileHandler.loadSpeedData(speedFileName);
				System.out.println("Loading Speed Data");
				if(speedList != null) {
					System.out.println("Speed Data loaded");
				}
			}
			catch(FileNotFoundException e) {
				System.out.println("File not found "+ e.getMessage());
			}
		}
		if(volumeList != null && speedList != null) {
			createRoadSection(volumeList, speedList);
			
		}
		scnr.close();
	}


	public static void createRoadSection(ArrayList<RoadVolume> volumeList, ArrayList<RoadSpeed> speedList){
		ArrayList<RoadSection> sectionList = new ArrayList<>();

		for(RoadVolume volume: volumeList) {
			for(RoadSpeed speed: speedList) {
				SimpleDateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy");
				String formattedVolumeDate = formatDate.format(volume.getFileData());
				String formattedSpeedDate = formatDate.format(speed.getFileData());

				if (formattedVolumeDate.equals(formattedSpeedDate) && volume.getTime().equals(speed.getTime())) {
					RoadSection roadSection = new RoadSection(volume, speed);
					sectionList.add(roadSection);
					break; // Exit the inner loop once a match is found
				}
			}

		}
		// Calls writeRoadSectionData to create a new file
		FileHandler.writeRoadSectionData(sectionList);

	}
}