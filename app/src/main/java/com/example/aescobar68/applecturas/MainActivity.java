package com.example.aescobar68.applecturas;

import android.content.Intent;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class MainActivity extends AppCompatActivity {

    Button btn_intro;
    Button btn_exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_exit = (Button)findViewById(R.id.btn_salir);
        btn_intro = (Button)findViewById(R.id.entrar);

        btn_intro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent btn_intro =  new Intent(MainActivity.this, menuprincipal.class);
                startActivity(btn_intro);
            }
        });

        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.runFinalization();
                System.exit(0);

            }
        });

    }

}
