package com.hb.period.entities;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by Altanchimeg on 2/19/2016.
 */
public class DateStatus {
    @DatabaseField(generatedId = true)
    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return name;
    }

    public void setStatus(String name) {
        this.name = name;
    }
}
