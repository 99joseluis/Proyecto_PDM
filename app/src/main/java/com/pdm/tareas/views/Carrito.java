package com.pdm.tareas.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.pdm.tareas.Models.Producto;
import com.pdm.tareas.controllers.RegistroCarrito;
import com.pdm.tareas.controllers.RegistroProd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Carrito extends AppCompatActivity {

    private ArrayList<Producto> compras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);
        Log.d("Carrito", "Entro al carrito");

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            compras = (ArrayList) bundle.getSerializable("compras");
        }
        Log.d("Carrito", compras.toString());
        for(Producto p: compras){
            Log.d("Carrito", p.toString());
        }

        for(int i = 0; i < compras.size(); i++){

        }
        RecyclerView recyclerView = findViewById(R.id.reciclerViewCarrito);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        Producto[] productos = new Producto[compras.size()];
        int i = 0;
        for(Producto p: compras){
            if(p != null)
                productos[i++] = new Producto(p.getImagen(), p.getNombre(), p.getPrecio(), p.getCantidad());

        }


        RegistroCarrito registroCarrito = new RegistroCarrito(productos, Carrito.this);
        recyclerView.setAdapter(registroCarrito);

    }


    public void terminarCompra(View view) {
        Toast.makeText(Carrito.this, "Compra exitosa!!! :)", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Carrito.this, Menu.class);
        startActivity(intent);
    }

}