package com.pdm.tareas.controllers;

import android.app.Activity;
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
import com.pdm.tareas.Models.Usuario;
import com.pdm.tareas.views.Menu;
import com.pdm.tareas.views.R;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;

public class RegistroProd extends RecyclerView.Adapter<RegistroProd.ViewHolder> implements Serializable {

    private Producto[] productos;
    private Context context;
    private LinkedList<Producto> compras;
    private ProductDataRecorder recorder;
    private final String archivo = "productos.db";

    public RegistroProd(Producto[] productos, Menu menu){
        this.productos = productos;
        this.context = menu;
        compras = new LinkedList<>();
        LinkedList<Producto> list = new LinkedList<>();
        for(Producto prod : productos)
            list.add(prod);

        recorder = new ProductDataRecorder(list);
        recorder.writeObjects(archivo);
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
        holder.imagenProducto.setImageBitmap(BitmapFactory.decodeByteArray(productoList.getImagen(), 0, productoList.getImagen().length));


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

    private class ProductDataRecorder extends Activity implements Serializable {

        private LinkedList<Producto> list ;

        public ProductDataRecorder(LinkedList<Producto> objeto){
            list = objeto;
        }

        public void setList(LinkedList<Producto> list){
            this.list = list;
        }

        public void writeObjects(String nombreArch){
            try{
                FileOutputStream fos = new FileOutputStream(nombreArch);
                ObjectOutputStream obj = new ObjectOutputStream(fos);
                for (Producto prod: list) {
                    obj.writeObject(prod);
                }
                fos.close();
                obj.close();
            }catch(IOException e1){
                //Toast.makeText(this, "Hubo un error al guardar el usuario", Toast.LENGTH_LONG).show();
            }
        }

        public void leerObjetos(String nombreArch){
            try{
                FileInputStream fis = new FileInputStream(nombreArch);
                ObjectInputStream obj = new ObjectInputStream(fis);
                LinkedList<Producto> listUsers = new LinkedList<>();
                while(obj.read() > 0){
                    listUsers.add((Producto) obj.readObject());
                }
                obj.close();
                fis.close();
            }catch(IOException e1){
                //Toast.makeText(this, "Hubo un error al leer el archivo", Toast.LENGTH_LONG).show();
            }catch(ClassNotFoundException e2){
                //Toast.makeText(this, "Hubo un error al leer el archivo", Toast.LENGTH_LONG).show();
            }
        }
    }
}
