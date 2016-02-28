package com.hb.period.ui;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.hb.period.R;
import com.hb.period.database.DataManager;
import com.hb.period.entities.Day;
import com.hb.period.enums.DayType;

import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bayarkhuu on 2/27/2016.
 */
public class CalendarGridViewAdapter extends BaseAdapter {
    String TAG = CalendarGridViewAdapter.class.getName();

    public List<Day> mList;
    public Context context;

    public CalendarGridViewAdapter(Context context, List<Day> dayList) {
        this.context = context;
        mList = dayList;
    }


    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater li = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(R.layout.calendar_cell, null);
            viewHolder = new ViewHolder(v);
            v.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) v.getTag();
        }
        if (mList.get(position).getDayType() == DayType.PERIOD) {
            viewHolder.dayCell.setBackground(context.getResources().getDrawable(R.drawable.bg_oval_period));
        } else {
            viewHolder.dayCell.setBackground(context.getResources().getDrawable(R.drawable.bg_oval_ovulation));
        }
        viewHolder.dayCell.setText(mList.get(position).getLocalDate() + "");
        return v;
    }

    public List<Day> getData() {
        return mList;
    }
}

class ViewHolder {
    public Button dayCell;

    public ViewHolder(View base) {
        dayCell = (Button) base.findViewById(R.id.dayCell);
    }
}