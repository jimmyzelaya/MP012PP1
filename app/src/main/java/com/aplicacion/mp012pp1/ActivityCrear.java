package com.aplicacion.mp012pp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aplicacion.mp012pp1.Procesos.SQLiteConexion;
import com.aplicacion.mp012pp1.Procesos.Transacciones;

import java.security.PrivateKey;

public class ActivityCrear extends AppCompatActivity {

    //SQLiteConexion conexion;

    Button btnAdd;
    EditText txtNombres, txtApellidos, txtEdad, txtCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);

        init();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AgregarEmpleado();
            }
        });
    }
   private void init(){
       txtNombres = (EditText) findViewById(R.id.txtNombre);
       txtApellidos = (EditText) findViewById(R.id.txtApellidos);
       txtEdad = (EditText) findViewById(R.id.txtEdad);
       txtCorreo = (EditText) findViewById(R.id.txtCorreo);

       btnAdd = (Button) findViewById(R.id.btnAdd);
    }

    private void AgregarEmpleado()
    {
        //Conexion e Insercion a la Data Base
        SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.NameDataBase, null,1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(Transacciones.nombres, txtNombres.getText().toString());
        valores.put(Transacciones.apellidos, txtApellidos.getText().toString());
        valores.put(Transacciones.edad, txtEdad.getText().toString());
        valores.put(Transacciones.correo, txtCorreo.getText().toString());

        Long resultado = db.insert(Transacciones.tablaEmpleados, Transacciones.id, valores);

        Toast.makeText(getApplicationContext(), "Registro Ingresado", Toast.LENGTH_LONG).show();

        db.close();

        ClearScreen();

    }

    private void ClearScreen()
    {
        txtNombres.setText("");
        txtApellidos.setText("");
        txtEdad.setText("");
        txtCorreo.setText("");
    }
}