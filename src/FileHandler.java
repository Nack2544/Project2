import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
private ArrayList<RoadVolume > loadVolumeData = new ArrayList<>();
private ArrayList<RoadSpeed > loadSpeedData = new ArrayList<>();
private ArrayList<RoadSection > writeRoadSectionData = new ArrayList<>();

//public static ArrayList<> loadVolumData(String filename){
//
//}

public FileHandler(){
    Scanner in = new Scanner(System.in);
    FileHandler fileHandler = new FileHandler();

    try {
        System.out.print("Enter Path and Name of Volume and Speed Data File ");
        String inputVolume = in.next();
        String inputSpeed = in.next();

        File fileVolume = new File(inputVolume);
        File fileSpeed = new File(inputSpeed);

    }
    catch (IOException e){
        throw new (e.getCause());
    }


    boolean found = false;
}

    public void loadVolumeData(){
        while(File.ha)
    try {
        System.out.println("Loading Volume Data");
    }
    catch (FileNotFoundException){
        System.out.println("File not found");
    }
    }
}
