package com.example.implicit_intent_example;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnMsg,btnEmail,btnDial,btnShare;
    EditText tx,tx1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMsg=findViewById(R.id.btnMessage);
        btnDial=findViewById(R.id.btnDial);
        btnEmail=findViewById(R.id.btnEmail);
        btnShare=findViewById(R.id.btnShare);
        tx=findViewById(R.id.editTextText);
        tx1=findViewById(R.id.editTextText2);
        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phn=tx.getText().toString();
                Intent iDial=new Intent(Intent.ACTION_DIAL);
                iDial.setData(Uri.parse("tel: "+phn));
                if (iDial.resolveActivity(getPackageManager()) != null) {
                    startActivity(iDial);
                }
            }
        });
        btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phn=tx.getText().toString();
                String msg=tx1.getText().toString();
                Intent iMsg=new Intent(Intent.ACTION_SENDTO);
                iMsg.setData(Uri.parse("smsto:"+Uri.encode(phn)));
                iMsg.putExtra("sms_body",msg);
                if (iMsg.resolveActivity(getPackageManager()) != null) {
                    startActivity(iMsg);
                }
            }
        });


    }
}