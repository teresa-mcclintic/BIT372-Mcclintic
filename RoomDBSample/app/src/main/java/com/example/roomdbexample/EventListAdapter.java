package com.example.roomdbexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdbexample.roomdb.Event;

import org.w3c.dom.Text;

import java.util.List;


public class EventListAdapter extends RecyclerView.Adapter<EventViewHolder> {

    private List<Event>events;

    public EventListAdapter(List<Event> events){
        this.events = events;
    }
/*    public EventListAdapter(@NonNull Context context, @NonNull List<Event> objects) {
        super(context, 0, objects);
    }*/

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        return new EventViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item,parent,false)
             );
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        Event event = this.events.get(position);
        holder.getEventImage().setImageResource(event.img_id);
        holder.getDateText().setText(event.date);
        holder.getTitleText().setText(event.title);

    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public void updateData(List<Event> events) {
        this.events.clear();
        this.events.addAll(events);
    }

}

class EventViewHolder extends RecyclerView.ViewHolder {

    private TextView titleText;
    private TextView dateText;
    private ImageView eventImage;

    public EventViewHolder(@NonNull View itemView) {
        super(itemView);
        titleText = itemView.findViewById(R.id.event_title_text);
        dateText = itemView.findViewById(R.id.event_date_text);
        eventImage = itemView.findViewById(R.id.event_img_holder);

    }

    public TextView getTitleText() {
        return titleText;
    }

    public TextView getDateText() {
        return dateText;
    }

    public ImageView getEventImage() {
        return eventImage;
    }

}

/*}


    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.event_item, parent, false);
        }

        TextView eventTitle = convertView.findViewById(R.id.event_title_text);
        TextView eventDate = convertView.findViewById(R.id.event_date_text);
        ImageView eventImg = convertView.findViewById(R.id.event_img_holder);

        Event event = getItem(position);
        eventTitle.setText(event.title);
        eventDate.setText(event.date);
        eventImg.setImageResource(event.img_id);

        return convertView;
    }
}*/
