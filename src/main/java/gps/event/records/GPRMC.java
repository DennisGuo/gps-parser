package gps.event.records;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


/*
 * Copyright 2012 Edmundo Carmona Antoranz
 * All rights reserved
 * Released under the terms of Mozilla Public License 2.0
 */

/**
 * Recommended minimum
 */
public class GPRMC extends GpsInfoRecord {


    private static SimpleDateFormat dateFormat = new SimpleDateFormat(
            "ddMMyy HHmmss.SSS");

    static {
        // set the timezone for analysis of dates on UTC
        dateFormat
                .setCalendar(Calendar.getInstance(TimeZone.getTimeZone("UTC")));
    }

    private boolean isValid;
    private double latitude;
    private double longitude;
    private double speed;
    private double direction;
    private Date readingDate;


    protected GPRMC(String[] fields) {
        super(fields);

        //log.debug("GPRMC (Recommended Minimum)");
        try {
            this.readingDate = dateFormat.parse(fields[9] + " " + fields[1]);
        } catch (ParseException e) {
            //log.error("Couldn't parse reading date", e);
            //log.debug("Will assume _now_ as reading date");
            this.readingDate = new Date();
        }
        this.isValid = fields[2].equals("A");
        if (this.isValid) {

            String rawLat = fields[3];
            String rawLong = fields[5];
            if (rawLat.length() > 0 && rawLong.length() > 0) {
                // we have a winner
                int degrees = Integer.parseInt(rawLat.substring(0, 2));
                double minutes = Double.parseDouble(rawLat.substring(2));
                this.latitude = degrees + minutes / 60;
                if (fields[4].equals("S")) {
                    this.latitude *= -1;
                }
                degrees = Integer.parseInt(rawLong.substring(0, 3));
                minutes = Double.parseDouble(rawLong.substring(3));
                this.longitude = degrees + minutes / 60;
                if (fields[6].equals("W")) {
                    this.longitude *= -1;
                }
            }
            // speed and direction
            if (!fields[7].equalsIgnoreCase("")) {
                this.speed = Double.parseDouble(fields[7]) * 1.852; // km/h
            }
            if (!fields[8].equalsIgnoreCase("")) {

                this.direction = Double.parseDouble(fields[8]); // 0 - 360}
            }
        }
    }

    public boolean isValid() {
        return isValid;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public Date getReadingDate() {
        return readingDate;
    }

    public double getSpeed() {
        return speed;
    }


    public double getDirection() {
        return direction;
    }


    public String toString() {
        return fields[0]
                + " "
                + (isValid ? "Valid" : "Not Valid")
                + " at "
                + readingDate
                + (this.isValid ? (" Lat: " + Math.abs(latitude)
                + (latitude < 0 ? " S " : " N ") + " Long: "
                + Math.abs(longitude) + (longitude < 0 ? " W " : " E "))
                + " Speed: " + speed + "km/h "
                + " Direction: " + direction
                : "");
    }

}
