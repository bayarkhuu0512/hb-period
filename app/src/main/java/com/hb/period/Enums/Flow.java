package com.hb.period.enums;

/**
 * Created by Altanchimeg on 2/19/2016.
 */
public enum Flow {
    LOW(0),
    MEDIUM(1),
    HIGH(2);

    private final int flowId;

    private Flow(int flowId) {
        this.flowId = flowId;
    }

    public int getFlow() {
        return flowId;
    }
}
