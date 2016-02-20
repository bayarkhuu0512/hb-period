package com.hb.period.enums;

/**
 * Created by bayarkhuu on 2/21/2016.
 */
public enum Color {
    LOW(0),
    MEDIUM(1),
    HIGH(2);

    private final int color;

    private Color(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }
}
