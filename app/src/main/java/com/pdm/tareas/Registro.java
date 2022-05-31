package com.pdm.tareas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.pdm.tareas.Models.Usuario;

public class Registro extends AppCompatActivity {

    private EditText eTNombre;
    private EditText eTapellido;
    private EditText eTUsername;
    private EditText eTPassword;
    private EditText confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        eTNombre = (EditText) findViewById(R.id.nameRegister);
        eTapellido = (EditText) findViewById(R.id.surnameRegister);
        eTUsername = (EditText) findViewById(R.id.usernameRegister);
        eTPassword = (EditText) findViewById(R.id.passwordRegister);
        confirmPassword = (EditText) findViewById(R.id.passwordRRegister);
    }

    public void goMenu(View view){
        String nombre = eTNombre.getText().toString();
        String apellidos = eTNombre.getText().toString();
        String username = eTNombre.getText().toString();
        String password = eTNombre.getText().toString();
        String cpassword = eTNombre.getText().toString();
        if(password == cpassword){
            Usuario usuario = new Usuario(nombre, apellidos, username, password);
        }

        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }
}