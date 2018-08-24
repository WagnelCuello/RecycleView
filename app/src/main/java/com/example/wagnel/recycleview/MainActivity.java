package com.example.wagnel.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Marca> list = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        list.add(new Marca("Honda","JAPON"));
        list.add(new Marca("Toyota","JAPON"));
        list.add(new Marca("Nissan","JAPON"));
        list.add(new Marca("Ford","ESTADOS UNIDOS"));
        list.add(new Marca("Chevrolet","Estados Unidos"));
        list.add(new Marca("Kia","COREA DEL SUR"));
        list.add(new Marca("Hyundai","COREA DEL SUR"));
        list.add(new Marca("Ferrari","ITALIA"));
        list.add(new Marca("Maserati","ITALIA"));

        RecyclerView rv = findViewById(R.id.my_recycler_view);
        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));
        rv.setAdapter(new MyRecyclerAdapter(this, list));
    }
}
