import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The RoadVolume class stores traffic volume data from four sensors
 * recorded at a specific date and time. This class provides methods to
 * get and set these values and prepare the data for file output.
 *
 * @version 1.0
 * @since 2024-10-23
 */
public class RoadVolume {

    private Date date;           // Date of the traffic recording
    private String time;         // Time of the traffic recording
    private int volumeSensor1;   // Volume recorded by the first sensor
    private int volumeSensor2;   // Volume recorded by the second sensor
    private int volumeSensor3;   // Volume recorded by the third sensor
    private int volumeSensor4;   // Volume recorded by the fourth sensor

    /**
     * Constructs a RoadVolume object with the specified date, time, and sensor volumes.
     *
     * @param date          The date of traffic recording
     * @param time          The time of traffic recording
     * @param volumeSensor1 The volume data from sensor 1
     * @param volumeSensor2 The volume data from sensor 2
     * @param volumeSensor3 The volume data from sensor 3
     * @param volumeSensor4 The volume data from sensor 4
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
        SimpleDateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy"); // Date format for file output
        String stringDate = formatDate.format(date);
        return String.format("%s,%s,%d,%d,%d,%d", stringDate, time, volumeSensor1, volumeSensor2, volumeSensor3, volumeSensor4);
    }

    // Getter and setter methods for date, time, and sensor volumes

    public Date getData() {
        return date;
    }

    public void setData(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getVolumeSensor1() {
        return volumeSensor1;
    }

    public void setVolumeSensor1(int volumeSensor1) {
        this.volumeSensor1 = volumeSensor1;
    }

    public int getVolumeSensor2() {
        return volumeSensor2;
    }

    public void setVolumeSensor2(int volumeSensor2) {
        this.volumeSensor2 = volumeSensor2;
    }

    public int getVolumeSensor3() {
        return volumeSensor3;
    }

    public void setVolumeSensor3(int volumeSensor3) {
        this.volumeSensor3 = volumeSensor3;
    }

    public int getVolumeSensor4() {
        return volumeSensor4;
    }

    public void setVolumeSensor4(int volumeSensor4) {
        this.volumeSensor4 = volumeSensor4;
    }
}
