package com.hb.period;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;


import com.hb.period.adapter.CalendarAdapter;
import com.hb.period.entities.Record;
import com.hb.period.enums.MoodStatus;
import com.hb.period.database.DataManager;
import com.hb.period.entities.Day;
import com.hb.period.entities.Lady;
import com.hb.period.entities.Record;
import com.hb.period.enums.DayType;
import com.hb.period.enums.MoodStatus;
import com.hb.period.ui.CalendarGridViewAdapter;
import com.hb.period.utils.Constants;
import com.hb.period.utils.PrefManager;

import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DataManager dataManager;
    public List<LocalDate> recordPeriodList = new ArrayList<LocalDate>();
    public List<LocalDate> recordOvulationList = new ArrayList<LocalDate>();
    private List<Day> dayList = new ArrayList<Day>();
    public int monthNumber = 1;
    private Typeface mogul_wolfgang;
    private Typeface roboto_light;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mogul_wolfgang = Typeface.createFromAsset(getAssets(),
                Constants.MOGUL_WOLFGANG);
        roboto_light = Typeface.createFromAsset(getAssets(),
                Constants.ROBOTO_LIGHT);
        context = this;

      /*  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        Lady lady = new Lady();
        lady.setCycleLength(30);
        lady.setPeriodLength(7);
        PrefManager prefManager = new PrefManager(this);
        prefManager.setUserName("Altanchimeg");
        prefManager.setPassCode(1234);

        dataManager = new DataManager(this);
        dataManager.createLady(lady);
//        Toast.makeText(this, dataManager.getLady().getCycleLength() + "", Toast.LENGTH_LONG).show();

        Record record = new Record();
        Calendar c1 = Calendar.getInstance();
        c1.set(Calendar.DAY_OF_MONTH, 25);
        LocalDate dt = LocalDate.fromCalendarFields(c1);
        record.setDate(dt);
        record.setMood(MoodStatus.Superhappy);
        dataManager.createRecord(record);
        Toast.makeText(this, record.getDate() + "", Toast.LENGTH_LONG).show();

        LocalDate startDate = record.getDate();
        monthNumber = startDate.getMonthOfYear();

//        while (startDate.getMonthOfYear() < 12) {
        for (int j = 0; j < lady.getPeriodLength(); j++) {
            //Log.d("PERIOD", "Period day is: " + startDate.plusDays(j));
            recordPeriodList.add(startDate.plusDays(j));
            addDay(startDate.plusDays(j), DayType.PERIOD);
        }
        startDate = startDate.plusDays(lady.getCycleLength());
        for (int k = 6; k >= 0; k--) {
            //Log.d("PERIOD", "       Ovulation day is: " + startDate.minusDays(14 + k));
            recordOvulationList.add(startDate.minusDays(14 + k));
            addDay(startDate.minusDays(14 + k), DayType.OVULATION);
        }
        //      }


        TextView todayDate = (TextView) findViewById(R.id.todayDate);
        todayDate.setText(getString(R.string.today)+" "+dt);
        todayDate.setTypeface(roboto_light);

        TextView periodMain = (TextView) findViewById(R.id.periodMain);
        periodMain.setText(getString(R.string.periodMain));
        periodMain.setTypeface(roboto_light);

        TextView todayText = (TextView) findViewById(R.id.todayNumber);
        todayText.setText("6"+getString(R.string.whereText));
        todayText.setTypeface(mogul_wolfgang);
        todayText.setTextSize(40);

        TextView dayText = (TextView) findViewById(R.id.dayText);
        dayText.setText(getString(R.string.day));
        dayText.setTypeface(roboto_light);

        TextView month = (TextView) findViewById(R.id.monthText);
        month.setText(getString(R.string.month4));
        month.setTypeface(mogul_wolfgang);
        month.setTextSize(30);


        TextView helloWorld = (TextView) findViewById(R.id.helloWorld);
        helloWorld.setText(prefManager.getUserName());
        helloWorld.setTypeface(mogul_wolfgang);

        GridView calendarGridView = (GridView) findViewById(R.id.calendarGridView);
        CalendarGridViewAdapter calendarGridViewAdapter = new CalendarGridViewAdapter(context, dayList);
        calendarGridView.setAdapter(calendarGridViewAdapter);
    }

    private void addDay(LocalDate date, DayType type) {
        Day day = new Day();
        day.setLocalDate(date);
        day.setDayType(type);
        dayList.add(day);
    }


    public void btn_next(View v) {
        monthNumber += 1;
        changeCalendar(monthNumber);
    }

    public void btn_previous(View v) {
        monthNumber -= 1;
        changeCalendar(monthNumber);
    }

    public void changeCalendar(int monthNum) {
        for (int i = 0; i < recordPeriodList.size(); i++)
            if (recordPeriodList.get(i).getMonthOfYear() == monthNum)
                Log.d("PERIOD", "Period day is: " + recordPeriodList.get(i));
        for (int i = 0; i < recordOvulationList.size(); i++) {
            if (recordOvulationList.get(i).getMonthOfYear() == monthNum)
                Log.d("PERIOD", "   Ovulation day is: " + recordOvulationList.get(i));
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

		/*
         * You'll need this in your class to release the helper when done.
		 */
    }


}
