package com.example.alarm_clock;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView stopwatchTextView;
    private Button startStopButton;
    private Button setAlarmButton;
    private Button cancelAlarmButton;
    private TimePicker alarmTimePicker;
    private Handler handler;
    private boolean isStopwatchRunning = false;
    private int seconds = 0;
    private AlarmManager alarmManager;
    private PendingIntent pendingIntent;
    private BroadcastReceiver alarmReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stopwatchTextView = findViewById(R.id.stopwatchTextView);
        startStopButton = findViewById(R.id.startStopButton);
        setAlarmButton = findViewById(R.id.setAlarmButton);
        alarmTimePicker = findViewById(R.id.alarmTimePicker);
        handler = new Handler();
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        startStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStopwatchRunning) {
                    stopStopwatch();
                } else {
                    startStopwatch();
                }
            }
        });

        setAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAlarm();
            }
        });

    }

    private void startStopwatch() {
        isStopwatchRunning = true;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                seconds++;

                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;
                stopwatchTextView.setText(String.format("%02d:%02d:%02d:%02d", hours, minutes, secs));
                if (isStopwatchRunning) {
                    handler.postDelayed(this, 1000);
                }
            }
        }, 1000);
        startStopButton.setText("Stop");
    }

    private void stopStopwatch() {
        isStopwatchRunning = false;
        startStopButton.setText("Start");
    }

    private void setAlarm() {
        int hour = alarmTimePicker.getCurrentHour();
        int minute = alarmTimePicker.getCurrentMinute();


        // Get current time
        Calendar currentTime = Calendar.getInstance();
        int currentHour = currentTime.get(Calendar.HOUR_OF_DAY);
        int currentMinute = currentTime.get(Calendar.MINUTE);

        // Calculate time difference
        int timeDifferenceHours = hour - currentHour;
        int timeDifferenceMinutes = minute - currentMinute;
        if (timeDifferenceMinutes < 0) {
            timeDifferenceHours--;
            timeDifferenceMinutes += 60;
        }

        // Set alarm time
        Calendar alarmTime = Calendar.getInstance();
        alarmTime.add(Calendar.HOUR_OF_DAY, timeDifferenceHours);
        alarmTime.add(Calendar.MINUTE, timeDifferenceMinutes);
        alarmTime.set(Calendar.SECOND, 0);

        // Create intent for the AlarmReceiver class
        Intent intent = new Intent(MainActivity.this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent, PendingIntent.FLAG_IMMUTABLE);


        // Set the alarm using AlarmManager
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, alarmTime.getTimeInMillis(), pendingIntent);



        // Show a toast message to indicate that the alarm is set
        Toast.makeText(this, "Alarm is set for " + DateFormat.getTimeInstance(DateFormat.SHORT).format(alarmTime.getTime()), Toast.LENGTH_SHORT).show();
    }


}