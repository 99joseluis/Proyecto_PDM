package com.pdm.tareas.controllers;

import com.pdm.tareas.Models.Usuario;

import java.io.Serializable;
import java.util.LinkedList;

public class RegistroUsr implements Serializable {

    private LinkedList<Usuario> registro;

    public RegistroUsr(){
        registro = new LinkedList<Usuario>();
        registro.add(new Usuario("Jose", "Garcia", "admin@gmail.com", "admin123456"));
        registro.add(new Usuario("Yazmin", "Lopez", "yazL@gmail.com", "yazmin123"));
    }

    public RegistroUsr(Usuario usr){
        registro = new LinkedList<Usuario>();
        registro.add(usr);
    }

    public int tamañoRegistro(){
        return registro.size();
    }

    public boolean añadirUsr(Usuario usr){
        registro.add(usr);
        return true;
    }

    public boolean estaRegistrado(Usuario usr){
        return registro.contains(usr);
    }

    public boolean estaRegistrado(String correo, String contraseña){
        for(Usuario usr: registro){
            if(usr.getMail().equals(correo) && usr.getPassword().equals(contraseña))
                return true;
        }
        return false;
    }


    public String toString(){
        String usrs = "";
        for(Usuario usr: registro)
            usrs += usr + "\n";
        return usrs;
    }

}
