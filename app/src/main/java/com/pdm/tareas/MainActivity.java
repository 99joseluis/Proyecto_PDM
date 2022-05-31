package com.pdm.tareas;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.pdm.tareas.Models.Logeado;
import com.pdm.tareas.Models.RegistroUsuarios;
import com.pdm.tareas.Models.Usuario;


public class MainActivity extends AppCompatActivity {

    private EditText userName;
    private EditText password;
    private Logeado login;
    private TextView tvMessage;
    private RegistroUsuarios registro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        tvMessage = (TextView) findViewById(R.id.Messages);
        registro = new RegistroUsuarios();
        login = new Logeado();
    }

    public void register(View view){
        Intent intent = new Intent(this, Registro.class);
        startActivity(intent);
    }

    public void login(View view){

        String username = userName.getText().toString();
        String pass = password.getText().toString();

        Log.d("Login", username);
        Log.d("Login", pass);

        if(registro.estaRegistrado(username, pass)){
            Usuario usuario = registro.obtenerUsuario(userName.getText().toString(), password.getText().toString());
            if(login.size() == 0){
                login.add(usuario);
            }else{
                if(!login.isLogged(usuario))
                    login.add(usuario);
            }
            Intent intent = new Intent(this, Menu.class);
            startActivity(intent);
        }else{
            register(view);
        }
    }
}