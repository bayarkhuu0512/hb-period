package com.hb.period.entities;

import com.hb.period.enums.Flow;
import com.hb.period.enums.MoodStatus;
import com.hb.period.enums.Symptoms;
import com.j256.ormlite.field.DatabaseField;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.util.Date;

/**
 * Created by Altanchimeg on 2/19/2016.
 */
public class Record {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private boolean isPeriod;

    @DatabaseField
    private MoodStatus mood;

    @DatabaseField
    private Symptoms symptom;

    @DatabaseField
    private Flow flow;

    @DatabaseField
    private boolean takeMedicine;

    @DatabaseField
    private String note;

    @DatabaseField
    private LocalDate date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPeriod() {
        return isPeriod;
    }

    public void setIsPeriod(boolean isPeriod) {
        this.isPeriod = isPeriod;
    }

    public Symptoms getSymptom() {
        return symptom;
    }

    public void setSymptom(Symptoms symptom) {
        this.symptom = symptom;
    }

    public MoodStatus getMood() {
        return mood;
    }

    public void setMood(MoodStatus mood) {
        this.mood = mood;
    }

    public Flow getFlow() {
        return flow;
    }

    public void setFlow(Flow flow) {
        this.flow = flow;
    }

    public boolean isTakeMedicine() {
        return takeMedicine;
    }

    public void setTakeMedicine(boolean takeMedicine) {
        this.takeMedicine = takeMedicine;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
