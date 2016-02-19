package com.hb.period.entities;

import com.j256.ormlite.field.DatabaseField;

import java.util.Date;

/**
 * Created by Altanchimeg on 2/19/2016.
 */
public class Record {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private int dateStatusID;

    @DatabaseField
    private int moodID;

    @DatabaseField
    private int symptomsID;

    @DatabaseField
    private boolean takeMedicine;

    @DatabaseField
    private String note;

    @DatabaseField
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDateStatusID() {
        return dateStatusID;
    }

    public void setDateStatusID(int dateStatusID) {
        this.dateStatusID = dateStatusID;
    }

    public int getMoodID() {
        return moodID;
    }

    public void setMoodID(int moodID) {
        this.moodID = moodID;
    }

    public int getSymptomsID() {
        return symptomsID;
    }

    public void setSymptomsID(int symptomsID) {
        this.symptomsID = symptomsID;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
