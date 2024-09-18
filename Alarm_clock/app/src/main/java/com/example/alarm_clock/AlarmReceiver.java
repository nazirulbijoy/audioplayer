package com.example.alarm_clock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("AlarmReceiver", "Alarm received");

        // Play alarm sound
        try {
            MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.alarm_sound);

            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        } catch (Exception e) {
            Log.e("AlarmReceiver", "Error playing alarm sound: " + e.getMessage());
        }
    }
}

