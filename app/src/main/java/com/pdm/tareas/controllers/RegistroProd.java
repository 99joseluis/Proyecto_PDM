package com.pdm.tareas.controllers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pdm.tareas.Models.Producto;
import com.pdm.tareas.views.Menu;
import com.pdm.tareas.views.R;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.LinkedList;

public class RegistroProd extends RecyclerView.Adapter<RegistroProd.ViewHolder> implements Serializable {

    private Producto[] productos;
    private Context context;
    private LinkedList<Producto> compras;

    public RegistroProd(Producto[] productos, Menu menu){
        this.productos = productos;
        this.context = menu;
        compras = new LinkedList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.producto_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Producto productoList = productos[position];
        holder.nombreProducto.setText(productoList.getNombre());
        holder.precioProducto.setText("$ "+productoList.getPrecio());
        holder.imagenProducto.setImageResource(productoList.getImagen());


        holder.itemView.setOnClickListener(view -> {
            Toast.makeText(context, productoList.getNombre() + "\n"+ "Añadido a la canasta", Toast.LENGTH_SHORT).show();
            compras.add(productoList);
        });
    }

    @Override
    public int getItemCount() {
        return productos.length;
    }

    public LinkedList<Producto> getCompras(){return compras;}


    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imagenProducto;
        TextView  nombreProducto;
        TextView  precioProducto;
        TextView  cantidadProducto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagenProducto = itemView.findViewById(R.id.imageViewP);
            nombreProducto = itemView.findViewById(R.id.textViewNombre);
            precioProducto = itemView.findViewById(R.id.textViewPrecio);
            cantidadProducto = itemView.findViewById(R.id.textViewCantidad);
            cantidadProducto.setVisibility(View.INVISIBLE);
        }
    }
}
