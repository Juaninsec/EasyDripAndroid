package com.example.easydrip;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.easydrip.ui.login.LoginActivity;


public class MainActivity extends AppCompatActivity {


     TextView cabecera_text;
     Button loginYRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cabecera_text=findViewById(R.id.tV1);
        loginYRegistro=findViewById(R.id.btn1);
    }

    public void RegistroClick(View view){

        Intent registrarse = new Intent(this, LoginActivity.class);
        startActivity(registrarse);

    }


}