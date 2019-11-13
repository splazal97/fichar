package com.example.fichar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.RoomDatabase;

import android.os.Bundle;
import android.telephony.emergency.EmergencyNumber;
import android.util.Log;
import android.widget.EditText;

import com.example.fichar.db.FicharDAO;
import com.example.fichar.db.FicharDB;
import com.example.fichar.model.Empleado;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

//        EditText nombreEditText = findViewById(R.id.nombre);
//        String nombre = nombreEditText.getText().toString();

        final Empleado empleado = new Empleado("Miguel Hernandez", "mherna", "mherna");

        mainViewModel.insertarEmpleado(empleado);


        mainViewModel.obtenerEmpleados().observe(this, new Observer<List<Empleado>>() {
            @Override
            public void onChanged(List<Empleado> empleados) {
                for(Empleado empleado1: empleados){
                    Log.e("EMP ", empleado1.toString());
                }
            }
        });
    }
}
