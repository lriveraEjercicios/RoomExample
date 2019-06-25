package com.example.roomexample.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.UUID;

@Entity(tableName = "nota")
public class Nota {
    @PrimaryKey
    @NonNull
    private String id;

    @ColumnInfo(name="contenido")
    private String mensaje;

    public Nota() {
        id = UUID.randomUUID().toString();
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String m) {
        this.mensaje = m;
    }
}
