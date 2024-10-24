import java.util.ArrayList;

public class RoadSection {
   private RoadVolume roadVolume;
   private RoadSpeed roadSpeed;
   private int volumeTotal;
   private double volumeAvg;
   private double speedAvg;

   public RoadSection(RoadVolume roadVolume, RoadVolume roadVolume, RoadSpeed roadSpeed){

   }
    public RoadSection(){
        RoadVolume roadVolume = new RoadVolume();
        RoadSpeed roadSpeed = new RoadSpeed();
    }

    public String getFileData(){

    }
    public RoadVolume getRoadVolume() {
        return roadVolume;
    }

    public void setRoadVolume(RoadVolume roadVolume) {
        this.roadVolume = roadVolume;
    }

    public RoadSpeed getRoadSpeed() {
        return roadSpeed;
    }

    public void setRoadSpeed(RoadSpeed roadSpeed) {
        this.roadSpeed = roadSpeed;
    }

    public int getVolumeTotal() {
        return volumeTotal;
    }

    public void setVolumeTotal(int volumeTotal) {
        this.volumeTotal = volumeTotal;
    }

    public double getVolumeAvg() {
        return volumeAvg;
    }

    public void setVolumeAvg(double volumeAvg) {
        this.volumeAvg = volumeAvg;
    }

    public double getSpeedAvg() {
        return speedAvg;
    }

    public void setSpeedAvg(double speedAvg) {
        this.speedAvg = speedAvg;
    }

    public int calcVolumeTotal(){

    }
    public double calcVolumeAvg(){

    }
    public double calcSpeedAvg(){

    }



}
/**
 *   public String getFileData(){
 *
 *     }
 *
 *     public RoadVolume getRoadVolume(){
 *
 *     }
 *
 *     public void setRoadVolume(RoadVolume roadVolume){
 *
 *     }
 *
 *     public RoadSpeed getRoadSpeed(){
 *
 *     }
 *
 *     public void setRoadSpeed(RoadSpeed roadSpeed){
 *
 *     }
 *
 *     public int getVolumeTotal(){
 *
 *     }
 *
 *     public void setVolumeTotal(int total){
 *
 *     }
 *
 *     public double getVolumeAvg(){
 *
 *     }
 *
 *     public void setVolumeAvg(double avg){
 *
 *     }
 *
 *     public double getSpeedAvg(){
 *
 *     }
 *
 *     public void setSpeedAvg(double avg){
 *
 *     }
 *
 *     public int calcVolumeTotal(){
 *
 *     }
 *
 *     public double calcVolumeAvg(){
 *
 *     }
 *
 *     public double calcSpeedAvg(){
 *
 *     }
 */