package org.unitec.mensajitoandroid;

public class Fecha {
    private int year;
    private String month;
    private Chronology chronology;
    private boolean leapyear;
    private int dayofmonth;
    private int dayofyear;
    private String era;
    

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Chronology getChronology() {
        return chronology;
    }

    public void setChronology(Chronology chronology) {
        this.chronology = chronology;
    }

    public boolean isLeapyear() {
        return leapyear;
    }

    public void setLeapyear(boolean leapyear) {
        this.leapyear = leapyear;
    }

    public int getDayofmonth() {
        return dayofmonth;
    }

    public void setDayofmonth(int dayofmonth) {
        this.dayofmonth = dayofmonth;
    }

    public int getDayofyear() {
        return dayofyear;
    }

    public void setDayofyear(int dayofyear) {
        this.dayofyear = dayofyear;
    }

    public String getEra() {
        return era;
    }

    public void setEra(String era) {
        this.era = era;
    }
}
