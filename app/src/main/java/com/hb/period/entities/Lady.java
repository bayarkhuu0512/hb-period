package com.hb.period.entities;

import com.j256.ormlite.field.DatabaseField;

import org.joda.time.LocalDate;

import java.util.Date;

/**
 * Created by bayarkhuu on 2/18/2016.
 * <p/>
 * Updated by Altanchimeg on 02/19/2016.
 */
public class Lady {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private int periodLength;

    @DatabaseField
    private int cycleLength;

    @DatabaseField
    private LocalDate birthDate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeriodLength() {
        return periodLength;
    }

    public void setPeriodLength(int periodLength) {
        this.periodLength = periodLength;
    }

    public int getCycleLength() {
        return cycleLength;
    }

    public void setCycleLength(int cycleLength) {
        this.cycleLength = cycleLength;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
