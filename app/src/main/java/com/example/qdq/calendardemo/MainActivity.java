package com.example.qdq.calendardemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private SelectCalendarPopWindow calendarPopWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectDate(View view) {
        if (calendarPopWindow == null) {
            calendarPopWindow = new SelectCalendarPopWindow(this);
        }
        calendarPopWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);
    }
}
