package com.example.roomexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.roomexample.controller.NotaController;
import com.example.roomexample.models.Nota;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etNota;
    NotaController controller;
    ListView listView;
    NotaAdapter adapter;
    ArrayList<Nota> notas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNota = findViewById(R.id.etNota);
        controller = NotaController.get(this);

        notas = new ArrayList<Nota>();
        listView = findViewById(R.id.lv_notas);
        adapter = new NotaAdapter(this, R.layout.row, notas);
        listView.setAdapter(adapter);

        getNotas();
    }

    private void getNotas() {
        notas.clear();
        notas.addAll(controller.getNotas());
        adapter.notifyDataSetChanged();
    }

    public void createNotaPressed(View view) {
        String sNota = etNota.getText().toString();
        if (!"".equals(sNota)) {
            Nota n = new Nota();
            n.setMensaje(sNota);
            controller.createNota(n);
            getNotas();
        }
    }
}
