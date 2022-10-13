package com.example.quecocinohoy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivityRegister2Step extends AppCompatActivity {
    private Button btnInicio;
    private ImageButton btnMostrarPass;
    private boolean visible = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_register2_step);
        Button btnInicio = (Button) findViewById(R.id.btnInicio);
        btnMostrarPass = (ImageButton)findViewById(R.id.imgbtnMostrarPass);
        EditText txtPass = (EditText) findViewById(R.id.txtPassRegister);
        EditText txtPassDos = (EditText) findViewById(R.id.txtPassDosRegister);


        btnMostrarPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(visible == false){
                    txtPass.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    txtPassDos.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    visible = true;
                }
                else{
                    txtPass.setInputType(129);
                    txtPassDos.setInputType(129);
                    visible = false;
                }
            }
        });

        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtPass.toString().equals(txtPassDos.toString())){
                    Intent intento = new Intent(MainActivityRegister2Step.this, MainActivityInicio.class);
                    startActivity(intento);
                }
                else
                {
                    txtPass.setText("");
                    txtPassDos.setText("");
                    Toast mensajeError = Toast.makeText(MainActivityRegister2Step.this, "¡Las contraseñas deben ser iguales!", Toast.LENGTH_LONG);
                    mensajeError.show();
                }
            }
        });
    }
}