package com.pdm.tareas.Models;

import android.content.Intent;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.pdm.tareas.R;

import java.util.LinkedList;

public class Logeado extends AppCompatActivity {

    private LinkedList<Usuario> login;
    private TextView tvMessage;

    public Logeado(){
        login = new LinkedList<>();
    }

    public Logeado(Usuario user){
        login = new LinkedList<>();
        login.add(user);
    }

    /**
     * Metodo para añadir a un usuario a la lista de usuarios que iniciaron sesión
     * @param user Usuario que inicio sesión
     */
    public void add(Usuario user){
        if(!login.contains(user))
            login.add(user);
        else{
            tvMessage = (TextView) findViewById(R.id.Messages);
            tvMessage.setText("The user is already logged");
            setContentView(R.layout.messages);
        }
    }

    public int size(){
        return login.size();
    }

    /**
     * Metodo que representará cuando el usuario salga de su sesión
     * @return true si salio correctamente
     */
    public boolean salir(Usuario usuario){
        if(isLogged(usuario)){
            login.remove(usuario);
            return true;
        }
        return false;
    }

    /**
     * Metodo para saber si un usuario ya inicio sesión
     * @param user2 Usuario a revisar si ya inicio sesión
     * @return True si ya inicio sesión y False en otro caso
     */
    public boolean isLogged(Usuario user2){
        for(Usuario user: login){
            if(user.equals(user2))
                return true;
        }
        return false;
    }



}
