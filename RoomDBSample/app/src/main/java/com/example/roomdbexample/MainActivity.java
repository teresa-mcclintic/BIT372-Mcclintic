package com.example.roomdbexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.roomdbexample.roomdb.Event;
import com.example.roomdbexample.roomdb.EventDao;
import com.example.roomdbexample.roomdb.EventDb;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.lang.reflect.Array;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView eventList;
    private EventListViewModel eventVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, CreateEventActivity.class);
        FloatingActionButton fab = findViewById(R.id.add_event_btn);
        fab.setOnClickListener((view) -> startActivity(intent));
        eventList = findViewById(R.id.event_list);
        eventList.setLayoutManager(new LinearLayoutManager(this));

        ViewModelProvider.Factory factory = new ViewModelProvider.NewInstanceFactory();
        eventVM = new ViewModelProvider(this,factory).get(EventListViewModel.class);
        eventVM.init(getApplicationContext());
        EventListAdapter adapter = new EventListAdapter(eventVM.getEvents().getValue());
        eventList.setAdapter(adapter);

        //subscribe to view model
        eventVM.getEvents().observe(this, new Observer<List<Event>>(){
            @Override
            public void onChanged(List<Event> events) {
                adapter.updateData(events);
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        eventVM.getEvents();
    }
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Toast toast = Toast.makeText(this, "Selected Item: " + item.getTitle(), Toast.LENGTH_SHORT);
        toast.show();

        super.onOptionsItemSelected(item);
        Intent intent = new Intent(this, CreateEventActivity.class);
        startActivity(intent);
        return true;


        }



    @Override
    protected void onResume() {

        super.onResume();
        EventDb db = Room.databaseBuilder(getApplicationContext(),
                EventDb.class, EventDb.DATABASE_NAME).allowMainThreadQueries().build();

        EventDao dao = db.eventDao();
        ArrayAdapter<Event> adapter = new EventListAdapter(getApplicationContext(),dao.getAllEvent());
        eventList.setAdapter(adapter);
    }*/
}