package com.example.fichar;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.fichar.db.FicharDAO;
import com.example.fichar.db.FicharDB;
import com.example.fichar.model.Empleado;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    FicharDAO dao;

    public MainViewModel(@NonNull Application application) {
        super(application);
        dao = FicharDB.getInstance(application).dao();
    }

    void insertarEmpleado(Empleado empleado){
        dao.insertarEmplado(empleado);
    }

    LiveData<List<Empleado>> obtenerEmpleados(){
        return dao.getEmpleados();
    }
}
