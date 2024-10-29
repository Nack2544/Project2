import java.text.SimpleDateFormat;
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

    
    private Date date;
    private String time;
    private int volumeSensor1;
    private int volumeSensor2;
    private int volumeSensor3;
    private int volumeSensor4;

    /**
     * Construct RoadVolume
     * @param date
     * @param time
     * @param volumeSensor1
     * @param volumeSensor2
     * @param volumeSensor3
     * @param volumeSensor4
     */
    
    public RoadVolume(Date date, String time, int volumeSensor1, int volumeSensor2, int volumeSensor3, int volumeSensor4) {
		
		this.date = date;
		this.time = time;
		this.volumeSensor1 = volumeSensor1;
		this.volumeSensor2 = volumeSensor2;
		this.volumeSensor3 = volumeSensor3;
		this.volumeSensor4 = volumeSensor4;
	}


	/**
     * Generates a formatted string of the object's data suitable for file output.
     *
     * @return A string containing the date, time, and sensor values.
     */
    public String getFileData() {
        // Return a string with date, time, and sensor data in a readable format.
        SimpleDateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy");
        String stringDate = formatDate.format(date);
        return String.format("%s,%s,%s,%s,%s,%s", stringDate, time, volumeSensor1, volumeSensor2, volumeSensor3, volumeSensor4);
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
