import java.util.Date;

/**
 * The RoadVolume class stores traffic volume data from four sensors
 * recorded at a specific date and time. This class provides methods to
 * get and set these values and prepare the data for file output.
 *
 * @author Suphakrit Jinaongkan
 * @version 1.0
 * @since 2024-10-23
 */
public class RoadVolume {

    /**
     * The date of the traffic recording.
     */
    private Date date;

    /**
     * The time of the traffic recording.
     */
    private String time;

    /**
     * Volume data from sensor 1.
     */
    private int volumeSensor1;

    /**
     * Volume data from sensor 2.
     */
    private int volumeSensor2;

    /**
     * Volume data from sensor 3.
     */
    private int volumeSensor3;

    /**
     * Volume data from sensor 4.
     */
    private int volumeSensor4;
    /**
     * Construct new RoadVolume object with the given data
     * @param dateInput
     * @param timeInput
     * @param volumeSensor1Input
     * @param volumeSensor2Input
     * @param volumeSensor3Input
     * @param volumeSensor4Input
     */
    public void RoadVolume(Date dateInput, String timeInput, int volumeSensor1Input, int volumeSensor2Input, int volumeSensor3Input, int volumeSensor4Input) {
        this.date = dateInput;
        this.time = timeInput;
        this.volumeSensor1 = volumeSensor1Input;
        this.volumeSensor2 = volumeSensor2Input;
        this.volumeSensor3 = volumeSensor3Input;
        this.volumeSensor4 = volumeSensor4Input;
    }
    /**
     * Generates a formatted string of the object's data suitable for file output.
     *
     * @return A string containing the date, time, and sensor values.
     */
    public String getFileData() {
        // Return a string with date, time, and sensor data in a readable format.
        return String.format("Date: %s, Time: %s, Sensor1: %d, Sensor2: %d, Sensor3: %d, Sensor4: %d",
                date, time, volumeSensor1, volumeSensor2, volumeSensor3, volumeSensor4);
    }

    /**
     * Gets the date of the traffic recording.
     *
     * @return The recorded date.
     */
    public Date getData() {
        return date;
    }

    /**
     * Sets the date of the traffic recording.
     *
     * @param date The new date to be set.
     */
    public void setData(Date date) {
        this.date = date;
    }

    /**
     * Gets the time of the traffic recording.
     *
     * @return The recorded time as a string.
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets the time of the traffic recording.
     *
     * @param time The new time to be set.
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Gets the volume recorded by sensor 1.
     *
     * @return The volume data from sensor 1.
     */
    public int getVolumeSensor1() {
        return volumeSensor1;
    }

    /**
     * Sets the volume recorded by sensor 1.
     *
     * @param volumeSensor1 The new volume data for sensor 1.
     */
    public void setVolumeSensor1(int volumeSensor1) {
        this.volumeSensor1 = volumeSensor1;
    }

    /**
     * Gets the volume recorded by sensor 2.
     *
     * @return The volume data from sensor 2.
     */
    public int getVolumeSensor2() {
        return volumeSensor2;
    }

    /**
     * Sets the volume recorded by sensor 2.
     *
     * @param volumeSensor2 The new volume data for sensor 2.
     */
    public void setVolumeSensor2(int volumeSensor2) {
        this.volumeSensor2 = volumeSensor2;
    }

    /**
     * Gets the volume recorded by sensor 3.
     *
     * @return The volume data from sensor 3.
     */
    public int getVolumeSensor3() {
        return volumeSensor3;
    }

    /**
     * Sets the volume recorded by sensor 3.
     *
     * @param volumeSensor3 The new volume data for sensor 3.
     */
    public void setVolumeSensor3(int volumeSensor3) {
        this.volumeSensor3 = volumeSensor3;
    }

    /**
     * Gets the volume recorded by sensor 4.
     *
     * @return The volume data from sensor 4.
     */
    public int getVolumeSensor4() {
        return volumeSensor4;
    }

    /**
     * Sets the volume recorded by sensor 4.
     *
     * @param volumeSensor4 The new volume data for sensor 4.
     */
    public void setVolumeSensor4(int volumeSensor4) {
        this.volumeSensor4 = volumeSensor4;
    }
}
