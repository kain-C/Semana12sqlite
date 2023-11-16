package com.example.semana12sqlite.Controlador;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.semana12sqlite.Modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ConexionHelper extends SQLiteOpenHelper {

    private static final String NOMBRE_BD="Usuario.bd";
    private static final int VERSION_BD=1;
    private static final String TABLA_Usuario="CREATE TABLE Usuario(ID TEXT PRIMARY KEY, Nombre TEXT, Correo TEXT)";


    public ConexionHelper(Context context) {
        super(context,NOMBRE_BD,null, VERSION_BD);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_Usuario);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLA_Usuario);
            sqLiteDatabase.execSQL(TABLA_Usuario);
    }
    public void agregarUsuario(String ID, String Nombre, String Correo){
        SQLiteDatabase bd=getWritableDatabase();
        if (bd!=null){
            bd.execSQL("INSERT INTO  Usuario VALUES('"+ID+"','"+Nombre+"','"+Correo+"')");
            bd.close();
        }
    }
    public List<Usuario>mostrarusuario(){
        SQLiteDatabase bd=getReadableDatabase();
        Cursor cursor=bd.rawQuery("SELECT * FROM Usuario",null);
        List<Usuario> Usuario=new ArrayList<>();
        if(cursor.moveToFirst()) {
            do {
                Usuario.add(new Usuario(cursor.getString(0), cursor.getString(1), cursor.getString(2)));
            } while (cursor.moveToNext());
        }
        return Usuario;
    }
    public void buscarUsuarios(Usuario usuario,String ID){
        SQLiteDatabase bd=getReadableDatabase();
        Cursor cursor=bd.rawQuery("SELECT * FROM Usuario where ID= '"+ID+"'",null);

        if(cursor.moveToFirst()) {
            do {
              usuario.setNombre(cursor.getString(1));
              usuario.setCorreo(cursor.getString(2));
            } while (cursor.moveToNext());
        }
    }
    public void editarUsuario(String ID, String Nombre, String Correo){
        SQLiteDatabase bd=getWritableDatabase();
        if (bd!=null){
            bd.execSQL("UPDATE Usuario SET Nombre='"+Nombre+"','"+Correo+"'WHERE ID'"+ID+"'");
            bd.close();
        }
    }
    public void eliminarUsuario(String ID){
        SQLiteDatabase bd=getWritableDatabase();
        if (bd!=null){
            bd.execSQL("DELETE FROM Usuario WHERE ID='"+ID+"'");
            bd.close();
        }
    }
}

