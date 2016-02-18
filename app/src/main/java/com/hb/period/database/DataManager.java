package com.hb.period.database;

/**
 * Created by Aagii on 6/3/2015.
 */

import android.content.Context;

import com.hb.period.entities.Lady;
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
}
