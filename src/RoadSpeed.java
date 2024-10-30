import java.text.SimpleDateFormat;
import java.util.Date;

public class RoadSpeed {
    private Date date;
    private String time;
    private double speedSensor1;
    private double speedSensor2;

    // Constructor
    public RoadSpeed(Date date, String time, double speedSensor1, double speedSensor2) {
    	super();
        this.date = date;
        this.time = time;
        this.speedSensor1 = speedSensor1;
        this.speedSensor2 = speedSensor2;
    }

    // Method to format data for output (like in a file)
    public String getFileData() {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        String stringFormat = formatDate.format(date);
    	return String.format("%s,%s,%s,%s", stringFormat,time, speedSensor1, speedSensor2);
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
