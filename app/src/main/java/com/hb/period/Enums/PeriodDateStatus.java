package com.hb.period.Enums;

/**
 * Created by Altanchimeg on 2/19/2016.
 */
public enum PeriodDateStatus {
    START_DATE(0),
    END_DATE(1),
    IN_PERIOD(3),
    NONE(4);

    private final int preiodDateStatus;

    private PeriodDateStatus(int preiodDateStatus) {
        this.preiodDateStatus = preiodDateStatus;
    }

    public int getPreiodDateStatus() {
        return preiodDateStatus;
    }
}
