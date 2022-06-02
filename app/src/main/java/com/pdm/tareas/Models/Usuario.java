package com.pdm.tareas.Models;


import java.io.Serializable;

public class Usuario implements Serializable {

    private String nombre;
    private String apellidos;
    private String correo;
    private String contrasena;


    public Usuario(String name, String surname, String username, String contrasena){
        this.nombre = name;
        this.apellidos = surname;
        this.correo = username;
        this.contrasena = contrasena;
    }

    public String getName(){
        return nombre;
    }

    public String getSurname(){
        return apellidos;
    }

    public String getMail(){
        return correo;
    }

    public String getPassword(){
        return contrasena;
    }

    public boolean equals(Usuario user){
        return ((user.nombre == nombre) && (user.apellidos == apellidos) && (user.correo == correo) && (user.contrasena == contrasena));
    }

    public String toString(){
        String ret = "";
        ret += nombre +"\n";
        ret += apellidos + "\n";
        ret += correo + "\n";
        ret += contrasena + "\n";
        return ret;
    }

}
