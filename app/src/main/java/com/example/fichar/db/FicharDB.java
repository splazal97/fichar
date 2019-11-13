package com.example.fichar.db;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.fichar.model.DetallesEmpleados;
import com.example.fichar.model.Empleado;
import com.example.fichar.model.Horas;

@Database(entities = {Empleado.class, Horas.class}, views = {DetallesEmpleados.class}, version = 2)
public abstract class FicharDB extends RoomDatabase {
    private static FicharDB ficharDB;

    public abstract FicharDAO dao();

    public static FicharDB getInstance(final Context context){

        if(ficharDB == null) {
            synchronized (FicharDB.class) {
                ficharDB = Room.databaseBuilder(context, FicharDB.class, "fichar.db")
                        .fallbackToDestructiveMigration()
                        .addCallback(new Callback() {
                            @Override
                            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                super.onCreate(db);
                                insertarDatosIniciales(getInstance(context).dao());
                            }
                        })
                        .build();
            }
        }

        return ficharDB;
    }

    static void insertarDatosIniciales(final FicharDAO dao){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                dao.insertarEmplado(new Empleado("Admin", "admin", "admin"));
            }
        });
    }
}
