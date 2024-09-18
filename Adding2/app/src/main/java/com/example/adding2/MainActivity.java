package com.example.adding2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     private Button b;
     private EditText e,e1;
    private TextView t;
    private Object view;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=findViewById(R.id.b1);
        e=findViewById(R.id.n3);
        e1=findViewById(R.id.n2);
        t=findViewById(R.id.n1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
                String s=e.getText().toString();
                String s1=e1.getText().toString();
                int a=Integer.parseInt(s);
                int b=Integer.parseInt(s1);
                int c=a+b;
                StringBuffer buffer = new StringBuffer();
                 t.setText("The Sum is "+ c);
                for(int i = 1; i <= 10; i++) {
                   buffer.append(a+"X"+i+" = "+(a*i)+"\n\n");

                }
                t.setText(buffer);
            }
        });
    }
}