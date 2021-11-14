package com.example.proyectobasefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectobasefinal.database.AdminSQLiteOpenHelper;

public class playlyst_act extends AppCompatActivity {

    private EditText code, name, genero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlyst);

        code = findViewById(R.id.code);
        name = findViewById(R.id.name);
        genero = findViewById(R.id.genero);
    }

    public void guardarPlaylist(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "cancan", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = code.getText().toString();
        String nombre = name.getText().toString();
        String gener = genero.getText().toString();

        if(!codigo.isEmpty() && !nombre.isEmpty() && !gener.isEmpty())
        {
            ContentValues cont = new ContentValues();
            cont.put("codigo", codigo);
            cont.put("nombre", nombre);
            cont.put("genero",gener);

            db.insert("playlist",null,cont);
            db.close();
            clean();

            Toast.makeText(getBaseContext(), "Has Guardado una Playlist", Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(getBaseContext(),"Hay campos vacíos ...", Toast.LENGTH_SHORT).show();
        }
    }

    public void mostrarPlaylist(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "cancan", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = code.getText().toString();

        if(!codigo.isEmpty())
        {
            Cursor file =
                    db.rawQuery("SELECT nombre, genero FROM playlist WHERE codigo="+codigo, null);
            if (file.moveToFirst())
            {
                name.setText(file.getString(0));
                genero.setText(file.getString(1));

                Toast.makeText(getBaseContext(), "Se ha consultado la Playlist", Toast.LENGTH_SHORT).show();
            }else
            {
                Toast.makeText(getBaseContext(), "No hay Playlist asociada", Toast.LENGTH_SHORT).show();
            }
        }else
        {
            Toast.makeText(getBaseContext(),"El código está vacío...", Toast.LENGTH_SHORT).show();
        }

    }

    public void eliminarPlaylist(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "cancan", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = code.getText().toString();

        if(!codigo.isEmpty())
        {
            db.delete("playlist","codigo="+codigo, null);
            db.close();
            clean();
            Toast.makeText(getBaseContext(),"Se ha eliminado una Playlist "+codigo, Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(getBaseContext(),"El código está vacío...", Toast.LENGTH_SHORT).show();
        }
    }

    public void actualizarPlaylist(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "cancan", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = code.getText().toString();
        String nombre = name.getText().toString();
        String gener = genero.getText().toString();

        if(!codigo.isEmpty() && !nombre.isEmpty() && !gener.isEmpty())
        {
            ContentValues cont = new ContentValues();
            cont.put("nombre", nombre);
            cont.put("genero",gener);

            db.update("playlist",cont,"codigo="+codigo,null);
            db.close();
            clean();

            Toast.makeText(getBaseContext(), "Has actualizado la Playlist", Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(getBaseContext(),"Hay campos vacíos ...", Toast.LENGTH_SHORT).show();
        }

    }

    public  void clean()
    {
        code.setText("");
        name.setText("");
        genero.setText("");
    }
}