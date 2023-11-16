
package com.example.semana12sqlite.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.semana12sqlite.Controlador.UsuariosLISTA;
import com.example.semana12sqlite.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void mostrar(View view){
        Intent i = new Intent(this, UsuariosLISTA.class);
        startActivity(i);
    }
    public void registrar(View view){
        Intent i = new Intent(this, Register.class);
        startActivity(i);
    }
    public void ingresar(View view){
        Intent i = new Intent(this, Principal.class);
        startActivity(i);
    }
}