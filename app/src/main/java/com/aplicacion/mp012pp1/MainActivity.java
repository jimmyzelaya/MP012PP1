package com.aplicacion.mp012pp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtnombre, txtapellidos;
    Button btnmostrar, btnsecond, btnCrear, btnConsultar, btnLista, btnCombo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtnombre = (EditText) findViewById(R.id.txtnombre);
        txtapellidos = (EditText) findViewById(R.id.txtapellidos);
        btnmostrar = (Button) findViewById(R.id.btnmostrar);
        btnsecond = (Button) findViewById(R.id.btnsecond);
        btnCrear = (Button) findViewById(R.id.btnCrear);
        btnConsultar = (Button) findViewById(R.id.btnConsultar);
        btnLista = (Button) findViewById(R.id.btnLista);
        btnCombo = (Button) findViewById(R.id.btnCombo);

        btnmostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Nombre: "+txtnombre.getText().toString(),Toast.LENGTH_LONG).show();
            }
        });

        btnsecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                intent.putExtra("nombre", txtnombre.getText().toString());
                intent.putExtra("apellidos", txtnombre.getText().toString());
                startActivity(intent);
            }
        });

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ActivityCrear.class);
                startActivity(intent);

            }
        });

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ActivityConsulta.class);
                startActivity(intent);

            }
        });

        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ActivityList.class);
                startActivity(intent);

            }
        });

        btnCombo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ActivityCombo.class);
                startActivity(intent);

            }
        });
    }
}