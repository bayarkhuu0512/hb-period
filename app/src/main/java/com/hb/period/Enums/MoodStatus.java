package com.hb.period.Enums;

/**
 * Created by Altanchimeg on 2/19/2016.
 */
public enum MoodStatus {
    Crying(0),
    Unhappy(1),
    Cute(2),
    Happy(3),
    Superhappy(4),
    Angry(5),
    Dazed(6),
    Bored(7),
    Excited(8),
    InLove(9),
    Ill(10),
    Worried(11),
    Stressed(12),
    Lonely(13);

    private final int moodStatus;

    private MoodStatus(int moodStatus) {
        this.moodStatus = moodStatus;
    }

    public int getMoodStatus() {
        return moodStatus;
    }
}
