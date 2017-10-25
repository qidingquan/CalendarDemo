package com.example.qdq.calendardemo;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.qdq.calendardemo.calendar.CalendarView;
import com.example.qdq.calendardemo.calendar.DateBean;
import com.example.qdq.calendardemo.calendar.OnMonthItemClickListener;
import com.example.qdq.calendardemo.calendar.OnPagerChangeListener;

/**
 * 选择日期
 */

public class SelectCalendarPopWindow extends PopupWindow {
    private static final String TAG = "SelectCalendarPopWindow";

    private CalendarView calendarView;
    private View view;
    private TextView tv_select_date;
    private TextView tv_title;
    private TextView tv_sure;
    private int year;
    private int month;
    private int day;
    public SelectCalendarPopWindow(Context context) {
        this(context, null);
    }

    public SelectCalendarPopWindow(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SelectCalendarPopWindow(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = LayoutInflater.from(context).inflate(R.layout.popup_select_date, null);
        setContentView(view);
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        setBackgroundDrawable(new ColorDrawable(0x64000000));
        setOutsideTouchable(true);

        tv_select_date=view.findViewById(R.id.tv_select_date);
        tv_title=view.findViewById(R.id.tv_title);
        tv_sure=view.findViewById(R.id.tv_sure);

        calendarView=view.findViewById(R.id.calendarView);
        calendarView.init();
        View shadeView=view.findViewById(R.id.shadeView);
        shadeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        calendarView.setOnItemClickListener(new OnMonthItemClickListener() {
            @Override
            public void onMonthItemClick(View view, DateBean date) {
                year=date.getSolar()[0];
                month=date.getSolar()[1];
                day=date.getSolar()[2];
                tv_select_date.setText(date.getSolar()[0]+"/"+date.getSolar()[1]+"/"+date.getSolar()[2]);
            }
        });
        calendarView.setOnPagerChangeListener(new OnPagerChangeListener() {
            @Override
            public void onPagerChanged(int[] date) {
                tv_title.setText(date[0]+"/"+date[1]);
            }
        });
        tv_select_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendarView.toSpecifyDate(year,month,day);
            }
        });
    }

}
