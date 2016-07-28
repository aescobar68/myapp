package com.example.aescobar68.applecturas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class TotalizarActivity extends AppCompatActivity {

    Button btn_ruta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_totalizar);
        setToolbartz();

        btn_ruta = (Button) findViewById(R.id.btnRuta);
        btn_ruta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn_ruta = new Intent(TotalizarActivity.this, TotalRutaActivity.class);
                startActivity(btn_ruta);
            }
        });


    }
    private void setToolbartz() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setSubtitle("Totalizar registros");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detailtz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_add:
                Intent intent = new Intent(TotalizarActivity.this, AboutActivity.class);
                startActivity(intent);
                return true;

        }

        return super.onOptionsItemSelected(item);

    }


}
