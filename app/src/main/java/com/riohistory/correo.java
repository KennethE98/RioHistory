package com.riohistory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class correo extends AppCompatActivity implements View.OnClickListener{
    EditText passw,passw2;
    Button btnRegistrar;

    private static final String TAG="Correo";
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correo);
        passw=(EditText) findViewById(R.id.edtPassword);
        passw2=(EditText) findViewById(R.id.edtPassword2);
        btnRegistrar=(Button) findViewById(R.id.btnRegistrar);
        btnRegistrar.setOnClickListener(this);
        inicialize();
    }
    //Fire Base
    public void inicialize(){
        firebaseAuth=FirebaseAuth.getInstance();
        authStateListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
                if(firebaseUser!=null){
                    Log.w(TAG,"onAuthStateChanged - signed_in"+firebaseUser.getUid());
                    Log.w(TAG,"onAuthStateChanged - singned_in" +firebaseUser.getEmail());
                }
                else{
                    Log.w(TAG,"onAuthStateChanged - signed_out");
                }
            }
        };
    }
    //Verificacion de coincidencia de ambas contraseñas
    @Override
    public void onClick(View view) {
        String ps1,ps2;
        ps1=passw.getText().toString();
        ps2=passw2.getText().toString();
        if(ps1.equals(ps2)){
            Toast.makeText(this,"Correcto",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"Contraseña no coincide",Toast.LENGTH_SHORT).show();
        }
    }
}