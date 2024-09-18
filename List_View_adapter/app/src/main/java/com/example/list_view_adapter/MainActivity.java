package com.example.list_view_adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String arr[]={"Hello","YO","Degs","Hello","YO","Degs","Hello","YO","Degs","Hello","YO","Degs","Hello","YO","Degs","Hello","YO","Degs","Hello","YO","Degs","Hello","YO","Degs"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview);
        //using build in adaptor
//        ArrayAdapter ad=new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
//        listView.setAdapter(ad);
        //using custom
     Bijoyadaptor ad=new Bijoyadaptor(this,R.layout.my_bijoy_layout,arr);
     listView.setAdapter(ad);
    }
}