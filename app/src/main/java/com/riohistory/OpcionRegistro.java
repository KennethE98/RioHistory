package com.riohistory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OpcionRegistro extends AppCompatActivity {

    Button correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcion_registro);
        correo=(Button)findViewById(R.id.btnEmail);
        correo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(OpcionRegistro.this,correo.class);
                startActivity(i);
            }
        });
    }
}