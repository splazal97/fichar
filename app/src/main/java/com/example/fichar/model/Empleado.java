package com.example.fichar.model;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class Empleado {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String nombre;
    public String usuario;
    public String contraseña;
    public String aplelidos;

    public Empleado(String nombre, String usuario, String contraseña){
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", usuario='" + usuario + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", aplelidos='" + aplelidos + '\'' +
                '}';
    }
}
