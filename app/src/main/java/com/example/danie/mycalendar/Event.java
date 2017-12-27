package com.example.danie.mycalendar;

/**
 * Created by daniel on 12/26/2017.
 */

public class Event implements Comparable<Event>{
    int time;
    String month;
    int day;
    int year;
    String location;
    String name;
    public Event(int year, String month, int day, int time, String location, String name){
        this.time = time;
        this.month = month;
        this.day = day;
        this.year = year;
        this.location = location;
        this.name = name;

    }
    public String toString(){
        return name + ": " + month + " " + day + ", " + year + " at " + time + " @ " + location;
    }
    public int compareTo(Event other){
        return this.year - other.year;
    }
}
