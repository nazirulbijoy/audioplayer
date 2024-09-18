package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
       private EditText editTextText3;
    private EditText editTextText;
    private EditText  editTextText2;
    private Button button;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        editTextText3=findViewById(R.id.editTextText3);
        editTextText=findViewById(R.id.editTextText);
        editTextText2=findViewById(R.id.editTextText2);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "Thanx for using this app", Toast.LENGTH_SHORT).show();
//                String s=editTextText.getText().toString();
//                int kg=Integer.parseInt(s);
//                double pound =kg*2.205;
//                editTextText2.setText("The value in pound is "+pound);
//            }
//        });
    }
    public void calculate(View view)
    {
        Toast.makeText(MainActivity.this, "Thanx for using this app", Toast.LENGTH_SHORT).show();
        String s=editTextText.getText().toString();
        int kg=Integer.parseInt(s);
        double pound =kg*2.205;
        editTextText2.setText("The value in pound is "+pound);
    }
}