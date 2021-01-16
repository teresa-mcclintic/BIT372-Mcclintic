package com.example.roomdbexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.roomdbexample.roomdb.Event;
import com.example.roomdbexample.roomdb.EventDao;
import com.example.roomdbexample.roomdb.EventDb;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    private ListView eventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, CreateEventActivity.class);
        FloatingActionButton fab = findViewById(R.id.add_event_btn);
        fab.setOnClickListener((view) -> startActivity(intent));
        eventList = findViewById(R.id.event_list);
    }

    @Override
    protected void onResume() {

        super.onResume();
        EventDb db = Room.databaseBuilder(getApplicationContext(),
                EventDb.class, EventDb.DATABASE_NAME).allowMainThreadQueries().build();

        EventDao dao = db.eventDao();
        ArrayAdapter<Event> adapter = new EventListAdapter(getApplicationContext(),dao.getAllEvent());
        eventList.setAdapter(adapter);
    }
}