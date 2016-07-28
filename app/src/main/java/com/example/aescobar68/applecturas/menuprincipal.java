package com.example.aescobar68.applecturas;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class menuprincipal extends AppCompatActivity {

    Button btn_lecturas;
    Button btn_irbuscar;
    Button btn_iractualizar;
    Button btn_irtotalizar;
    Button btn_irfoto;
    Button btn_salir;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuprincipal);

        setToolbarab();


        btn_lecturas = (Button) findViewById(R.id.Lecturas);
        btn_lecturas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn_lecturas = new Intent(menuprincipal.this, lecturasActivity.class);
                startActivity(btn_lecturas);
            }
        });

        btn_irbuscar = (Button) findViewById(R.id.LectursNoEnvidas);
        btn_irbuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn_irbuscar = new Intent(menuprincipal.this, BuscarActivity.class);
                startActivity(btn_irbuscar);
            }
        });

       btn_iractualizar = (Button) findViewById(R.id.ActualizarArchivos);
       btn_iractualizar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent btn_iractualizar = new Intent(menuprincipal.this, ActualizarActivity.class);
               startActivity(btn_iractualizar);
           }
       });

        btn_irtotalizar = (Button)findViewById(R.id.Totalizar);
        btn_irtotalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn_irtotalizar = new Intent(menuprincipal.this,TotalizarActivity.class);
                startActivity(btn_irtotalizar);
            }
        });

        btn_irfoto = (Button)findViewById(R.id.EnviarrFotografias);
        btn_irfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn_irfoto = new Intent(menuprincipal.this,Tomar_fotoActivity.class);
                startActivity(btn_irfoto);
            }
        });

        btn_salir = (Button)findViewById(R.id.MenuSalir);
        btn_salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    private void setToolbarab() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        toolbar.setSubtitle("Menu Principal");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detailab, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_add:
                Intent intent = new Intent(menuprincipal.this, AboutActivity.class);
                startActivity(intent);
                return true;

            case R.id.action_setting:
                Intent intent3 = new Intent(menuprincipal.this, Preferencias.class);
                startActivity(intent3);
                return true;

        }

        return super.onOptionsItemSelected(item);

    }



    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "menuprincipal Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.aescobar68.applecturas/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "menuprincipal Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.aescobar68.applecturas/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }


}