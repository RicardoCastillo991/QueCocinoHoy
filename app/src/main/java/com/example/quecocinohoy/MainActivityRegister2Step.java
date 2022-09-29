package com.example.quecocinohoy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivityRegister2Step extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_register2_step);
        Button btnInicio = (Button) findViewById(R.id.btnInicio);
        EditText txtPass = (EditText) findViewById(R.id.txtPassRegister);
        EditText txtPassDos = (EditText) findViewById(R.id.txtPassDosRegister);
        CheckBox ckBoxMostrarPass = (CheckBox)findViewById(R.id.ckboxMostrarPass);

        if(ckBoxMostrarPass.isChecked() == true){
            txtPass.setInputType(InputType.TYPE_CLASS_TEXT);
            txtPassDos.setInputType(InputType.TYPE_CLASS_TEXT);

        }
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