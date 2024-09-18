 package com.example.audioplayer;

 import android.annotation.SuppressLint;
 import android.media.MediaPlayer;
 import android.os.Bundle;
 import android.os.Handler;
 import android.view.View;
 import android.widget.Button;
 import android.widget.SeekBar;
 import android.widget.TextView;

 import androidx.appcompat.app.AppCompatActivity;

 public class MainActivity extends AppCompatActivity {
   private TextView textView;
     private TextView message;
   private Button play,pause;
   private SeekBar seekbar;
   MediaPlayer mp;
    private Handler handler = new Handler();
     private Runnable updateSeekbar;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        message=findViewById(R.id.message);
        play=findViewById(R.id.play);
        pause=findViewById(R.id.pause);
        seekbar=findViewById(R.id.seekBar);
        mp=MediaPlayer.create(this, R.raw.falak);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mp.start();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
            }
        });
        seekbar.setMax(mp.getDuration());
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;
            int hours=0;
            int minutes=0;
            int seconds=0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if(fromUser)mp.seekTo(progress);
            progressChangedValue = progress;
                progress/=1000;
                int hours = progress/3600;
                int minutes = ( progress % 3600)/ 60;
                int seconds =  progress % 60;
           message.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                handler.removeCallbacks(updateSeekbar);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                handler.removeCallbacks(updateSeekbar);
                mp.seekTo(seekBar.getProgress());
                updateSeekbar();
            }
        });
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                seekbar.setProgress(0);
                handler.removeCallbacks(updateSeekbar);
            }
        });
    }
     private void updateSeekbar() {
         updateSeekbar = new Runnable() {
             @Override
             public void run() {
                 seekbar.setProgress(mp.getCurrentPosition());
                 handler.postDelayed(this, 1000);
             }
         };
         handler.post(updateSeekbar);
     }
     @Override
     protected void onDestroy() {
         super.onDestroy();
         if (mp != null) {
             mp.release();
             mp = null;
         }
         if (handler != null) {
             handler.removeCallbacks(updateSeekbar);
         }
     }
}