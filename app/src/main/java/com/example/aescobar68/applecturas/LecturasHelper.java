package com.example.aescobar68.applecturas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by aescobar68 on 12/06/2016.
 */
public class LecturasHelper extends SQLiteOpenHelper {

    /** ENCABEZADOS DE LA TABLA LECTURAS QUE RECIBIRAN LOS DATOS A PARTIR DEL ARCHIVO PLANO DE LA EMPRESA */

    String tabla ="CREATE TABLE Lecturas(Id INTEGER PRIMARY KEY AUTOINCREMENT, MINICIPIO TEXT, CODIGO INTEGER, TIPO TEXT, CICLO TEXT, RUTA INTEGER," +
            "ORDEN INTEGER, NOMBRE TEXT, DIRECCION TEXT, MEDIDOR TEXT, MARCA TEXT, FACTOR INTEGER, DIGITOS INTEGER, PROMEDIO INTEGER, ESTRATO TEXT, CLASE TEXT," +
            "TRANSFORMADOR TEXT, LECANTERIOR INTEGER, FECHATM DATE)";


    public LecturasHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
