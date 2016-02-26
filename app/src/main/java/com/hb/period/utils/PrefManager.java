package com.hb.period.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;


public class PrefManager implements Constants {

    public String TAG = PrefManager.class.getName();

    SharedPreferences pref;
    Editor editor;
    Context context;

    // Constructor
    public PrefManager(Context context) {
        this.context = context;
        pref = this.context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    /**
     * Clear session details
     */
    public void logoutUser() {
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();
    }

    public boolean getIsSetup() {
        return pref.getBoolean(PREF_ISSETUP, false);
    }

    public void setIsSetup(boolean isSetup) {
        editor.putBoolean(PREF_ISSETUP, isSetup);
        editor.commit();
    }

    public String getUserName() {
        return pref.getString(PREF_USERNAME, "");
    }

    public void setUserName(String ladyUserName) {
        editor.putString(PREF_USERNAME, ladyUserName);
        editor.commit();
    }


    public String getPassCode() {
        return pref.getString(PREF_PASSCODE, "");
    }

    public void setPassCode(int passCode) {
        editor.putInt(PREF_PASSCODE, passCode);
        editor.commit();
    }


    public void removeAll() {
        editor.clear();
        editor.commit();
    }


}
