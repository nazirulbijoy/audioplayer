package com.example.content_contact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
     Contact o1=new Contact(01,"01866447600","Bijoy");
    Contact o2=new Contact(01,"01866447600","Bijoy");
    Contact o3=new Contact(01,"01866447600","Bijoy");
    Contact o8=new Contact(01,"01866447600","Bijoy");
    Contact o4=new Contact(01,"01866447600","Bijoy");
    Contact o5=new Contact(01,"01866447600","Bijoy");
    Contact o6=new Contact(01,"01866447600","Bijoy");
    Contact o7=new Contact(01,"01866447600","Bijoy");
     Contact[] Contacts={o1,o2,o3,o4,o5,o6,o7,o8};

    RecyclerView recyclerView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);//find the recyle
        recyclerView.setLayoutManager(new LinearLayoutManager(this));//for layout
        CustomAdapter add = new CustomAdapter(Contacts);
        recyclerView.setAdapter(add);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }
}