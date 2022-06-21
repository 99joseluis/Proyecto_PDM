package com.pdm.tareas.controllers;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pdm.tareas.Models.Producto;
import com.pdm.tareas.views.Carrito;
import com.pdm.tareas.views.R;


public class RegistroCarrito extends RecyclerView.Adapter<RegistroCarrito.ViewHolder> {

    private Producto[] productos;
    private Context context;

    public RegistroCarrito(Producto[] productos, Carrito carrito){
        this.productos = productos;
        this.context = carrito;
    }

    @NonNull
    @Override
    public RegistroCarrito.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.producto_item, parent, false);
        RegistroCarrito.ViewHolder viewHolder = new RegistroCarrito.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RegistroCarrito.ViewHolder holder, int position) {
        final Producto productoList = productos[position];
        holder.nombreProducto.setText(productoList.getNombre());
        holder.precioProducto.setText("$ "+productoList.getPrecio());
        holder.imagenProducto.setImageBitmap(BitmapFactory.decodeByteArray(productoList.getImagen(), 0, productoList.getImagen().length));
        holder.cantidadProducto.setText("Cantidad Seleccionada "+ productoList.getCantidad());

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(context, productoList.getNombre() + "\n"+ "Añadido a la canasta", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return productos.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imagenProducto;
        TextView nombreProducto;
        TextView  precioProducto;
        TextView cantidadProducto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagenProducto = itemView.findViewById(R.id.imageViewP);
            nombreProducto = itemView.findViewById(R.id.textViewNombre);
            precioProducto = itemView.findViewById(R.id.textViewPrecio);
            cantidadProducto = itemView.findViewById(R.id.textViewCantidad);

        }
    }
}
