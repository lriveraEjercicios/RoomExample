package com.example.roomexample.controller;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.roomexample.database.NotaDao;
import com.example.roomexample.database.NotaDatabase;
import com.example.roomexample.models.Nota;

import java.util.List;

public class NotaController {

    private static NotaController controller;
    private NotaDao mNotaDao;

    private NotaController(Context context){
        Context appContext = context.getApplicationContext();
        NotaDatabase database = Room.databaseBuilder(appContext, NotaDatabase.class, "nota")
                .allowMainThreadQueries().build();
        mNotaDao= database.getNotaDao();
    }

    public static NotaController get (Context context)
    {
        if (controller == null){
            controller = new NotaController(context);
        }
        return controller;
    }

    public List<Nota> getNotas(){
        return mNotaDao.getNotas();
    }
    public Nota getNota(String uuid)
    {
        return mNotaDao.getNota(uuid);
    }
    public void deleteNota(Nota nota)
    {
        mNotaDao.deleteNota(nota);
    }
    public void updateNota(Nota nota)
    {
        mNotaDao.updateNota(nota);
    }
    public void createNota(Nota nota)
    {
        mNotaDao.addNota(nota);
    }
}
