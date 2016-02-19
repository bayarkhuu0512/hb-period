package com.hb.period.Enums;

/**
 * Created by Altanchimeg on 2/19/2016.
 */
public enum Symptoms {
    Headache(0),
    Insomnia(1),
    BreastTenderness(2),
    Backaches(3),
    //Utgun hatah
    Constipation(4),
    Bleeding(5),
    //Hevliiger uvduh
    AbdominalCramps(6),
    MusclePain(7);

    private final int symptoms;

    private Symptoms(int symptoms) {
        this.symptoms = symptoms;
    }

    public int getSymptoms() {
        return symptoms;
    }
}
