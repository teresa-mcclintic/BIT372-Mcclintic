package com.example.eventlistmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.eventlistmvvm.roomdb.Event;
import com.example.eventlistmvvm.roomdb.EventDao;
import com.example.eventlistmvvm.roomdb.EventDb;

import java.util.HashMap;

public class CreateEventActivity extends AppCompatActivity {

    private static final HashMap<String, Integer> images;
    static {
        images = new HashMap<>();
        images.put("party", R.drawable.party);
        images.put("concert", R.drawable.concert);
        images.put("gathering", R.drawable.business_meeting);
        images.put("food", R.drawable.food);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        Spinner eventType = findViewById(R.id.event_image_type);
        ArrayAdapter<CharSequence> types =
                ArrayAdapter.createFromResource(this, R.array.event_type, android.R.layout.simple_spinner_item);
        eventType.setAdapter(types);

        Button createBtn = findViewById(R.id.create_btn);
        EditText title = findViewById(R.id.event_title_edit);
        EditText date = findViewById(R.id.event_date);
        
        // TODO: Create a repo object

        createBtn.setOnClickListener((view) -> {
            String titleStr = title.getText().toString();
            String dateStr = date.getText().toString();
            String typeKey = eventType.getSelectedItem().toString().toLowerCase();
            if (TextUtils.isEmpty(titleStr) || TextUtils.isEmpty(dateStr) || TextUtils.isEmpty(typeKey)) {
                Log.i("DEBUG", "EMPTY VALUES");
                return;
            }
            
            // TODO: store the event in the repo
            title.setText("");
            date.setText("");
            Toast.makeText(this, "Event Created", Toast.LENGTH_LONG).show();
            onBackPressed();
        });
    }
}