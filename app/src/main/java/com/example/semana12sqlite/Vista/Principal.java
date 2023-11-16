package com.example.semana12sqlite.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.semana12sqlite.Controlador.ConexionHelper;
import com.example.semana12sqlite.Modelo.Usuario;
import com.example.semana12sqlite.R;

public class Principal extends AppCompatActivity {
    Button btnBuscar,btnEliminar,btnEditar;

    EditText edtID,edtNombre,edtCorreo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        btnBuscar=(Button)findViewById(R.id.btnBuscar);
        btnEditar=(Button)findViewById(R.id.btnEditar);
        btnEliminar=(Button)findViewById(R.id.btnEliminar);
        edtID=(EditText)findViewById(R.id.edtID);
        edtNombre=(EditText)findViewById(R.id.edtNombre);
        edtCorreo=(EditText)findViewById(R.id.edtCorreo);

        final ConexionHelper conexionHelper=new ConexionHelper(getApplicationContext());
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario usuario=new Usuario();
                conexionHelper.buscarUsuarios(usuario,edtID.getText().toString());
                edtNombre.setText(usuario.getNombre());

                edtCorreo.setText(usuario.getCorreo());

            }
        });
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                conexionHelper.editarUsuario(edtID.getText().toString(),edtNombre.getText().toString(),edtCorreo.getText().toString());
                Toast.makeText(getApplicationContext(), "SE AH MODIFICADO CORRECTAMENTE", Toast.LENGTH_SHORT).show();
            }
        });
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                conexionHelper.eliminarUsuario(edtID.getText().toString());
                Toast.makeText(getApplicationContext(), "SE AH ELIMINADO CORRECTAMENTE", Toast.LENGTH_SHORT).show();
            }
        });
    }
}