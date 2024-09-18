package com.example.alarm_clock_intent;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText hourEditText;
    private EditText minuteEditText;
    private EditText messageEditText;
    private Button setAlarmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hourEditText = findViewById(R.id.hourEditText);
        minuteEditText = findViewById(R.id.minuteEditText);
        messageEditText = findViewById(R.id.messageEditText);
        setAlarmButton = findViewById(R.id.setAlarmButton);

        setAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hourString = hourEditText.getText().toString();
                String minuteString = minuteEditText.getText().toString();
                String message = messageEditText.getText().toString();

                if (!hourString.isEmpty() && !minuteString.isEmpty()) {
                    int hour = Integer.parseInt(hourString);
                    int minutes = Integer.parseInt(minuteString);
                    setAlarm(hour, minutes, message);
                } else {
                    // Handle invalid input
                }
            }
        });
    }

    private void setAlarm(int hour, int minutes, String message) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
        intent.putExtra(AlarmClock.EXTRA_HOUR, hour);
        intent.putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        intent.putExtra(AlarmClock.EXTRA_MESSAGE, message);
        intent.putExtra(AlarmClock.EXTRA_VIBRATE, true);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
