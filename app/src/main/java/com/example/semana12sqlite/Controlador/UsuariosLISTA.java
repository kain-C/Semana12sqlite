package com.example.semana12sqlite.Controlador;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.semana12sqlite.Modelo.Usuario;
import com.example.semana12sqlite.R;
import com.example.semana12sqlite.Vista.Register;

import java.util.ArrayList;
import java.util.List;

public class UsuariosLISTA extends AppCompatActivity {

    private RecyclerView recyclerUser ;
    private com.example.semana12sqlite.Controlador.UserAdapter UserAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios_lista);

        recyclerUser=(RecyclerView)findViewById(R.id.recyclerUser);

        recyclerUser.setLayoutManager(new LinearLayoutManager(this));


        ConexionHelper conexionHelper=new ConexionHelper(getApplicationContext());

        UserAdapter=new UserAdapter(conexionHelper.mostrarusuario());
        recyclerUser.setAdapter(UserAdapter);

    }

}