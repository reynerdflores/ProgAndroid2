package com.example.proyectobasefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import OBJETOS.CANCIONES;

public class Home_act extends AppCompatActivity {

    private VideoView videoView;
    CANCIONES can = new CANCIONES();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        videoView = findViewById(R.id.vw);

        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(ruta);
        videoView.setVideoURI(uri);

        videoView.start();

        //MediaController media = new MediaController(this);
        //videoView.setMediaController(media);

    }

    /*public void Task(View view)
    {
        try {

            for (int i = 0; i <=10; i++)
            {
                Thread.sleep(2200);
            }

        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }*/

    public void mis_canciones (View view)
    {
        Intent i = new Intent(this, mis_canciones.class);
        Bundle buna = new Bundle();
        buna.putStringArray("CANCIONES", can.getCanciones());
        i.putExtras(buna);
        startActivity(i);
    }
}