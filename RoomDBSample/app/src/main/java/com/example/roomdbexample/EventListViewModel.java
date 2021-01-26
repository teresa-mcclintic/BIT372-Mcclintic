package com.example.roomdbexample;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.roomdbexample.roomdb.Event;
import java.util.List;

public class EventListViewModel extends ViewModel{
    private MutableLiveData<List<Event>> eventsData;
    private EventRepository repo;

    public void init(Context context){
        if (eventsData == null) {
            eventsData = new MutableLiveData<>();
        }
        repo =EventRepository.getInstance(context);
        eventsData.setValue(repo.getEvents());
    }

    public MutableLiveData<List<Event>> getEvents() {
        eventsData.setValue(repo.getEvents());
        return eventsData;
    }
}
