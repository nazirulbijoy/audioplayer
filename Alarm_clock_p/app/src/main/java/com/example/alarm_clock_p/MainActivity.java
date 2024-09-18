package com.example.alarm_clock_p;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
   EditText hr,mn;
   Button tm,am;
   TimePickerDialog timePickerDialog;
   Calendar calendar;
   int crnthr,crntmn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hr=findViewById(R.id.ehr);
        mn=findViewById(R.id.emn);
        tm=findViewById(R.id.btnTime);
        am=findViewById(R.id.btnAlarm);
        tm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                crnthr=calendar.get(Calendar.HOUR_OF_DAY);
                crntmn = calendar.get(Calendar.MINUTE);
                timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        hr.setText(String.format("%02d",hourOfDay));
                        mn.setText(String.format("%02d",minute));
                    }
                },crnthr,crntmn,false);

                timePickerDialog.show();
            }
        });
      am.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              if(!hr.getText().toString().isEmpty()&&!mn.getText().toString().isEmpty()){
                  Intent intend=new Intent((AlarmClock.ACTION_SET_ALARM));
                  intend.putExtra(AlarmClock.EXTRA_HOUR,Integer.parseInt(hr.getText().toString()));
                  intend.putExtra(AlarmClock.EXTRA_MINUTES,Integer.parseInt(mn.getText().toString()));
                  intend.putExtra(AlarmClock.EXTRA_MESSAGE,"Set alarm for morning walk");
                  if(intend.resolveActivity(getPackageManager())!=null)startActivity(intend);
                  else
                      Toast.makeText(MainActivity.this, "this is no app that support this action", Toast.LENGTH_SHORT).show();
              }
              else Toast.makeText(MainActivity.this, "please set time", Toast.LENGTH_SHORT).show();

          }
      });
    }
}