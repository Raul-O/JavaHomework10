package org.example;

import java.util.concurrent.TimeUnit;

public class Athlete implements Comparable<Athlete>{
        int athleteNumber;
        String athleteName;
        String time;

    public Athlete(int athleteNumber, String athleteName, String time) {
        this.athleteNumber = athleteNumber;
        this.athleteName = athleteName;
        this.time = time;
    }


    public int compareTo(Athlete ath){

        return Integer.compare(Integer.parseInt(time.replaceAll(":", "")), Integer.parseInt(ath.time.replaceAll(":", "")));
    }
}
