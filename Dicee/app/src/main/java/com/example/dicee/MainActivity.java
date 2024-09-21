package com.example.dicee;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button rollbutton;
        rollbutton=findViewById(R.id.rollbutton);
        ImageView dice1,dice2,logo;
        int[] diceArray={R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};
        dice1=findViewById(R.id.imageDice1);
        dice2=findViewById(R.id.imageDice2);
        logo=findViewById(R.id.imageDiceLogo);
      rollbutton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Toast.makeText(MainActivity.this,"The dice has been rolled",Toast.LENGTH_LONG).show();
              Random randomNumbergenerator =new Random();
              int number=randomNumbergenerator.nextInt(6);
              dice1.setImageResource(diceArray[number]);
              number=randomNumbergenerator.nextInt(6);
              dice2.setImageResource(diceArray[number]);
          }
    });
    }
}


