import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The RoadSpeed class represents speed data collected for a specific road section.
 * It stores the date, time, and speed measurements from two sensors.
 * It also provides methods for retrieving and formatting data.
 *
 * @version 1.0
 * @since 2024-10-23
 */
public class RoadSpeed {
    private Date date;           // Date of the speed data
    private String time;         // Time of the speed data
    private double speedSensor1; // Speed recorded by the first sensor
    private double speedSensor2; // Speed recorded by the second sensor

    /**
     * Constructor to initialize RoadSpeed with specified date, time, and sensor speeds.
     *
     * @param date Date of speed data collection
     * @param time Time of speed data collection
     * @param speedSensor1 Speed recorded by the first sensor
     * @param speedSensor2 Speed recorded by the second sensor
     */
    public RoadSpeed(Date date, String time, double speedSensor1, double speedSensor2) {
        this.date = date;
        this.time = time;
        this.speedSensor1 = speedSensor1;
        this.speedSensor2 = speedSensor2;
    }

    /**
     * Formats the data for output in a file or other display, using a "MM/dd/yyyy" date format.
     *
     * @return A formatted string with date, time, and speeds from both sensors.
     */
    public String getFileData() {
        SimpleDateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy");
        String stringFormatDate = formatDate.format(date);
        return String.format("%s,%s,%.2f,%.2f", stringFormatDate, time, speedSensor1, speedSensor2);
    }

    // Getter and setter methods

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getSpeedSensor1() {
        return speedSensor1;
    }

    public void setSpeedSensor1(double speedSensor1) {
        this.speedSensor1 = speedSensor1;
    }

    public double getSpeedSensor2() {
        return speedSensor2;
    }

    public void setSpeedSensor2(double speedSensor2) {
        this.speedSensor2 = speedSensor2;
    }
}
