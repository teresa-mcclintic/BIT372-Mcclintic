package com.example.roomdbexample.roomdb;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Event.class}, version = 1)
//abstract class means it can list abstract methods that have their own implementation 
public abstract class EventDb extends RoomDatabase {
    public final static String DATABASE_NAME = "EventsRoomDb";
    public abstract EventDao eventDao(); //returns event Dao

}
