package com.aplicacion.mp012pp1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aplicacion.mp012pp1.Procesos.SQLiteConexion;
import com.aplicacion.mp012pp1.Procesos.Transacciones;

public class ActivityConsulta extends AppCompatActivity {

    SQLiteConexion conexion;

    EditText id, nombres, apellidos, edad, correo;
    Button btnConsulta, btnEliminar, btnActualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        init();

        btnConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BuscarEmpleado();
            }
        });

    }

    private void BuscarEmpleado(){
        try{
            SQLiteDatabase db = conexion.getWritableDatabase();

            //PARAMETROS DE BUSQUEDA
            String [] params = {id.getText().toString()};

            //CAMPOS A RETORNAR
            String [] fields = {Transacciones.nombres,
                    Transacciones.apellidos,
                    Transacciones.edad,
                    Transacciones.correo};

            String WhereCondition = Transacciones.id + "=?";

            Cursor cdata = db.query(Transacciones.tablaEmpleados, fields,
                    WhereCondition, params, null, null, null);

            cdata.moveToFirst();

            if (cdata.getCount()>0){

                nombres.setText(cdata.getString(0));
                apellidos.setText(cdata.getString(1));
                edad.setText(cdata.getString(2));
                correo.setText(cdata.getString(3));

                Toast.makeText(getApplicationContext(),"Consulta realizada exitosamente",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplicationContext(),"No se encontraron Datos",Toast.LENGTH_LONG).show();
            }
        }
        catch (Exception ex){
            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
        }

    }

    private void Eliminar()
    {

    }

    private void init()
    {
        conexion = new SQLiteConexion(this, Transacciones.NameDataBase, null,1);
        btnConsulta = (Button) findViewById(R.id.btnbuscar);
        btnEliminar = (Button) findViewById(R.id.btneliminar);
        btnActualizar = (Button) findViewById(R.id.btnactualizar);

        id = (EditText) findViewById(R.id.txtcid);
        nombres = (EditText) findViewById(R.id.txtcnombres);
        apellidos = (EditText) findViewById(R.id.txtcapellidos);
        edad = (EditText) findViewById(R.id.txtcedad);
        correo = (EditText) findViewById(R.id.txtccorreo);

    }
}