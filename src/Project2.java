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
		boolean validInput = false;

		while(!validInput){
			try{
				System.out.print("Enter Path and Name of Volume and Speed Data File: ");
				volumeFileName = scnr.next();
				speedFileName = scnr.next();
				System.out.println("Loading Volume Data");
				volumeList = FileHandler.loadVolumeData(volumeFileName);
				System.out.println("Loading Speed Data");
				speedList = FileHandler.loadSpeedData(speedFileName);
				validInput = true;


			}
			catch (FileNotFoundException e){
				System.out.println("File not found Error: " + e.getMessage());
			}
			finally {
				System.out.println();

			}

			}
		createRoadSection(volumeList, speedList);
		scnr.close();
//		printVolume(volumeList);
//		System.out.println("------------");
//		printSpeed(speedList);
		}
//		while(!validInput) {
//			try {
//				System.out.print("Enter Path and Name of Volume and Speed Data File: ");
//				volumeFileName = scnr.next();
//				volumeList = FileHandler.loadVolumeData(volumeFileName);
//				System.out.println("Loading Volume Data");
//				validInput = true;
//
//			}
//			catch(FileNotFoundException e) {
//				System.out.println("File not found " + e.getMessage());
//			}
//		}
//
//		validInput = false;
//		while(!validInput) {
//			try {
//				speedFileName = scnr.next();
//				speedList = FileHandler.loadSpeedData(speedFileName);
//				System.out.println("Loading Speed Data");
//			}
//			catch(FileNotFoundException e) {
//				System.out.println("File not found "+ e.getMessage());
//			}
//		}
//		if(volumeList != null && speedList != null) {
//			createRoadSection(volumeList, speedList);
//			scnr.close();
//		}

//	}


	public static void createRoadSection(ArrayList<RoadVolume> volumeList, ArrayList<RoadSpeed> speedList){
		ArrayList<RoadSection> sectionList = new ArrayList<>();

		for(RoadVolume volume: volumeList) {
			for(RoadSpeed speed: speedList) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
				String formattedVolumeDate = dateFormat.format(volume.getData());
				String formattedSpeedDate = dateFormat.format(speed.getDate());

				RoadSection roadSection = new RoadSection(volume, speed);
				sectionList.add(roadSection);
				if (formattedVolumeDate.equals(formattedSpeedDate) && volume.getTime().equals(speed.getTime())) {
					break; // Exit the inner loop once a match is found
				}
			}

		}
		// Calls writeRoadSectionData to create a new file
		FileHandler.writeRoadSectionData(sectionList);

	}
public static void printVolume(ArrayList<RoadVolume> volumeList){
	for(RoadVolume volume: volumeList){
		System.out.println(volume.getFileData());
	}
}

public static void printSpeed(ArrayList<RoadSpeed> speedList){
		for(RoadSpeed speed: speedList){
			System.out.println(speed.getFileData());
		}
}
}

