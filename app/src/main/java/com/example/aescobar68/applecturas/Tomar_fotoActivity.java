package com.example.aescobar68.applecturas;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Tomar_fotoActivity extends AppCompatActivity {

    private static String APP_DIRECTORY = "MisFotos/";

    private static String MEDIA_DIRECTORY = APP_DIRECTORY + "FotosApp";

    private int PHOTO_CODE = 200;
    private  String mPath;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    private ImageView mSetImage;
    private Button mOptionButton;
    private Button btnGrabar;

    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tomar_foto);
        setToolbar();

        mSetImage = (ImageView)findViewById(R.id.imageView3);
        mOptionButton = (Button)findViewById(R.id.btnTomaFoto);
        btnGrabar = (Button)findViewById(R.id.btnGrabarFoto);
        mOptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCamara();
            }
        });

        btnGrabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap imagen = ((BitmapDrawable)mSetImage.getDrawable()).getBitmap();
                long timestamp = System.currentTimeMillis()/1000;
                String imageName = String.valueOf(timestamp)+ ".jpg";
                String ruta = guardarImagen(getApplicationContext(), imageName, imagen);
                Toast.makeText(getApplicationContext(), ruta, Toast.LENGTH_LONG).show();
            }
        });



        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void openCamara() {
        File file = new File(Environment.getExternalStorageDirectory(),MEDIA_DIRECTORY);
        Boolean isDirectoryCreated = file.exists();

        if(!isDirectoryCreated)
            isDirectoryCreated = file.mkdirs();

        if(isDirectoryCreated){
            long timestamp = System.currentTimeMillis()/1000;
            String imageName = String.valueOf(timestamp)+ ".jpg";

            mPath=Environment.getExternalStorageDirectory() + File.separator + MEDIA_DIRECTORY + File.separator + imageName;
            File newFile = new File(mPath);

            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT,Uri.fromFile(newFile));
            startActivityForResult(intent, PHOTO_CODE);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

            MediaScannerConnection.scanFile(this,
                    new String[]{mPath}, null,
                    new MediaScannerConnection.OnScanCompletedListener() {
                        @Override
                        public void onScanCompleted(String path, Uri uri) {

                        }
                    });
                /* Cambiamos el tamaño de la imagen para mostrar en pantalla.
                */
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2;
            Bitmap bitmap = BitmapFactory.decodeFile(mPath, options);
            mSetImage.setImageBitmap(bitmap);
        }
    }

    private String guardarImagen (Context context, String nombre, Bitmap imagen){

        mPath=Environment.getExternalStorageDirectory() + File.separator + MEDIA_DIRECTORY + File.separator + nombre;
        File newFile = new File(mPath);

        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(newFile);
            imagen.compress(Bitmap.CompressFormat.JPEG, 20, fos);
            fos.flush();
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return newFile.getAbsolutePath();
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setSubtitle("Registro fotografico");

    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Tomar_foto Page", // TODO: Define a title for the content shown.
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
                "Tomar_foto Page", // TODO: Define a title for the content shown.
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
