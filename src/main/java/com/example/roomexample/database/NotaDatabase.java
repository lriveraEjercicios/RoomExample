package com.example.roomexample.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.roomexample.models.Nota;

@Database(entities={Nota.class}, version = 1)
public abstract class NotaDatabase extends RoomDatabase {
    public abstract  NotaDao getNotaDao();
}
