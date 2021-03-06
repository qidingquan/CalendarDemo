package com.example.qdq.calendardemo.calendar;

import android.view.View;
import android.widget.TextView;

public interface CalendarViewAdapter {
    /**
     * 返回阳历、阴历两个TextView
     *
     * @param view
     * @param date
     * @return
     */
    TextView[] convertView(View view, DateBean date);
}
