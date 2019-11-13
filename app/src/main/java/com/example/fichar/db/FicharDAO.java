package com.example.fichar.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.fichar.model.Empleado;

import java.util.List;

@Dao
public abstract class FicharDAO {

    @Insert
    public abstract void insertarEmplado(Empleado empleado);

    @Query("SELECT * FROM Empleado")
    public abstract LiveData<List<Empleado>> getEmpleados();


}


// Empleado empleado = new Empleado("Miguel", "Hernandez");
// INSERT INTO EMPLEADO VALUES(empleado.nombre, empleado.apellido)


// Empleado empleado = new Empleado("Miguel", "Hernandez");
// dao.insertarEmpleado(empleado);