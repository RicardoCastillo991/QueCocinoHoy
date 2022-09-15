package com.example.quecocinohoy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivityInicio extends AppCompatActivity {

    List<ListElement> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_inicio);

        init();
    }


    public void init(){
        elements = new ArrayList<>();
        elements.add(new ListElement("#7754232", "ricardo", "Santiago", "activo"));
        elements.add(new ListElement("#7754232", "Enyerver", "Santiago", "activo"));
        elements.add(new ListElement("#7754232", "Pablo", "Santiago", "activo"));
        elements.add(new ListElement("#7754232", "Pelao", "Santiago", "activo"));
        elements.add(new ListElement("#7754232", "Deivid", "Puerto Montt", "activo"));
        elements.add(new ListElement("#7754232", "Pailita", "Puerto Mont", "activo"));

        ListAdapter listAdapter = new ListAdapter(elements, this);
        RecyclerView recyclerView = findViewById(R.id.listRecicleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);


    }
}