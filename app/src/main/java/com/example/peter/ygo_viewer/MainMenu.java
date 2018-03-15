package com.example.peter.ygo_viewer;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            copyDatabase();
            Log.i("INFO", "COPIED DB SUCCESS");
        } catch (IOException e){
            Log.i("INFO", "FAILED TO COPY DB");
        }
        setContentView(R.layout.activity_main_menu);
    }

    public void copyDatabase() throws IOException {
        final String path = "/data/data/com.example.peter.ygo_viewer/databases/";
        //final String path = getApplicationContext().getFilesDir().getPath();
        final String Name = "cards_full.db";
        OutputStream myOutput = new FileOutputStream(path + Name);
        byte[] buffer = new byte[1024];
        int length;
        InputStream myInput = getApplicationContext().getAssets().open("cards_full.db");
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
        myInput.close();
        myOutput.flush();
        myOutput.close();
    }

    public void showTrunk(View view) {
        Intent intent = new Intent(this, DisplayTrunk.class);
        startActivity(intent);
    }
}
