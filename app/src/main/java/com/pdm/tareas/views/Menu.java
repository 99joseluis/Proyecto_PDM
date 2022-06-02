package com.pdm.tareas.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.pdm.tareas.Models.Producto;
import com.pdm.tareas.controllers.RegistroProd;
import com.pdm.tareas.views.Carrito;

import java.util.LinkedList;

public class Menu extends AppCompatActivity {
    private RegistroProd registroProd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        RecyclerView recyclerView = findViewById(R.id.reciclerView);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Producto[] productos = new Producto[]{
                new Producto(R.drawable.alitas, "Alitas BBQ y Buffalo", 150.00,1),
                new Producto(R.drawable.alitas2, "Alitas Buffalo", 100.50,1),
                new Producto(R.drawable.bigburger, "Hamburguesa con tocino", 120.50,1),
                new Producto(R.drawable.bigchesseburger, "Hamburguesa con extra queso", 160.00,1),
                new Producto(R.drawable.boneless, "Boneless (10pzas)", 130.50,1),
                new Producto(R.drawable.costillitas, "Costillitas BBQ", 180.00,1),
                new Producto(R.drawable.hamburguesaindividual, "Hamburguesa Sancilla", 100.50,1),
                new Producto(R.drawable.individualcostilla, "Costilla Individual", 120.90,1),
                new Producto(R.drawable.polloycarne, "Paquete de Carne y Pollo", 220.80,1),
                new Producto(R.drawable.paquetefamiliar, "Paquete familiar 1", 250.90,1),
                new Producto(R.drawable.paquetefamiliar2, "Paquete familiar 2", 290.00,1),
                new Producto(R.drawable.paqueteindividual, "Paquete individial", 99.90,1)
        };

        registroProd = new RegistroProd(productos, this);
        recyclerView.setAdapter(registroProd);




    }

    public void comprar(View view){
        LinkedList<Producto> compras = registroProd.getCompras();
        Intent intent = new Intent(Menu.this, Carrito.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("compras", compras);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}