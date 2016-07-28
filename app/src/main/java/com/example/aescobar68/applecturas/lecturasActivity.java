package com.example.aescobar68.applecturas;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;




public class lecturasActivity extends AppCompatActivity {

    Button btn_anterior;
    Button btn_siguiente;
    Spinner lcausal;


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturas);

        setToolbar();

        btn_siguiente = (Button) findViewById(R.id.Siguiente);
        btn_siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn_siguiente = new Intent(lecturasActivity.this, menuprincipal.class);
                startActivity(btn_siguiente);

            }
        });


        btn_anterior = (Button) findViewById(R.id.Anterior);
        btn_anterior.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Intent btn_anterior = new Intent(lecturasActivity.this, MainActivity.class);
                                                startActivity(btn_anterior);
                                            }
                                        });





        lcausal = (Spinner)findViewById(R.id.SpCausal);

        ArrayAdapter<CharSequence> adcausal =
                ArrayAdapter.createFromResource(this,
                        R.array.causal_array,
                        android.R.layout.simple_spinner_item);



        adcausal.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

         lcausal.setAdapter(adcausal);


            // ATTENTION: This was auto-generated to implement the App Indexing API.
                // See https://g.co/AppIndexing/AndroidStudio for more information.
                client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setSubtitle("Libro de lecturas");


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_add:
                Intent intent = new Intent(lecturasActivity.this, menuprincipal.class);
                startActivity(intent);
                return true;

            case R.id. action_busqueda:
                Intent intent2 = new Intent(lecturasActivity.this, BuscarActivity.class);
                startActivity(intent2);
                return true;

            case R.id. action_setting:
                Intent intent3 = new Intent(lecturasActivity.this, Preferencias.class);
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
                "lecturas Page", // TODO: Define a title for the content shown.
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
                "lecturas Page", // TODO: Define a title for the content shown.
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
