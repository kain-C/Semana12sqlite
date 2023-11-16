package com.example.semana12sqlite.Modelo;

public class Usuario {
    private String ID,Nombre,Correo;

    public Usuario(){

    }

    public Usuario(String ID,String Nombre, String Correo) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Correo = Correo;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }
}
