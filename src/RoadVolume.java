import java.util.ArrayList;
import java.util.Date;

public class RoadVolume {
    private Date date;
    private String time;
    private int volumeSensor1;
    private int volumeSensor2;
    private int volumeSensor3;
    private int volumeSensor4;

    /**
     *
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

    public String getFileData(){
        return ;
    }

    public Date getData(){
        return date;
    }

    public void setData(Date date){
        date = date;
    }

    public String getTime(){
        return time;
    }

    public void setTime(String time){
        time = time;
    }

    public int getVolumeSensor1(){
        return volumeSensor1;
    }

    public void setVolumeSensor1(int volumeSensor1){
        volumeSensor1 = volumeSensor1;
    }

    public int  getVolumeSensor2(){
        return volumeSensor2;
    }

    public void setVolumeSensor2(int volumeSensor2){

    }

    public int getVolumeSensor3(){
        return  volumeSensor3;
    }

    public void setVolumeSensor3(int volumeSensor3){

    }

    public int getVolumeSensor4(){
        return volumeSensor4;
    }
    public void setVolumeSensor4(int volumeSensor4){
        volumeSensor4 = volumeSensor4;
    }
}
