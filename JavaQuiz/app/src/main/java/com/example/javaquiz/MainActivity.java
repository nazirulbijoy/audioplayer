package com.example.javaquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] questions={"Is java a programming language","Is java has java introduced 1993","Is your nme is  Bijoy","IS your bro is fg"};
    boolean ans[]={true,false,true,false};
    int score=0;
    int index=0;
    TextView tx;
    Button yes,no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tx=findViewById(R.id.textView2);
        yes=findViewById(R.id.yes);
        no=findViewById(R.id.no);
        tx.setText(questions[index]);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index<=questions.length-1)
                {
                    if (ans[index] == true) {
                        score++;
                    }
                    index++;
                    if(index<=questions.length-1)
                    {
                        tx.setText(questions[index]);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "the score is "+score, Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Restart the app to play again", Toast.LENGTH_SHORT).show();
                }
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index<=questions.length-1)
                {
                    if (ans[index] == false) {
                        score++;
                    }
                    index++;
                    if(index<=questions.length-1)
                    {
                        tx.setText(questions[index]);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "the score is "+score, Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Restart the app to play again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}