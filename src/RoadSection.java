import java.util.ArrayList;

/**
 * The RoadSection class stores and manages data about a specific road section,
 * including traffic volume and speed metrics. It provides methods to calculate
 * total volume, average volume, and average speed for the section.
 *
 * This class interacts with the RoadVolume and RoadSpeed objects to retrieve
 * relevant data and allows setting and getting these objects.
 *
 * @version 1.0
 * @since 2024-10-23
 */
public class RoadSection {

    private RoadVolume roadVolume; // Stores road volume data
    private RoadSpeed roadSpeed;   // Stores road speed data
    private int volumeTotal;       // Total volume across all sensors
    private double volumeAvg;      // Average volume across all sensors
    private double speedAvg;       // Average speed across all speed sensors

    /**
     * Constructor that initializes RoadVolume and RoadSpeed objects and
     * calculates volume and speed metrics.
     *
     * @param roadVolume The RoadVolume data for this section
     * @param roadSpeed The RoadSpeed data for this section
     */
    public RoadSection(RoadVolume roadVolume, RoadSpeed roadSpeed) {
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
        String volumeData = roadVolume.getFileData(); // Retrieve formatted volume data
        double speedData1 = roadSpeed.getSpeedSensor1(); // Speed from first sensor
        double speedData2 = roadSpeed.getSpeedSensor2(); // Speed from second sensor

        // Format additional data for total volume, average volume, and average speed
        String additionalData = String.format("%d,%.2f,%.2f", calcVolumeTotal(), calcVolumeAvg(), calcSpeedAvg());
        return volumeData + "," + speedData1 + "," + speedData2 + "," + additionalData;
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
        volumeTotal = roadVolume.getVolumeSensor1() + roadVolume.getVolumeSensor2() + roadVolume.getVolumeSensor3() + roadVolume.getVolumeSensor4();
        return volumeTotal;
    }

    /**
     * Calculates the average volume across all sensors.
     *
     * @return The average volume.
     */
    public double calcVolumeAvg() {
        volumeAvg = (double) calcVolumeTotal() / 4;
        return volumeAvg;
    }

    /**
     * Calculates the average speed of vehicles in this road section.
     *
     * @return The average speed.
     */
    public double calcSpeedAvg() {
        speedAvg = (roadSpeed.getSpeedSensor1() + roadSpeed.getSpeedSensor2()) / 2;
        return speedAvg;
    }
}
