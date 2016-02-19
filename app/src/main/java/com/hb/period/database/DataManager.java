package com.hb.period.database;

/**
 * Created by Altanchimeg 02/19/2016
 */

import android.content.Context;

import com.hb.period.entities.DateStatus;
import com.hb.period.entities.Lady;
import com.hb.period.entities.Mood;
import com.hb.period.entities.Record;
import com.hb.period.entities.Symptom;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

public class DataManager{
    String TAG = DataManager.class.getName();

    private Context context;
    private DatabaseHelper databaseHelper = null;

    private Dao<Lady, Integer> ladyDAO;
    private Dao<Record, Integer> recordDAO;
    private Dao<DateStatus, Integer> dateStatusDAO;
    private Dao<Mood, Integer> moodDAO;
    private Dao<Symptom, Integer> symptomDAO;


    public DataManager(Context context) {
        this.context = context;
    }

    private DatabaseHelper getHelper() {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(context,
                    DatabaseHelper.class);
        }
        return databaseHelper;
    }

// Create and get Lady table
    public Lady getLady() {
        try {
            ladyDAO = getHelper().getLadyDao();
            QueryBuilder<Lady, Integer> ladyQb = ladyDAO
                    .queryBuilder();
            return ladyQb.queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void createLady(Lady lady) {
        try {
            ladyDAO = getHelper().getLadyDao();
            ladyDAO.createOrUpdate(lady);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Create and get Record table
    public Record getRecord() {
        try {
            recordDAO = getHelper().getRecordDao();
            QueryBuilder<Record, Integer> recordQb = recordDAO
                    .queryBuilder();
            return recordQb.queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void createRecord(Record record) {
        try {
            recordDAO = getHelper().getRecordDao();
            recordDAO.createOrUpdate(record);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Create and get DateStatus table
    public DateStatus getDateStatus() {
        try {
            dateStatusDAO = getHelper().getDateStatusDao();
            QueryBuilder<DateStatus, Integer> dateStatusQb = dateStatusDAO
                    .queryBuilder();
            return dateStatusQb.queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void createDateStatus(DateStatus dateStatus) {
        try {
            dateStatusDAO = getHelper().getDateStatusDao();
            dateStatusDAO.createOrUpdate(dateStatus);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Create and get Mood table
    public Mood getMood() {
        try {
            moodDAO = getHelper().getMoodDAO();
            QueryBuilder<Mood, Integer> moodQb = moodDAO
                    .queryBuilder();
            return moodQb.queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void createMood(Mood mood) {
        try {
            moodDAO = getHelper().getMoodDAO();
            moodDAO.createOrUpdate(mood);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Create and get Symptom table
    public Symptom getSymptom() {
        try {
            symptomDAO = getHelper().getSymptomDAO();
            QueryBuilder<Symptom, Integer> symptomQb = symptomDAO
                    .queryBuilder();
            return symptomQb.queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void createSymptom(Symptom symptom) {
        try {
            symptomDAO = getHelper().getSymptomDAO();
            symptomDAO.createOrUpdate(symptom);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
