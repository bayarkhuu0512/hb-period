package com.hb.period.enums;

/**
 * Created by Altanchimeg on 2/19/2016.
 */
public enum MoodStatus {
    Crying("Crying"),
    Unhappy("UnHappy"),
    Cute("Cute"),
    Happy("Happy"),
    Superhappy("Super Happy"),
    Angry("Angry"),
    Dazed("Dazed"),
    Bored("Bored"),
    Excited("Excited"),
    InLove("In Love"),
    Ill("Ill"),
    Worried("Worried"),
    Stressed("Stressed"),
    Lonely("Lonely");
    private final String moodStatus;

    private MoodStatus(String moodStatus) {
        this.moodStatus = moodStatus;
    }

    public String getMoodStatus() {
        return moodStatus;
    }
}
