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

    public Measurement() {
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setSystolicPressure(int systolicPressure) {
        this.systolicPressure = systolicPressure;
    }

    public void setDiastolicPressure(int diastolicPressure) {
        this.diastolicPressure = diastolicPressure;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

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

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int getSystolicPressure() {
        return systolicPressure;
    }

    public int getDiastolicPressure() {
        return diastolicPressure;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public String getComment() {
        return comment;
    }

    @Override
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

}
