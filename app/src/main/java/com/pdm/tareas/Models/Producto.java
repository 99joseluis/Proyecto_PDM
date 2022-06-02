package com.pdm.tareas.Models;

import java.io.Serializable;

public class Producto implements Serializable {

    private Integer imagen;
    private String nombre;
    private Double precio;
    private Integer cantidad;

    public Producto(Integer imagen, String nombre, Double precio, Integer cantidad){
        this.imagen = imagen;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getImagen() {
        return imagen;
    }

    public void setImagen(Integer imagen) {
        this.imagen = imagen;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public boolean equals(Object o){
        Producto p = (Producto) o;
        return true? p.getNombre() == nombre && p.getImagen() == imagen && p.getPrecio() == precio : false;
    }

    public String toString(){
        String s ="";
        s+= nombre +"\n";
        s += precio +"\n";
        s += cantidad +"\n";
        return s;
    }
}
