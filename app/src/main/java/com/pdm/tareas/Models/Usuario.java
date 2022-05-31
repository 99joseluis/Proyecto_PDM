package com.pdm.tareas.Models;


public class Usuario {

    private String nombre;
    private String apellidos;
    private String username;
    private String password;

    public Usuario(String name, String surname, String username, String password){
        this.nombre = name;
        this.apellidos = surname;
        this.username = username;
        this.password = password;
    }

    public String getName(){
        return nombre;
    }

    public String getApellidos(){
        return apellidos;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public boolean equals(Usuario user){
        return ((user.nombre == nombre) && (user.apellidos == apellidos) && (user.username == username) && (user.password == password));
    }


}
