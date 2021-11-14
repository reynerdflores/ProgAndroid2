package com.example.proyectobasefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.IDNA;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import OBJETOS.ADMINISTRADOR;
import OBJETOS.CANCIONES;

public class MainActivity extends AppCompatActivity {

    private EditText user, pass;
    private TextView msj;
    private ADMINISTRADOR adm = new ADMINISTRADOR();
    private CANCIONES can = new CANCIONES();
    private ProgressBar barra;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.txtusu);
        pass = findViewById(R.id.txtcon);
        msj = findViewById(R.id.txtmsj);
        barra = findViewById(R.id.pb);
        btn = findViewById(R.id.btn);

        barra.setVisibility(View.INVISIBLE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Task().execute();
            }
        });
    }


    class Task extends AsyncTask<String, Void, String>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            barra.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                for (int i = 0; i<=10; i++)
                {
                    Thread.sleep(400);
                }

            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            barra.setVisibility(View.INVISIBLE);

            String usuario = user.getText().toString().trim();
            String contrasena = pass.getText().toString().trim();

            String userObj = adm.getUser().trim();
            String userPass = adm.getPass().trim();

            switch (usuario)
            {
                case "Reynerd":
                    if (usuario.equals(userObj) && contrasena.equals(userPass))
                    {
                        //inicio Sesion

                        msj.setVisibility(View.INVISIBLE);
                        Intent i = new Intent(getBaseContext(), Home_act.class);
                        startActivity(i);
                    }
                    break;
                case "":
                    if (usuario.equals("") && contrasena.equals(""))
                    {
                        //Campos Vacios
                        msj.setVisibility(View.VISIBLE);
                        msj.setText("Los campos están vacíos, ingrese nuevamente");
                    }
                    break;
                default:
                    if (!usuario.equals(userObj) && !contrasena.equals(userPass))
                    {
                        //Campos Incorrectos
                        msj.setVisibility(View.VISIBLE);
                        msj.setText("Los campos están incorrectos, ingrese nuevamente");
                    }
                    break;
            }
        }
    }








    public void FACEBOOK (View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://facebook.com/"));
        startActivity(i);
    }

    public void TWITTER (View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://twitter.com/"));
        startActivity(i);
    }

    public void YOUTUBE (View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://youtube.com/"));
        startActivity(i);
    }

    public void info (View view)
    {
        Intent i = new Intent(this, info_act.class);
        startActivity(i);
    }

}