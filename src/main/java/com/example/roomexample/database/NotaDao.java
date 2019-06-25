package com.example.roomexample.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.roomexample.models.Nota;

import java.util.List;

@Dao
public interface NotaDao {
    @Query("SELECT * FROM nota")
    List<Nota> getNotas();

    @Query("SELECT * FROM nota where id like :uuid")
    Nota getNota(String uuid);

    @Insert
    void addNota(Nota n);

    @Delete
    void deleteNota(Nota n);

    @Update
    void updateNota(Nota n);
}
