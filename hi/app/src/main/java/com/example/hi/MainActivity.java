package com.example.hi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
     private Button b;
    private TextView  t;
    private EditText e;
    private EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=findViewById(R.id.button);
        t=findViewById(R.id.textView);
        e=findViewById(R.id.editTextText);
        e1=findViewById(R.id.editTextText2);
//       b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
//                String s=e.getText().toString();
//                int k=Integer.parseInt(s);
//                double pound=2.205*k;
//                e1.setText("The value in pound is "+pound);
//            }
//        });
    }
    public void calculate(View view)
    {
        String s=e.getText().toString();
        int k=Integer.parseInt(s);
        double pound=2.205*k;
        e1.setText("The value in pound is "+pound);
        Toast.makeText(MainActivity.this, "Thanks for using this app", Toast.LENGTH_SHORT).show();
    }


}