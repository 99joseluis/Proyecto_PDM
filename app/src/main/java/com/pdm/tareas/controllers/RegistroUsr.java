package com.pdm.tareas.controllers;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.pdm.tareas.Models.Usuario;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;


public class RegistroUsr implements Serializable {

    private LinkedList<Usuario> dB;
    private UserDataRecorder recorder;
    private final String archivo = "UserData.bd";

    public RegistroUsr(Context context){
        dB = new LinkedList<>();
        dB.add(new Usuario("Jose", "Garcia", "admin@gmail.com", "admin123456"));
        dB.add(new Usuario("Yazmin", "Lopez", "yazL@gmail.com", "yazmin123"));
        recorder = new UserDataRecorder(dB);
    }

    public RegistroUsr(Usuario usr, Context context){
        dB = new LinkedList<>();
        dB.add(usr);
        recorder = new UserDataRecorder(dB);
    }

    public boolean añadirUsr(Usuario usr){
        dB.add(usr);
        recorder.setList(dB);
        recorder.writeObjects(archivo);
        return true;
    }

    public boolean estaRegistrado(Usuario usr){
        Log.d("Login", "Entro metodo estaRegistrado");
        return dB.contains(usr);
    }

    public boolean estaRegistrado(String correo, String contraseña){
        for(Usuario usr: dB){
            if(usr.getMail().equals(correo) && usr.getPassword().equals(contraseña)){
                return true;
            }
        }
        return false;
    }

    public int size(){
        return dB.size();
    }


    private class UserDataRecorder extends Activity implements Serializable {

        private LinkedList<Usuario> list ;

        public UserDataRecorder(LinkedList<Usuario> objeto){
            list = objeto;
        }

        public void setList(LinkedList<Usuario> list){
            this.list = list;
        }

        public void writeObjects(String nombreArch){
            try{
                FileOutputStream fos = new FileOutputStream(nombreArch);
                ObjectOutputStream obj = new ObjectOutputStream(fos);
                for (Usuario usr: list) {
                    obj.writeObject(usr);
                }
                fos.close();
                obj.close();
            }catch(IOException e1){
                //Toast.makeText(this, "Hubo un error al guardar el usuario", Toast.LENGTH_LONG).show();
            }
        }

        public void leerObjetos(String nombreArch){
            try{
                FileInputStream fis = new FileInputStream(nombreArch);
                ObjectInputStream obj = new ObjectInputStream(fis);
                LinkedList<Usuario> listUsers = new LinkedList<>();
                while(obj.read() > 0){
                    listUsers.add((Usuario) obj.readObject());
                }
                obj.close();
                fis.close();
            }catch(IOException e1){
                //Toast.makeText(this, "Hubo un error al leer el archivo", Toast.LENGTH_LONG).show();
            }catch(ClassNotFoundException e2){
                //Toast.makeText(this, "Hubo un error al leer el archivo", Toast.LENGTH_LONG).show();
            }
        }
    }
}
