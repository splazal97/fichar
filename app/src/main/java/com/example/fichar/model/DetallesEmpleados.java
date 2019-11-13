package com.example.fichar.model;


import androidx.room.DatabaseView;

@DatabaseView("SELECT Empleado.id, Empleado.nombre, Empleado.usuario,Empleado.contraseña FROM Empleado")
public class DetallesEmpleados {
    public  int id;
    public  String nombre;
    public String usuario;
    public String contraseña;
}
