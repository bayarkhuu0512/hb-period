package com.hb.period.utils;


import java.text.SimpleDateFormat;

public interface Constants {
    public static String PREF_NAME = "lady";
    public static String PREF_ISSETUP = "isSetup";
    public static String PREF_USERNAME = "username";
    public static String PREF_PASSCODE = "passCode";

    // Date Format
    public static String DATE_FORMAT = "yyyy/MM/dd";
    public static String TIME_FORMAT = "HH:mm";
    public static String HOUR_FORMAT = "hh";

    public static String MONTH_FORMAT = "MM";
    public static String DAY_FORMAT = "dd";
    public static String DAY_OF_WEEK = "E";

    public static SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
    public static SimpleDateFormat timeFormat = new SimpleDateFormat(TIME_FORMAT);
    public static SimpleDateFormat monthFormat = new SimpleDateFormat(MONTH_FORMAT);
    public static SimpleDateFormat dayFormat = new SimpleDateFormat(DAY_FORMAT);
    public static SimpleDateFormat dayOfWeekFormat = new SimpleDateFormat(DAY_OF_WEEK);
    public static SimpleDateFormat hourFormat = new SimpleDateFormat(HOUR_FORMAT);

    // Fonts
    public static String MOGUL_WOLFGANG = "fonts/Mogul Wolfgang Amadeus Mozart.ttf";


}
