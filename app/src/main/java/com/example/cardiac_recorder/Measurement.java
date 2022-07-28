package com.example.cardiac_recorder;

import java.io.Serializable;
import java.util.Objects;

public class Measurement implements Serializable {

    private String date;
    private String time;
    private int systolicPressure;
    private int diastolicPressure;
    private int heartRate;
    private String comment;

    /**
     * Measurement method
     */
    public Measurement() {
    }

    /**
     * setter of date
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * setter of time
     * @param time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * setter of Systolic pressure
     * @param systolicPressure
     */
    public void setSystolicPressure(int systolicPressure) {
        this.systolicPressure = systolicPressure;
    }

    /**
     * setter of Dystolic pressure
     * @param diastolicPressure
     */
    public void setDiastolicPressure(int diastolicPressure) {
        this.diastolicPressure = diastolicPressure;
    }

    /**
     * setter of Heart Rate
     * @param heartRate
     */
    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    /**
     * comment set
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
    public Measurement(String date, String time, int systolicPressure, int diastolicPressure, int heartRate, String comment) {
        this.date = date;
        this.time = time;
        this.systolicPressure = systolicPressure;
        this.diastolicPressure = diastolicPressure;
        this.heartRate = heartRate;
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Measurement that = (Measurement) o;
        return systolicPressure == that.systolicPressure && diastolicPressure == that.diastolicPressure && heartRate == that.heartRate && date.equals(that.date) && time.equals(that.time) && Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, time, systolicPressure, diastolicPressure, heartRate, comment);
    }

    /**
     * get date as string
     * @return string
     */
    public String getDate() {
        return date;
    }

    /**
     * get time as string
     * @return string
     */
    public String getTime() {
        return time;
    }

    /**
     *get Systolic Pressure as int
     * @return int
     */
    public int getSystolicPressure() {
        return systolicPressure;
    }

    /**
     * get Diastolic Pressure
     * @return int
     */
    public int getDiastolicPressure() {
        return diastolicPressure;
    }

    /**
     * get Heart Rate as int
     * @return int
     */
    public int getHeartRate() {
        return heartRate;
    }

    /**
     * get comment as String
     * @return string
     */
    public String getComment() {
        return comment;
    }

    @Override
    /**
     * convert all data into string value
     */
    public String toString() {
        return "Measurement{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", systolicPressure=" + systolicPressure +
                ", diastolicPressure=" + diastolicPressure +
                ", heartRate=" + heartRate +
                ", comment='" + comment + '\'' +
                '}';
    }
    public int compareTo(Measurement measurement) {
        return this.time.compareTo(measurement.getTime());
    }

}
