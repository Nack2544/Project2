import java.util.ArrayList;

/**
 * The RoadSection class stores and manages data about a specific road section,
 * including the traffic volume and speed metrics. It provides methods to calculate
 * total volume, average volume, and average speed for the section.
 *
 * This class interacts with the RoadVolume and RoadSpeed objects to retrieve
 * relevant data and allows setting and getting these objects.
 *
 * @author Suphakrit Jinaongkan
 * @version 1.0
 * @since 2024-10-23
 */
public class RoadSection {

    
    private RoadVolume roadVolume; 
    private RoadSpeed roadSpeed;
    private int volumeTotal;
    private double volumeAvg;
    private double speedAvg;

    /**
     * Default constructor that initializes RoadVolume and RoadSpeed objects.
     */

	public RoadSection(RoadVolume roadVolume, RoadSpeed roadSpeed) {
		super();
		this.roadVolume = roadVolume;
		this.roadSpeed = roadSpeed;
		this.volumeTotal = calcVolumeTotal();
		this.volumeAvg = calcVolumeAvg();
		this.speedAvg = calcSpeedAvg();

	} 



	/**
     * Retrieves a formatted string containing all data related to the road section.
     *
     * @return A string with the road section's volume and speed data.
     */
    public String getFileData() {
        String volumeData = roadVolume.getFileData();
//        String speedData = roadSpeed.getFileData();
        double speedData = roadSpeed.getSpeedSensor1();
        double speedData2 = roadSpeed.getSpeedSensor2();

        
        String additionalData = String.format("%d,%.2f,%.2f", calcVolumeTotal(), calcVolumeAvg(), calcSpeedAvg());
//        return volumeData + "," + speedData + "," + additionalData;
        return volumeData + "," + speedData + "," + speedData2 + "," + additionalData;
    }

    /**
     * Retrieves the RoadVolume object associated with this road section.
     *
     * @return The RoadVolume object.
     */
    public RoadVolume getRoadVolume() {
        return roadVolume;
    }

    /**
     * Sets the RoadVolume object associated with this road section.
     *
     * @param roadVolume The new RoadVolume object.
     */
    public void setRoadVolume(RoadVolume roadVolume) {
        this.roadVolume = roadVolume;
    }

    /**
     * Retrieves the RoadSpeed object associated with this road section.
     *
     * @return The RoadSpeed object.
     */
    public RoadSpeed getRoadSpeed() {
        return roadSpeed;
    }

    /**
     * Sets the RoadSpeed object associated with this road section.
     *
     * @param roadSpeed The new RoadSpeed object.
     */
    public void setRoadSpeed(RoadSpeed roadSpeed) {
        this.roadSpeed = roadSpeed;
    }

    /**
     * Retrieves the total volume for this road section.
     *
     * @return The total volume.
     */
    public int getVolumeTotal() {
        return volumeTotal;
    }

    /**
     * Sets the total volume for this road section.
     *
     * @param total The new total volume.
     */
    public void setVolumeTotal(int total) {
        this.volumeTotal = total;
    }

    /**
     * Retrieves the average volume for this road section.
     *
     * @return The average volume.
     */
    public double getVolumeAvg() {
        return volumeAvg;
    }

    /**
     * Sets the average volume for this road section.
     *
     * @param avg The new average volume.
     */
    public void setVolumeAvg(double avg) {
        this.volumeAvg = avg;
    }

    /**
     * Retrieves the average speed for this road section.
     *
     * @return The average speed.
     */
    public double getSpeedAvg() {
        return speedAvg;
    }

    /**
     * Sets the average speed for this road section.
     *
     * @param avg The new average speed.
     */
    public void setSpeedAvg(double avg) {
        this.speedAvg = avg;
    }

    /**
     * Calculates the total volume by summing up all sensor data.
     *
     * @return The total volume.
     */
    public int calcVolumeTotal() {
    	volumeTotal = (roadVolume.getVolumeSensor1() + roadVolume.getVolumeSensor2() + roadVolume.getVolumeSensor3() + roadVolume.getVolumeSensor4());
        return volumeTotal;
    }

    /**
     * Calculates the average volume across all sensors.
     *
     * @return The average volume.
     */
    public double calcVolumeAvg() {
    	volumeAvg = (double) calcVolumeTotal() /4;
        return volumeAvg;
    }

    /**
     * Calculates the average speed of vehicles in this road section.
     *
     * @return The average speed.
     */
    public double calcSpeedAvg() {
    	speedAvg = (roadSpeed.getSpeedSensor1() + roadSpeed.getSpeedSensor2())/2;
        return speedAvg;
    }
}
