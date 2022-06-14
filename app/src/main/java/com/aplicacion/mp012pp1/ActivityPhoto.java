package com.aplicacion.mp012pp1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.service.media.MediaBrowserService;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class ActivityPhoto extends AppCompatActivity {

    static  final  int REQUESTCODECAMARA =100;
    static  final  int REQUESTTAKEPHOTO =101;
    ImageView ObjetoImage;
    Button btnFoto;
    String PathFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        ObjetoImage = (ImageView) findViewById(R.id.Fotografia);
        btnFoto = (Button) findViewById(R.id.btnFoto);

        btnFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OtorgarPermisos();
            }
        });
    }

    private void OtorgarPermisos()
    {
        if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA)!=
                PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,
                    new String[]{ Manifest.permission.CAMERA }, REQUESTCODECAMARA);
        }
        else
        {
            TomarFotografia();

        }
    }

    private void TomarFotografia() {
        Intent tomarFoto=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(tomarFoto,REQUESTTAKEPHOTO);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == REQUESTCODECAMARA){

            if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                TomarFotografia();
            }
            else
            {
                Toast.makeText(getApplicationContext(),"PERMISO DENEGADO", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}