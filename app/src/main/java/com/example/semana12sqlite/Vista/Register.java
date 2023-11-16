package com.example.semana12sqlite.Vista;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.semana12sqlite.Controlador.ConexionHelper;
import com.example.semana12sqlite.Controlador.UsuariosLISTA;
import com.example.semana12sqlite.R;

public class Register extends AppCompatActivity {
    EditText edtID,edtNombre,edtCorreo;
    Button btnAgregar,btnMostrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        
        edtID=(EditText)findViewById(R.id.edtID);
        edtNombre=(EditText)findViewById(R.id.edtNombre);
        edtCorreo=(EditText)findViewById(R.id.edtCorreo);
        btnAgregar=(Button)findViewById(R.id.btnAgregar);
        btnMostrar=(Button)findViewById(R.id.btnmostar);
        final ConexionHelper conexionHelper=new ConexionHelper(getApplicationContext());

        btnMostrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent mostrarUsuarios=new Intent(getApplicationContext(), UsuariosLISTA.class);
                startActivity(mostrarUsuarios);
            }
        });
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                conexionHelper.agregarUsuario(edtID.getText().toString(),edtNombre.getText().toString(),edtCorreo.getText().toString());
                Toast.makeText(getApplicationContext(),"Se agrego Correctamente",Toast.LENGTH_SHORT).show();

            }

        });
    }
}