package com.pdm.tareas.views;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.pdm.tareas.controllers.RegistroUsr;



public class HomePage extends AppCompatActivity {

    private EditText userName;
    private EditText password;
    private TextView tvMessage;
    private RegistroUsr registroUsr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        tvMessage = (TextView) findViewById(R.id.Messages);
        registroUsr = new RegistroUsr();
    }

    public void register(View view){
        Intent intent = new Intent(HomePage.this, Registro.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("registro", registroUsr);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void login(View view){

        String username = userName.getText().toString();
        String pass = password.getText().toString();

        Log.d("Login", username);
        Log.d("Login", pass);

        if(registroUsr.estaRegistrado(username, pass)){
            Intent intent = new Intent(this, Menu.class);
            startActivity(intent);
        }else{
            register(view);
        }
    }
}