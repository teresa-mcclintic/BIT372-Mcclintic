package com.example.eventlistmvvm;

import android.content.Context;
import androidx.room.Room;
import com.example.eventlistmvvm.roomdb.Event;
import com.example.eventlistmvvm.roomdb.EventDb;

import java.util.List;

public class EventRepository {
    private EventDb db;
    private static EventRepository instance;

    private EventRepository() { }

    public static EventRepository getInstance(Context context) {
        if (instance == null) {
            instance = new EventRepository();
            instance.db = Room.databaseBuilder(context, EventDb.class,
                    EventDb.DATABASE_NAME).allowMainThreadQueries().build();
        }
        return instance;
    }
    public List<Event> getEvents() {
        return db.eventDao().getAllEvent();
    }
    public void insertEvent(Event event) {db.eventDao().insertEvent(event);}

}
