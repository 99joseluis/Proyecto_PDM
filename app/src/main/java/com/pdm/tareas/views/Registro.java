package com.pdm.tareas.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.pdm.tareas.controllers.RegistroUsr;
import com.pdm.tareas.Models.Usuario;

public class Registro extends AppCompatActivity {

    private EditText eTNombre;
    private EditText eTapellido;
    private EditText eTUsername;
    private EditText eTPassword;
    private EditText confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Registro", "Entro Registro");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        eTNombre = (EditText) findViewById(R.id.nameRegister);
        eTapellido = (EditText) findViewById(R.id.surnameRegister);
        eTUsername = (EditText) findViewById(R.id.usernameRegister);
        eTPassword = (EditText) findViewById(R.id.passwordRegister);
        confirmPassword = (EditText) findViewById(R.id.passwordRRegister);


       /* Bundle bundle = getIntent().getExtras();
        Log.d("Registro", bundle.toString());
        if(bundle != null){
            try{
                registroUsr = (RegistroUsr) bundle.getSerializable("registroUsr");
            }catch(Exception e){
                e.printStackTrace();
            }finally {
                registroUsr = new RegistroUsr(this);
            }
        }
        Log.d("Registro", String.valueOf(registroUsr.size()));*/
    }

    public void goMenu(View view){
        String nombre = eTNombre.getText().toString();
        String apellidos = eTapellido.getText().toString();
        String username = eTUsername.getText().toString();
        String password = eTPassword.getText().toString();
        String cpassword = confirmPassword.getText().toString();
        Usuario usuario = null;
        Log.d("Registro pass ", password);
        Log.d("Registro cpass", cpassword);
        if(password.equals(cpassword)){
            usuario = new Usuario(nombre, apellidos, username, password);
            Log.d("Registro añade usuario", usuario.toString());
            Intent intent = new Intent(this, HomePage.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("Registro", usuario);
            intent.putExtras(bundle);
            startActivity(intent);
        }

    }
}