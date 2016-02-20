package com.hb.period.database;

/**
 * Created by Altanchimeg 02/19/2016
 */

import android.content.Context;

import com.hb.period.entities.Lady;
import com.hb.period.entities.Record;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;

public class DataManager {
    String TAG = DataManager.class.getName();

    private Context context;
    private DatabaseHelper databaseHelper = null;

    private Dao<Lady, Integer> ladyDAO;
    private Dao<Record, Integer> recordDAO;

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


}
