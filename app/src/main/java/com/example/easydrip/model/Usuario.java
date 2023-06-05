package com.example.easydrip.model;

import androidx.annotation.NonNull;

public class Usuario {

    private String nombre;
    private String apellidos;
    private String nick;
    private String contrasena;
    private String correo;


    public Usuario(String nombre, String apellidos, String nick, String contrasena, String correo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nick = nick;
        this.contrasena = contrasena;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNick() {
        return nick;
    }

    public  void setNick(String nick) {
        this.nick = nick;
    }

    public String getContraseña() {
        return contrasena;
    }

    public void setContraseña(String contraseña) {
        this.contrasena = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

   /* @NonNull
    @Override
    public String toString() {
        return "Name: " + getNombre() + ", Apellidos: " + getApellidos() + ", Nick: " + getNick() + ", contraseña: " + getContraseña() + ", correo: " + getCorreo();
    } */
}
