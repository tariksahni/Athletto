package com.example.tarik.athletto;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;    // recylerview is used :)
    FloatingActionButton fab;

    MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //list = (ListView) findViewById(R.id.list);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        myAdapter = new MyAdapter(getApplicationContext(),getData());   // adapter is called goto myadapterclass
        recyclerView.setAdapter(myAdapter);  //recylerview is used
        //Toast.makeText(getApplicationContext(),"MainActivity called",Toast.LENGTH_SHORT).show();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                               // fab button is used for registration and this will take us to register_form class
                Intent intent = new Intent(MainActivity.this,Registration_form.class);
                startActivity(intent);
            }
        });
    }
    // i have taken dummy data because no url or any description of functionlity was given .
    public static List<DummyInformation> getData(){
        List<DummyInformation> data = new ArrayList<>();
        // list of dummy data that is shown on display page
        String[] names = {"TARIK SAHNI","SONIK SAINSATE","JATIN","PRANAV BHARDWAJ","AKSHAY SHARMA","SHUBHAM RANA","MUKUL CHANDEL"};
        Integer[] age = {20,20,20,21,22,22,21};
        String[] hometown = {"HAMIRPUR","SHIMLA","MANALI","SHIMLA","ROHRU","DHARAMSHALA","HAMIRPUR"};
        String[] prefrences = {"Table Tennis ,Cricket ,Squash ","Football ,Cricket ,Baseball","Football ,Cricket ,Basketball, Table tennis","Cricket","Badminton","Football","Badminton, Cricket, Basketball"};
        for(int i=0;i<names.length && i<age.length && i<hometown.length && i<prefrences.length;i++){
            DummyInformation current = new DummyInformation();
            current.name = names[i];
            current.age = age[i];
            current.hometown =hometown[i];
            current.prefrences = prefrences[i];
            data.add(current);

        }
        return data ;
    }
}
