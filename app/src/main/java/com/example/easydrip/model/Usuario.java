package com.example.easydrip.model;

import androidx.annotation.NonNull;

public class Usuario {
    private String nombre;
    private String apellidos;
    private String nick;
    private String contraseña;
    private String correo;

    public Usuario() {

    }

    public Usuario(String nombre, String apellidos, String nick, String contraseña, String correo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nick = nick;
        this.contraseña = contraseña;
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

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @NonNull
    @Override
    public String toString() {
        return "Name: " + getNombre() + ", Apellidos: " + getApellidos() + ", Nick: " + getNick() + ", contraseña: " + getContraseña() + ", correo: " + getCorreo();
    }
}
