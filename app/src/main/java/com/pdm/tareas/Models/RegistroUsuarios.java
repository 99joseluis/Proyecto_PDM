package com.pdm.tareas.Models;

import android.util.Log;

import java.util.LinkedList;

public class RegistroUsuarios {

    private LinkedList<Usuario> usuarios;

    public RegistroUsuarios(){
        usuarios = new LinkedList<>();
        usuarios.add(new Usuario("Jose", "Luis", "admin@gmail.com", "admin123456"));

    }

    public RegistroUsuarios(Usuario usuario){
        usuarios = new LinkedList<>();
        usuarios.add(usuario);
    }

    public boolean registrarUsuario(Usuario usuario){
        if(!estaRegistrado(usuario)){
            usuarios.add(usuario);
            return true;
        }
        return false;
    }

    public boolean estaRegistrado(Usuario usuario){
        return usuarios.contains(usuario);
    }


    public boolean estaRegistrado(String username, String password){
        for(Usuario usuario: usuarios){
            Log.d("Login", usuario.getUsername() );
            Log.d("Login", username);
            Log.d("Login", usuario.getPassword());
            Log.d("Login", password);
            if(usuario.getUsername().equals(username) && usuario.getPassword().equals(password))
                return true;
        }
        return false;
    }

    public Usuario obtenerUsuario(String username, String password){
        for(Usuario usuario: usuarios){
            if(usuario.getUsername() == username && usuario.getPassword() == password){
                return usuario;
            }
        }
        return null;
    }

}
