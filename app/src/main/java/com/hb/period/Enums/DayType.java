package com.hb.period.enums;

/**
 * Created by bayarkhuu on 2/27/2016.
 */
public enum DayType {
    NORMAL(0),
    PERIOD(1),
    FORECAST(2),
    FERTILE(3),
    OVULATION(4);

    private final int dayType;

    private DayType(int dayType) {
        this.dayType = dayType;
    }

    public int getDayType() {
        return dayType;
    }

}