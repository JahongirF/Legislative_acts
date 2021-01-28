package com.example.legislative_acts.Data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = ActsData.class, version = 2, exportSchema = false)
public abstract class ActsDataBase extends RoomDatabase {

    private static ActsDataBase dataBase;
    private static final String DB_NAME = "acts.db";
    private static final Object KEY = new Object();

    public static ActsDataBase getInstance(Context context)
    {
        synchronized (KEY)
        {
            if (dataBase == null)
            {
                dataBase = Room.databaseBuilder(context,ActsDataBase.class,DB_NAME).fallbackToDestructiveMigration().build();
            }
        }
        return dataBase;
    }

    public abstract Acts_Dao acts_dao();

}
