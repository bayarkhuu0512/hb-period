package com.hb.period.entities;

import com.hb.period.enums.DayType;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

/**
 * Created by bayarkhuu on 2/27/2016.
 */
public class Day {
    private LocalDate localDate;
    private DayType dayType;

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public DayType getDayType() {
        return dayType;
    }

    public void setDayType(DayType dayType) {
        this.dayType = dayType;
    }
}
