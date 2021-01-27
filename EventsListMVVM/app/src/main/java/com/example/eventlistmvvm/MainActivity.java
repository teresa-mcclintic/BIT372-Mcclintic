package com.example.eventlistmvvm;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eventlistmvvm.roomdb.Event;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

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

        // Create the ViewModel instance here

        ViewModelProvider.Factory factory = new ViewModelProvider.NewInstanceFactory();
        eventVM = new ViewModelProvider(this,factory).get(EventListViewModel.class);
        eventVM.init(getApplicationContext());

        EventAdapter adapter = new EventAdapter(eventVM.getEvents().getValue());
        eventList.setAdapter(adapter);

        // subscribe to view model with an observer
        // This observer should respond to LiveData changes and update the recycler view

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
}